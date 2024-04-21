package pages;

public class Faker {
    com.github.javafaker.Faker faker = new com.github.javafaker.Faker();
    public String fakeEmail = faker.internet().emailAddress();
    String savedEmail=fakeEmail;
    public String fakeBirthdate = String.valueOf(faker.date().birthday(7,100));




    public String fakePhoneNumber=faker.regexify("[3][1][5]{9}");
    public  String fakePassword = newPassword=faker.regexify("[aK][io][l][t][u][0-9]{10}");
    String confirmPassword = fakePassword;
    String newPassword=faker.regexify("[aK][io][l][t][u][0-9]{8}");

    public String confirmNewPassword = newPassword;
    String fakePasswordLessThanMin = faker.regexify("[ao][1-9]{7}");
    String fakePasswordOverMax = faker.regexify("[ao][1-9]{101}");
    public String fakePasswordOnlyDigits = faker.number().digits(8);
    public String fakePasswordOnlyLetters = faker.regexify("[k]{8}");
    public String fakeTitle=faker.lorem().characters(5,40);

    public String fakeTitleOverMaxLength=faker.lorem().characters(5,41);
    public String fakeDescription=faker.lorem().characters(2,100);
    public String fakeDescriptionOverMaxLength=faker.lorem().characters(5,101);
    public String fakeMyThoughts=faker.lorem().characters(2,1000);
    public String fakeMyThoughtsOverMaxLength=faker.lorem().characters(5,1001);


}



