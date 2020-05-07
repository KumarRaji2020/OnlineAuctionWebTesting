Feature: Validate Online Auction Web

	Scenario: Login as seller and add a product for bidding
    Given Open the Online Auction application
    When Click on Seller link  
    And Enter username and password
    Then Verify user is successfully logged in
    When Click on add product link
    And Enter product name and product model  
    And Click on Add button
    Then Verify product is added successfully
    
	Scenario: Login as bidder and bid a product
    Given Open the Online Auction application
    When Click on bidder link  
    And Select bid link against a product to bid
    And Enter bidder details and save
    Then Verify bidder details are added successfully

 	Scenario: Login as seller and find bidding winner of a product
    Given Open the Online Auction application
    When Click on Seller link  
    And Enter username and password
    Then Verify user is successfully logged in
    When Click on view product link
    And Click on close bid button
    Then Verify bidding winner details displayed for that product