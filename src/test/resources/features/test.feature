@feature
Feature: Home loan borrowing power calculator

  @scenario1
  Scenario Outline: Verify borrowing estimate
    Given Open Home loan borrowing power calculator
    And Person with details "<type>", "<No. of Dependent>", "<property for>", "<annual income>", "<other income>", "<monthly expenses>", "<home loan repayment>", "<other loan repayment>", "<other commitments>" and "<credit card limit>"
    Then click on Work out how much I could borrow button
    And Verify has a borrowing estimate of "$479,000"

   Examples: 
      | type   | No. of Dependent | property for    | annual income | other income | monthly expenses | home loan repayment | other loan repayment | other commitments | credit card limit |
      | Single |     0 						| home to live in | 80000					| 10000				 | 500							| 0								    | 100									 | 0								 | 10000						 |
 
  @scenario2
  Scenario: Verify start over button
    When click on start over button
    Then verify form clears
    
  @scenario3
   Scenario Outline: Verify error text message
    Given Open Home loan borrowing power calculator
		And Person with details "<type>", "<No. of Dependent>", "<property for>", "<annual income>", "<other income>", "<monthly expenses>", "<home loan repayment>", "<other loan repayment>", "<other commitments>" and "<credit card limit>"
    Then click on Work out how much I could borrow button
    And Verify the text message
    
   Examples: 
      | type   | No. of Dependent | property for    | annual income | other income | monthly expenses | home loan repayment | other loan repayment | other commitments | credit card limit |
      | Single |     0 						| home to live in | 0							| 0				 		 | 1								| 0								    | 0										 | 0								 | 0								 |
 
