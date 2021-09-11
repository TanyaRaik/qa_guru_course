package tests;

import config.WebConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class WebTest {
  @Test
  public void openGitHubLocal() {
    System.setProperty("remote", "local");
    WebConfig webConfig = ConfigFactory.create(WebConfig.class, System.getProperties());
    assertThat(webConfig.getBaseUrl()).isEqualTo("https://github.com");
    assertThat(webConfig.getNameBrowser()).isEqualTo("chrome");
    assertThat(webConfig.getVersionBrowser()).isEqualTo("92.0");
    assertThat(webConfig.isRemote()).isEqualTo(false);
  }
  // команда для запуска теста gradlew clean test -Dremote=local

  @Test
  public void openGitHubRemote() {
    System.setProperty("remote", "remote");
    WebConfig webConfig = ConfigFactory.create(WebConfig.class, System.getProperties());
    assertThat(webConfig.getBaseUrl()).isEqualTo("https://github.com");
    assertThat(webConfig.getNameBrowser()).isEqualTo("chrome");
    assertThat(webConfig.getVersionBrowser()).isEqualTo("92.0");
    assertThat(webConfig.isRemote()).isEqualTo(true);
  }
  // команда для запуска теста gradlew clean test -Dremote=remote
}