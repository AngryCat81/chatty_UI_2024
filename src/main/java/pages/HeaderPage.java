package pages;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class HeaderPage {


    private SelenideElement chattyLogo = $(By.cssSelector("[class=\"header__logo\"]"));
    private SelenideElement helloUserText = $x("//div[@class='header']//p[1]");
    private SelenideElement helloUserDropDown = $(By.className("header__user"));
    private SelenideElement userProfileLink = $(By.cssSelector("a[href='/userprofile']"));

    private SelenideElement myDraftsLink = $(By.cssSelector("[href=\"/draft\"]"));
    private SelenideElement logOutLink = $(By.cssSelector("[href=\"/login\"]")); ///KORJAVOE NAZVANIE SELEKTORA ER:logout AR:login
    private SelenideElement contactLink = $(By.cssSelector("[href=\"/contact\"]"));
    private SelenideElement aboutLink = $(By.cssSelector("[href=\"/about\"]"));
    private SelenideElement homeLink = $(By.cssSelector("[href=\"/homeblog\"]"));
    private SelenideElement aboutChattyTitle = $x("//*[@id=\"root\"]/div[2]/div/div/h1");
    private SelenideElement aboutLinkMainText=$x("//p[contains(text(),'Chatty is a social network platform designed to co')]");
    private SelenideElement UserSideBarSection=$(By.className("sidebar__section"));
    private SelenideElement contactUsPageTitle=$(By.tagName("h1"));
    private SelenideElement adminPanelLink=$(By.cssSelector("a[href='/users']"));



    public SelenideElement getMyDraftsLink() {
        return myDraftsLink;
    }

    public SelenideElement getContactUsPageTitle() {
        return contactUsPageTitle;
    }

    public SelenideElement getUserSideBarSection() {
        return UserSideBarSection;
    }

    public SelenideElement getAboutLinkMainText() {
        return aboutLinkMainText;
    }

    public SelenideElement getAboutChattyTitle() {
        return aboutChattyTitle;
    }

    public SelenideElement getHelloUserText() {
        return helloUserText;
    }

    public SelenideElement getChattyLogo() {
        return chattyLogo;
    }

    public SelenideElement getHelloUserDropDown() {
        return helloUserDropDown;
    }

    public boolean logoIsDisplayed() {
        return chattyLogo.isDisplayed();

    }




    public void clickLogo() {
        chattyLogo.click();
    }

    public void clickOnHomeLink() {
        homeLink.click();
    }

    public void clickOnAboutLink() {
        aboutLink.click();

    }

    public void clickOnContactLink() {
        contactLink.click();
    }

    public void clickOnHelloUserDropDown() {
     actions().moveToElement(helloUserDropDown).perform();
      //  helloUserDropDown.click();
    }

    public void clickOnYourProfileLink() {
        userProfileLink.click();


    }


    public void clickOnMyDraftsLink() {
        myDraftsLink.click();
    }

    public void clickOnLogOutLink() {
        logOutLink.click();
    }

    public void clickOnAdminPanelLink (){
        adminPanelLink.click();
    }


}


