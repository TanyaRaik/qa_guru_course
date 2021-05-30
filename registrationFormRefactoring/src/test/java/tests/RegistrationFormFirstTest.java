package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.StudentRegistrationFormPage;

import static utils.RandomUtils.*;
import static utils.RandomUtils.getRandomMonth;


public class RegistrationFormFirstTest extends TestBase{
    StudentRegistrationFormPage registrationPage = new StudentRegistrationFormPage();
    Faker faker = new Faker();
    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            gender = getRandomGender(),
            userNumber = faker.number().digits(10),
            month = getRandomMonth(),
            year = getRandomYear(),
            day = getRandomDay(),
            subjectsInput = getRandomString(10),
            hobby1 = getRandomHobby(),
            fileName = "Test-JPG.jpg",
            currentAddress = faker.address().fullAddress(),
            state = "Uttar Pradesh",
            city = "Merrut";

    @Test
    void fillInStudentRegistrationFormTest() {
        registrationPage.openPage();
        fillInFormFields();
        registrationPage.InitStudentRegistration();
        registrationPage.checkRegistrationFields(firstName, lastName, userEmail, gender, userNumber, day, month, year,
                hobby1, fileName, currentAddress, state, city);

    }

    private void fillInFormFields() {
        registrationPage.typeFirstName(firstName);
        registrationPage.typeLastName(lastName);
        registrationPage.typeUserNumber(userNumber);
        registrationPage.typeUserEmail(userEmail);
        registrationPage.typeCurrentAddress(currentAddress);
        registrationPage.typeSubject(subjectsInput);
        registrationPage.SelectGender(gender);
        registrationPage.SelectHobby(hobby1);
        registrationPage.selectState(state);
        registrationPage.selectCity(city);
        registrationPage.uploadPicture(fileName);
        registrationPage.selectDateOfBirth(month, year, day);
    }
}