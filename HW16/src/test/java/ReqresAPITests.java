
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;

public class ReqresAPITests {
  Faker faker = new Faker(new Locale("en"));
  String name = faker.funnyName().name();
  String job = faker.job().position();
  String email = "eve.holt@reqres.in";
  String password = faker.bothify("test");

  @Test
  void create () {
    ObjectNode body = new ObjectMapper().createObjectNode();
    body.put("name", name);
    body.put("job", job);
    given ()
            .contentType (JSON)
            .body(body)
            .when ()
            .post ("https://reqres.in/api/users")
            .then ()
            .statusCode (201)
            .contentType(JSON)
            .body ("name", is (name), "job", is (job));
  }

  @Test
  void createNegative () {
    given()
            .contentType(JSON)
            .body ("{\"job\"}")
            .when()
            .post("https://reqres.in/api/users")
            .then()
            .statusCode(400);
  }

  @Test
  void registerSuссessful () {
    ObjectNode body = new ObjectMapper().createObjectNode();
    body.put("email", email);
    body.put("password", password);

    given ()
            .contentType (JSON)
            .body (body)
            .when ()
            .post ("https://reqres.in/api/register")
            .then ()
            .statusCode (200)
            .contentType(JSON);
  }

  @Test
  void updateUser(){
    ObjectNode body = new ObjectMapper().createObjectNode();
    body.put("name", name);
    body.put("job", job + "123");
    given ()
            .contentType (JSON)
            .body (body)
            .when ()
            .put ("https://reqres.in/api/users/2")
            .then ()
            .statusCode (200)
            .contentType(JSON)
            .body ( "name", is (name), "job",is(job + "123"));
  }

  @Test
  void getUser(){
    given ()
            .contentType (JSON)
            .when ()
            .get ("https://reqres.in/api/users/2")
            .then ()
            .statusCode (200)
            .contentType(JSON);
  }

  @Test
  void deleteUser(){
    given ()
            .contentType (JSON)
            .when()
            .delete ("https://reqres.in/api/users/2")
            .then ()
            .statusCode (204);
  }
}
