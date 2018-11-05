package my.so;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static my.so.addnewsite.allertName;

public class ranks extends suite {
    private String urlRanks = "https://my.solidopinion.com/settings/" + allertName + "#ranks1";

    
    @Test(description = "Select template")
    @Feature("Site")
    @Story("Ranks")
    public void t1_SelectTemplate() {
        open(urlRanks);
        $(By.xpath("//a[@data-target='#ranks1']")).waitUntil(Condition.visible, 15000).click();
        open(urlRanks);
        $(By.id("ranksmenu")).waitUntil(Condition.visible, 15000).click();
        $(By.xpath("//a[@data-value='Music reviews']")).click();
        $(By.id("modalWindowWarning")).shouldBe(Condition.visible);
        $(By.xpath("//div[@id='modalWindowWarning']//h3[@id='changethenameLabel']")).shouldBe();
        $(By.xpath("//button[@class='btn btn-primary save_data']")).waitUntil(Condition.visible, 10000).click();
        $(By.xpath("//div[@class='alert alert-success']")).waitUntil(Condition.visible, 10000);
        $(By.xpath("//div[@class='alert alert-success']//button")).click();
        $(By.xpath("//span[@id='ranks_template_name']//b")).shouldHave(Condition.text("Music reviews"));
        $(By.xpath("//tr[@class='rank_row'][1]//span[@class='general']")).shouldHave(Condition.text("Boss"));
    }

    @Test(description = "Add rank")
    @Feature("Site")
    @Story("Ranks")
    public void t2_AddRank() {
        open(urlRanks);
        $(By.xpath("//div[@id='table_abs']//button[@href='#modalAddRank']")).waitUntil(Condition.visible, 15000).click();
        $(By.id("modalAddRank")).shouldBe(Condition.visible);
        $(By.id("//div[@id='modalAddRank']//h3[@id='addRankLabel']")).shouldBe();
        $(By.id("rank_title")).setValue("autotest");
        $(By.id("rank_moderator")).click();
        $(By.id("rank_protection")).click();
        $(By.id("rank_points")).setValue("10");
        $(By.id("rank_free_rule")).selectOptionByValue("change_name");
        $(By.id("add_rank")).click();
        $(By.xpath("//div[@class='alert alert-success']")).waitUntil(Condition.visible, 10000);
        $(By.xpath("//div[@class='alert alert-success']//button")).click();
        $(By.xpath("//tr[@class='rank_row'][3]//span[@class='general']")).shouldHave(Condition.text("autotest"));

    }

    @Test(description = "Add custom rank")
    @Feature("Site")
    @Story("Ranks")
    public void t3_AddCustomRank() {
        open(urlRanks);
        $(By.id("addCustomRankButton")).waitUntil(Condition.visible, 15000).click();
        $(By.id("addCustomRankModal")).shouldBe(Condition.visible);
        $(By.xpath("//div[@id='addCustomRankModal']//h3[@id='addRankLabel2']")).shouldBe();
        $(By.id("searchUserField")).setValue("jonnydepp679@yahoo.com");
        $(By.id("customRankTitle")).setValue("autotest");
        $(By.id("saveCustomRankChanges")).click();
        $(By.xpath("//table[@id='customRankTable']//span[@class='general']")).shouldHave(Condition.text("autotest"));
    }
}
