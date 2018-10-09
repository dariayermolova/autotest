package ims;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;

public class WidgetLoginFacebook extends suite {
    private String urlWidgets = "http://my.solidopinion.com/demo/?sitename=prod40118";
    private String commentsTest = "test";
    private String emailFD = "alexandrine.sandrine99@gmail.com";
    private String passYFD = "!Q2w3e4r5t";


    @Test(description = "Login to widget via facebook")
    @Feature("IMS")
    @Story("Login")
    public void t1_LoginViaFacebook() {
        open(urlWidgets);
        switchTo().frame($(By.xpath("//div[@class='so_comments']//iframe")));
        $(By.className("top_comments")).shouldHave(Condition.text("TOP Comments"));
        $(By.xpath("//span[@data-i18n='com.all_comments']")).shouldHave(Condition.text("All Comments"));

        $(By.xpath("//div[@id='comment_data']")).setValue(commentsTest);

        $(By.xpath("//span[@class='icon-facebook']")).shouldHave(Condition.text("F")).click();
        switchTo().window(1);
        $(By.id("email")).setValue(emailFD);
        $(By.id("pass")).setValue(passYFD);
        $(By.xpath("//input[@name='login']")).click();
        switchTo().window(0);
        switchTo().frame($(By.xpath("//div[@class='so_comments']//iframe")));
        $(By.xpath("//span[@id='display_name']")).shouldBe();
        $(By.id("top_menu_list")).click();
        $(By.xpath("//a[@data-i18n='com.user_menu_logout']")).click();
        $(By.xpath("//span[@id='display_name']")).shouldNotBe();
    }
}
