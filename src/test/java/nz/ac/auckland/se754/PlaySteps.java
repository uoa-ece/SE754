package nz.ac.auckland.se754;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.hamcrest.core.*;
import org.hamcrest.*;

public class PlaySteps {
	
    private TicTacToe game;
    
    @Given("a $width by $height tic tac toe game")
    public void aTicTacToeGame(int width, int height) {
        game = new TicTacToe(width, height);
    }
 
    @When("I toogle the cell at ($xPosition, $yPosition)")
    public void iToggleTheCellAt(int xPosition, int yPosition) {
        game.play(xPosition, yPosition);
    }
 
    @Then("the board should look like $board")
    public void theAlertStatusShouldBe(String board) {
        Assert.assertEquals(game.displayBoard(), board);
    }
}
