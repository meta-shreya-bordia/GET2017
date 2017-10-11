package com.metacube.testautomation;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG_LoginCheck {
	WebDriver driverChrome;
	WebDriver driverFirefox;
	WebDriver driverIE;
	
	@BeforeTest
	public void beforeTest() throws InterruptedException {
		driverChrome =  new ChromeDriver();
		driverChrome.get("http://automationpractice.com/index.php");
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\user11\\Downloads\\drivers-20171010T120029Z-001\\drivers\\geckodriver-v0.18.0-win32\\geckodriver.exe");
		driverFirefox =  new FirefoxDriver();
		driverFirefox.get("http://automationpractice.com/index.php");
		System.setProperty("webdriver.ie.driver", "C:\\Users\\user11\\Downloads\\drivers-20171010T120029Z-001\\drivers\\IEDriverServer_Win32_3.6.0\\IEDriverServer.exe");
		driverIE =  new InternetExplorerDriver();
		driverIE.get("http://automationpractice.com/index.php");
	}
	
	//Default priority of a Test = 0	
	
	@Test(priority = 1)
	public void testAccountCreationForChrome() throws InterruptedException {
		driverChrome.findElement(By.className("login")).click();
		Thread.sleep(1000);
		driverChrome.findElement(By.id("email_create")).sendKeys("abc@metacube.com");
		driverChrome.findElement(By.id("SubmitCreate")).click();
		Thread.sleep(3000);
		assertEquals(driverChrome.getCurrentUrl(), "http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation");
	}
	
	@Test(priority = 2)
	public void testForgotPasswordForChrome() throws InterruptedException {
		driverChrome.findElement(By.className("login")).click();
		driverChrome.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		assertEquals(driverChrome.getTitle(), "Forgot your password - My Store");
	}
	
	@Test(priority = 3)
	public void testAccountCreationForFireFox() throws InterruptedException {
		driverFirefox.findElement(By.className("login")).click();
		Thread.sleep(1000);
		driverFirefox.findElement(By.id("email_create")).sendKeys("vaishali.jain@metacube.com");
		driverFirefox.findElement(By.id("SubmitCreate")).click();
		Thread.sleep(5000);
		assertEquals(driverFirefox.getCurrentUrl(), "http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation");
	}
	
	@Test(priority = 4)
	public void testForgotPasswordForFireFox() throws InterruptedException {
		driverFirefox.findElement(By.className("login")).click();
		driverFirefox.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(3000);
		assertEquals(driverFirefox.getTitle(), "Forgot your password - My Store");
	}

	@Test(priority = 5)
	public void testAccountCreationForIE() throws InterruptedException {
		driverIE.findElement(By.className("login")).click();
		Thread.sleep(1000);
		driverIE.findElement(By.id("email_create")).sendKeys("vaishali.jain@metacube.com");
		driverIE.findElement(By.id("SubmitCreate")).click();
		Thread.sleep(5000);
		assertEquals(driverIE.getCurrentUrl(), 
				"http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation");
	}
	
	@Test(priority=6)
	public void testForgotPasswordForIE() throws InterruptedException {
		driverIE.findElement(By.className("login")).click();
		driverIE.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		assertEquals(driverIE.getTitle(), "Forgot your password - My Store");
	}

	@AfterTest
	public void afterTest() throws InterruptedException {
		Thread.sleep(1000);
		driverChrome.quit();
		driverFirefox.quit();
		driverIE.quit();
	}
}
