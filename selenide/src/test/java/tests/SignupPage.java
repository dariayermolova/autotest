package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SignupPage extends suite {


    private String urlSignup = "https://my.solidopinion.com/signup";
    private String pass = "123456";
    private By commentator = By.id("go_profile");
    private By deleteProfile = By.className("remove_account");
    private By popupYes = By.xpath("//div[@id='modalWindowWarning']//div[@class='modal-footer']//button[@class='btn btn-primary save_data']");
    private By dropdownLogout = By.className("dropdown-toggle");
    private By buttonLogout = By.className("signout");


    @Test
    public void t1_SignupInAdmin() {
        open(urlSignup);

        $(By.className("header-title")).shouldHave(text("Solidopinion"));
        $(By.xpath("//header[@class='navbar']//a[@class='pull-left']")).shouldHave(attribute("href","https://my.solidopinion.com/"));
        $(By.id("facebook-login")).shouldHave(text("F"));
        $(By.id("tw-login")).shouldHave(text("T"));
        $(By.xpath("//footer//div[2]//a")).shouldHave(attribute("href", "https://solidopinion.com/terms/"));
        $(By.xpath("//footer//div[2]//a[2]")).shouldHave(attribute("href", "https://solidopinion.com/contact/"));

        String randomName = "randomname" + (int) (Math.random() * 100);
        System.out.println(randomName);
        $(By.xpath("//input[@id='name']")).setValue(randomName);
        String randomEmail = "automateapitest.owner+" + (int) (Math.random() * 1000) + "@gmail.com";
        $(By.xpath("//input[@id='email']")).setValue(randomEmail);
        $(By.xpath("//input[@id='password']")).setValue(pass);
        $(By.xpath("//input[@id='password2']")).setValue(pass);
        $(By.id("go_signup")).click();

        $(By.className("dropdown-toggle")).shouldBe();
        $(By.xpath("//label[@for='embed-radio-1']//span[@class='embed-radio-title-1']")).shouldHave(text("Facebook comments"));
        $(By.xpath("//header[@class='header-signup']//a[@class='pull-left']")).shouldHave(attribute("href","https://solidopinion.com/"));
        $(By.id("go_profile")).click();

        $(By.id("text_visible_email")).shouldHave(text(randomEmail));
        $(By.xpath("//li[@id='tab-panel-comments-li']//a")).shouldHave(text("Your comments"));

        $(By.className("dropdown-toggle")).click();
        $(By.className("signout")).click();
        $(By.id("facebook-login")).shouldHave(text("F"));
        $(By.id("tw-login")).shouldHave(text("T"));

    }

}

