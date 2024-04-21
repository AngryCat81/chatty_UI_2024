import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.After;
import org.junit.Before;
import pages.*;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    final String BASE_URL = "http://chatty.telran-edu.de:8089/login";

    @Before
    public void setUp() {
        open(BASE_URL);
       //Configuration.fastSetValue = true;// Uvelichivaet skorost' zapolnenija form, pishetsja na JavaScript
        Configuration.clickViaJs = true;// pomogaet kliknutj na knopki ,esli oni chem-to perekriti (reklamoj)pishetsja na JavaScript
        Configuration.timeout = 10000;//javnoe ozhidanie, esli ne hvataet vstroennih v selenide 4 sekund
        Configuration.browser = "chrome";//propisivaem browser v kotorom hotim protestirovatj
       // Configuration.browserSize = "300x300"; //menjaem razmer ekrana,chtobi proveritj, chto funkcional sohranjon
        Configuration.headless = true;//rezhim testa ,kotorij pozvoljaet testirovatj bez vizualizacii (dlja skorosti)

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());// metod ,kotorij v sluchae padenija testa pozvoljaet zabratj
        // screenshot iz Allure , i pokazat' ego v konsoli "Idea" vmeste s otchjotom o prohozhdenii testa
    }

    @After
    public void tearDown() {
        closeWebDriver();
    }
    LoginPage loginPage = new LoginPage();
    HeaderPage headerPage=new HeaderPage();
    RegistrationPage registrationPage=new RegistrationPage();

    PostPreviewPage postPreviewPage =new PostPreviewPage();
    PostCreationPage postCreationPage= new PostCreationPage();
    MyDraftsPage myDraftsPage=new MyDraftsPage();
    PostPage postPage=new PostPage();
    UserProfileEditPage userProfileEditPage=new UserProfileEditPage();
    ContactUsPage contactUsPage=new ContactUsPage();
    AdminPanelPage adminPanelPage=new AdminPanelPage();


    Faker faker = new Faker();
    String fakeEmail = faker.internet().emailAddress();
    String savedEmail=fakeEmail;

    String fakeBirthdate = String.valueOf(faker.date().birthday(7,100));
    String fakePassword = faker.regexify("[aK][io][l][t][u][0-9]{8,10}");
    String confirmPassword = fakePassword;
     String newPassword=faker.regexify("[aK][io][l][t][u][0-9]{8,10}");

     public String confirmNewPassword = newPassword;
    String fakePhoneNumber=faker.regexify("[1-9]{8,9}");
    String fakeName=faker.regexify("[aK][io][u]{3,5}");
    String fakeNameValueOverMax=faker.regexify("[aK][io][l][t][u]{21,31}");
    String fakeNameValueLessThanMin=faker.regexify("[aK][io][l][t][u]{1,2}");


    String fakePasswordLessThanMin = faker.regexify("[ao][1-9]{2,5}");
    String fakePasswordOverMax = faker.regexify("[ao][1-9]{101,105}");
    String fakePasswordOnlyDigits = faker.number().digits(8);
    String fakePasswordOnlyLetters = faker.regexify("[k]{8,10}");
    String fakeTitle=faker.lorem().characters(5,40);

    String fakeTitleOverMaxLength=faker.lorem().characters(41,50);
    String fakeDescription=faker.lorem().characters(2,100);
    String fakeDescriptionOverMaxLength=faker.lorem().characters(101,120);
    String fakeMyThoughts=faker.lorem().characters(2,1000);
    String fakeMyThoughtsOverMaxLength=faker.lorem().characters(1001,1005);


}