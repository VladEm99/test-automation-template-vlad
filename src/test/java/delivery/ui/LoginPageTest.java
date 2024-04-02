package delivery.ui;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPageTest {

    @Test
    public void insertIncorrectLoginAndPasswordAndCheckErrorMessage(){
        Selenide.open("http://35.208.34.242:3000/signin");

        //step 1
//        SelenideElement usernameInput = $(By.xpath("//*[@data-name=\"username-input\"]"));
//        usernameInput.sendKeys("dummyUsername");

        $x("//*[@data-name=\"username-input\"]").sendKeys("dummyUsername");

        //step 2
//        SelenideElement passwordInput = $(By.xpath("//*[@data-name=\"password-input\"]"));
//        passwordInput.sendKeys("dummyPassword");

        $x("//*[@data-name=\"password-input\"]").sendKeys("dummyPassword");

        //step 3
//        SelenideElement signIn = $x("//*[@data-name=\"signIn-button\"]");
//        signIn.click();

        $x("//*[@data-name=\"signIn-button\"]").click();

        //step 4
//        SelenideElement errorInvalidCredentials = $x("//*[@data-name = 'authorizationError-popup-close-button123']");
//        errorInvalidCredentials.shouldBe(Condition.visible);

        $x("//*[@data-name = 'authorizationError-popup-close-button123']")
                .shouldBe(Condition.visible);
    }
}
