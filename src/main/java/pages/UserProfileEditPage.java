package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


public class UserProfileEditPage {
    private SelenideElement editProfilePlusButton = $(By.cssSelector("[data-test=\"post-header__plus\"]"));
    private SelenideElement profileAvatarAreaForClick = $(By.cssSelector("[alt=\"Uploaded\"]"));
    private SelenideElement avatarUpload = $x("//*[@id=\"root\"]/div[2]/div[2]/form/div[1]/div/input");
    private SelenideElement nameInputField = $(By.cssSelector("input[placeholder='Name']"));

    private SelenideElement surnameInputField = $(By.cssSelector("[placeholder=\"Surname\"]"));
    private SelenideElement genderDropDown = $(By.cssSelector("[data-test=\"profileGender\"]"));//$x("//select[@id='gender'] ");
    private SelenideElement maleOption = $(By.cssSelector("[value=\"MALE\"]"));
    private SelenideElement femaleOption = $x("//option[text()='FEMALE']");
    private SelenideElement birthdateInputField = $(By.id("birthDate"));

    private SelenideElement phoneInputField = $(By.name("phone"));
    private SelenideElement changePasswordButton = $(By.name("password"));
    private SelenideElement saveButton = $(By.className("save__btn"));
    private SelenideElement oldPasswordInputField = $(By.cssSelector("[placeholder=\"Old password\"]"));
    private SelenideElement newPasswordInputField = $(By.cssSelector("[placeholder=\"New password\"]"));
    private SelenideElement newPasswordConfirmInputField = $(By.cssSelector("[placeholder=\"Confirm new password\"]"));
    private SelenideElement saveButtonOnPasswordChangePopUpWindow = $(By.className("PasswordModal_pass_btn__eGL9h"));
    private SelenideElement oldPasswordEyeIcon = $x("//*[@id=\"root\"]/div[2]/div[3]/div/div/div/div[1]/img");
    private SelenideElement newPasswordEyeIcon = $x("//*[@id=\"root\"]/div[2]/div[3]/div/div/div/div[2]/img");
    private SelenideElement confirmNewPasswordEyeIcon = $x("//*[@id=\"root\"]/div[2]/div[3]/div/div/div/div[3]/img");

    public SelenideElement getOldPasswordEyeIcon() {
        return oldPasswordEyeIcon;
    }

    public SelenideElement getNewPasswordEyeIcon() {
        return newPasswordEyeIcon;
    }

    public SelenideElement getConfirmNewPasswordEyeIcon() {
        return confirmNewPasswordEyeIcon;
    }

    public SelenideElement getSaveButton() {
        return saveButton;
    }

    public SelenideElement getNameInputField() {
        return nameInputField;
    }

    public String fillInNameField(String nameValue) {
        nameInputField.setValue(nameValue);
        return nameValue;
    }





    public void fillInSurnameField(String surnameValue) {
        surnameInputField.setValue(surnameValue);
    }

    public void clickOnGenderField() {
        genderDropDown.click();

    }

    public void chooseMaleGender() {
        maleOption.click();
    }

    public void chooseFemaleGender() {

        femaleOption.click();
    }

    public void fillInBirthdateField(String birthdateValue) {
        birthdateInputField.press("1");
        birthdateInputField.setValue(birthdateValue);
    }

    public void fillInPhoneInputField(String phoneValue) {
        phoneInputField.setValue(phoneValue);
    }

    public void clickOnChangePasswordButton() {
        changePasswordButton.click();

    }

    public void clickOnSaveButton() {
        saveButton.click();
    }

    public void clickOnEditProfileButton() {
        editProfilePlusButton.click();
    }


    public SelenideElement getPhoneInputField() {
        return phoneInputField;
    }

    public void clickOnSavePasswordButton() {
        saveButtonOnPasswordChangePopUpWindow.click();
    }

    public void fillInOldPasswordField(String oldPasswordValue) {
        oldPasswordInputField.setValue(oldPasswordValue);

    }

    public void fillInNewPasswordField(String newPasswordValue) {
        newPasswordInputField.setValue(newPasswordValue);

    }

    public void fillInConfirmPasswordField(String confirmPasswordValue) {
        newPasswordConfirmInputField.setValue(confirmPasswordValue);
    }

    public void saveNameInputValue() {
        nameInputField.getText();


    }

    public SelenideElement getAvatarUpload() {
        return avatarUpload;
    }

    public SelenideElement getOldPasswordInputField() {
        return oldPasswordInputField;
    }

    public SelenideElement getNewPasswordInputField() {
        return newPasswordInputField;
    }

    public SelenideElement getNewPasswordConfirmInputField() {
        return newPasswordConfirmInputField;
    }

    public void userIsLocatedOnProfileEditPage() {
        PostCreationPage postCreationPage = new PostCreationPage();
        HeaderPage headerPage = new HeaderPage();
        UserProfileEditPage userProfileEditPage = new UserProfileEditPage();
        postCreationPage.userLogin();
        headerPage.clickOnHelloUserDropDown();
        headerPage.clickOnYourProfileLink();
        userProfileEditPage.clickOnEditProfileButton();
    }

