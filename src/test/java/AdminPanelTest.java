import com.codeborne.selenide.CollectionCondition;


import org.junit.Test;


import static com.codeborne.selenide.Condition.*;
public class AdminPanelTest extends BaseTest {

    @Test
    public void allTitlesOnUsersTableExist() {
        adminPanelPage.adminLogin();
        adminPanelPage.getTableHeaderNumber().shouldBe(visible).shouldHave(text("№"));
        adminPanelPage.getTableHeaderRole().shouldBe(visible).shouldHave(text("Role"));
        adminPanelPage.getHeaderTableEmail().shouldBe(visible).shouldHave(text("Email"));
        adminPanelPage.getHeaderTableName().shouldBe(visible).shouldHave(text("Name"));
        adminPanelPage.getHeaderTableActions().shouldBe(visible).shouldHave(text("Actions"));

    }

    @Test
    public void loadMoreButtonFunction() {
        adminPanelPage.adminLogin();
        adminPanelPage.getTrashBins().filter(visible).shouldBe(CollectionCondition.size(10));
        adminPanelPage.clickInLoadMoreButton();
        adminPanelPage.getTrashBins().shouldBe(CollectionCondition.size(20));
    }

    @Test
    public void adminUserRoleSwitcher() {
        adminPanelPage.adminLogin();
        adminPanelPage.getAdminUserRoleSwitcher().shouldBe(visible).shouldBe(enabled);


    }
}
