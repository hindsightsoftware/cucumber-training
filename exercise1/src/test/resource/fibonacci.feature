Feature: Fibonacci sequencer

  Scenario: A user inputs a sequence
    Given a user has started up a fibonacci sequencer
    When the user inputs a sequence of 10 into the sequencer
    Then the sequencer will return "0, 1, 1, 2, 3, 5, 8, 13, 21, 34"
