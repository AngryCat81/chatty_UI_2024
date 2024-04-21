package pages;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

 public class RegistrationPage {

     private SelenideElement registrationFormTitle = $(By.tagName("h1"));
     private SelenideElement emailInputField = $(By.cssSelector("[placeholder=\"Email\"]"));
     private SelenideElement passwordInputField = $(By.cssSelector("[placeholder=\"Password\"]"));
     private SelenideElement confirmPasswordInputField = $(By.cssSelector("[placeholder=\"Confirm password\"]"));
     private SelenideElement registrationButton = $(By.className("registration-btn"));
     private SelenideElement emailErrorMessage = $x("//div[text()='Email cannot be empty']");

     private SelenideElement emailErrorFormatMessage = $x("//div[text()='Incorrect email format']");
     private SelenideElement passwordErrorMessage = $x("//div[text()='Password cannot be empty']");
     private SelenideElement confirmPasswordErrorMessage = $x("//div[text()='Confirm password cannot be empty']");
     private SelenideElement confirmPasswordDoesntMatchMessage = $x("//*[@id=\"root\"]/div/div/form/div[2]");
     private SelenideElement invalidPasswordErrorMessage = $x("//div[text()='Password must be 8-100 characters and include at least one letter and one digit']");
     private SelenideElement passwordEyeIcon = $(By.className("password-eye"));
     private SelenideElement confirmPasswordEyeIcon = $x("//label[2]//span[1]//img[1]");
     private SelenideElement usernameInputField = $(By.id("Username"));
     private SelenideElement nameInputField = $(By.id("Name"));
     private SelenideElement surnameInputField = $(By.id("Surname"));
     private SelenideElement phoneInputField = $(By.id("Phone"));
     private SelenideElement birthdateInputField = $(By.id("Birthdate"));
     private SelenideElement sexDropDown = $(By.id("sex"));
     private SelenideElement sexDropDownOptionFemale = $(By.id("female"));
     private SelenideElement sexDropDownOptionMale = $(By.id("male"));
     private SelenideElement avatar = $(By.id("Avatar"));
     private SelenideElement adminDropDown =$(By.cssSelector("value=\"admin\""));
     private SelenideElement roleSelectionDropDown=$("form[class='form'] select");

     public SelenideElement getConfirmPasswordEyeIcon() {
         return confirmPasswordEyeIcon;
     }

     public SelenideElement getPasswordEyeIcon() {
         return passwordEyeIcon;
     }

     public SelenideElement getConfirmPasswordDoesntMatchMessage() {
         return confirmPasswordDoesntMatchMessage;
     }

     public SelenideElement getEmailErrorFormatMessage() {
         return emailErrorFormatMessage;
     }

     public SelenideElement getInvalidPasswordErrorMessage() {
         return invalidPasswordErrorMessage;
     }

     public SelenideElement getRegistrationButton() {
         return registrationButton;
     }

     public SelenideElement getEmailInputField() {
         return emailInputField;
     }

     public SelenideElement getEmailErrorMessage() {
         return emailErrorMessage;
     }

     public SelenideElement getPasswordErrorMessage() {
         return passwordErrorMessage;
     }

     public SelenideElement getConfirmPasswordErrorMessage() {
         return confirmPasswordErrorMessage;
     }

     public SelenideElement getRegistrationFormTitle() {
         return registrationFormTitle;
     }


     public String fillInEmailInputField(String emailValue) {
         emailInputField.setValue(emailValue);

         return emailValue;
     }

     public String fillInPasswordField(String passwordValue) {
         passwordInputField.setValue(passwordValue);
         return passwordValue;
     }

     public void fillInConfirmPasswordField(String confirmPasswordvalue) {
         confirmPasswordInputField.setValue(confirmPasswordvalue);

     }

     public void clickOnRegistrationButton() {
         registrationButton.click();
     }

     public void clickOnEyeIcon() {
         passwordEyeIcon.click();
     }

     public void clickOnConfirmPasswordEyeIcon() {
         confirmPasswordEyeIcon.click();
     }

     public void fillInUsernameInputField(String usernameValue) {
         usernameInputField.setValue(usernameValue);
     }

     public void fillInNameInputField(String nameValue) {
         nameInputField.setValue(nameValue);
     }

     public void fillInSurnameInputField(String surnameValue) {
         surnameInputField.setValue(surnameValue);
     }

     public void fillInPhoneInputField(String phoneValue) {
         phoneInputField.setValue(phoneValue);
     }

     public void fillInBirthdateInputField(String birthdateValue) {
         phoneInputField.setValue(birthdateValue);

     }

     public void clickOnSexField() {
         sexDropDown.click();

     }

     public void chooseFemaleFromSexDropDown() {
         sexDropDownOptionFemale.click();


     }

     public void clickOnAdminDropDown(){
         adminDropDown.click();
     }

 public void clickOnRoleSelectionDropDown(){
     roleSelectionDropDown.click();}
 }
