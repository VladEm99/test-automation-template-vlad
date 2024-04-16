package delivery.ui.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class OrderPage {
    public SelenideElement usernameInput = $x("//*[@data-name='username-input']");
    public SelenideElement phoneInput = $x("//*[@data-name='phone-input']");
    public SelenideElement commentInput = $x("//*[@data-name='comment-input']");
    public SelenideElement createOrderButton = $x("//*[@data-name='createOrder-button']");
    public SelenideElement orderCreatedPopUp = $x("//*[@data-name='orderSuccessfullyCreated-popup']");
    public SelenideElement openStatusPopupButton = $x("//*[@data-name='openStatusPopup-button']");
    public SelenideElement searchOrderInput = $x("//*[@data-name='searchOrder-input']");
    public SelenideElement searchOrderSubmitButton = $x("//*[@data-name='searchOrder-submitButton']");
    public ElementsCollection orderStatuses = $$x("//li[contains(@data-name, 'status-item-')]");
}
