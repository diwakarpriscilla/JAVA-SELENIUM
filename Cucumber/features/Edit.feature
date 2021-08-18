Feature: Edit Lead functionality of Test leaf
@smoke
Scenario: Creating successful Lead
#Login functionality begins
#Given Open the Chrome browser
#And Load the application URL 'http://leaftaps.com/opentaps/'
Given Enter Username 'demosalesmanager'
And Enter Password 'crmsfa'
When Click Login button
Then Homepage should be displayed
#login functionality ends

#Edit lead functionality begins 
Given Click CRMandSFA link
And Click the Leads Tab
And Click find Leads
And Enter First Name in Lead page 'FirstNameP'
And click Find Lead button
And Pick the first Lead
And Click Edit 
And change company name 'UpdatedTestLeafPJ'
When Clicked submit Update button
Then Confirm the changed name is displayed 'UpdatedTestLeafPJ'