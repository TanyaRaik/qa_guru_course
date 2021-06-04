package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
  public static final String repository = "selenide/selenide";
  public static final int issue_number = 1479;
  public static final String issue_name = "Add work with Alert during file upload";

  @BeforeAll
  public static void setup(){
    Configuration.startMaximized = true;
    Configuration.baseUrl = "https://github.com";
  }
}