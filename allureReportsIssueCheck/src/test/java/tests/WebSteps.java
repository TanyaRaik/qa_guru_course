package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.screenshot;

public class WebSteps extends TestBase{

  @Step("Open main page")
  public void openMainPage() {
    open(Configuration.baseUrl);
  }

  @Step("Find repository {repository}")
  public void searchForRepository(String repository) {
    $(".header-search-input").click();
    $(".header-search-input").sendKeys(repository);
    $(".header-search-input").submit();
  }

  @Step("Move to repository {repository}")
  public void goToRepository(String repository) {
    $(By.linkText(repository)).click();
  }

  @Step("Open Issues tab")
  public void openIssueTab() {
    $(withText("Issues")).click();
  }

  @Step("Verify Issue with number {number} is visible")
  public void shouldSeeIssueWithNumber(int number) {
    $(withText("#" + number)).should(Condition.visible);
  }

  @Attachment(value = "Screenshot", type = "image/png")
  public byte[] makeScreenshot() {
    return screenshot(OutputType.BYTES);
  }

}