


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.junit.Test;
import org.junit.experimental.categories.Category;



import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.*;

public class PostPreviewTest extends BaseTest {
    @Test
    public void postQuantityOnPageExclAuthor() {
        postCreationPage.userLogin();
        String title= postPreviewPage.getTitleText();
        ElementsCollection allTitles= postPreviewPage.getPostPreviewTitle().filter(visible);
       assertEquals(4,allTitles.size());




    }

    @Test

    public void authorPostQuantityOnPage() {
        postCreationPage.userLogin();
        postPreviewPage.clickOnMyPostTumbler();
        ElementsCollection allTitles= postPreviewPage.getPostPreviewTitle().filter(visible);
        assertEquals(10,allTitles.size());

    }

    @Test

    public void suggestionsModuleWithTurnedOffMyPostsTumbler() {
        postCreationPage.userLogin();
        postPreviewPage.getSuggestedUsersProfile().shouldHave(sizeGreaterThanOrEqual(1));
        postPreviewPage.getFirstSuggestedUserProfile().shouldHave(Condition.href("userprofile"));


    }

    @Test
    public void suggestionsModuleWithTurnedOnMyPostsTumbler() {
        postCreationPage.userLogin();
        postPreviewPage.clickOnMyPostTumbler();
        postPreviewPage.getSuggestedUsersProfile().shouldHave(sizeGreaterThanOrEqual(1));
        String sidebarUsername= postPreviewPage.getSidebarUsername().getText();
        String suggestionsUsername= postPreviewPage.getFirstSuggestedUserProfile().getText();
        assertNotEquals(sidebarUsername,suggestionsUsername);

    }


    @Test
    public void NextPageButton() {
        postCreationPage.userLogin();
        postPreviewPage.clickOnNextPageButton();

    }

    @Test
    public void PreviousPageButton() {
        postCreationPage.userLogin();
        postPreviewPage.clickOnPreviousPageButton();

    }

    @Test
    public void sortPostsFromOldToNew() {
        postCreationPage.userLogin();
        postPreviewPage.clickOnSortingDropDown();

    }




}


