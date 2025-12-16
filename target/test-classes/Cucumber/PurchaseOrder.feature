
@tag
Feature: Purchase the order from eCommerce Website



@tag2
Scenario Outline: Positive test of purchasing the order
Given Logged in with username <name> and password <password>
When  I add product <productName> from Cart
And   Checkout <productName> and  submit the order
Then  "THANK YOU FOR THE ORDER." message is displayed on  ConfirmationPage


Examples:
|name                       | passsword      | productName |
|aliva.august20@gmail.com   | Password@20    | ZARA COAT 3 |

