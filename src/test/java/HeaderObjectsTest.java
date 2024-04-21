

import org.junit.Test;


import static com.codeborne.selenide.Condition.*;


public class HeaderObjectsTest extends BaseTest {
    @Test
    public void AboutLink() {
        postCreationPage.userLogin();
        headerPage.clickOnAboutLink();
        headerPage.getAboutChattyTitle().shouldHave(text("About Chatty"));
        headerPage.getAboutLinkMainText().shouldHave(partialText("Our mission is to bring people together"));
    }

    @Test
    public void HomeLink() {
        postCreationPage.userLogin();
        headerPage.clickOnAboutLink();
        headerPage.clickOnHomeLink();
        headerPage.getUserSideBarSection().shouldBe(visible);

    }

    @Test

    public void ContactLink() {
        postCreationPage.userLogin();
        headerPage.clickOnContactLink();
        headerPage.getContactUsPageTitle().shouldHave(text("Contact Us"));

    }

    @Test

    public void myDraftsLink() {
        postCreationPage.userLogin();
        headerPage.clickOnHelloUserDropDown();
        headerPage.clickOnMyDraftsLink();
        myDraftsPage.getMyDraftsPageTitle().shouldHave(text("My drafts"));

    }
}
