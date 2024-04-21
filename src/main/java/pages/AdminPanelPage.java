package pages;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;

public class AdminPanelPage {

    private SelenideElement adminPanelTitle=$(By.cssSelector("h1[data-test='adminPanelTitle']"));
    private SelenideElement searchByEmailField=$(By.cssSelector("placeholder=\"Search by email...\""));
    private SelenideElement  tableHeaderNumber=$(By.cssSelector("th[data-test='tableHeaderNumber']"));
    private SelenideElement tableHeaderRole=$(By.cssSelector("th[class='id-hide']"));
    private SelenideElement headerTableName=$(By.cssSelector("th[data-test='tableHeaderName']"));
    private SelenideElement headerTableActions=$(By.cssSelector("th[data-test='tableHeaderActions']"));
    private SelenideElement headerTableEmail=$(By.cssSelector("th[data-test='tableHeaderEmail']"));

    private SelenideElement searchButton=$(By.cssSelector("[data-test=\"searchEmailButton\"]"));
    private SelenideElement editIcon=$(By.cssSelector("[class=\"svg-inline--fa fa-pen-to-square \"]"));
    private SelenideElement deleteIcon=$x("//tbody/tr[1]/td[5]");
    private SelenideElement loadMoreButton=$(By.className("admin-btn"));

    private SelenideElement keyIcon=$(By.id("key_icon"));

    private ElementsCollection trashBins =$$(By.cssSelector("[data-icon=\"trash\"]"));

    public SelenideElement createButton=$(By.id("btn_create"));
    public SelenideElement userEmail=$(By.className("data-test=\"userEmail\""));

    private SelenideElement searchInputField=$x("//input[@placeholder='Search by email...']");
    private SelenideElement userName=$(By.cssSelector("td[data-test='userName']"));

    private SelenideElement avatar=$x("//*[@id=\"root\"]/div[2]/div[2]/form/div[1]/div/input");
    private SelenideElement adminUserRoleSwitcher=$(By.id("role-switcher"));
    private SelenideElement deleteProfileWarningPopAp =$(By.id("error_message"));

    private SelenideElement warningPopApYesButton=$(By.id("submit_yes"));

    public SelenideElement getUserEmail() {
        return userEmail;
    }

    public SelenideElement getWarningPopApYesButton() {
        return warningPopApYesButton;
    }

    public SelenideElement getDeleteProfileWarningPopAp() {
        return deleteProfileWarningPopAp;
    }

    public SelenideElement getAdminUserRoleSwitcher() {
        return adminUserRoleSwitcher;
    }

    public SelenideElement getUserName() {
        return userName;
    }

    public ElementsCollection getTrashBins() {
        return trashBins;
    }

    public SelenideElement getHeaderTableEmail() {
        return headerTableEmail;
    }

    public SelenideElement getAdminPanelTitle() {
        return adminPanelTitle;
    }

    public SelenideElement getSearchByEmailField() {
        return searchByEmailField;
    }

    public SelenideElement getTableHeaderNumber() {
        return tableHeaderNumber;
    }

    public SelenideElement getTableHeaderRole() {
        return tableHeaderRole;
    }

    public SelenideElement getHeaderTableName() {
        return headerTableName;
    }

    public SelenideElement getHeaderTableActions() {
        return headerTableActions;
    }

    public SelenideElement getSearchButton() {
        return searchButton;
    }

    public SelenideElement getEditIcon() {
        return editIcon;
    }

    public SelenideElement getDeleteIcon() {
        return deleteIcon;
    }

    public SelenideElement getLoadMoreButton() {
        return loadMoreButton;
    }

    public SelenideElement getKeyIcon() {
        return keyIcon;
    }


    public void adminLogin(){
        LoginPage loginPage=new LoginPage();
        loginPage.enterEmail("katja@th.lv");
        loginPage.enterPassword("katja1981");
        loginPage.clickOnLoginButton();
    }
    public void  userRegistration(){
        createButton.click();

    }

    public void clickInLoadMoreButton(){
        loadMoreButton.click();
    }
    public void clickOnDeleteIcon(){
        deleteIcon.click();
    }

    public void clickOnCreateButton (){
        createButton.click();
    }

    public void clickOnEditIcon (){
        editIcon.click();
    }
    public void clickOnSearchButton(){
        searchButton.click();
    }

    public void fillInSearchField(String searchInputValue){
        searchInputField.setValue(searchInputValue);
    }

    public void uploadAvatar() {


        avatar.uploadFile(new File("C:\\Users\\kraka\\Downloads\\Poodle.jpg"));

    }
}
