package tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GitHubIssueAnnotationsTest extends TestBase{

  private WebSteps steps = new WebSteps();

  @Test
  @Severity(SeverityLevel.BLOCKER)
  @DisplayName("Annotations Find Issue ")
  public void testIssueSearchAnnotations() {
    steps.openMainPage();
    steps.searchForRepository(repository);
    steps.goToRepository(repository);
    steps.openIssueTab();
    steps.shouldSeeIssueWithNumber(issue_number);
    steps.shouldSeeIssueWithName(issue_name);
    steps.makeScreenshot();
  }

  @Test
  @Severity(SeverityLevel.BLOCKER)
  @DisplayName("Annotations Find Issue Failed")
  public void testIssueSearchAnnotationsFailed() {
    steps.openMainPage();
    steps.searchForRepository(repository);
    steps.goToRepository(repository);
    steps.openIssueTab();
    steps.shouldSeeIssueWithNumber(issue_number);
    steps.shouldSeeIssueWithName(issue_name + "12345");
    steps.makeScreenshot();
  }
}