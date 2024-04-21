
import com.codeborne.selenide.CollectionCondition;

import com.codeborne.selenide.ElementsCollection;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import static com.codeborne.selenide.Condition.*;


public class CreatePostTest extends BaseTest {


    @Test
    @Category(Smoke.class)
    public void successfulPostCreationWithAllFilledInInputFields() {

        postCreationPage.userLogin();

        postPreviewPage.clickOnCreatePost();
        String title=postCreationPage.fillInTitleInputField(fakeTitle);
        postCreationPage.fillInDescriptionInputField(fakeDescription);
        postCreationPage.fillInMyThoughtsInputField(fakeMyThoughts);
        postCreationPage.clickOnUploadArea();
        postCreationPage.uploadPicture();
        postCreationPage.pushSubmitButton();
        ElementsCollection filteredTitles = postPreviewPage.getPostPreviewTitle().filterBy(text(title));
        filteredTitles.shouldHave(CollectionCondition.size(1));


    }

    @Test//ne dolzhen padatj , post dolzhen bitj sozdan,po tz toljko Title objazateljnoe pole
    @Category(Smoke.class)

    public void successfulPostCreationOnlyWithTitleFilledInField() {
        postCreationPage.userLogin();
        int postsQuantityBeforeAdding = postPreviewPage.getPostsPreview().size();
        postPreviewPage.clickOnCreatePost();
        String title= postCreationPage.fillInTitleInputField(fakeTitle);
        postCreationPage.pushSubmitButton();
        ElementsCollection filteredTitles = postPreviewPage.getPostPreviewTitle().filterBy(text(title));
        filteredTitles.shouldHave(CollectionCondition.size(1));

    }

    @Test
    public void uploadPicturePNG(){
        postCreationPage.userLogin();
        postPreviewPage.clickOnCreatePost();
        postCreationPage.clickOnUploadArea();
        postCreationPage.uploadPictureMoreThan2Mb();
        postCreationPage.getPictureUploadErrorMessage().shouldHave(text("File size exceeds the 2MB limit"));
    }

    @Test //dolzhen padatj img size>2mb
    public void uploadPictureMoreThan2Mb(){
        postCreationPage.userLogin();
        postPreviewPage.clickOnCreatePost();
        postCreationPage.clickOnUploadArea();
        postCreationPage.uploadPictureMoreThan2Mb();
        postCreationPage.getPictureUploadErrorMessage().shouldHave(text("File size exceeds the 2MB limit"));
    }

    @Test// dolzhen padatj nepraviljnij format faila
    public void uploadPictureGifFormat(){
        postCreationPage.userLogin();
        postPreviewPage.clickOnCreatePost();
        postCreationPage.clickOnUploadArea();
        postCreationPage.uploadPictureGIF();
        postCreationPage.getPictureUploadErrorMessage().shouldHave(text("No file selected")); //tekst oshibki korjavij
    }


    @Test
    public void titleLengthOverMax() {
        postCreationPage.userLogin();
        postPreviewPage.clickOnCreatePost();
        postCreationPage.fillInTitleInputField(fakeTitleOverMaxLength);
        postCreationPage.fillInDescriptionInputField(fakeDescription);
        postCreationPage.fillInMyThoughtsInputField(fakeMyThoughts);
        postCreationPage.pushSubmitButton();
        postCreationPage.getTitleErrorMessage().shouldHave(text("Title should contain maximum 40 symbols"));

    }




    @Test//net soobshenija ob oshibke
    public void postCreationDescriptionInputFieldValueOverMax() {
        postCreationPage.userLogin();
        postPreviewPage.clickOnCreatePost();
        postCreationPage.fillInTitleInputField("sobaka lesnaya");
        postCreationPage.fillInDescriptionInputField(fakeDescriptionOverMaxLength);
        postCreationPage.fillInMyThoughtsInputField(fakeMyThoughts);
        postCreationPage.pushSubmitButton();
        postCreationPage.getDescriptionErrorMessage().shouldHave(text("Description should contain maximum 100 symbols"));

    }

    @Test//net soobshenija ob oshibke
    public void postCreationMyThoughtsOverValidMaxValue() {
        int postsQuantityBeforeAdding = postPreviewPage.getPostsPreview().size();
        postCreationPage.userLogin();
        postPreviewPage.clickOnCreatePost();
        postCreationPage.fillInTitleInputField("sobaka lesnaya");
        postCreationPage.fillInDescriptionInputField(fakeDescription);
        postCreationPage.fillInMyThoughtsInputField(fakeMyThoughtsOverMaxLength);
        postCreationPage.pushSubmitButton();
        postCreationPage.getMyThoughtsErrorMessage().shouldHave(text("Text should contain maximum 1000 symbols"));

    }


    @Test
    @Category(Smoke.class)

    public void savePostInDrafts() {
        postCreationPage.userLogin();
        postPreviewPage.clickOnCreatePost();
        String title= postCreationPage.fillInTitleInputField(fakeTitle);
        postCreationPage.fillInDescriptionInputField(fakeDescription);
        postCreationPage.fillInMyThoughtsInputField(fakeMyThoughts);
        postCreationPage.clickOnSaveInDrafts();
        postCreationPage.pushSubmitButton();
        postPreviewPage.clickOnMyDraftsLink();
        ElementsCollection filteredTitles = postPreviewPage.getPostPreviewTitle().filterBy(text(title));
        filteredTitles.shouldHave(CollectionCondition.size(1));



    }

    @Test
    @Category(Smoke.class)

    public void savePostInDraftsWithDelayInFuture() {
        postCreationPage.userLogin();
        postPreviewPage.clickOnCreatePost();
        String title=  postCreationPage.fillInTitleInputField(fakeTitle);
        postCreationPage.fillInDescriptionInputField(fakeDescription);
        postCreationPage.fillInMyThoughtsInputField(fakeMyThoughts);
        postCreationPage.fillInDateForDelayedPost("02-05-2030");
        postCreationPage.clickOnSaveInDrafts();
        postCreationPage.pushSubmitButton();
        postPreviewPage.clickOnMyDraftsLink();
        ElementsCollection filteredTitles = postPreviewPage.getPostPreviewTitle().filterBy(text(title));
        filteredTitles.shouldHave(CollectionCondition.size(1));

    }

    @Test
    @Category(Smoke.class)

    public void savePostInDraftsWithDelayInPast() {
        postCreationPage.userLogin();
        postPreviewPage.clickOnCreatePost();
        postCreationPage.fillInTitleInputField("Save water drink Riesling");
        postCreationPage.fillInDescriptionInputField(fakeDescription);
        postCreationPage.fillInMyThoughtsInputField(fakeMyThoughts);
        postCreationPage.fillInDateForDelayedPost("02-05-2000");
        postCreationPage.clickOnSaveInDrafts();
        postCreationPage.getDateErrorMessage().shouldHave(text("Date can’t be earlier than today"));
        postCreationPage.getSubmitButton().shouldNotBe(enabled);

    }





    }

