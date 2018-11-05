package my.so;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static my.so.addnewsite.allertName;

public class revenue extends suite {
    private String urlRevenue = "https://my.solidopinion.com/settings/" + allertName + "#revenue";

    @Test(description = "Change Promoted Headline")
    @Feature("Site")
    @Story("Revenue")
    public void t1_ChangePH() {
        open(urlRevenue);
        $(By.xpath("//a[@data-target='#revenue1']")).click();
        $(By.id("headline_min_points")).setValue("    ");
        $(By.id("headline_length")).setValue("    ").setValue("0");
        $(By.id("headline_allow_multi_line_false")).click();
        $(By.id("expiration_time_headline")).setValue("   ");

    }

    @Test(description = "Change Default Headline Options")
    @Feature("Site")
    @Story("Revenue")
    public void t2_ChangeDHO() {
        $(By.id("headline_font_size")).setValue("   ").setValue("0");
        $(By.xpath("//div[@id='default-justification']//label[2]")).click();
        $(By.id("shading_1")).click();
        $(By.id("default_headline_tooltip")).setValue("autotest");
        $(By.id("default-preview-editor")).setValue("autotest");
        $(By.id("default-headline-link")).setValue("autotest.com");
        $(By.xpath("//div[@id='headline_ads_layout']//div[@data-toggle='buttons']//label[1]")).click();

    }
    @Test(description = "Change Promoted Headlines Options")
    @Feature("Site")
    @Story("Revenue")
    public void t3_ChangePHO() {
        $(By.id("promo_fontSize")).setValue("   ").setValue("0");
        $(By.id("shading_2")).click();

        $(By.id("learn_more_link")).setValue("autotest.com");
    }

    @Test(description = "Change Promoted Comments")
    @Feature("Site")
    @Story("Revenue")
    public void t4_ChangePC() {
        $(By.id("promo_page_size")).setValue("2");
        $(By.id("promo_min_points")).setValue("1");
        $(By.id("set_promotion_message_all")).click();
        $(By.id("promo_expiration")).click();
        $(By.id("promo_expiration_days")).setValue("1");
        $(By.id("promo_title")).setValue("autotest");
        $(By.id("promo_placeholder")).setValue("autotest");
        $(By.id("promo_display_balance")).click();
        $(By.id("promo_description")).setValue("autotest");
        $(By.id("promo_dummy_author")).setValue("autotest");
        $(By.id("promo_dummy_text")).setValue("autotest");
        $(By.id("promo_ads_explanation")).setValue("autotest");
        $(By.id("save_pomoted")).click();
        $(By.xpath("//button[@data-dismiss='alert']")).waitUntil(Condition.visible, 10000);

        refresh();
    }

}
