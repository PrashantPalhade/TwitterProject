Feature: Twitter Login

  Scenario Outline: Login page with valid credentials
    Given User is on Login Page
    Then User enters "<username>" and "<password>"
    And clicks on Log In link
    Then User is logged in successfully

    Examples: 
      | username                   | userfullname     | password  |
      | prashant.palhade@gmail.com | Prashant Palhade | Time2win# |

  Scenario Outline: Login page with invalid credentials
    Given User is on Login Page
    Then User enters "<username>" and "<password>"
    And clicks on Log In link
    Then Login Error is displayed

    Examples: 
      | username | userfullname | password |
      | test     | testNameFull | test     |

  Scenario Outline: Navigate to ProfilePage
    Given User is on Login Page
    Then User enters "<username>" and "<password>"
    And clicks on Log In link
    Then clicks on Profile option
    Then Profile Page is displayed

    Examples: 
      | username  | userfullname      | password  |
      | DbPalhade | PrashantPalhadeDB | Time2win# |
      
      
