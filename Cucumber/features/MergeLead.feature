Feature: MergeLead
@regression
Scenario: Merge Lead

Given Enter Username 'demosalesmanager'
And Enter Password 'crmsfa'
When Click Login button
Then Homepage should be displayed

Given Click CRMandSFA link
And Click the Leads Tab

Given Click link 'Leads'
And Click link 'Merge Leads'

When clicks lookup icon
Then New Window Opens