# EVBox test assignment

## Technologies stack:
- Java 8
- Selenium WebDriver
- TestNG
- Maven
- Allure report
- Yandex HtmlElements

## Run configurations:
Run via maven surefire plugin is supported

Supported arguments: 
    - browserType=chrome|firefox
    
Run command sample: mvn test -DbrowserType=chrome

Please note apiKey for Rucaptcha should be added manually for security reasons


## Found bug:
Country select in request help form (https://evbox.com/en/learn/support) has some countries not in alphabet order.

e.g. Austria is located between Belgium and Belize


