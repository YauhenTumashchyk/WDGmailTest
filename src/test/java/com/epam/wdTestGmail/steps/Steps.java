package com.epam.wdTestGmail.steps;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Steps
{
	public WebDriver getDriver() {
		return driver;
	}

	private WebDriver driver;

	private final Logger logger = Logger.getLogger(Steps.class);

	public void initBrowser()
	{
		driver = new FirefoxDriver();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		logger.info("Browser started");
	}

	public void clearnAllCookie()
	{
		driver.manage().deleteAllCookies();
	}

	public void closeDriver()
	{
		driver.quit();
	}

//	public boolean isLoggedIn(String username)
//	{
//		LoginPage loginPage = new LoginPage(driver);
//		return (loginPage.getLoggedInUserName().trim().toLowerCase().equals(username));
//	}


}
