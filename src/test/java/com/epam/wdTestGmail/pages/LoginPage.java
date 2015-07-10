package com.epam.wdTestGmail.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage {

    private static final Logger logger = Logger.getLogger(LoginPage.class);
    private final String BASE_URL = "https://gmail.com/";

    //    singInMailBox
    @FindBy(id = "Email")
    private WebElement inputUsername;

    //    password
    @FindBy(id="Passwd")
    private WebElement inputPassword;

    //next button
    @FindBy(xpath = "//input[@id='next']")
    private WebElement buttonNext;

    //singIn button
    @FindBy(xpath = "//input[@id='signIn']")
    private WebElement buttontSingIn;

    //shows user in use
    @FindBy(xpath = "//span[@id='email-display']")
    private WebElement linkLoggedInUser;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("Login page opened");
    }

    public HomePage singInMailBox(String username, String password) {
        inputUsername.sendKeys(username);
        buttonNext.click();
        inputPassword.sendKeys(password);
        buttontSingIn.click();

        logger.info("user signed in");

        return new HomePage(this.driver);
    }

    public String getUserName() {
        return linkLoggedInUser.getText();
    }


}
