package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class GitHubIssueLambdaStepsTest extends TestBase{

  @Test
  @Severity(SeverityLevel.BLOCKER)
  @DisplayName("Lambda steps Find Issue")
  public void testIssueSearch() {
    step("Open main page", (s) -> {
      s.parameter("url", Configuration.baseUrl);
      open(Configuration.baseUrl);
    });

    step("Find repository " + repository, (s) -> {
      s.parameter("repository", repository);
      $(".header-search-input").click();
      $(".header-search-input").sendKeys(repository);
      $(".header-search-input").submit();
    });

    step("Move to repository " + repository, (s) -> {
      s.parameter("repository", repository);
      $(By.linkText(repository)).click();
    });

    step("Open Issues tab", () -> {
      $(withText("Issues")).click();
    });

    step("Verify Issue with number " + issue_number + " is visible", (s) -> {
      s.parameter("number", issue_number);
      $(withText("#"+ issue_number)).should(Condition.visible);
    });
  }

  @Test
  @Severity(SeverityLevel.BLOCKER)
  @DisplayName("Lambda steps Find Issue Failed")
  public void testIssueSearchFailed() {
    step("Open main page", (s) -> {
      s.parameter("url", Configuration.baseUrl);
      open(Configuration.baseUrl);
    });

    step("Find repository " + repository, (s) -> {
      s.parameter("repository", repository);
      $(".header-search-input").click();
      $(".header-search-input").sendKeys(repository);
      $(".header-search-input").submit();
    });

    step("Move to repository " + repository, (s) -> {
      s.parameter("repository", repository);
      $(By.linkText(repository)).click();
    });

    step("Open Issues tab", () -> {
      $(withText("Issues")).click();
    });

    step("Verify Issue with number " + issue_number + " is visible", (s) -> {
      s.parameter("number", issue_number + 12345);
      $(withText("#"+ issue_number + 12345)).should(Condition.visible);
    });
  }
}
