Feature: As a googleler I want to search for Serenity and Maven


Scenario Outline: User search for Serenity and Maven
	Given the user sees the google search page 
	When the user decides to search for Serenity and Maven <searchValue>
	And the user clicks the Search icon 
	Then the user should see results on Serenity and Maven 
	Examples: 
		| searchValue | 
		| Serenity and Maven |
		| Maven and Serenity |
