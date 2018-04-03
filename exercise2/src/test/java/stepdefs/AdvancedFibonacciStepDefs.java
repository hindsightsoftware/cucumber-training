package stepdefs;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import library.Fibonacci;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AdvancedFibonacciStepDefs {

    private Fibonacci fibonacci;
    private String output;

    @Given("^a user has started up a fibonacci sequencer$")
    public void instantiateFibonacci() throws Exception {
        fibonacci = new Fibonacci();
    }

    @When("^the user inputs (\\d+) into the sequencer$")
    public void getSequence(int count) throws Exception {
        output = fibonacci.getSequence(count);
    }

    @Then("^the sequencer will return \"([^\"]*)\"$")
    public void assertSequenceAgainstOutline(String expectedOutput) throws Exception {
        assertThat(output, is(expectedOutput));
    }

    @Then("^the sequencer will return$")
    public void assertSequenceAgainstDocString(String expectedOutput) throws Exception {
        assertThat(output, is(expectedOutput));
    }

    @Then("^the sequencer out will match$")
    public void assertSequenceAgainstTable(DataTable table) throws Exception {
        List<String> tableAsStrings = table.asList(String.class);

        assertThat("[" + output + "]", is(tableAsStrings.toString()));
    }

}
