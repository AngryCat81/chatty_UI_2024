package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
public class PostCreationPage  {
    LoginPage loginPage=new LoginPage();


    private SelenideElement titleInputField = $(By.cssSelector("[data-test=\"title-input\"]"));
    private SelenideElement descriptionInputField = $(By.cssSelector("[data-test=\"description-input\"]"));
    private SelenideElement myThoughtsInputField = $(By.cssSelector("[placeholder=\"My thoughts. No more than 1000 characters\"]"));
   private  SelenideElement uploadArea =$(By.className("post_uploaded_image__7qSWV"));
    private SelenideElement pictureUploadField = $x("//*[@id=\"root\"]/div[2]/div[2]/div/form/div[4]/input");
    private SelenideElement calendarField = $(By.id("publishDate"));
    private SelenideElement draftTumbler = $(By.id("draftCheckbox"));
    private SelenideElement submitButton = $x("//button[@type='submit']");
    private SelenideElement calendarFieldValue = $(By.cssSelector("[value]"));
    private SelenideElement titleErrorMessage=$x("//*[@id=\"root\"]/div[2]/div[2]/div/form/div[1]/p");
    private SelenideElement descriptionErrorMessage=$x("//*[@id=\"root\"]/div[2]/div[2]/div/form/div[2]/p");

    public SelenideElement getDescriptionErrorMessage() {
        return descriptionErrorMessage;
    }

    public SelenideElement getMyThoughtsErrorMessage() {
        return MyThoughtsErrorMessage;
    }

    private SelenideElement MyThoughtsErrorMessage=$x("//*[@id=\"root\"]/div[2]/div[2]/div/form/div[3]/p");


    private SelenideElement dateErrorMessage=$x("//p[normalize-space()='Please fill all fields']");
    private SelenideElement pictureUploadErrorMessage =$(By.className("post_error_message__FQTrb"));

    public SelenideElement getPictureUploadErrorMessage() {
        return pictureUploadErrorMessage;
    }

    public SelenideElement getSubmitButton() {
        return submitButton;
    }

    public SelenideElement getDateErrorMessage() {
        return dateErrorMessage;
    }

    public SelenideElement getTitleErrorMessage() {
        return titleErrorMessage;
    }

    public String fillInTitleInputField(String titleValue) {
        titleInputField.setValue(titleValue);
        return titleValue;
    }

    public void fillInDescriptionInputField(String DescriptionValue) {
        descriptionInputField.setValue(DescriptionValue);

    }

    public void fillInMyThoughtsInputField(String myThoughtsValue) {
        myThoughtsInputField.setValue(myThoughtsValue);

    }

    public void pushSubmitButton() {
        submitButton.click();
    }

    public void clickOnUploadArea(){
       uploadArea.click();
    }


    public void uploadPicture() {
        pictureUploadField.uploadFile(new File("C:\\Users\\kraka\\Downloads\\Poodle.jpg"));

    }
    public void uploadPictureMoreThan2Mb() {
        pictureUploadField.uploadFile(new File("C:\\Users\\kraka\\Downloads\\photo_visokogo_razresheniya.jpg"));
    }
    public void uploadPictureGIF() {
        pictureUploadField.uploadFile(new File("C:\\Users\\kraka\\Downloads\\gif picture.gif"));
    }

        public void clickOnSaveInDrafts(){
        draftTumbler.click();
    }

    public void  userLogin(){
        loginPage.enterEmail("sobachka@kl.lo");
        loginPage.enterPassword("sobachka231");
        loginPage.clickOnLoginButton();



    }


    public void fillInDateForDelayedPost(  String dateValue){
        calendarFieldValue.setValue(dateValue);
    }
}