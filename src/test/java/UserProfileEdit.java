import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static com.codeborne.selenide.Condition.*;

import static org.junit.Assert.assertNotEquals;


public class UserProfileEdit extends BaseTest {
    @Test
    @Category(Smoke.class)

    public void userProfileSuccessfulEditingWithoutPasswordChanging()  {

        postCreationPage.userLogin();
        headerPage.clickOnHelloUserDropDown();
        headerPage.clickOnYourProfileLink();
        userProfileEditPage.clickOnEditProfileButton();
       String usernameBeforeEditing = userProfileEditPage.getNameInputField().getAttribute("value");
       userProfileEditPage.fillInNameField(fakeName);
       userProfileEditPage.fillInSurnameField(fakeName);
        userProfileEditPage.clickOnGenderField();
        userProfileEditPage.chooseMaleGender();
        userProfileEditPage.fillInBirthdateField("06-05-1981");
        userProfileEditPage.fillInPhoneInputField(fakePhoneNumber);

        userProfileEditPage.clickOnAvatar();
        userProfileEditPage.uploadAvatar();

        userProfileEditPage.clickOnSaveButton();
        WebDriverRunner.getWebDriver().navigate().refresh();

        String usernameAfterEditing = postPreviewPage.getSidebarUsername().getText();
        assertNotEquals(usernameBeforeEditing, usernameAfterEditing);
    }


    @Test
    @Category(Smoke.class)
    public void userProfileSuccessfulEditingWithPasswordChanging() {

        loginPage.clickOnSignUpLink();
        registrationPage.fillInEmailInputField(fakeEmail);
        String savedFakePassword = registrationPage.fillInPasswordField(fakePassword);
        registrationPage.fillInConfirmPasswordField(savedFakePassword);
        registrationPage.clickOnRegistrationButton();
        headerPage.clickOnHelloUserDropDown();
        headerPage.clickOnYourProfileLink();
        userProfileEditPage.clickOnEditProfileButton();
        userProfileEditPage.fillInNameField(fakeName);
        userProfileEditPage.clickOnChangePasswordButton();
        userProfileEditPage.fillInOldPasswordField(savedFakePassword);
        userProfileEditPage.fillInNewPasswordField(newPassword);
        userProfileEditPage.fillInConfirmPasswordField(confirmNewPassword);
        userProfileEditPage.clickOnSavePasswordButton();
        userProfileEditPage.clickOnSaveButton();
        headerPage.clickOnHelloUserDropDown();
        headerPage.clickOnLogOutLink();
        loginPage.enterEmail(savedEmail);
        loginPage.enterPassword(confirmNewPassword);
        loginPage.clickOnLoginButton();
        headerPage.getChattyLogo().shouldBe().isDisplayed();
    }

    @Test
    public void nameInputFieldEmpty() {
        userProfileEditPage.userIsLocatedOnProfileEditPage();
        userProfileEditPage.clearNameField();
        userProfileEditPage.clickOnSaveButton();
        userProfileEditPage.getSaveButton().shouldHave(disabled);
    }

    @Test
    public void nameInputFieldValueLengthOverMax() {
        userProfileEditPage.userIsLocatedOnProfileEditPage();
        userProfileEditPage.fillInNameField(fakeNameValueOverMax);
        userProfileEditPage.clickOnSaveButton();
        userProfileEditPage.getSaveButton().shouldHave(disabled);
    }

    @Test
    public void nameInputFieldValueLengthLessThanMin() {
        userProfileEditPage.userIsLocatedOnProfileEditPage();
        userProfileEditPage.fillInNameField("a");
        userProfileEditPage.clickOnSaveButton();
        userProfileEditPage.getSaveButton().shouldHave(disabled);
    }

    @Test
    public void nameInputFieldValueSpecialSymbol() {
        userProfileEditPage.userIsLocatedOnProfileEditPage();
        userProfileEditPage.fillInNameField("Masha$");
        userProfileEditPage.clickOnSaveButton();
        userProfileEditPage.getSaveButton().shouldHave(disabled);
    }

    @Test
    public void nameInputFieldValueOnlyDigits() {
        userProfileEditPage.userIsLocatedOnProfileEditPage();
        userProfileEditPage.fillInNameField("1111");
        userProfileEditPage.clickOnSaveButton();
        userProfileEditPage.getSaveButton().shouldHave(disabled);
    }

    @Test
    public void nameInputFieldValueDigitsAndLetters() {
        userProfileEditPage.userIsLocatedOnProfileEditPage();
        userProfileEditPage.fillInNameField("343kat");
        userProfileEditPage.clickOnSaveButton();
        userProfileEditPage.getSaveButton().shouldHave(disabled);
    }

    @Test
    public void surnameInputFieldEmpty() {
        userProfileEditPage.userIsLocatedOnProfileEditPage();
        userProfileEditPage.clearSurnameField();
        userProfileEditPage.clickOnSaveButton();
        userProfileEditPage.getSaveButton().shouldHave(disabled);
    }

