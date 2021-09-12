import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.Matchers.is;

public class DemoAPITests {
  String baseUrl = "http://demowebshop.tricentis.com/";
  String cookieName = "Nop.customer";
  String cookieValue = "706b4e21-7362-442c-8b26-ca7c9ac03f49";

  @Test
  void addToCartTest(){
    Response response =
            given()
                    .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                    .cookie(cookieName, cookieValue)
                    .body("addtocart_43.EnteredQuantity=2")
                    .when()
                    .post(baseUrl+"addproducttocart/details/43/1")
                    .then()
                    .statusCode(200)
                    .body("success", is(true))
                    .body("message", is("The product has been added to your <a href=\"/cart\">shopping cart</a>"))
                    .extract().response();

    String itemsInCard = response.path("updatetopcartsectionhtml");

    open(baseUrl+"favicon.ico");
    getWebDriver().manage().addCookie(new Cookie(cookieName, cookieValue));
    open(baseUrl);
    assertThat($(".cart-qty").getText()).isEqualTo(itemsInCard);
    getWebDriver().manage().deleteAllCookies();
  }


  @Test
  public void addToWishListTest() {
    Response response =
            given()
                    .contentType("application/x-www-form-urlencoded")
                    .cookie(cookieName, cookieValue)
                    .body("addtocart_43.EnteredQuantity=1")
                    .when()
                    .post(baseUrl+"addproducttocart/details/43/2")
                    .then()
                    .statusCode(200)
                    .body("success", is(true))
                    .body("message", is("The product has been added to your <a href=\"/wishlist\">wishlist</a>"))
                    .extract().response();

    String itemsInWishList = response.path("updatetopwishlistsectionhtml");

    open(baseUrl+"favicon.ico");
    getWebDriver().manage().addCookie(new Cookie(cookieName, cookieValue));
    open(baseUrl);
    assertThat($(".wishlist-qty").getText()).isEqualTo(itemsInWishList);
    getWebDriver().manage().deleteAllCookies();
  }
}