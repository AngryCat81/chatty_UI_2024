


import org.junit.Test;
import org.junit.experimental.categories.Category;


import static com.codeborne.selenide.Condition.*;


public class ContactUsFormTest extends BaseTest {
    @Test
    @Category(Smoke.class)
    public void successfullySentMessage() {
        postCreationPage.userLogin();
        headerPage.clickOnContactLink();
        contactUsPage.fillInNameInputField(fakeName);
        contactUsPage.fillInEmailInputField(fakeEmail);
        contactUsPage.fillInMessageInputField(fakeTitle);
        contactUsPage.clickOnSendMessageButton();
        contactUsPage.getSentMessageConfirmationText().shouldHave(text("Feedback submitted successfully!"));
    }




    @Test

    public void invalidEmailFormat() {
        postCreationPage.userLogin();
        headerPage.clickOnContactLink();
        contactUsPage.fillInEmailInputField("koza.lo.lo");
        contactUsPage.fillInNameInputField(fakeName);
        contactUsPage.fillInMessageInputField(fakeTitle);
        contactUsPage.clickOnSendMessageButton();
        contactUsPage.getInvalidEmaiFormatMessage().shouldHave(text("Invalid email format"));

    }

    @Test
    public void messageValueOverValidMaxLength(){
        postCreationPage.userLogin();
        headerPage.clickOnContactLink();
        contactUsPage.fillInNameInputField(fakeName);
        contactUsPage.fillInEmailInputField(fakeEmail);
        contactUsPage.fillInMessageInputField(fakeMyThoughtsOverMaxLength);
        contactUsPage.clickOnSendMessageButton();
        contactUsPage.getSentMessageConfirmationText().shouldNotBe(visible);
    }
}

