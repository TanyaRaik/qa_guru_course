package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static config.Credentials.credentials;

public class TestBase {

  @BeforeAll
  public static void setUp() {
    SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

    Configuration.startMaximized = true;

    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("enableVNC", true);
    capabilities.setCapability("enableVideo", true);
    Configuration.browserCapabilities = capabilities;

    String login = credentials.login();
    String password = credentials.password();

    Configuration.remote = String.format("https://%s:%s@%s/wd/hub/", login, password, System.getProperty("selenoidUrl"));
  }

  @AfterEach
  public void tearDown() {
    String sessionId = getSessionId();

    Attach.screenshotAs("Last screenshot");
    Attach.pageSource();
    Attach.browserConsoleLogs();
    closeWebDriver();

    Attach.addVideo(sessionId);
  }

  public static String getSessionId() {
    return ((RemoteWebDriver) getWebDriver()).getSessionId().toString();
  }
}