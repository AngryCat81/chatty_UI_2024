
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;

import org.junit.Test;
import org.junit.experimental.categories.Category;


import static com.codeborne.selenide.Condition.*;



public class LoginTest extends BaseTest {


    @Test//
    @Category(Smoke.class)
    public void userSuccessfulLogin() {
        loginPage.getLoginFormTitle().shouldBe(visible).shouldHave(text("Login Form"));
        loginPage.enterEmail("fk@fk.lv");
        loginPage.enterPassword("12345678a");
        loginPage.clickOnLoginButton();
        headerPage.getChattyLogo().shouldBe().isDisplayed();

    }

    @Test//dolzhen padatj
    public void userLoginWithEmptyEmailField() {

        loginPage.enterPassword("12345678a");
        loginPage.getLoginButton().shouldNotBe(enabled);


    }

    @Test//dolzhen padatj
    public void userLoginWithEmptyFields() {
        loginPage.getLoginButton().shouldNotBe(enabled);
    }

    @Test //dolzhen padatj, nepraviljnoe soobshenie ob oshibke
    public void LoginWithInvalidEmail() {
        loginPage.enterEmail("fk@fk.l");
        loginPage.enterPassword("12345678a");
        loginPage.getErrorMessageText().shouldBe(visible).shouldHave(text("Email or Password is not correct"));
        loginPage.getLoginButton().shouldNotBe(enabled);
    }

    @Test//dolzhen padatj, nepraviljnoe soobshenie ob oshibke
    public void LoginWithInvalidEmailWithoutAt() {
        loginPage.enterEmail("fkfk.lv");
        loginPage.enterPassword("12345678a");
        loginPage.getErrorMessageText().shouldBe(visible).shouldHave(text("Email or Password is not correct"));
        loginPage.getLoginButton().shouldNotBe(enabled);
    }

    @Test//dolzhen padatj
    public void LoginWithInvalidPasswordFormat() {
        loginPage.enterEmail("fk@fk.lv");
        loginPage.enterPassword("12345678");
        loginPage.getErrorMessageText().shouldBe(visible).shouldHave(text("Email or Password is not correct"));
        loginPage.getLoginButton().shouldNotBe(enabled);

    }

    @Test//dolzhen padatj
    public void LoginWithNotRegisteredUserCredentials() {
        loginPage.enterEmail("ferk@fk.lv");
        loginPage.enterPassword("12345678ab");
        loginPage.clickOnLoginButton();
        loginPage.getErrorMessageText().shouldHave(text("Email or Password is not correct"));


    }

    @Test
    @Category(Smoke.class)
    public void redirectionToCreateAccountPage() {
        loginPage.getSignUpQuestionText().shouldBe(visible).shouldHave(text("Don't have an account?"));
        loginPage.getSignUpLinkText().shouldBe(visible).shouldHave(text("Sign up"));
        loginPage.clickOnSignUpLink();
        registrationPage.getRegistrationFormTitle().shouldBe(visible).shouldHave(text("Create Account"));
    }

    @Test
    public void eyeIconFunction() {
        loginPage.enterPassword("12345678a");
        loginPage.getEyeIcon().shouldHave(Condition.attribute("alt", "close"));
        loginPage.clickOnEyeIcon(); //open eye icon
        loginPage.getEyeIcon().shouldHave(Condition.attribute("alt", "open"));
    }

    @Test
    public void copyPasteFunctionInPasswordFieldDisabled() {
        String password = loginPage.enterPassword("12345678a");
        loginPage.passwordCopyPaste();
        loginPage.getEmailInputField().shouldNotHave(text("12345678a"));


    }
}






