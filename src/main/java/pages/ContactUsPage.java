package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ContactUsPage {

    private SelenideElement nameInputField = $(By.id("name"));
    private SelenideElement emailInputField = $(By.id("email"));
    private SelenideElement messageInputField = $(By.id("content"));
    private SelenideElement sendMessageButton = $(By.cssSelector("button[type='submit']"));

    private SelenideElement sentMessageConfirmationText =$x("//*[@id=\"root\"]/div[2]/div/div/div");//(By.id("success-message")); pochemu lokator ne rabotaet
    private SelenideElement invalidEmaiFormatMessage=$(By.className("error"));

    public SelenideElement getInvalidEmaiFormatMessage() {
        return invalidEmaiFormatMessage;
    }

    public SelenideElement getSentMessageConfirmationText() {
        return sentMessageConfirmationText;
    }

    public void fillInNameInputField(String nameValue) {
        nameInputField.setValue(nameValue);
    }

    public void fillInEmailInputField(String emailValue) {
        emailInputField.setValue(emailValue);
    }

    public void fillInMessageInputField(String messageValue) {
        messageInputField.setValue(messageValue);

    }

    public void clickOnSendMessageButton(){
        sendMessageButton.click();
    }
}
