package nz.ac.auckland.se754;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import weka.clusterers.ClusterEvaluation;
import weka.clusterers.DBSCAN;
import weka.core.Attribute;
import weka.core.ChebyshevDistance;
import weka.core.FastVector;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.ProtectedProperties;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.StringToWordVector;

public class DBSCANDemoTest {
	
	DBSCANDemo dbscanDemo;

	@Before
	public void setup() {
		
		dbscanDemo = new DBSCANDemo();
	}
	
	@Test
	public void shouldNotBeNullWhenIntializingTrainingDataContent() {
		Assert.assertNotNull(dbscanDemo.getTrainingDataContent());
	}
	
	@Test 
	public void shouldNotBeEmptyWhenInitializingTrainingDataContent() {
		Assert.assertFalse(dbscanDemo.getTrainingDataContent().isEmpty());
	}
	
	@Test
	public void shouldEqualToOriginalDataSizeWhenIntializingTrainingDataContent() {
		Assert.assertEquals(1074,dbscanDemo.getTrainingDataContent().size());
	}
	
	@Test
	public void shouldNotBeNullWhenInitializingTrainingDataQuestionIds() {
		Assert.assertNotNull(dbscanDemo.getTrainingDataQuestionIds());
	}
	
	@Test
	public void shouldNotBeEmptyWhenInitializingTrainingDataQuestionIds() {
		Assert.assertFalse(dbscanDemo.getTrainingDataQuestionIds().isEmpty());
		System.out.println("[Test] Number of Questions: "+dbscanDemo.getTrainingDataQuestionIds().size());
	}
	
	@Test
	public void shouldNotBeNullWhenGeneratingQuestionContentFromDataEntries() {
		Assert.assertNotNull(dbscanDemo.generateQuestionContentFromDataEntries());
	}
	
	@Test
	public void shouldNotBeEmptyWhenGeneratingQuestionContentFromDataEntries() {
		Assert.assertFalse(dbscanDemo.generateQuestionContentFromDataEntries().isEmpty());
	}
	
	@Test
	public void shouldBeEqualWhenComparingTheNumberOfQuestions() {
		Assert.assertEquals(dbscanDemo.getTrainingDataQuestionIds().size(), 
				dbscanDemo.generateQuestionContentFromDataEntries().size());
		System.out.println("[Test] The text of the a sample question: \n"+
				dbscanDemo.generateQuestionContentFromDataEntries().get(
						(Integer)dbscanDemo.generateQuestionContentFromDataEntries().keySet().toArray()[1]));
	}
	
	@Ignore
	@Test 
	public void test() {
		
		Map<Integer, String> questionContentMap = dbscanDemo.generateQuestionContentFromDataEntries();
		
		FastVector attInfo = new FastVector();
		attInfo.addElement(new Attribute("Question_ID"));
		FastVector dummy = null;  // To avoid ambiguity
		attInfo.addElement(new Attribute("Question_Content", dummy));
		Instances dataset = new Instances("Training_Question_Data", attInfo, 1000);
		Instance inst = new Instance(2);
		Attribute att0 = dataset.attribute("Question_ID");
		Attribute att1 = dataset.attribute("Question_Content");
		for(Integer i: questionContentMap.keySet()) {
			inst.setValue(att0, i);
			inst.setValue(att1, questionContentMap.get(i));
			dataset.add(inst);
		}
		System.out.println("[Test] First instance in dataset is: \n"+dataset.firstInstance());
		System.out.println("[Test] The last instance is: \n"+inst);
		
		StringToWordVector filter = new StringToWordVector();
		try {
			filter.setInputFormat(dataset);
			filter.setAttributeIndices("2");
			filter.setTFTransform(true);
			filter.setIDFTransform(true);
			
			Instances filteredData = Filter.useFilter(dataset, filter);
			System.out.println("[Test] Filtered dataset: \n"+filteredData);
			
			DBSCAN dbscan = new DBSCAN();
			dbscan.setEpsilon(0.5);
			dbscan.setMinPoints(2);
			dbscan.buildClusterer(filteredData);
			
			ClusterEvaluation eval = new ClusterEvaluation();
			eval.setClusterer(dbscan);
			eval.evaluateClusterer(filteredData);
			System.out.println(eval.clusterResultsToString());
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test 
	public void testOnlyText() {
		
		Map<Integer, String> questionContentMap = dbscanDemo.generateQuestionContentFromDataEntries();
		
		FastVector attInfo = new FastVector();
		FastVector dummy = null;  // To avoid ambiguity
		attInfo.addElement(new Attribute("Question_Content", dummy));
		Instances dataset = new Instances("Training_Question_Data", attInfo, 1000);
		Instance inst = new Instance(1);
		Attribute att1 = dataset.attribute("Question_Content");
		for(Integer i: questionContentMap.keySet()) {
			inst.setValue(att1, questionContentMap.get(i));
			dataset.add(inst);
		}
		System.out.println("[Test] First instance in dataset is: \n"+dataset.firstInstance());
		System.out.println("[Test] The last instance is: \n"+inst);
		
		StringToWordVector filter = new StringToWordVector();
		try {
			filter.setInputFormat(dataset);
			filter.setTFTransform(true);
			filter.setIDFTransform(true);
			
			Instances filteredData = Filter.useFilter(dataset, filter);
			System.out.println("[Test] Filtered dataset: \n"+filteredData);
			
			DBSCAN dbscan = new DBSCAN();
			dbscan.setEpsilon(0.5);
			dbscan.setMinPoints(2);
			//dbscan.setDatabase_distanceType();
			dbscan.buildClusterer(filteredData);
			
			ClusterEvaluation eval = new ClusterEvaluation();
			eval.setClusterer(dbscan);
			eval.evaluateClusterer(filteredData);
			System.out.println(eval.clusterResultsToString());
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
