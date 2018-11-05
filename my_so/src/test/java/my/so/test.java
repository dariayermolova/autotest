package my.so;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.google.common.io.Files;
import io.qameta.allure.Attachment;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.After;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

public class test {

    @BeforeTest(description = "Open a browser")
    public void getDriver() {
        Configuration.browser = "chrome";
        Configuration.timeout = 8000;
        Configuration.headless = true;
        Configuration.screenshots = true;
        Configuration.captureJavascriptErrors = true;
        System.out.println("Before Suite");
    }

    @BeforeClass
    public void addScreenAllure() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));

    }

    @AfterClass
    public void deleteScreenAllure() {
        SelenideLogger.removeListener("allureSelenide");
    }


    @After
    public void tearDown() throws IOException {
        screenshots();
    }

    @Attachment(type = "image/png")
    public byte[] screenshots() throws IOException {
        File screenshot = Screenshots.getLastScreenshot();
        return Files.toByteArray(screenshot);
    }

}