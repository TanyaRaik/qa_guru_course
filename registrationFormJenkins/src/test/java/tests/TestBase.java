package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {

  @BeforeAll
  public static void setup() {
    Configuration.startMaximized = true;
    Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub/";
  }
}