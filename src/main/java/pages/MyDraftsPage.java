package pages;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MyDraftsPage {
    private ElementsCollection postsInDrafts = $$(By.className("post"));
    private SelenideElement myDraftsPageTitle=$(By.className("post-header__feed"));

    public SelenideElement getMyDraftsPageTitle() {
        return myDraftsPageTitle;
    }

    public ElementsCollection getPostsInDrafts() {
        return postsInDrafts;


    }

    public int getPostSize(){
        return   postsInDrafts.size();
    }


    }


