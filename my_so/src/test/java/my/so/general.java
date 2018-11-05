package my.so;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static my.so.addnewsite.allertName;

public class general extends suite {
    private String[] arrayLanguage = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13"};
    private int randLanguage = (int) (Math.random() * arrayLanguage.length);
    private String language = arrayLanguage[randLanguage];
    private String urlGeneral = "https://my.solidopinion.com/settings/" + allertName + "#general";

    @Test(description = "Change general")
    @Feature("Site")
    @Story("General")
    public void t1_ChangeInfo() {
        open(urlGeneral);
        $(By.xpath("//li[@class='active']//a[@data-target='#general1']")).shouldBe();
        $(By.id("sitename")).setValue("                                ");
        $(By.id("sitename")).setValue("autotest");
        $(By.id("siteurl")).setValue("                                  ");
        $(By.id("siteurl")).setValue("autotest.com");
        $(By.id("language_id")).selectOptionByValue(language);
        $(By.id("save_general")).click();
   //     $(By.className("dropdown-toggle")).shouldBe().click();
   //     $(By.className("signout")).click();
    }
}
