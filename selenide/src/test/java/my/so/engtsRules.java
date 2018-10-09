package my.so;

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
        $(By.xpath("//a[@data-target='#gamerules1']")).click();
        open(urlGamerules);

    }
}
