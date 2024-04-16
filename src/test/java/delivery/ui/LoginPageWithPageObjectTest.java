package delivery.ui;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import delivery.ui.pages.LoginPage;
import delivery.ui.pages.OrderPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Selenide.open;

public class LoginPageWithPageObjectTest {
    LoginPage loginPage = new LoginPage();
    BaseTest baseTest = new BaseTest();
    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
//        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        open("https://fe-delivery.tallinn-learning.ee/signin");
    }
    @Test
    public void loginAndCreateOrder(){
        OrderPage orderPage = loginPage.login("vladem", "pd2V7wYbfT2n");

        orderPage.usernameInput.setValue("asdad");
        orderPage.phoneInput.setValue("322423432432");
        orderPage.commentInput.setValue("weqewqe");
        orderPage.createOrderButton.click();

        orderPage.orderCreatedPopUp.shouldBe(Condition.visible);
    }
    @Test
    public void orderSearchAndCheckStatus(){
        OrderPage orderPage = loginPage.login(baseTest.username, baseTest.password);
        orderPage.openStatusPopupButton.click();
        orderPage.searchOrderInput.setValue("49");
        orderPage.searchOrderSubmitButton.click();
        orderPage.orderStatuses.shouldHave(CollectionCondition.size(4));
    }
}
