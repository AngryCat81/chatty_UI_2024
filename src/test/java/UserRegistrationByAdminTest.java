


import org.junit.Test;




public class UserRegistrationByAdminTest extends BaseTest {

    @Test
    public void successfulUserRegistration(){
        adminPanelPage.adminLogin();
        adminPanelPage.clickOnCreateButton();
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
