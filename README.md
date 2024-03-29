**Configuration**
1. Open the `src/test/resources/application.yaml` file.
2. Update with your credentials:

    ```yaml
    general:
      username: YOUR_API_KEY_HERE
    ```
**Usage**
```
mvn clean test  
mvn allure:serve 
```

To run a specific test class using Maven, execute the following command in the terminal:

```
mvn clean test -Dtest=TestClassName
```

**Checklist for Tallinn Delivery web app UI**
```
| Nr | Check name                                                                    | Status        |
| -- | ----------------------------------------------------------------------------- | ------------- |
| 1  | Successfull login with valid data ENG localisation                            |               |
| 2  | Unsuccessfull login - invalid username ENG localization                       |               |        
| 3  | Unsuccessfull login - invalid password ENG localization                       |               |            
| 4  | Unsuccessfull login - empty username field ENG localization                   |               |
| 5  | Unsuccessfull login - empty password field ENG localization    	             |               |
| 6  | Unsuccessfull login - username and password fields are empty ENG localization |               |
| 7  | Unsuccessfull login - empty username field ENG localization                   |               |
| 8  | Successfull login with valid data RUS localization                            |               |
| 9  | Unsuccessfull login - invalid username RUS localization                       |               |
| 10 | Unsuccessfull login - invalid password RUS localization                       |               |
| 11 | Unsuccessfull login - empty username field RUS localization                   |               |
| 12 | Unsuccessfull login - empty password field RUS localization                   |               |
| 13 | Unsuccessfull login - username and password fields are empty RUS localization |               |
| 14 | Unsuccessfull login - empty username field RUS localization                   |               |
| 15 | RU localisation switch button works correctly                                 |               |
| 16 | ENG localisation switch button works correctly                                |               |
```

**List of web element names and their locators**
```
| Nr | Element name               | Xpath                            |
| -- | -------------------------- | -------------------------------- |
| 1  | Username field             | //*[@data-name="username-input"] |
| 2  | Password field             | //*[@data-name="password-input"] |        
| 3  | ENG localization button    | //button[text()='EN']            |            
| 4  | RU localization button     | //button[text()='RU']            |
| 5  | Sign in button   	  | //*[@data-name="signIn-button"]  |
```
**Xpaths for html document**
[Document link](https://drive.google.com/file/d/15Zlqvx4sW5WhWymnXEa0eu3o7N7aDY1e/view)
```
4.1 Выбрать все элементы <td>, содержащие имена (Name): //td//b[text()='Name']
4.2 Выбрать все элементы <tr>, у которых атрибут data-qa начинается с "amount-": //tr[starts-with(@data-qa, 'amount-')]
4.3 Выбрать все элементы <tr>, содержащие элемент <td> с текстом "John Doe": //tr//td//p//span[text()='John Doe']
```
