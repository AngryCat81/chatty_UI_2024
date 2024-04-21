package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import org.openqa.selenium.By;

import javax.lang.model.util.Elements;
import javax.print.attribute.Attribute;

import java.util.ArrayList;
import java.util.List;


import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


public class PostPreviewPage {
    private SelenideElement myPostsTumbler = $(By.id("myPostsId"));
    private SelenideElement usernameInSidebar = $x("//*[@id=\"root\"]/div[2]/div[3]/div/div/div[1]/p");
    private SelenideElement blogTitle = $x("//p[text()='Feed']");
    private SelenideElement createPostTitle = $x("//p[text()='Create a post']");
    private SelenideElement createPostPlusButton = $x("//span[text()='+']");
    private SelenideElement suggestions = $(By.tagName("h2"));
    private ElementsCollection postsPreview = $$(By.cssSelector("[data-test=\"post\"]"));
    private ElementsCollection suggestedUsersProfile=$$(By.className("user-info"));
    private SelenideElement firstSuggestedUserProfile = $x("//*[@id=\"root\"]/div[2]/div[4]/div/div/ul/li[1]/div/span");
    private SelenideElement userAvatarSidebar = $(By.className("user__img"));
    private SelenideElement sidebarUsername=$(By.cssSelector("div[class='user-info'] p"));
    private SelenideElement myDraftsLink = $x("//span[normalize-space()='My drafts']");
    private SelenideElement postPreviewPicture = $(By.className("post-photo"));
    private SelenideElement postPreviewAuthor = $x("//*[@id=\"root\"]/div[2]/div/div/div/div[2]/div[1]/div[1]/span");
    private SelenideElement myThoughtsText=$(By.className("post-content__body"));
    private SelenideElement  readingTime= $(By.className("post-user__reading-time"));
    private SelenideElement postPreviewDate = $x("//*[@id=\"root\"]/div[2]/div[2]/div[1]/div/div[1]/div[2]/div[2]/p");



    private ElementsCollection postPreviewTitle = $$(By.tagName("h3"));
    private SelenideElement postPreviewDescription = $(By.className("post__description"));
    private SelenideElement usersAvatars =$(By.className("post-user__top__avatar"));
    private SelenideElement nextPageButton = $(By.id("next-btn"));
    private SelenideElement previousPageButton = $(By.id("next-btn"));
    private SelenideElement sortingDropDown = $(By.id("sort_by"));

    public SelenideElement getSidebarUsername() {
        return sidebarUsername;
    }

    public ElementsCollection getPostPreviewTitle() {
        return postPreviewTitle;
    }


    public SelenideElement getUsersAvatars() {
        return usersAvatars;
    }

    public SelenideElement getMyThoughtsText() {
        return myThoughtsText;
    }

    public SelenideElement getFirstSuggestedUserProfile() {
        return firstSuggestedUserProfile;
    }

    public SelenideElement getUsernameInSidebar() {
        return usernameInSidebar;
    }

    public SelenideElement getBlogTitle() {
        return blogTitle;
    }

    public SelenideElement getCreatePostTitle() {
        return createPostTitle;
    }

    public SelenideElement getSuggestions() {
        return suggestions;
    }

    public ElementsCollection getPostsPreview() {
        return postsPreview;
    }

    public SelenideElement getPostPreviewPicture() {
        return postPreviewPicture;
    }

    public SelenideElement getPostPreviewAuthor() {
        return postPreviewAuthor;
    }

    public SelenideElement getReadingTime() {
        return readingTime;
    }

    public SelenideElement getPostPreviewDate() {
        return postPreviewDate;
    }



    public SelenideElement getPostPreviewDescription() {
        return postPreviewDescription;
    }

    public ElementsCollection getSuggestedUsersProfile() {
        return suggestedUsersProfile;
    }

    public void clickOnCreatePost() {
        createPostPlusButton.click();
    }

    public void clickOnMyDraftsLink() {
        myDraftsLink.click();
    }

    public void clickOnMyPostTumbler() {
        myPostsTumbler.click();
    }

    public void clickOnPost() {
        postsPreview.first().click();
    }
    public int getPostSPreviewSize(){
        int size = postsPreview.size();
        return size;
    }

    public void clickOnSuggestedAccount() {
        firstSuggestedUserProfile.click();

        }
        public void clickOnNextPageButton () {
            nextPageButton.click();
        }

        public void clickOnPreviousPageButton () {
            previousPageButton.click();
        }

        public void clickOnSortingDropDown () {
            sortingDropDown.click();
        }

//    public void postsSortedFromNewToOld(){
//        // Проверяем порядок дат публикации: от новых к старым
//        for (int i = 0; i < postDates.size() - 1; i++) {
//            String date1 = postDates.get(i).getText();
//            String date2 = postDates.get(i + 1).getText();
//            date1.shouldBe(Condition.greaterThanOrEqual(date2))
//    }


    public void postPreviewContainsAllRequiredContent() {
        for (SelenideElement post : postsPreview) {
            post.$(By.className("post-photo")).shouldBe(visible);
            post.$x("//*[@id=\"root\"]/div[2]/div[2]/div[1]/div/div[1]/div[1]/div[1]/span").shouldBe(visible);
            post.$(By.className("post-user__reading-time")).shouldBe(visible);
            post.$x("//*[@id=\"root\"]/div[2]/div[2]/div[1]/div/div[1]/div[2]/div[2]/p").shouldBe(visible);
            post.$(By.tagName("h3")).shouldBe(visible);
            post.$(By.className("post-user__top__avatar")).shouldBe(visible);
            post.$(By.id("next-btn")).shouldBe(visible);
        }
    }


    public String getTitleText() {
        return postPreviewTitle.first().getText();
    }

    }










