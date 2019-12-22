Feature: Documentaion

@dev
Scenario: validate links present in the page
Given open browser
When  enter url
Then  validate page title
Then  get linkes presen in the page
Then  validate all links
Then  close browser

@aviva
 Scenario: Test Aviva HomePage
 Given open browser
 When  enter "avivaURL"
 Then Verify page title
 Then click on login button