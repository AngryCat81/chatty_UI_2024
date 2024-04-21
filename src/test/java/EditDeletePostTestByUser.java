import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.List;

import static org.junit.Assert.*;


public class EditDeletePostTestByUser extends BaseTest {
    @Test
    @Category(Smoke.class)
    public void successfulPostEditing() {
        postCreationPage.userLogin();
        postPreviewPage.clickOnMyPostTumbler();
        String oldTitle= postPreviewPage.getTitleText();
        postPreviewPage.clickOnPost();
        postPage.clickOnEditIcon();
        postPage.editTitle(fakeTitle);
        String editedValue = fakeTitle;
        postPage.editDescription(fakeTitle);
        postPage.editText(fakeTitle);
        postPage.clickOnSubmitButton();
        postPreviewPage.clickOnPost();
        assertNotEquals(oldTitle,editedValue);



    }




    @Test
    @Category(Smoke.class)
    public void successfulPostDeleting() {

        postCreationPage.userLogin();
        postPreviewPage.clickOnMyPostTumbler();
        postPreviewPage.clickOnPost();
        String title= String.valueOf(postPreviewPage.getPostPreviewTitle());
        postPage.clickOnDeleteIcon();
        postPreviewPage.clickOnMyPostTumbler();
        List<String> titlesAfterDeletion = postPreviewPage.getPostPreviewTitle().texts();
        Assert.assertFalse(titlesAfterDeletion.contains(title));







    }
}
