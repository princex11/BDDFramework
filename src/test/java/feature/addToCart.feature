Feature: testing login and add to cart.


  Background: user should be logged in
    Given homepage of demoblaze "http://demoblaze.com"
    When clicks on login tab
    And Enter username "prince_x4" and Password "password"
    And clicks on login button
    Then verify user name is displaying i.e successful login

  @b_addLaptopToCart
  Scenario: add laptop to cart
    Given after successful login user on homepage
    When user clicks on laptops link
    And select laptop sony_viao_i_five
    And navigated to selected laptop page, where user clicks on add_to_cart button
    And handles the alert
    And navigates to cart page "https://demoblaze.com/cart.html"
    Then verify if the laptop is in cart or not.






