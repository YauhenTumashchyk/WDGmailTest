package com.epam.wdTestGmail.tests;

import com.epam.wdTestGmail.pages.HomePage;
import com.epam.wdTestGmail.pages.LoginPage;
import com.epam.wdTestGmail.steps.Steps;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GmailTest {

    private static final String FIRST_USERNAME = "13webdriveruser@gmail.com";
    private static final String FIRST_USER_PASSWORD = "1234REWQ";

    private static final String SECOND_USERNAME = "23webdriveruser@gmail.com";
    private static final String SECOND_USER_PASSWORD = "REWQ1234";

    private static final String THIRD_USERNAME = "33webdriveruser@gmail.com";
    private static final String THIRD_USER_PASSWORD = "12QW34ER";

    private Steps steps;
    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;


    @BeforeMethod
    public void setUp() throws Exception {
        steps = new Steps();
        steps.initBrowser();
    }

//    @AfterMethod
//    public void tearDown() throws Exception {
//        steps.closeDriver();
//    }

    @Test
    public void loginGmail() {

        //sing in first user and send email
        steps.stepSingInMail(FIRST_USERNAME, FIRST_USER_PASSWORD);
        steps.stepSendNewMessage(SECOND_USERNAME);
        steps.stepSingOut();

        //sing in second user and mark letter as spam
        steps.stepSingInMail(SECOND_USERNAME, SECOND_USER_PASSWORD);
        steps.stepMarkLetterSpam(FIRST_USERNAME);
        steps.stepSingOut();

        //sing in first user and send email
        steps.stepSingInMail(FIRST_USERNAME, FIRST_USER_PASSWORD);
        steps.stepSendNewMessage(SECOND_USERNAME);
        steps.stepSingOut();

        //sing in second user and check spam
        steps.stepSingInMail(SECOND_USERNAME, SECOND_USER_PASSWORD);


    }

//    @Test
//    public void loginGmail1() {
//
//    }

}
