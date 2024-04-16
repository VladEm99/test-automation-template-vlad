package delivery.ui.pages;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;



public class LoginPage {
    public SelenideElement usernameInput = $x("//*[@data-name='username-input']");
    public SelenideElement passwordInput = $x("//*[@data-name='password-input']");
    public SelenideElement signInButton = $x("//*[@data-name='signIn-button']");

    public OrderPage login(String username, String password){
        usernameInput.setValue(username);
        passwordInput.setValue(password);
        signInButton.click();
        return new OrderPage();
    }
}

