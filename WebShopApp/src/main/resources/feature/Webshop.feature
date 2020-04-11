@Webshopapp
Feature: DemoWebshp website
@TC01_Webshopapp
Scenario Outline: Login into Webshopapp
Given the user launch the chrome application i am on the home page
When the user clicks the login button
Then the user login using <email> and <password>
And click on the login button user nagivate to the next page
Examples:
 		| email | password  |
		|manitejakotha51@gmail.com | mani9959970193|
		|bunty123@gmail.com|9989955230|

@TC02_Webshopapp
Scenario Outline: Select product in Webshopapp
Given the user launch the chrome application i am on the home page and logs in with <email> and <password>
Given the user clicks on books
Then the user clicks on computers
Then the user clicks on phones
Examples:
 		| email | password  |
		|manitejakotha51@gmail.com | mani9959970193|
		|bunty123@gmail.com|9989955230|

@TC03_Webshopapp
Scenario Outline: select shopping cart in webshopapp
Given the user launch the chrome application i am on the home page and selects and logs in with <email> and <password>
Given the user clicks the shopping cart link
Then the user selects the country
And the user selects state
And the user enters zipcode
And the user clicks on accept
Examples:
 		| email | password  |
		|manitejakotha51@gmail.com | mani9959970193|
		|bunty123@gmail.com|9989955230|

@TC04_Webshopapp
Scenario Outline: click on checkouts page
Given the user launch the chrome application i am on the home page and selects the products and selects shipping cart link logs with <email> and <password>
Then user cicks on checkout link
Then the user clicks on continue buttons as address is already filled
Then click on logout
Then closes the browser
Examples:
 		| email | password  |
		|manitejakotha51@gmail.com | mani9959970193|
		|bunty123@gmail.com|9989955230|

