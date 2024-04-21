package pages;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    private SelenideElement emailInputField = $(By.cssSelector("[placeholder=\"Email\"]"));
    private SelenideElement passwordInputField = $(By.cssSelector("[placeholder=\"Password\"]"));
    private SelenideElement loginButton = $(By.cssSelector("[data-test=\"submit\"]"));
    private SelenideElement eyeIcon = $(By.cssSelector("[class=\"password-eye\"]"));

    private SelenideElement errorMessageText = $(By.className("text-error"));
    private SelenideElement loginFormTitle = $(By.tagName("h1"));
    private SelenideElement signUpQuestionText = $(By.className("link"));
    private SelenideElement signUpLinkText = $(By.cssSelector("[href=\"/registration\"]"));//

    public SelenideElement getErrorMessageText() {
        return errorMessageText;
    }

    public SelenideElement getEmailInputField() {
        return emailInputField;
    }

    private SelenideElement EyeIcon = $(By.className("password-eye"));
    private SelenideElement eyeIconCondition = $x("//span[text()='closeeye1.png']");

    public SelenideElement getEyeIconCondition() {
        return eyeIconCondition;
    }

    public SelenideElement getGetEyeIcon() {
        return EyeIcon;
    }

    public SelenideElement getPasswordInputField() {
        return passwordInputField;
    }

    public SelenideElement getEyeIcon() {
        return eyeIcon;
    }

    public SelenideElement getLoginButton() {
        return loginButton;
    }

    public SelenideElement getSignUpQuestionText() {
        return signUpQuestionText;
    }

    public SelenideElement getSignUpLinkText() {
        return signUpLinkText;
    }

    public SelenideElement getLoginFormTitle() {
        return loginFormTitle;
    }


    public void enterEmail(String emailValue) {
        emailInputField.setValue(emailValue);
    }


    public String enterPassword(String passwordValue) {
        passwordInputField.setValue(passwordValue);
        return passwordValue;
    }

    public void clickOnLoginButton() {
        loginButton.click();
    }

    public void clickOnEyeIcon() {
        eyeIcon.click();
    }

    public void clickOnSignUpLink() {
        signUpLinkText.click();
    }

    public void passwordCopyPaste() {
        passwordInputField.sendKeys(Keys.CONTROL + "a");

        passwordInputField.sendKeys(Keys.CONTROL + "c");

        emailInputField.sendKeys(Keys.CONTROL + "v");
    }

}
