Feature: Validating the programming Assigment
 
 @RatesJson @UnitTesting1 @IntegrationTest
 Scenario Outline: Verify  if currency convertion from rates.json file
    Given User select "<ToCurrency>" "<FromCurrency>" "<Amount> " from "<Path>"
    And   Show the The Exhange Rate and Converted Result 
    
    
Examples: 
    |ToCurrency    |FromCurrency |Amount |Path     |
    |rates.PKR     |rates.USD    |100    |JsonFile | 
    
 
@Api @UnitTesting2 @IntegrationTest
Scenario Outline: Verify  if currency convertion from exchangeratesapi.io Api
    Given User select "<ToCurrency>" "<FromCurrency>" "<Amount> " from "<Path>"
    And   Show the The Exhange Rate and Converted Result 
    
    
Examples: 
    |ToCurrency    |FromCurrency |Amount |Path  |
    |rates.PLN     |rates.USD    |100    |Api   | 
    
    
    