    @Test
    public void surnameInputFieldValueLengthOverMax() {
        userProfileEditPage.userIsLocatedOnProfileEditPage();
        userProfileEditPage.fillInSurnameField(fakeNameValueOverMax);
        userProfileEditPage.clickOnSaveButton();
        userProfileEditPage.getSaveButton().shouldHave(disabled);
    }

    @Test
    public void surnameInputFieldValueLengthLessThanMin() {
        userProfileEditPage.userIsLocatedOnProfileEditPage();
        userProfileEditPage.clearSurnameField();
        userProfileEditPage.fillInSurnameField("ka");
        userProfileEditPage.clickOnSaveButton();
        userProfileEditPage.getSaveButton().shouldHave(disabled);
    }

    @Test
    public void surnameInputFieldValueSpecialSymbol() {
        userProfileEditPage.userIsLocatedOnProfileEditPage();
        userProfileEditPage.fillInSurnameField("kar%");
        userProfileEditPage.clickOnSaveButton();
        userProfileEditPage.getSaveButton().shouldHave(disabled);
    }

    @Test
    public void surnameInputFieldValueOnlyDigits() {
        userProfileEditPage.userIsLocatedOnProfileEditPage();
        userProfileEditPage.fillInSurnameField("343");
        userProfileEditPage.clickOnSaveButton();
        userProfileEditPage.getSaveButton().shouldHave(disabled);
    }

    @Test
    public void surnameInputFieldValueDigitsAndLetters() {
        userProfileEditPage.userIsLocatedOnProfileEditPage();
        userProfileEditPage.fillInSurnameField("343ret");
        userProfileEditPage.clickOnSaveButton();
        userProfileEditPage.getSaveButton().shouldHave(disabled);
    }

    @Test
    public void phoneInputFieldEmpty() {
        userProfileEditPage.userIsLocatedOnProfileEditPage();
        userProfileEditPage.clearPhoneField();
        userProfileEditPage.clickOnSaveButton();
        userProfileEditPage.getSaveButton().shouldHave(disabled);


    }

    @Test// Bag, ne dolzhen padatj.pokazivaet ,chto pole pustoe, ne pokazivaet ,chto pole zapolneno
    public void phoneInputValue12() {
        userProfileEditPage.userIsLocatedOnProfileEditPage();
        userProfileEditPage.fillInPhoneInputField("123456789135");
        userProfileEditPage.clickOnSaveButton();
        WebDriverRunner.getWebDriver().navigate().refresh();
        userProfileEditPage.clickOnEditProfileButton();
        userProfileEditPage.getPhoneInputField().shouldHave(text("123456789135"));


    }

    @Test
    public void editPasswordFormEyeIconFunction() {
        userProfileEditPage.userIsLocatedOnProfileEditPage();
        userProfileEditPage.clickOnChangePasswordButton();
        userProfileEditPage.fillInOldPasswordField("derevo21");
        userProfileEditPage.fillInNewPasswordField("sobaka48");
        userProfileEditPage.fillInConfirmPasswordField("sobaka48");
        userProfileEditPage.getOldPasswordEyeIcon().shouldHave(Condition.attributeMatching("src", ".*closeye.*"));
        userProfileEditPage.clickOnOldPasswordEyeIcon();
        userProfileEditPage.getOldPasswordEyeIcon().shouldHave(Condition.attributeMatching("src", ".*openeye.*"));
        userProfileEditPage.getNewPasswordEyeIcon().shouldHave(Condition.attributeMatching("src", ".*closeye.*"));
        userProfileEditPage.clickOnNewPasswordEyeIcon();
        userProfileEditPage.getNewPasswordEyeIcon().shouldHave(Condition.attributeMatching("src", ".*openeye.*"));
        userProfileEditPage.getConfirmNewPasswordEyeIcon().shouldHave(Condition.attributeMatching("src", ".*closeye.*"));
        userProfileEditPage.clickOnConfirmNewPasswordEyeIcon();
        userProfileEditPage.getConfirmNewPasswordEyeIcon().shouldHave(Condition.attributeMatching("src", ".*openeye.*"));
    }

    @Test
    public void editPasswordFormCopyPasteFunctionDisabled() {
        userProfileEditPage.userIsLocatedOnProfileEditPage();
        userProfileEditPage.clickOnChangePasswordButton();
        userProfileEditPage.fillInOldPasswordField("sobachka");
        userProfileEditPage.oldPasswordCopyPaste();
        userProfileEditPage.getOldPasswordInputField().shouldNotHave(text("sobachka"));
        userProfileEditPage.clearOldPasswordInputField();
        userProfileEditPage.clearNewPasswordInputField();
        userProfileEditPage.fillInNewPasswordField("koshechka");
        userProfileEditPage.newPasswordCopyPaste();
        userProfileEditPage.getOldPasswordInputField().shouldNotHave(text("koshechka"));
        userProfileEditPage.clearOldPasswordInputField();
        userProfileEditPage.fillInConfirmPasswordField("1228383893");
        userProfileEditPage.confirmPasswordCopyPasteFunction();
        userProfileEditPage.getOldPasswordInputField().shouldNotHave(text("1228383893"));


    }
}
