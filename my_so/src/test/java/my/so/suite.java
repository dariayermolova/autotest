package my.so;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.google.common.io.Files;
import io.qameta.allure.Attachment;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.After;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.io.File;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class suite {
    private String urlLogin = "https://my.solidopinion.com/signin";
    private String email = "daria.yermolova@nure.ua";
    private String pass = "D21UDOW2";
    private String urlProfile = "https://my.solidopinion.com/profile";

    @BeforeSuite(description = "Open a browser, add allure")
    public void getDriver() {
        Configuration.browser = "chrome";
        Configuration.timeout = 8000;
        Configuration.headless = true;
        Configuration.screenshots = true;
        Configuration.captureJavascriptErrors = true;
        System.out.println("Before Suite");
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
    }

    @BeforeClass(description = "Login to Admin")
    public void loginInAdmin() {
            open(urlLogin);
            $(By.className("header-title")).shouldHave(text("Solidopinion"));
            $(By.xpath("//header[@class='navbar']//a[@class='pull-left']")).shouldHave(attribute("href","https://my.solidopinion.com/"));
            $(By.id("facebook-login")).shouldHave(text("F"));
            $(By.id("tw-login")).shouldHave(text("T"));

            $(By.xpath("//footer//div[2]//a")).shouldHave(attribute("href", "https://solidopinion.com/terms/"));
            $(By.xpath("//footer//div[2]//a[2]")).shouldHave(attribute("href", "https://solidopinion.com/contact/"));
            $(By.id("email")).setValue(email);
            $(By.id("password")).setValue(pass);
            $(By.id("go_login_page")).click();

            $(By.id("text_visible_email")).shouldHave(text(email));
            $(By.xpath("//header[@class='header-signup']//a[@class='pull-left']")).shouldHave(attribute("href","https://solidopinion.com/"));

    }

    @AfterClass(description = "Logout from Admin")
    public void logoutFromAdmin() {
        open(urlProfile);
        $(By.xpath("//li[@id='tab-panel-comments-li']//a")).shouldHave(text("Your comments"));
        $(By.className("dropdown-toggle")).shouldBe().click();
        $(By.className("signout")).click();
        $(By.id("facebook-login")).shouldHave(text("F"));
        $(By.id("tw-login")).shouldHave(text("T"));
        System.out.println("tests.LoginPage = method2");
    }

    @AfterSuite(description = "Delete allure")
    public void afterSuite()
    {
        SelenideLogger.removeListener("allureSelenide");
        System.out.println("After Suite");
    }

    @After
    public void tearDown() throws IOException {
        screenshots();
    }

    @Attachment(type = "image/png")
    public byte[] screenshots() throws IOException {
        File screenshot = Screenshots.getLastScreenshot();
        return Files.toByteArray(screenshot);
    }

}
