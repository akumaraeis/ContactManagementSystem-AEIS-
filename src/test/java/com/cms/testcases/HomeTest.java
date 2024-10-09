package com.cms.testcases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cms.basetest.BaseTest;

public class HomeTest extends BaseTest {
	
public SoftAssert sf;
	
	public static Logger log;
	public static Select s1;
	public static Select s2;
	public static Select s3;
	public static Select s4;
	public static Select s5;
	public static Select s6;
	public static JavascriptExecutor js;
	
	 
//	public String br;
	
	
	
	@BeforeClass
	
	public void openUrl() throws IOException
	{
		
//		initBrowser(br);
	//	initBrowser(Machine);
		
		
		
		initBrowser("Local");
		log = LogManager.getLogger(HomeTest.class);
		log.info("Browser is launched");
	//	initBrowser();
	//	launchUrl();
		creatingObject();
		
		 
	}
	
	@Test(priority=1)
	public void VerifyHomePageFunctionality() throws IOException, InterruptedException
	{
		
		launchUrl();
		log.info("ChromeBrowser is launched");
		Thread.sleep(2000);
		log.info("URL Is Launched");
		hp.ClickonActiveAccounts();
		Thread.sleep(2000);
		log.info("Active Accounts page opens");
	//	SoftAssertion sf = new softAssertion();
		hp.ClickonHomeTab();
		Thread.sleep(1000);
		log.info("Returned to HomePage");
		hp.ClickonActiveContacts();
		Thread.sleep(1000);
		log.info("Active Contacts page opens");
		hp.ClickonHomeTab();
		Thread.sleep(1000);
		log.info("Returned to HomePage");
		hp.ClickonRunningProjects();
		log.info("Running Projects page opens");
		Thread.sleep(1000);
		hp.ClickonHomeTab();
		log.info("Returned to HomePage");
		hp.ClickonTeams();
		Thread.sleep(2000);
		log.info("Team page opens");
		hp.ClickonHomeTab();
		Thread.sleep(2000);
		
		//**********checking operation on  Active Contacts ***************** 		
		hp.sendAccountName();
		Thread.sleep(2000);
		log.info("Active Accounts name send in serch Box");
		hp.ClickonAccountSeachBtn();
		Thread.sleep(2000);
		log.info("Search Button is clicked");
		hp.ClickonAccountClearBtn();
		Thread.sleep(2000);
		log.info("Clear the searched data");
		WebElement Accountstatus = driverR.findElement(By.xpath("(//select)[1]"));
		js = (JavascriptExecutor)driverR;
		js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",Accountstatus );
		 Thread.sleep(2000);
		Accountstatus.click();
		s1 = new Select(Accountstatus);
		s1.selectByVisibleText("Active");
		Thread.sleep(2000);
		log.info("Active Account status selected");
		hp.ClickonAccountSeachBtn();
		Thread.sleep(1000);
		hp.ClickonAccountClearBtn();
		Thread.sleep(1000);
		log.info("Clear the searched data");
//		driverR.navigate().refresh();
		Thread.sleep(1000);
		WebElement AccountType = driverR.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/select[1]"));
		js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",AccountType );
		Thread.sleep(1000);
		AccountType.click();
		s2 = new Select(AccountType);
		s2.selectByVisibleText("Vendor");
		Thread.sleep(1000);
		hp.ClickonAccountSeachBtn();
		Thread.sleep(1000);
		hp.ClickonAccountClearBtn();
		Thread.sleep(1000);
		
		WebElement IndustryType = driverR.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[4]/select[1]"));
		s3 = new Select(IndustryType);
		js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",IndustryType );
		 Thread.sleep(1000);
		 IndustryType.click();
		s3.selectByVisibleText("Construction");
		Thread.sleep(1000);
		hp.ClickonAccountSeachBtn();
		Thread.sleep(1000);
		hp.ClickonAccountClearBtn();
		Thread.sleep(1000);
//**********checking operation on  Active Contacts *****************
		js.executeScript("window.scrollBy(0,1000)");
		hp.sendContactName();
		Thread.sleep(1000);
		hp.ClickonContactSeachBtn();
		Thread.sleep(1000);
//		js.executeScript("window.scrollBy(0,1000)");	 
		hp.ClickonContactClearBtn();
		js.executeScript("window.scrollBy(0,1000)");
		WebElement ContactType = driverR.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[3]/select[1]"));
		js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",ContactType );
		 Thread.sleep(1000);
		 ContactType.click();
		s4 = new Select(ContactType);
		s4.selectByVisibleText("Employee");
		Thread.sleep(1000);
		hp.ClickonContactSeachBtn();
		Thread.sleep(1000);
		hp.ClickonContactClearBtn();
		Thread.sleep(1000);
//		js.executeScript("window.scrollBy(0,1000)");
		WebElement Contactstatus = driverR.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[4]/select[1]"));
		js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",Contactstatus );
		 Thread.sleep(2000);
		Contactstatus.click();
		s5 = new Select(Contactstatus);
		s5.selectByVisibleText("Active");
		Thread.sleep(2000);
		hp.ClickonContactSeachBtn();
		Thread.sleep(1000);
		hp.ClickonContactClearBtn();
		Thread.sleep(1000);
		
        //**********checking operation on  Active Projects ***************** 
		js.executeScript("window.scrollBy(0,3000)");
		hp.sendProjectName();
		hp.ClickonProjectSeachBtn();
		Thread.sleep(2000); 
		hp.ClickonProjectClearBtn();
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,3000)");
		WebElement Projectstatus = driverR.findElement(By.xpath("(//select)[6]"));
		s6 = new Select(Projectstatus);
		s6.selectByVisibleText("Active");
		hp.ClickonProjectSeachBtn();
		Thread.sleep(2000);
		hp.ClickonProjectClearBtn();
		Thread.sleep(2000);
		
		
		
	//	js.executeScript("arguments[0].scrollintoView(true)",WebElement);
		
		
		
		

}

	@AfterClass
	public void closebrowser()
	{
		teardown();
	}
	
	
}



