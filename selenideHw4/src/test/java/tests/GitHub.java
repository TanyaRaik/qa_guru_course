package tests;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class GitHub {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void GitHubTest() {
        //Open git hub
        open("https://github.com/selenide/selenide");

        //Move to wiki tab
        $(byText("Wiki")).click();

        //Filter "SoftAssertions"
        $("#wiki-pages-filter").setValue("SoftAssertions").pressEnter();

        // Make sure SoftAssertions is visible and click the link
        $(byText("SoftAssertions")).should(visible).click();

        //Asserts for JUnit5
        $("#wiki-body").shouldHave(text("Using JUnit5 extend test class:"));
    }
}