package my.so;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static my.so.addnewsite.allertName;

public class style extends suite {
    private String urlStyle = "https://my.solidopinion.com/settings/" + allertName + "#style";
    private String[] arrayType = {"0", "3", "4", "5"};
    private int randomType = (int) (Math.random() * arrayType.length);
    private String allertType = arrayType[randomType];

    private String[] arrayVorting = {"vote", "like", "both"};
    private int randomVorting = (int) (Math.random() * arrayVorting.length);
    private String allertVorting = arrayVorting[randomVorting];

    private String[] arrayColors = {"1", "0", "3"};
    private int randomColors = (int) (Math.random() * arrayColors.length);
    private String allertColors = arrayColors[randomColors];

    private String[] arrayPeriod = {"day", "3days", "week", "2weeks", "month", "3month", "6month", "year", "all"};
    private int randomPeriod = (int) (Math.random() * arrayPeriod.length);
    private String allertPeriod = arrayPeriod[randomPeriod];


    @Test(description = "Check configure")
    @Feature("Site")
    @Story("Style")
    public void t1_CheckConfigure() {
        $(By.xpath("//a[@data-target='#style1']")).click();
        open(urlStyle);
        $(By.xpath("//li[@class='active']//a[@href='#config']")).shouldBe();
        $(By.xpath("//select[@name='widget_type']")).selectOptionByValue(allertType);
        $(By.xpath("//select[@name='voting_type']")).selectOptionByValue(allertVorting);
        $(By.name("comments_page_size")).setValue("    ").setValue("3");
        $(By.id("save_widget")).click();
        $(By.xpath("//button[@data-dismiss='alert']")).waitUntil(Condition.visible, 10000);
    }

    @Test(description = "Check colors")
    @Feature("Site")
    @Story("Style")
    public void t2_CheckColors() {
        $(By.xpath("//li//a[@href='#colors']")).click();
        $(By.xpath("//li[@class='active']//a[@href='#colors']")).shouldBe();
        $(By.id("color_template")).selectOptionByValue(allertColors);
        $(By.id("transparent_bg")).click();
        $(By.id("save_widget")).click();
        $(By.xpath("//button[@data-dismiss='alert']")).waitUntil(Condition.visible, 10000);
    }

    @Test(description = "Check Ad space")
    @Feature("Site")
    @Story("Style")
    public void t3_CheckAdSpace() {
        $(By.xpath("//li//a[@href='#adblocks']")).click();
        $(By.xpath("//li[@class='active']//a[@href='#adblocks']")).shouldBe();
        $(By.id("top_left_block")).selectOptionByValue("ad");
        $(By.id("top_right_block")).selectOptionByValue("local");
        $(By.id("bottom_left_block")).selectOptionByValue("last");
        $(By.id("bottom_right_block")).selectOptionByValue("none");
        $(By.id("save_widget")).click();
        $(By.xpath("//button[@data-dismiss='alert']")).waitUntil(Condition.visible, 10000);
    }

    @Test(description = "Check Community tab")
    @Feature("Site")
    @Story("Style")
    public void t4_CheckCommunityTab() {
        $(By.xpath("//li//a[@href='#community']")).click();
        $(By.xpath("//li[@class='active']//a[@href='#community']")).shouldBe();
        $(By.id("display_community_option_popular")).click();
        $(By.id("display_community_option_top")).click();
        $(By.id("top_popular_period")).selectOptionByValue(allertPeriod);
        $(By.id("save_widget")).click();
        $(By.xpath("//button[@data-dismiss='alert']")).waitUntil(Condition.visible, 10000);
    }

    @Test(description = "Check Community widget")
    @Feature("Site")
    @Story("Style")
    public void t5_CheckCommunityWidget() {
        $(By.xpath("//li//a[@href='#community_widget']")).click();
        $(By.xpath("//li[@class='active']//a[@href='#community_widget']")).shouldBe();
        $(By.id("display_community_widget_option_people")).click();
        $(By.id("display_community_widget_option_last")).click();
        $(By.id("c_transparent_bg")).click();
        $(By.id("apply_comments_colors")).click();
        $(By.id("save_widget")).click();
        $(By.xpath("//button[@data-dismiss='alert']")).waitUntil(Condition.visible, 10000);
    }


}
