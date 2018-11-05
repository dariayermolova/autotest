package widget;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import my.so.suite;
import my.so.test;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;


public class headline extends test {
    private String urlWidget = "http://my.solidopinion.com/demo/?sitename=prod40118";
    private String emailSo = "daria.yermolova@nure.ua";
    private String passSo = "D21UDOW2";

    @Test(description = "Login to headline and post headline")
    @Feature("Widget")
    @Story("Headline")
    public void t1_LoginAndPost() {
        open(urlWidget);
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        refresh();
        switchTo().frame($(By.xpath("//div[@class='so_promo_headline']//iframe")));
        $(By.id("headline")).click();
        switchTo().defaultContent();
        switchTo().frame($(By.xpath("//div[@class='so_promo_headline_submit']//iframe")));
        $(By.id("headline-text")).waitUntil(Condition.visible, 10000).setValue("autotest");
        $(By.id("headline-url")).setValue("test.com");
        $(By.xpath("//div[@class='headline-promoted-form clearfix']//input")).click();
        switchTo().window(1);
        $(By.id("email")).waitUntil(Condition.visible, 20000).setValue(emailSo);
        $(By.id("password")).setValue(passSo);
        $(By.id("go_login")).click();
        switchTo().window(0);
        switchTo().frame($(By.xpath("//div[@class='so_promo_headline_submit']//iframe")));
        $(By.xpath("//div[@class='headline-promoted-form clearfix']//input")).waitUntil(Condition.visible, 20000).click();
        $(By.xpath("//div[@class='btn-actions']//button")).waitUntil(Condition.visible, 20000).click();
      //  $(By.xpath("//div[@class='so-alert so-alert-success']")).shouldBe(Condition.visible);
    }
}