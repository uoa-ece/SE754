package nz.ac.auckland.se754;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class DBSCANDemo {
	
	String TRAINING_DATA_PATH_STRING = "dat/training_data_content.txt";
	String TRAINING_DATA_LABEL_PATH_STRING = "dat/training_data_label.csv";
	String DATA_CONTENT_DELIMITER = "\t";
	String DATA_LABEL_DELIMITER = ",";
	
	Map<Integer, String> trainingDataContentMap;
	HashMap<Integer, Set<Integer>> trainingDataQuestionIds;
	
	public DBSCANDemo() {
		dataInitialization();
	}

	public Map<Integer, String> getTrainingDataContent() {	
		return trainingDataContentMap;
	}
	
	public Map<Integer, Set<Integer>> getTrainingDataQuestionIds() {
		return trainingDataQuestionIds;
	}
	
	private void dataInitialization() {
		
		trainingDataContentMap = new HashMap<Integer, String>();
		trainingDataQuestionIds = new HashMap<Integer, Set<Integer>>();
		
		readTrainingDataContentFromFile(TRAINING_DATA_PATH_STRING);
		readTrainingDataQuestionIdsFromFile(TRAINING_DATA_LABEL_PATH_STRING);
	
	}
	
	private void readTrainingDataContentFromFile(String dataPath) {
		try {
			BufferedReader br = new BufferedReader(
					new FileReader(dataPath));
			String line = null;
			while((line = br.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line, DATA_CONTENT_DELIMITER);
				if(!st.hasMoreTokens()) {
					continue;
				}
				int dataEntryId = Integer.valueOf(st.nextToken().trim());
				String dataEntryContent = "";
				while(st.hasMoreTokens()) {
					dataEntryContent += st.nextToken();
				}
				trainingDataContentMap.put(dataEntryId, dataEntryContent);
			}
			
			br.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void readTrainingDataQuestionIdsFromFile(String dataPath) {
		try {
			BufferedReader br = new BufferedReader(
					new FileReader(dataPath));
			
			// To skip the header of the CSV file
			String line = br.readLine();
			while((line = br.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line, DATA_LABEL_DELIMITER);
				if(!st.hasMoreTokens()) {
					continue;
				}
				int dataEntryId = Integer.valueOf(st.nextToken().trim());
				st.nextToken();
				if(!st.hasMoreTokens()) {
					continue;
				}
				int questionId = Integer.valueOf(st.nextToken().trim());
				
				if(!trainingDataQuestionIds.containsKey(questionId)) {
					Set<Integer> dataEntrySet = new HashSet<Integer>();
					dataEntrySet.add(dataEntryId);
					trainingDataQuestionIds.put(questionId, dataEntrySet);
				}
				trainingDataQuestionIds.get(questionId).add(dataEntryId);
			}
			
			br.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Map<Integer, String> generateQuestionContentFromDataEntries() {
		
		Map<Integer, String> questionContentMap = new HashMap<Integer, String>();
		
		for(Integer i: trainingDataQuestionIds.keySet()) {
			
			String questionContentString = "";
			for(Integer j: trainingDataQuestionIds.get(i)) {
				questionContentString += " "+trainingDataContentMap.get(j);
			}
			questionContentMap.put(i, questionContentString.trim());
		}
		
		return questionContentMap;
	}
}
