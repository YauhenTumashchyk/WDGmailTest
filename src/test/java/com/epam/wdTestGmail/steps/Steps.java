package com.epam.wdTestGmail.steps;

import com.epam.wdTestGmail.pages.HomePage;
import com.epam.wdTestGmail.pages.LoginPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Steps {

    private final Logger logger = Logger.getLogger(Steps.class);
    private HomePage homePage;
    private WebDriver driver;

    public HomePage getHomePage() {
        return homePage;
    }

    public void setHomePage(HomePage homePage) {
        this.homePage = homePage;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void initBrowser() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        logger.info("Browser started");
    }

    public void stepSingInMail(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        setHomePage(loginPage.singInMailBox(username, password));

    }

    public void stepSendNewMessage(String userSend) {
        HomePage homepage = getHomePage();
        homepage.sendNewMessage(userSend);
    }

    public void stepMarkLetterSpam(String userToSpam){
        HomePage homepage = getHomePage();
        homepage.markLetterSpam(userToSpam);
    }

    public void goToSpamPage(String searchParam){
        HomePage homepage = getHomePage();
        homepage.searchSelected(searchParam);
    }

    public void stepSingOut() {
        HomePage homepage = getHomePage();
        homepage.singOut();
    }

    public void closeDriver() {
        driver.quit();
    }

//	public boolean isLoggedIn(String username)
//	{
//		LoginPage loginPage = new LoginPage(driver);
//		return (loginPage.getLoggedInUserName().trim().toLowerCase().equals(username));
//	}


}
