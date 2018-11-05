package my.so;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class profile extends suite {

   private String urlLogin = "https://my.solidopinion.com/signin";
    private String email = "daria.yermolova@nure.ua";
    private String pass = "D21UDOW2";
    private String randomName = "autotest+" + (int) (Math.random() * 1000);
    private String randomLocation = "Kiev " + (int) (Math.random() * 1000);
    private String randomAbout = "test " + (int) (Math.random() * 1000);
    private String[] arrayTimezone = {"Pacific/Midway", "America/Anchorage", "Pacific/Pitcairn", "America/Denver", "America/Phoenix",
    "America/Los_Angeles", "Pacific/Easter", "America/Cayman", "America/Lima", "America/New_York", "America/Barbados"};
    private int randomNumberTimezone = (int) (Math.random() * arrayTimezone.length);
    private String allertTimezone = arrayTimezone[randomNumberTimezone];




    @Test(description = "Change user information")
    @Feature("Profile")
    @Story("User's info")
    public void t2_ChangeInfo () {
        $(By.xpath("//input[@id='button-change']")).click();
        $(By.id("visible_name")).setValue("                                ");
        $(By.id("visible_name")).shouldBe().setValue(randomName);
        $(By.id("visible_email")).shouldHave(text(email));
        $(By.id("visible_location")).shouldBe().setValue(randomLocation);
        $(By.id("visible_about")).shouldBe().setValue(randomAbout);
        $(By.id("visible_timezone")).selectOptionByValue(allertTimezone);
        $(By.id("visible_datetime_format_absolute")).click();
        $(By.id("go_save")).click();
    }

    @Test(description = "Check the changed information")
    @Feature("Profile")
    @Story("User's info")
    public void t3_CheckInfo() {
        $(By.id("text_visible_name")).shouldHave(text(randomName));
        $(By.id("text_visible_location")).shouldHave(text(randomLocation));
        $(By.id("text_visible_about")).shouldHave(text(randomAbout));
        $(By.id("text_visible_timezone")).shouldHave(text(allertTimezone));
        $(By.id("text_visible_datetime_format")).shouldBe();

    }

    @Test(description = "Find any site with user activity")
    @Feature("Profile")
    @Story("User's activity")
    public void t4_FindSite() {
        $(By.id("site-search")).setValue("prod40118");
        $(By.id("points_qty_prod40118")).shouldBe();
        $(By.xpath("//span[@class='title-mod']//b")).shouldBe(visible);
    }

    @Test(description = "Check user's comments")
    @Feature("Profile")
    @Story("User's activity")
    public void t5_CheckComments() {
        $(By.xpath("//button[@data-url='solidopinion.com']")).click();
        $(By.className("profile-comments")).shouldBe();
        $(By.xpath("//div[@class='profile-comments']//div[@class='wrap-popover-list-profile']")).shouldBe();
        $(By.className("goBack")).click();
    }
    @Test(description = "Check user's promo comments")
    @Feature("Profile")
    @Story("User's activity")
    public void t6_CheckPromoComments() {
        $(By.id("site-search")).setValue("prod40118");
        $(By.id("points_qty_prod40118")).shouldBe();
        $(By.xpath("//a[@href='#tab-panel-promoted']")).click();
        sleep(2000);
        $(By.xpath("//div[@class='prom_art_url']//a")).waitUntil(visible, 20000).shouldHave(text("Go to discussion"));
        $(By.xpath("//button[@data-site_id='prod40118']")).shouldHave(text("Promote"));
        $(By.xpath("//div[@class='prom_art_name']//span")).shouldHave(text("Article name:"));
      //  $(By.className("dropdown-toggle")).shouldBe().click();
    //    $(By.className("signout")).click();
    }
/*
    @Test(description = "Delete profile")
    @Feature("Profile")
    @Story("Delete/Restore profile")
    public void t7_DeleteProfile() {
        $(By.id("remove_account")).click();
        $(By.id("warning_message")).shouldBe(visible);
      //  $(By.xpath("//input[@value='remove_account']")).shouldBe(visible);
        $(By.className("//div[@id='modalWindowWarning']//div[@class='modal-footer'][1]//button[1]")).click();
        $(By.className("removed-header")).shouldBe(visible);
    }

    @Test(description = "Restore profile")
    @Feature("Profile")
    @Story("Delete/Restore profile")
    public void t8_RestoreProfile() {
        $(By.id("restore_account")).click();
        $(By.xpath("//input[@value='restore_account']")).shouldBe();
        $(By.className("//button[@class='btn btn-primary save_data']")).click();
        $(By.id("text_visible_email")).shouldHave(text(email));
        $(By.className("dropdown-toggle")).shouldBe().click();
        $(By.className("signout")).click();
    }
*/


}
