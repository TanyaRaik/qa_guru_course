package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GitHubIssueSelenideTest extends TestBase {

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Selenide Find Issue")
    public void testGitHubIssueSelenide() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open(Configuration.baseUrl);
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repository);
        $(".header-search-input").submit();
        $(By.linkText(repository)).click();
        $(withText("Issues")).click();
        $(withText("#" + issue_number)).should(Condition.visible);
        $(withText(issue_name)).should(Condition.visible);
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Selenide Find Issue Failed")
    public void testGitHubIssueSelenideFailed() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open(Configuration.baseUrl);
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repository);
        $(".header-search-input").submit();
        $(By.linkText(repository)).click();
        $(withText("Issues")).click();
        $(withText("#" + issue_number)).should(Condition.visible);
        $(withText(issue_name + "12345")).should(Condition.visible);
    }
}