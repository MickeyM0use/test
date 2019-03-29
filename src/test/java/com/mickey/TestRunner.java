package com.mickey;

import com.codeborne.selenide.Configuration;
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features=".")
public class TestRunner
{

    @BeforeClass
    static public void setUp() throws MalformedURLException
    {
        Configuration.timeout = System.getProperty("env").equals("k8s") ? 5000 : 15000;

        DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();

        ChromeOptions option = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("intl.accept_languages", "ru-RU,ru");
        prefs.put("profile.default_content_settings.popups", 0);
        option.setExperimentalOption("prefs", prefs);
        desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, option);

        RemoteWebDriver remoteDriver = new RemoteWebDriver(new URL(System.getProperty("hub.url")), desiredCapabilities);
        remoteDriver.setFileDetector(new LocalFileDetector());
        setWebDriver(remoteDriver);

        setResolution();

        // Записать текущее окружение в глобальную переменную
      //  Modules.current_env = System.getProperty(ENV_PROPERTY);
    }

    @AfterClass
    static public void closeBrowser()
    {
        close();
    }

    static private void setResolution()
    {
            getWebDriver().manage().window().maximize();

    }
}