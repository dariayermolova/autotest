package my.so;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class addnewsite extends suite {
    private String urlsites = "https://my.solidopinion.com/sites";
    private String email = "daria.yermolova@nure.ua";
    private String pass = "D21UDOW2";


    public static String randomSitename() {
        String randomName = "shortname" + (int) (Math.random() * 1000);
        return randomName;
    }

    public static String allertName = randomSitename();

    @Test(description = "Add new site")
    @Feature("Site")
    @Story("New site")
    public void t1_AddNewSite() {
        open(urlsites);
        $(By.xpath("//div[@id='navbar']//a")).click();
        $(By.id("sitename")).setValue("sitename");
        $(By.id("siteurl")).setValue("autotest.com");
        $(By.id("shortname")).setValue(allertName);
        $(By.id("go_save")).click();
        System.out.println(allertName);
    }
}