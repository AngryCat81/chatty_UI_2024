package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class PostPage {


    private SelenideElement titleInputField = $(By.cssSelector("[data-test=\"title-input\"]"));
    private SelenideElement descriptionInputField = $(By.cssSelector("[data-test=\"description-input\"]"));
    private SelenideElement textInputField = $(By.cssSelector("[data-test=\"textarea\"]"));
    private SelenideElement errorText = $(By.className("error"));
    private SelenideElement editPostFormCloseButton = $(By.className("close"));
    private SelenideElement editIcon = $(By.cssSelector("[data-test=\"edit-button\"]"));
    private SelenideElement deleteIcon = $(By.cssSelector("[data-test=\"delete-button\"]"));
    private SelenideElement submitButton=$x("//button[@type='submit']");
    private SelenideElement textContent =$(By.className("post-content__body"));

    private SelenideElement similarPostsLinks =$(By.id("posts_links"));

    public SelenideElement getTitleInputField() {
        return titleInputField;
    }

    public SelenideElement getEditIcon() {
        return editIcon;
    }

    public SelenideElement getDeleteIcon() {
        return deleteIcon;
    }

    public SelenideElement getSimilarPostsLinks() {
        return similarPostsLinks;
    }

    public SelenideElement getTextContent() {
        return textContent;
    }

    public SelenideElement getSubmitButton() {
        return submitButton;
    }

    public void clickOnEditIcon() {
        editIcon.click();

    }

    public void editTitle(String titleValue) {
        titleInputField.setValue(titleValue);

    }

    public void editDescription(String descriptionValue) {
        descriptionInputField.setValue(descriptionValue);
    }

    public void editText(String textValue) {
        textInputField.setValue(textValue);
    }
    public void clickOnSubmitButton(){
        submitButton.click();
    }

    public void clickOnDeleteIcon(){
        deleteIcon.click();
    }



}
