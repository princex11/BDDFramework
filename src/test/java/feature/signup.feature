Feature: testing signup
  @a_signup
  Scenario: user signup
    Given user on homepage of demoblaze "https://demoblaze.com"
    When user clicks on signup tab
    And enter username "prince_x4" and password "password"
    And click on signup button
    Then handle alert