package stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import library.Fibonacci;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FibonacciStepDefs {

    private Fibonacci fibonacci;
    private String output;

    @Given("^a user has started up a fibonacci sequencer$")
    public void instantiateFibonacci() throws Exception {
        fibonacci = new Fibonacci();
    }

    @When("^the user inputs a sequence of (\\d+) into the sequencer$")
    public void getSequence(int count) throws Exception {
        output = fibonacci.getSequence(count);
    }

    @Then("^the sequencer will return \"([^\"]*)\"$")
    public void assertSequence(String expectedOutput) throws Exception {
        assertThat(output, is(expectedOutput));
    }

}
