package my.so;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static my.so.addnewsite.allertName;

public class moderation extends suite{
    private String urlModeration = "https://my.solidopinion.com/settings/" + allertName + "#moderation1";
    private String urlLogin = "https://my.solidopinion.com/signin";
    private String emailAdmin = "daria.yermolova@nure.ua";
    private String passAdmin = "D21UDOW2";




    @Test(description = "Check Moderation")
    @Feature("Site")
    @Story("Moderation")
    public void t1_CheckModeration() {
        open(urlModeration);
        $(By.xpath("//a[@data-target='#moderation1']")).waitUntil(Condition.visible, 15000).click();
        $(By.id("moderate__allcomments")).waitUntil(Condition.visible, 15000).click();
        $(By.id("moderate_comments_with_links")).shouldHave(Condition.attribute("disabled"));
        $(By.id("moderate_postmoderation")).click();
        $(By.id("moderator_tag")).setValue("     ").setValue("autotest");
        $(By.xpath("//div[@id='moderator_tag_enabled']//label[1]")).click();
        $(By.xpath("//input[@value='ADMIN_AND_MODERATORS']")).click();
        $(By.id("save_moderation")).click();
   //     $(By.xpath("//div[@class='alert alert-success']")).waitUntil(Condition.visible, 15000);


    }

    @Test(description = "Check add moderator")
    @Feature("Site")
    @Story("Moderation")
    public void t2_CheckAddModeration() {
        open(urlModeration);
        $(By.xpath("//button[@href='#addModerator']")).click();
        $(By.id("addModerator")).shouldBe(Condition.visible);
        $(By.id("moderator_email")).setValue("testsolidopinion@yahoo.com");
        $(By.id("settings")).click();
        $(By.id("add_moderator")).click();
        $(By.xpath("//div[@class='actions-bar'][1]//span[@class='moderator_email']")).shouldHave(Condition.attribute("data-code",
                "06b25b9be3c47b28d5319d177b2e3bb2ed311eba"));
        $(By.xpath("//div[@class='actions-bar'][1]//div[@class='icon-delete']")).click();
        $(By.xpath("//div[@class='actions-bar'][1]//span[@class='moderator_email']")).waitUntil(visible, 20000).shouldHave(Condition.attribute("data-code",
                "0918ccb125b1b313bcf82a8d1850d40861cd78e4"));
        $(By.id("save_moderation")).click();
    //    $(By.xpath("//div[@class='alert alert-success']")).waitUntil(Condition.visible, 15000);
    }


}