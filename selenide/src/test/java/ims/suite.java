package ims;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Screenshots;
import com.google.common.io.Files;
import io.qameta.allure.Attachment;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

import java.io.File;
import java.io.IOException;

public class suite {


    @BeforeClass(description = "Open a browser")
    public void getDriver() {
        Configuration.browser = "chrome";
        Configuration.timeout = 6000;
        //Configuration.headless = true;
        Configuration.browserSize = "1366x768";
        Configuration.screenshots = true;
        Configuration.captureJavascriptErrors = true;
        System.out.println("Before Suite");
    }

    @AfterSuite
    public void afterClass()
    {
        System.out.println("After Suite");

    }
    @After
    public void tearDown() throws IOException {
        screenshot();
    }

    @Attachment(type = "image/png")
    public byte[] screenshot() throws IOException {
        File screenshot = Screenshots.getLastScreenshot();
        return Files.toByteArray(screenshot);
    }

}
