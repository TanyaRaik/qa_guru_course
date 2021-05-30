package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormFirstTest {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void successfulSubmitFormTest() {
        open("https://demoqa.com/automation-practice-form");

        //set variables
        String firstName = "firstName";
        String lastName = "firstName";
        String userNumber = "1234567890";
        String userEmail = "test@test.com";
        String currentAddress = "Test Address";
        String subjectsInput = "Coding";
        String day = "16";
        String month = "January";
        String year = "1992";


        String dateOfBirth = $("#dateOfBirthInput").getValue();
        String fileName = "Test-JPG.jpg";

        //Fill in form fields
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userNumber").setValue(userNumber);
        $("#userEmail").setValue(userEmail);
        $("#currentAddress").setValue(currentAddress);
        $("[for=gender-radio-1]").click();
        $("[for=hobbies-checkbox-1]").click();
        $("#subjectsInput").setValue(subjectsInput);
 
        $("#state").click();
        $("#react-select-3-option-0").click();
        String state = $("#state .css-1uccc91-singleValue").getText();

        $("#city").click();
        $("#react-select-4-option-0").click();
        String city = $("#city .css-1uccc91-singleValue").getText();

        $("#uploadPicture").uploadFile(new File("src/test/java/resources/"+fileName));

        $("[id=dateOfBirthInput]").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $("[aria-label='Choose Thursday, " + month + " " + day + "th, " + year + "']").click();


        $("#submit").click();

        //Check fields in an opened form
        $(".table-responsive").shouldHave(text(firstName + ' ' + lastName));
        $(".table-responsive").shouldHave(text(userEmail));
        $(".table-responsive").shouldHave(text(userNumber));
        $(".table-responsive").shouldHave(text(day+ ' ' + month + ',' + year));
//        $(".table-responsive").shouldHave(text(subjectsInput));
        $(".table-responsive").shouldHave(text(fileName));
        $(".table-responsive").shouldHave(text("Sports"));
        $(".table-responsive").shouldHave(text(currentAddress));
        $(".table-responsive").shouldHave(text(state + ' '+ city));
    }
}