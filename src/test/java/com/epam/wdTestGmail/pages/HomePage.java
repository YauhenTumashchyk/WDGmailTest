package com.epam.wdTestGmail.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends AbstractPage {

    private static final Logger logger = Logger.getLogger(HomePage.class);


    //WriteMessage button
    @FindBy(xpath = "//div[@class='T-I J-J5-Ji T-I-KE L3']")
    private WebElement buttonWriteMessage;

    //SendMessage button
    @FindBy(xpath = "//div[@class='T-I J-J5-Ji aoO T-I-atl L3']")
    private WebElement buttonSendMessage;

    //inputSendTo
    @FindBy(xpath = "//textarea[@name='to']")
    private WebElement inputSendTo;

    //inputMailSubject
    @FindBy(xpath = "//input[@name='subjectbox']")
    private WebElement inputMailSubject;

    //inputMailValue
    @FindBy(xpath = "//div[@class='Am Al editable LW-avf']")
    private WebElement inputMailValue;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void openPage() {

    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void sendNewMessage(String userSend, String mailTitle, String mailValue) {
        buttonWriteMessage.click();
        inputSendTo.sendKeys(userSend);
        inputMailSubject.sendKeys(mailTitle);
        inputMailValue.sendKeys(mailValue);
        buttonSendMessage.click();
        logger.info("new message send");
    }


}
