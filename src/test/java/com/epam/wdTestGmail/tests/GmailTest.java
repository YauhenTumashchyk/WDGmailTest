package com.epam.wdTestGmail.tests;

import com.epam.wdTestGmail.pages.HomePage;
import com.epam.wdTestGmail.pages.LoginPage;
import com.epam.wdTestGmail.steps.Steps;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GmailTest {
    private Steps steps;
    private static final String FIRST_USERNAME = "13webdriveruser@gmail.com";
    private static final String FIRST_USER_PASSWORD = "1234REWQ";

    private static final String SECOND_USERNAME = "23webdriveruser@gmail.com";
    private static final String SECOND_USERNAME_PASSWORD = "REWQ1234";

    private static final String THIRD_USERNAME = "33webdriveruser@gmail.com";
    private static final String THIRD_USERNAME_PASSWORD = "12QW34ER";

    private static final String MAIL_TITLE = "Default Title";
    private static final String MAIL_VALUE = "Default Value";



    private WebDriver driver;

    @BeforeClass
    public void setUp() throws Exception {
        steps = new Steps();
        steps.initBrowser();
        driver = steps.getDriver();
    }

    @AfterClass
    public void tearDown() throws Exception {
        steps.closeDriver();
    }

    @Test
    public void loginGmail() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.openPage();
        HomePage homePage = loginPage.singInMailBox(FIRST_USERNAME, FIRST_USER_PASSWORD);

        homePage.sendNewMessage(SECOND_USERNAME, MAIL_TITLE, MAIL_VALUE);
    }

    @Test
    public void loginGmail1() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.openPage();
        HomePage homePage = loginPage.singInMailBox(SECOND_USERNAME, SECOND_USERNAME_PASSWORD);

    }

}
