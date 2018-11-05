package my.so;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static my.so.addnewsite.allertName;

public class engtsRules extends suite{
    private String urlGamerules = "https://my.solidopinion.com/settings/" + allertName + "#gamerules1";

    @Test(description = "Select template")
    @Feature("Site")
    @Story("Engt(s) Rules")
    public void t1_SelectTemplate() {
        open(urlGamerules);
        $(By.xpath("//a[@data-target='#gamerules1']")).click();
        open(urlGamerules);
        $(By.id("gameslist")).click();
        $(By.xpath("//a[@data-value='Game Rules Gamified']")).click();
        $(By.id("save_rules")).click();
        $(By.xpath("//div[@class='alert alert-success']")).waitUntil(Condition.visible, 10000);
        $(By.xpath("//span[@id='rules_template_name']//b")).shouldHave(Condition.text("Game Rules Gamified"));
        $(By.id("click_on_post_share")).shouldBe(Condition.readonly);
    }

    @Test(description = "Send custom template")
    @Feature("Site")
    @Story("Engy(s) Rules")
    public void t2_SendCustomTemplate() {
        open(urlGamerules);
        $(By.id("request_rules")).click();
        $(By.id("newGameRulesPopup")).shouldBe(Condition.visible);
        $(By.xpath("//div[@id='newGameRulesPopup']//h3[@id='addRankLabel2']")).shouldHave(Condition.text("Order custom template"));
        $(By.id("customRulesDescriptionText")).setValue("Hi, it's a message from autotest. Don't pay attention");
        $(By.id("sendGameRulesRequest")).click();
        $(By.id("newGameRulesPopup")).shouldBe(Condition.disappear);
    }
}
