

import org.junit.Test;
import org.junit.experimental.categories.Category;


import static com.codeborne.selenide.Condition.*;
public class AdminLoginTest extends BaseTest {


    @Test
    @Category(Smoke.class)
    public void adminSuccessfulLogin() {
        loginPage.enterEmail("katja@th.lv");
        loginPage.enterPassword("katja1981");
        loginPage.clickOnLoginButton();
        adminPanelPage.getAdminPanelTitle().shouldHave(text("Admin panel"));

    }
}
