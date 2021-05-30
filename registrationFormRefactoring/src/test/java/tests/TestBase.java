package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

  @BeforeAll
  public static void setup() {
    Configuration.startMaximized = true;
  }
}