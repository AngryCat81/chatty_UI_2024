
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.Test;
import org.junit.experimental.categories.Category;



import static java.lang.Thread.sleep;
import static org.junit.Assert.assertNotEquals;

public class UserProfileEditDeleteByAdminTest extends BaseTest {
    @Test
    @Category(Smoke.class)

    public void successfulUserProfileEditingByAdmin() {
        loginPage.clickOnSignUpLink();
        String userEmail= registrationPage.fillInEmailInputField(fakeEmail);
        registrationPage.fillInPasswordField(fakePassword);
        registrationPage.fillInConfirmPasswordField(confirmPassword);
        registrationPage.clickOnRegistrationButton();
        headerPage.clickOnHelloUserDropDown();
        headerPage.clickOnLogOutLink();
        adminPanelPage.adminLogin();
        adminPanelPage.fillInSearchField(userEmail);
        adminPanelPage.clickOnSearchButton();
        adminPanelPage.clickOnEditIcon();
        userProfileEditPage.clickOnEditProfileButton();
        String nameBeforeEditing =userProfileEditPage.getNameInputField().getText();
        String usernameAfterEditing= userProfileEditPage.fillInNameField(fakeName);
        userProfileEditPage.fillInSurnameField(fakeName);
        userProfileEditPage.clickOnGenderField();
        userProfileEditPage.chooseFemaleGender();
        userProfileEditPage.fillInBirthdateField("06-05-1981");
        userProfileEditPage.fillInPhoneInputField(fakePhoneNumber);
        userProfileEditPage.clickOnAvatar();
        adminPanelPage.uploadAvatar();
        userProfileEditPage.clickOnSaveButton();
        WebDriverRunner.getWebDriver().navigate().refresh();
        headerPage.clickOnHelloUserDropDown();
        headerPage.clickOnAdminPanelLink();
        adminPanelPage.fillInSearchField(userEmail);
        adminPanelPage.clickOnSearchButton();
        assertNotEquals(nameBeforeEditing, usernameAfterEditing);

    }

    @Test
    @Category(Smoke.class)

    public void successfulUserProfileDeleteByAdmin()  {
        loginPage.clickOnSignUpLink();
       String userEmail= registrationPage.fillInEmailInputField(fakeEmail);
        registrationPage.fillInPasswordField(fakePassword);
        registrationPage.fillInConfirmPasswordField(confirmPassword);
        registrationPage.clickOnRegistrationButton();
        headerPage.clickOnHelloUserDropDown();
        headerPage.clickOnLogOutLink();
        adminPanelPage.adminLogin();
        adminPanelPage.fillInSearchField(userEmail);
        adminPanelPage.clickOnSearchButton();
        adminPanelPage.clickOnDeleteIcon();
        WebDriverRunner.getWebDriver().navigate().refresh();
        adminPanelPage.fillInSearchField(userEmail);
        adminPanelPage.clickOnSearchButton();
        adminPanelPage.getUserEmail().shouldNotBe(Condition.exist);

    }
}
