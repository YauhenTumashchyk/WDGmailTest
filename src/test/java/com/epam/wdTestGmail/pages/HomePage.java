package com.epam.wdTestGmail.pages;

import com.epam.wdTestGmail.utils.Utils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomePage extends AbstractPage {

    private static final Logger logger = Logger.getLogger(HomePage.class);

    //WriteMessage button
    @FindBy(xpath = "//div[@class='T-I J-J5-Ji T-I-KE L3']")
    private WebElement buttonWriteMessage;

    //SendMessage button
    @FindBy(xpath = "//div[@class='T-I J-J5-Ji aoO T-I-atl L3']")
    private WebElement buttonSendMessage;

    //buttonUserMenu
    @FindBy(xpath = "//a[@class='gb_pa gb_l gb_r gb_h']")
    private WebElement buttonUserMenu;

    //buttonInSpam
    @FindBy(xpath = "//div[@class='T-I J-J5-Ji nN T-I-ax7 T-I-Js-Gs T-I-Js-IF ar7']")
    private WebElement buttonInSpam;

    //buttonSearch
    @FindBy(xpath = "//button[@ id='gbqfb']")
    private WebElement buttonSearch;

    //buttonSingOut
    @FindBy(xpath = "//a[@id='gb_71']")
    private WebElement buttonSingOut;

    //inputSendTo
    @FindBy(xpath = "//textarea[@name='to']")
    private WebElement inputSendTo;

    //inputMailSubject
    @FindBy(xpath = "//input[@name='subjectbox']")
    private WebElement inputMailSubject;

    //inputMailValue
    @FindBy(xpath = "//div[@class='Am Al editable LW-avf']")
    private WebElement inputMailValue;

    //frameMailSend
    @FindBy(xpath = "//div [@class='vh' and text()='Письмо отправлено.']")
    private WebElement frameMailSend;

    //inputSearchField
    @FindBy(xpath = "//input[@name='q']")
    private WebElement inputSearchField;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void sendNewMessage(String userSend) {
        buttonWriteMessage.click();
        inputSendTo.sendKeys(userSend);
        inputMailSubject.sendKeys(Utils.getRandomString(10));
        inputMailValue.sendKeys(Utils.getRandomString(10));
        buttonSendMessage.click();

        logger.info("new message send");
    }

    public void markLetterSpam(String userToSpam) {
        logger.info("markLetterSpam method begin");
        List<WebElement> mail = driver.findElements(By.xpath("//tr/td/div[not(text())]/span[@email]"));
        List<WebElement> checkbox = driver.findElements(By.xpath("//div[@role='checkbox']"));
        String username;


        for (int i = 0; i < mail.size(); i++) {
            username = mail.get(i).getAttribute("email");
            if (username.equals(userToSpam)) {
                checkbox.get(i).click();
            }

        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        buttonInSpam.click();

    }

    public void searchSelected(String searchParam){
        inputSearchField.sendKeys(searchParam);
        buttonSearch.click();

    }

    public void singOut() {
        buttonUserMenu.click();
        buttonSingOut.click();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();

        logger.info("user singed out");
    }


}
