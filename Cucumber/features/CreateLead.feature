Feature: Create Lead functionality of Test leaf

Scenario: Creating successful Lead
#Login functionality begins
#Given Open the Chrome browser
#And Load the application URL 'http://leaftaps.com/opentaps/'
Given Enter Username 'demosalesmanager'
And Enter Password 'crmsfa'
When Click Login button
Then Homepage should be displayed
#login functionality ends

#Create lead functionality begins 
Given Click CRMandSFA link
And Click the Leads Tab
And Click the link Create Lead
And Enter Company name 'TestLeaf'
And Enter First Name 'FirstNameP'
And Enter Last Name 'lNameJeb'
And Enter Phone Name '98670'

When Click SUBMIT button
Then View Leads page should be displayed