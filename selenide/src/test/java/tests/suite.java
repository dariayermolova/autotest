package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class suite {







    @BeforeSuite
    public void getDriver() {
        Configuration.browser = "chrome";
        System.out.println("Before Suite");
    }

    @AfterSuite
    public void afterClass() {
        System.out.println("After Suite");
    }
}
