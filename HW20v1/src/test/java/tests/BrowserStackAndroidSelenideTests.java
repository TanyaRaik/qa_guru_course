package tests;

import com.codeborne.selenide.CollectionCondition;
import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;


@Tag("selenide_android")
public class BrowserStackAndroidSelenideTests extends TestBase {

  @Test
  @DisplayName("Successful search in wikipedia android app")
  void searchTest() {
    step("Type search", () -> {
      $(MobileBy.AccessibilityId("Search Wikipedia")).click();
      $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).val("BrowserStack");
    });
    step("Verify content found", () ->
            $$(MobileBy.id("org.wikipedia.alpha:id/page_list_item_container"))
                    .shouldHave(sizeGreaterThan(0)));
  }

  @Test
  @DisplayName("Header in article android app")
  void checkHeaderTest() {
    step("Type search", () -> {
      $(MobileBy.AccessibilityId("Search Wikipedia")).click();
      $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).val("Putin's Palace");
    });

    step("Select an article", () ->
            $$(MobileBy.className("android.widget.TextView")).
                    findBy(text("Search Wikipedia")).click());

    $(MobileBy.id("org.wikipedia.alpha:id/view_page_title_text")).
            shouldHave(text("Putin's Palace"));
  }

  @Test
  @DisplayName("Options of article in wikipedia android app")
  void optionsOfArticleTest() {
    step("Click more options", () -> {
      $$(MobileBy.id("org.wikipedia.alpha:id/view_list_card_header_menu")).get(0).click();
    });

    step("Verify available options", () -> {
      $$(MobileBy.id("org.wikipedia.alpha:id/title"))
              .shouldBe(CollectionCondition.itemWithText("Hide this card"));
    });
  }
}