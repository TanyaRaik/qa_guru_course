package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
  public static final String repository = "selenide/selenide";
  public static final int issue_number = 1477;

  @BeforeAll
  public static void setup(){
    Configuration.startMaximized = true;
    Configuration.baseUrl = "https://github.com";
  }
}