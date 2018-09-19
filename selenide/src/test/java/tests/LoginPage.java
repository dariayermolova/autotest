package tests;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage extends suite {
    private String urlLogin = "https://my.solidopinion.com/signin";
    private String emailAdmin = "daria.yermolova@nure.ua";
    private String passAdmin = "D21UDOW2";
    private String emailFD = "alexandrine.sandrine99@gmail.com";
    private String emailYahoo = "alexandrine_sandrine@yahoo.com";
    private String passYFD = "!Q2w3e4r5t";
    private String emailTw = "daria.yermolova@solidopinion.com";
    private String passTw = "D21UDOW2";
    private String emailG = "daria.yermolova@nure.ua";
    private String passG = "daria2016";
    private String urlPpac = "http://ppacentral.com";
    private String urlModtool = "https://modtools.solidopinion.com/";
    private String urlWidget = "http://my.solidopinion.com/demo/?sitename=prod40118";
    private String urlProfile = "https://my.solidopinion.com/profile";

    @Test
    public void t1_LoginInAdmin() {
        open(urlLogin);

        $(By.className("header-title")).shouldHave(text("Solidopinion"));
        $(By.xpath("//header[@class='navbar']//a[@class='pull-left']")).shouldHave(attribute("href","https://my.solidopinion.com/"));
        $(By.id("facebook-login")).shouldHave(text("F"));
        $(By.id("tw-login")).shouldHave(text("T"));

        $(By.xpath("//footer//div[2]//a")).shouldHave(attribute("href", "https://solidopinion.com/terms/"));
        $(By.xpath("//footer//div[2]//a[2]")).shouldHave(attribute("href", "https://solidopinion.com/contact/"));
        $(By.id("email")).setValue(emailAdmin);
        $(By.id("password")).setValue(passAdmin);
        $(By.id("go_login_page")).click();

        $(By.id("text_visible_email")).shouldHave(text(emailAdmin));
        $(By.xpath("//header[@class='header-signup']//a[@class='pull-left']")).shouldHave(attribute("href","https://solidopinion.com/"));

        System.out.println("tests.LoginPage = method1");

    }

    @Test
    public void t2_CheckPpac() {
        open(urlPpac);
        $(By.id("user-login")).shouldNotBe();
        $(By.className("user-box")).shouldHave(text("Welcome "));
        $(By.xpath("//div[@class='headline-user-wrap']//a")).shouldHave(text("Profile"));
    }

    @Test
    public void t3_CheckModtool() {
        open(urlModtool);
        $(By.className("user-name")).shouldBe();
        $(By.className("logout")).shouldBe();
        $(By.xpath("//div[@class='commets-filter-inner-left']//button[@class='btn active'][1]")).shouldHave(text("Comments"));
        $(By.xpath("//div[@class='commets-filter-inner-left']//button[@class='btn active'][2]")).shouldHave(text("Promo comments"));
        $(By.xpath("//div[@class='commets-filter-inner-left']//button[@class='btn active'][3]")).shouldHave(text("Headlines"));
    }

    @Test
    public void t4_CheckWidget() {
        open(urlWidget);
        switchTo().frame($(By.xpath("//div[@class='so_comments']//iframe")));
        $(By.xpath("//span[@id='display_name']")).shouldBe();
        //$(By.xpath("//span[@class='current-user-points-amount']")).shouldHave(text("ENGT(s)"));
        $(By.xpath("//span[@data-i18n='com.all_comments']")).shouldHave(text("All Comments"));
    }

    @Test
    public void t5_LogoutFromAdmin() {
        open(urlProfile);
        $(By.xpath("//li[@id='tab-panel-comments-li']//a")).shouldHave(text("Your comments"));
        $(By.className("dropdown-toggle")).shouldBe().click();
        $(By.className("signout")).click();
        $(By.id("facebook-login")).shouldHave(text("F"));
        $(By.id("tw-login")).shouldHave(text("T"));
        System.out.println("tests.LoginPage = method2");

    }

    @Test
    public void t6_LoginViaYahoo() {
        open(urlLogin);
        $(By.id("yahoo-login")).shouldBe().click();
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
        $(By.id("text_visible_email")).shouldHave(text(emailYahoo));
        $(By.xpath("//header[@class='header-signup']//a[@class='pull-left']")).shouldHave(attribute("href","https://solidopinion.com/"));
        $(By.xpath("//li[@id='tab-panel-comments-li']//a")).shouldHave(text("Your comments"));
        $(By.className("dropdown-toggle")).shouldBe().click();
        $(By.className("signout")).click();
        $(By.id("facebook-login")).shouldHave(text("F"));

    }

    @Test
    public void t7_LoginViaFacebook() {
        open(urlLogin);
        $(By.id("facebook-login")).shouldBe().click();
        switchTo().window(1);
        $(By.id("homelink")).shouldHave(text("Facebook"));
        $(By.id("email")).setValue(emailFD);
        $(By.id("pass")).setValue(passYFD);
        $(By.xpath("//input[@name='login']")).click();
        switchTo().window(0);
        $(By.id("text_visible_email")).shouldBe().shouldHave(text(emailFD));
        $(By.xpath("//header[@class='header-signup']//a[@class='pull-left']")).shouldHave(attribute("href","https://solidopinion.com/"));
        $(By.xpath("//li[@id='tab-panel-comments-li']//a")).shouldHave(text("Your comments"));
        $(By.className("dropdown-toggle")).shouldBe().click();
        $(By.className("signout")).click();
        $(By.id("facebook-login")).shouldHave(text("F"));
    }

  /*  @Test
    public void t8_LoginViaDisqus() {
        open(urlLogin);
        $(By.id("disqus-login")).shouldBe().click();
        switchTo().window(1);
        $(By.className("logo")).shouldHave(text("Disqus"));
        $(By.id("username")).setValue(emailYFD);
        $(By.id("password")).setValue(passYFD);
        $(By.className("btn")).click();
        switchTo().window(1);
        $(By.id("text_visible_email")).shouldBe().shouldHave(text(emailYFD));
        $(By.xpath("//header[@class='header-signup']//a[@class='pull-left']")).shouldHave(attribute("href","https://solidopinion.com/"));
        $(By.xpath("//li[@id='tab-panel-comments-li']//a")).shouldHave(text("Your comments"));
        $(By.className("dropdown-toggle")).shouldBe().click();
        $(By.className("signout")).click();
        $(By.id("facebook-login")).shouldHave(text("F"));
    }
  @Test
    public void t9_LoginViaTwitter() {
      open(urlLogin);
      $(By.id("tw-login")).shouldBe().click();
      switchTo().window(1);
      $(By.xpath("//h1[@class='logo']//a[@class='alternate-context']")).shouldHave(attribute("href", "https://twitter.com/home"));
      $(By.id("username_or_email")).setValue(emailTw);
      $(By.id("password")).setValue(passTw);
      $(By.id("allow")).click();
      switchTo().window(0);
      $(By.id("text_visible_email")).shouldBe().shouldHave(text(emailTw));
      $(By.xpath("//header[@class='header-signup']//a[@class='pull-left']")).shouldHave(attribute("href","https://solidopinion.com/"));
      $(By.xpath("//li[@id='tab-panel-comments-li']//a")).shouldHave(text("Your comments"));
      $(By.className("dropdown-toggle")).shouldBe().click();
      $(By.className("signout")).click();
      $(By.id("facebook-login")).shouldHave(text("F"));
  }
*/
  @Test
    public  void  t9_LoginViaGoogle() {
      Configuration.timeout = 6000;
      open(urlLogin);
      $(By.id("google-login")).shouldBe().click();
      switchTo().window(1);
      $(By.className("Fmgc2c")).shouldHave(text("Google"));
      $(By.id("identifierId")).setValue(emailG);
      $(By.id("identifierNext")).click();
      $(By.xpath("//input[@type='password']")).setValue(passG);
      $(By.id("passwordNext")).click();
      switchTo().window(0);
      $(By.id("text_visible_email")).shouldBe().shouldHave(text(emailG));
      $(By.xpath("//header[@class='header-signup']//a[@class='pull-left']")).shouldHave(attribute("href","https://solidopinion.com/"));
      $(By.xpath("//li[@id='tab-panel-comments-li']//a")).shouldHave(text("Your comments"));
      $(By.className("dropdown-toggle")).shouldBe().click();
      $(By.className("signout")).click();
      $(By.id("facebook-login")).shouldHave(text("F"));

  }
}

