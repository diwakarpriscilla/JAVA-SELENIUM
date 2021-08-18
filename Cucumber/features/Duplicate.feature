Feature: DuplicateLead
@functional
Scenario: Merge Lead

Given Enter Username 'demosalesmanager'
And Enter Password 'crmsfa'
When Click Login button
Then Homepage should be displayed

Given Click CRMandSFA link
And Click the Leads Tab

Given Click link 'Leads'
And Click link 'Find Leads'
And click phone tab
And Enter phone number
And click Find Leads button
And click first result
And Click link 'Duplicate Lead'
And click submit button