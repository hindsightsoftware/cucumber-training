Feature: Advanced fibonacci sequencer

  Scenario Outline: Outline demonstration
    Given a user has started up a fibonacci sequencer
    When the user inputs <count> into the sequencer
    Then the sequencer will return "<output>"

    Examples:
      | count | output                          |
      | 5     | 0, 1, 1, 2, 3                   |
      | 10    | 0, 1, 1, 2, 3, 5, 8, 13, 21, 34 |

  Scenario: A user inputs a sequence
    Given a user has started up a fibonacci sequencer
    When the user inputs 10 into the sequencer
    Then the sequencer will return
      """
      0, 1, 1, 2, 3, 5, 8, 13, 21, 34
      """

  Scenario: Tables demo
    Given a user has started up a fibonacci sequencer
    When the user inputs 5 into the sequencer
    Then the sequencer out will match
      | 0     |
      | 1     |
      | 1     |
      | 2     |
      | 3     |