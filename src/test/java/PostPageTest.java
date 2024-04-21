


import org.junit.Test;
import org.junit.experimental.categories.Category;


import static com.codeborne.selenide.Condition.*;


public class PostPageTest extends BaseTest {

    @Test//valitsja net ssilok na similar links
    @Category(Smoke.class)
    public void authorPostContainsTitlePictureEtc() {
        postCreationPage.userLogin();
        postPreviewPage.clickOnMyPostTumbler();//tumbler ne vsegda perekljuchatesja

        postPreviewPage.clickOnPost();
        //postPreviewPage.getPostPreviewTitle().shouldBe(visible);
        postPreviewPage.getPostPreviewPicture().shouldBe(visible);
        postPreviewPage.getMyThoughtsText().shouldBe(visible);
        postPreviewPage.getReadingTime().shouldBe(visible);
        postPreviewPage.getPostPreviewAuthor().shouldBe(visible);
        postPreviewPage.getUsersAvatars().shouldBe(visible);
        postPage.getEditIcon().shouldBe(visible);
        postPage.getDeleteIcon().shouldBe(visible);
        postPage.getSimilarPostsLinks().shouldBe(visible);

    }
}
