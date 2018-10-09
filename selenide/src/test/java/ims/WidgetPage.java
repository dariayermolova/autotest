package ims;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class WidgetPage extends suite {

    private String urlWidgets = "http://my.solidopinion.com/demo/?sitename=prod40118";
    private String commentsTest = "test";
    private String emailSo = "daria.yermolova@nure.ua";
    private String passSo = "D21UDOW2";
    private String name = "autotest";
    private String emailFD = "alexandrine.sandrine99@gmail.com";
    private String emailYahoo = "alexandrine_sandrine@yahoo.com";
    private String passYFD = "!Q2w3e4r5t";
    private String emailTw = "daria.yermolova@solidopinion.com";
    private String passTw = "D21UDOW2";
    private String emailG = "daria.yermolova@nure.ua";
    private String passG = "daria2016";

    @Test(description = "Login to comment widget via so")
    @Feature("IMS")
    @Story("Login")
        public void t1_LoginViaSo() {
        open(urlWidgets);

        switchTo().frame($(By.xpath("//div[@class='so_comments']//iframe")));
        $(By.className("top_comments")).shouldHave(Condition.text("TOP Comments"));
        $(By.xpath("//span[@data-i18n='com.all_comments']")).shouldHave(Condition.text("All Comments"));

        $(By.xpath("//div[@id='comment_data']")).setValue(commentsTest);
        $(By.xpath("//span[@class='icon-so']")).click();

        switchTo().window(1);
       $(By.className("icon-facebook")).shouldHave(Condition.text("F"));
        $(By.className("icon-twitter")).shouldHave(Condition.text("T"));
        $(By.id("email")).setValue(emailSo);
        $(By.id("password")).setValue(passSo);
        $(By.id("go_login")).click();

        switchTo().window(0);
        switchTo().frame($(By.xpath("//div[@class='so_comments']//iframe")));
        $(By.xpath("//span[@id='display_name']")).shouldBe();
        $(By.id("top_menu_list")).click();
        $(By.xpath("//a[@data-i18n='com.user_menu_logout']")).click();
        $(By.xpath("//span[@id='display_name']")).shouldNotBe();

    }

    @Test(description = "Quick signup in the widget")
    @Feature("IMS")
    @Story("Signup")
       public void t2_SignupFromWidget() {
        open(urlWidgets);

        switchTo().frame($(By.xpath("//div[@class='so_comments']//iframe")));
        $(By.className("top_comments")).shouldHave(Condition.text("TOP Comments"));
        $(By.xpath("//span[@data-i18n='com.all_comments']")).shouldHave(Condition.text("All Comments"));

        $(By.xpath("//div[@id='comment_data']")).setValue(commentsTest);

        $(By.xpath("//span[@class='icon-so']")).shouldHave(Condition.text("S"));
        $(By.xpath("//span[@class='icon-facebook']")).shouldHave(Condition.text("F"));

        String randomEmail = "automateapitest.owner+" + Math.random()*100 + "@gmail.com";
        $(By.xpath("//input[@name='email']")).setValue(randomEmail);
        $(By.xpath("//input[@name='name']")).setValue(name);
        //$(By.xpath("//input[@class='i-agree']")).shouldBe().click();
        $(By.className("i-agree")).shouldBe().click();
        $(By.className("go_frontend_login")).click();

        $(By.xpath("//span[@id='display_name']")).shouldBe();
        $(By.id("top_menu_list")).click();
        $(By.xpath("//a[@data-i18n='com.user_menu_logout']")).shouldBe().click();
        $(By.xpath("//span[@id='display_name']")).shouldNotBe();
        WebDriver driver =  getWebDriver();
        driver.manage().deleteAllCookies();
    }


    @Test(description = "Login to widget via yahoo")
    @Feature("IMS")
    @Story("Login")
       public void t4_LoginViaYahoo() {
        open(urlWidgets);
        switchTo().frame($(By.xpath("//div[@class='so_comments']//iframe")));
        $(By.className("top_comments")).shouldHave(Condition.text("TOP Comments"));
        $(By.xpath("//span[@data-i18n='com.all_comments']")).shouldHave(Condition.text("All Comments"));

        $(By.xpath("//div[@id='comment_data']")).setValue(commentsTest);

        $(By.xpath("//span[@class='icon-yahoo']")).shouldHave(Condition.text("Y")).click();
        switchTo().window(1);
        $(By.id("login-username")).setValue(emailYahoo);
        $(By.id("login-signin")).click();
        $(By.xpath("//div[@class='txt-align-center']//img")).shouldHave(attribute("alt", "Yahoo"));
        $(By.className("username")).shouldHave(text(emailYahoo));
        $(By.id("login-passwd")).setValue(passYFD);
        $(By.id("login-signin")).click();
        $(By.className("oauth2-title")).shouldHave(text("alexandrine_sandrine"));
        $(By.id("oauth2-agree")).click();
        switchTo().window(0);
        switchTo().frame($(By.xpath("//div[@class='so_comments']//iframe")));
        $(By.xpath("//span[@id='display_name']")).shouldBe();
        $(By.id("top_menu_list")).click();
        $(By.xpath("//a[@data-i18n='com.user_menu_logout']")).click();
        $(By.xpath("//span[@id='display_name']")).shouldNotBe();
        WebDriver driver =  getWebDriver();
        driver.manage().deleteAllCookies();
    }

    @Test(description = "Login to widget via google")
    @Feature("IMS")
    @Story("Login")
      public void t5_LoginViaGoogle() {
        open(urlWidgets);
        switchTo().frame($(By.xpath("//div[@class='so_comments']//iframe")));
        $(By.className("top_comments")).shouldHave(Condition.text("TOP Comments"));
        $(By.xpath("//span[@data-i18n='com.all_comments']")).shouldHave(Condition.text("All Comments"));

        $(By.xpath("//div[@id='comment_data']")).setValue(commentsTest);

        $(By.xpath("//span[@class='icon-google']")).shouldHave(Condition.text("G")).click();
        switchTo().window(1);
        $(By.className("Fmgc2c")).shouldHave(text("Google"));
        $(By.id("identifierId")).setValue(emailG);
        $(By.id("identifierNext")).click();
        $(By.xpath("//input[@type='password']")).setValue(passG);
        $(By.id("passwordNext")).click();
        switchTo().window(0);
        switchTo().frame($(By.xpath("//div[@class='so_comments']//iframe")));
        $(By.xpath("//span[@id='display_name']")).shouldBe();
        $(By.id("top_menu_list")).click();
        $(By.xpath("//a[@data-i18n='com.user_menu_logout']")).click();
        $(By.xpath("//span[@id='display_name']")).shouldNotBe();
        WebDriver driver =  getWebDriver();
        driver.manage().deleteAllCookies();
    }
}


