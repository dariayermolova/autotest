package my.so;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static my.so.addnewsite.allertName;

public class filters extends suite {
    private String urlFilters = "https://my.solidopinion.com/settings/" + allertName + "#filters1";

    @Test(description = "Check Restricted Words")
    @Feature("Site")
    @Story("Filters")
    public void t1_CheckRestrictedWords() {
        $(By.xpath("//a[@data-target='#filters1']")).click();
        open(urlFilters);
        $(By.id("restricted_words")).setValue("spam");
        $(By.id("dropdownMenuLang")).click();
        $(By.xpath("//li[1]//label//input[@class='profanity_list_item']")).click();
    }

    @Test(description = "Check ip, domain, social")
    @Feature("Site")
    @Story("Filters")
    public void t2_CheckIpDomainSocial() {
        $(By.id("allowed_ips")).setValue("192.168.1.105");
        $(By.id("allowed_domains")).setValue("autotest.com");
        $(By.id("fb")).click();
        $(By.id("gp")).click();
        $(By.id("save_filters")).click();
        $(By.xpath("//button[@data-dismiss='alert']")).waitUntil(Condition.visible, 10000);
    }

    @Test(description = "Check blacklist")
    @Feature("Site")
    @Story("Filters")
    public void t3_CheckBlacklist() {
        $(By.xpath("//button[@href='#modalAddFilter']")).click();
        $(By.id("modalAddFilter")).shouldBe(Condition.visible);
        $(By.id("filter_value")).setValue("Jonnydepp679@yahoo.com").pressEnter();
        $(By.className("autocomplete-suggestion")).waitUntil(Condition.visible, 15000).click();
        $(By.id("filter_description")).setValue("spam");
        $(By.id("save_filter")).click();
        $(By.className("filter_email")).shouldHave(Condition.text("Jonnydepp679@yahoo.com"));
        $(By.xpath("//div[@data-filter_value='jonnydepp679@yahoo.com']")).click();
        $(By.className("filter_email")).shouldNotBe();
    }
}