    public void clearNameField() {
//        nameInputField.doubleClick();
//        nameInputField.sendKeys(Keys.DELETE);//NE RABOTAET.Clear tozhe ne rabotaet
        nameInputField.sendKeys(Keys.BACK_SPACE);
        nameInputField.sendKeys(Keys.BACK_SPACE);
        nameInputField.sendKeys(Keys.BACK_SPACE);
        nameInputField.sendKeys(Keys.BACK_SPACE);
        nameInputField.sendKeys(Keys.BACK_SPACE);
        nameInputField.sendKeys(Keys.BACK_SPACE);
        nameInputField.sendKeys(Keys.BACK_SPACE);
        nameInputField.sendKeys(Keys.BACK_SPACE);
    }


    public void clearSurnameField() {

        surnameInputField.sendKeys(Keys.BACK_SPACE);
        surnameInputField.sendKeys(Keys.BACK_SPACE);
        surnameInputField.sendKeys(Keys.BACK_SPACE);
        surnameInputField.sendKeys(Keys.BACK_SPACE);
        surnameInputField.sendKeys(Keys.BACK_SPACE);
        surnameInputField.sendKeys(Keys.BACK_SPACE);
        surnameInputField.sendKeys(Keys.BACK_SPACE);
        surnameInputField.sendKeys(Keys.BACK_SPACE);
    }

    public void clearPhoneField() {

        phoneInputField.sendKeys(Keys.BACK_SPACE);
        phoneInputField.sendKeys(Keys.BACK_SPACE);
        phoneInputField.sendKeys(Keys.BACK_SPACE);
        phoneInputField.sendKeys(Keys.BACK_SPACE);
        phoneInputField.sendKeys(Keys.BACK_SPACE);
        phoneInputField.sendKeys(Keys.BACK_SPACE);
        phoneInputField.sendKeys(Keys.BACK_SPACE);
        phoneInputField.sendKeys(Keys.BACK_SPACE);
        phoneInputField.sendKeys(Keys.BACK_SPACE);
        phoneInputField.sendKeys(Keys.BACK_SPACE);
    }

    public void getPhoneFieldInputValue() {
        phoneInputField.getText();
    }


    public void clickOnOldPasswordEyeIcon() {
        oldPasswordEyeIcon.click();
    }

    public void clickOnNewPasswordEyeIcon() {
        newPasswordEyeIcon.click();
    }

    public void clickOnConfirmNewPasswordEyeIcon() {
        confirmNewPasswordEyeIcon.click();
    }

    public void clearOldPasswordInputField() {
        oldPasswordInputField.sendKeys(Keys.BACK_SPACE);
        oldPasswordInputField.sendKeys(Keys.BACK_SPACE);
        oldPasswordInputField.sendKeys(Keys.BACK_SPACE);
        oldPasswordInputField.sendKeys(Keys.BACK_SPACE);
        oldPasswordInputField.sendKeys(Keys.BACK_SPACE);
        oldPasswordInputField.sendKeys(Keys.BACK_SPACE);
        oldPasswordInputField.sendKeys(Keys.BACK_SPACE);
        oldPasswordInputField.sendKeys(Keys.BACK_SPACE);
    }

    public void clearNewPasswordInputField() {
        oldPasswordInputField.sendKeys(Keys.BACK_SPACE);
        oldPasswordInputField.sendKeys(Keys.BACK_SPACE);
        oldPasswordInputField.sendKeys(Keys.BACK_SPACE);
        oldPasswordInputField.sendKeys(Keys.BACK_SPACE);
        oldPasswordInputField.sendKeys(Keys.BACK_SPACE);
        oldPasswordInputField.sendKeys(Keys.BACK_SPACE);
        oldPasswordInputField.sendKeys(Keys.BACK_SPACE);
        oldPasswordInputField.sendKeys(Keys.BACK_SPACE);
    }

    public void oldPasswordCopyPaste() {
        oldPasswordInputField.sendKeys(Keys.CONTROL + "a");

        oldPasswordInputField.sendKeys(Keys.CONTROL + "c");

        newPasswordInputField.sendKeys(Keys.CONTROL + "v");
    }

    public void newPasswordCopyPaste() {
        newPasswordInputField.sendKeys(Keys.CONTROL + "a");

        newPasswordInputField.sendKeys(Keys.CONTROL + "c");

        oldPasswordInputField.sendKeys(Keys.CONTROL + "v");
    }

    public void confirmPasswordCopyPasteFunction() {
        newPasswordConfirmInputField.sendKeys(Keys.CONTROL + "a");

        newPasswordConfirmInputField.sendKeys(Keys.CONTROL + "c");

        oldPasswordInputField.sendKeys(Keys.CONTROL + "v");
    }
 public void clickOnAvatar(){
     profileAvatarAreaForClick.click();
 }
    public void uploadAvatar() {

        avatarUpload.uploadFile(new File("C:\\Users\\kraka\\Downloads\\avatar.jpg"));

    }
}

