Feature: Login functionality of Test leaf

Scenario: Valid Credential 
#Given Open the Chrome browser
#And Load the application URL 'http://leaftaps.com/opentaps/'
Given Enter Username 'demosalesmanager'
And Enter Password 'crmsfa'
When Click Login button
Then Homepage should be displayed