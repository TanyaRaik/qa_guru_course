package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationFormPage {

  public void openPage() {
    open("https://demoqa.com/automation-practice-form");
    $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
  }

  public void typeFirstName(String firstName) {
    $("#firstName").setValue(firstName);
  }

  public void typeLastName(String lastName) {
    $("#lastName").setValue(lastName);
  }

  public void typeUserNumber(String userNumber) {
    $("#userNumber").setValue(userNumber);
  }

  public void typeUserEmail(String userEmail) {
    $("#userEmail").setValue(userEmail);
  }

  public void typeCurrentAddress(String currentAddress) {
    $("#currentAddress").setValue(currentAddress);
  }

  public void typeSubject(String subjectsInput) {
    $("#subjectsInput").setValue(subjectsInput).pressEnter();
  }

  public void SelectGender(String gender) {
    $("#genterWrapper").$(byText(gender)).click();
  }

  public void SelectHobby(String hobby) {
    $("#hobbiesWrapper").$(byText(hobby)).click();
  }

  public void typeAddress(String address) {
    $("#subjectsInput").setValue(address);
  }

  public void selectState(String state){
    $("#state").click();
    $("#stateCity-wrapper").$(byText(state)).click();
  }

  public void selectCity(String city){
    $("#city").click();
    $("#stateCity-wrapper").$(byText(city)).click();
  }

  public void selectDateOfBirth(String month, String year, String day){
    $("[id=dateOfBirthInput]").click();
    $(".react-datepicker__year-select").selectOption(year);
    $(".react-datepicker__month-select").selectOption(month);
    $$(".react-datepicker__day:not(.react-datepicker__day--outside-month)").findBy(text(day)).click();
  }

  public void uploadPicture(String fileName) {
    $("#uploadPicture").uploadFromClasspath(fileName);
  }

  public void InitStudentRegistration() {
    $("#submit").click();
  }

  public void checkRegistrationFields(String firstName, String lastName, String email, String gender, String number,
                                      String day, String month, String year, String hobby1, String fileName,
                                      String currentAddress, String state, String city){
    $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

    $x("//td[text()='Student Name']").parent().shouldHave(text(firstName + " " + lastName));
    $x("//td[text()='Student Email']").parent().shouldHave(text(email));
    $x("//td[text()='Gender']").parent().shouldHave(text(gender));
    $x("//td[text()='Mobile']").parent().shouldHave(text(number));
    $x("//td[text()='Date of Birth']").parent().shouldHave(text(day + " " + month + "," + year));
    $x("//td[text()='Hobbies']").parent().shouldHave(text(hobby1));
    $x("//td[text()='Picture']").parent().shouldHave(text(fileName));
    $x("//td[text()='Address']").parent().shouldHave(text(currentAddress));
    $x("//td[text()='State and City']").parent().shouldHave(text(state + " " + city));
  }
}