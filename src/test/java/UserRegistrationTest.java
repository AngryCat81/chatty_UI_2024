import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;
import org.junit.Test;
import org.junit.experimental.categories.Category;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class UserRegistrationTest extends BaseTest {



    @Test
    @Category(Smoke.class)
    public void successfulUserRegistration() {
        loginPage.clickOnSignUpLink();
        registrationPage.fillInEmailInputField(fakeEmail);
        registrationPage.fillInPasswordField(fakePassword);
        registrationPage.fillInConfirmPasswordField(confirmPassword);
        registrationPage.clickOnRegistrationButton();

        headerPage.getChattyLogo().shouldBe(visible);
    }

    @Test
    public void registrationWithEmptyPasswordField() {
        loginPage.clickOnSignUpLink();
        registrationPage.fillInEmailInputField(fakeEmail);
        registrationPage.getPasswordErrorMessage().shouldHave(text("Password cannot be empty"));
        registrationPage.getRegistrationButton().shouldNotBe(enabled);
    }

    @Test
    public void onlyDigitsInPasswordField() {
        loginPage.clickOnSignUpLink();
        registrationPage.fillInEmailInputField(fakeEmail);
        registrationPage.fillInPasswordField(fakePasswordOnlyDigits);
        registrationPage.getInvalidPasswordErrorMessage().shouldHave(text("Password must be 8-100 characters and include " +
                "at least one letter and one digit\n"));
        registrationPage.getRegistrationButton().shouldNotBe(enabled);


    }

    @Test//
    public void onlyLettersInPasswordField() {
        loginPage.clickOnSignUpLink();
        registrationPage.fillInEmailInputField(fakeEmail);
        registrationPage.fillInPasswordField(fakePasswordOnlyLetters);
        registrationPage.getInvalidPasswordErrorMessage().shouldHave(text("Password must be 8-100 characters and include " +
                "at least one letter and one digit\n"));
        registrationPage.getRegistrationButton().shouldNotBe(enabled);


    }
    @Test
    public void passwordLengthOverMaxValidValue() {
        loginPage.clickOnSignUpLink();
        registrationPage.fillInEmailInputField(fakeEmail);
        registrationPage.fillInPasswordField(fakePasswordOverMax);
        registrationPage.getInvalidPasswordErrorMessage().shouldHave(text("Password must be 8-100 characters and include " +
                "at least one letter and one digit\n"));
        registrationPage.getRegistrationButton().shouldNotBe(enabled);
    }
    @Test//
    public void passwordLengthLessMinValidValue() {
        loginPage.clickOnSignUpLink();
        registrationPage.fillInEmailInputField(fakeEmail);
        registrationPage.fillInPasswordField("sobaka1");

        registrationPage.getInvalidPasswordErrorMessage().shouldHave(text("Password must be 8-100 characters and include " +
                "at least one letter and one digit\n"));
        registrationPage.getRegistrationButton().shouldNotBe(enabled);
    }



    @Test
    public void withEmptyConfirmPasswordField() {
        loginPage.clickOnSignUpLink();
        registrationPage.fillInPasswordField(fakePassword);
        registrationPage.getConfirmPasswordErrorMessage().shouldHave(text("Confirm password cannot be empty"));
        registrationPage.getRegistrationButton().shouldNotBe(enabled);

    }

    @Test
    public void passwordDoesntMatchToConfirmPassword() {
        loginPage.clickOnSignUpLink();
        registrationPage.fillInPasswordField(fakePassword);
        registrationPage.fillInConfirmPasswordField("123");
        registrationPage.getConfirmPasswordDoesntMatchMessage().shouldHave(text("Passwords do not match"));
        registrationPage.getRegistrationButton().shouldNotBe(enabled);

    }

    @Test
    public void withEmailWithoutAt() {
        loginPage.clickOnSignUpLink();
        registrationPage.fillInEmailInputField("koshkasobaka.lv");

        registrationPage.fillInPasswordField(fakePassword);
        registrationPage.fillInConfirmPasswordField(confirmPassword);
        registrationPage.getEmailErrorFormatMessage().shouldHave(text("Incorrect email format"));
        registrationPage.getRegistrationButton().shouldNotBe(enabled);


    }

    @Test
    public void withEmailWithoutDot() {
        loginPage.clickOnSignUpLink();
        registrationPage.fillInEmailInputField("koshka@sobakalv");

        registrationPage.fillInPasswordField(fakePassword);
        registrationPage.fillInConfirmPasswordField(confirmPassword);
        registrationPage.getEmailErrorFormatMessage().shouldHave(text("Incorrect email format"));
        registrationPage.getRegistrationButton().shouldNotBe(enabled);


    }
    @Test
    public void eyeIconFunction() {
        loginPage.clickOnSignUpLink();

        registrationPage.fillInPasswordField(fakePassword);
       registrationPage.getPasswordEyeIcon().shouldHave(Condition.attribute("alt","close"));
        registrationPage.clickOnEyeIcon(); //open eye icon
        sleep(5000);
        registrationPage.getPasswordEyeIcon().shouldHave(Condition.attribute("alt","open"));
        registrationPage.fillInConfirmPasswordField(confirmPassword);
        registrationPage.getConfirmPasswordEyeIcon().shouldHave(Condition.attribute("alt","close"));
        registrationPage.clickOnConfirmPasswordEyeIcon();
        registrationPage.getConfirmPasswordEyeIcon().shouldHave(Condition.attribute("alt","open"));
    }
    @Test//test padaet iz-za nehvatki polej

    public void fieldsAreMissed (){
        loginPage.clickOnSignUpLink();
        registrationPage.fillInUsernameInputField(fakeName);
        registrationPage.fillInNameInputField(fakeName);
        registrationPage.fillInSurnameInputField(fakeName);
        registrationPage.fillInPhoneInputField(fakePhoneNumber);
        registrationPage.fillInBirthdateInputField("11/05/2000");
        registrationPage.clickOnSexField();
        registrationPage.chooseFemaleFromSexDropDown();
        registrationPage.clickOnRegistrationButton();



    }



    }
