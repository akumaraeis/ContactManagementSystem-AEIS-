package com.cms.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class HomePage {
	
	public static WebDriver driver1;
	public static JavascriptExecutor js ;
	
	@FindBy(xpath="(//*[text()='Active Accounts'])[1]")
//	@FindBy(xpath="//a[@xpath=\"1\"]")
	private WebElement ActiveAccounts ;

	@FindBy(xpath="(//*[text()='Active Contacts'])[1]")
	private WebElement ActiveContacts ;
	
	@FindBy(xpath="//h2[@class='pt-2 m-0 w-full'][normalize-space()='Active Projects']")
	private WebElement RunningProjects;
	
	@FindBy(xpath="(//*[text()=\"Teams\"])[2]")
	private WebElement Teams;
	
	@FindBy(xpath="(//*[@type=\"text\"])[1]")
	private WebElement AccountName;
	
	@FindBy(xpath="(//*[text()=\"Search\"])[1]")
	private WebElement AccountSeachBtn;
	
	@FindBy(xpath="(//*[text()=\"Search\"])[2]")
	private WebElement ContactSeachBtn;
	
	@FindBy(xpath="(//*[text()=\"Search\"])[3]")
	private WebElement ProjectSeachBtn;
	
	@FindBy(xpath="(//*[text()=\"Clear\"])[1]")
	private WebElement AccountClearBtn;
	
	@FindBy(xpath="(//*[text()=\"Clear\"])[2]")
	private WebElement ContactClearBtn;
	
	@FindBy(xpath="(//*[text()=\"Clear\"])[3]")
	private WebElement ProjectClearBtn;
	
	@FindBy(xpath="(//*[text()=\"Home\"])[1]")
	private WebElement HomeTab;
	
	@FindBy(xpath="//div[@class='flex flex-col']//div[2]//div[2]//div[1]//div[1]//input[1]")
	private WebElement ContactFirstName;
	
	@FindBy(xpath="(//*[@type=\"text\"])[3]")
	private WebElement ContactLastName;
	
	@FindBy(xpath="//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/div[1]/div[1]/input[1]")
	private WebElement ProjectName;
	
	
	 public HomePage(WebDriver driverR)
	{
		driver1 = driverR;
		PageFactory.initElements(driverR, this);
	}
	 
	 public void ClickonActiveAccounts() throws InterruptedException
		{
		    js = (JavascriptExecutor)driver1;
			js.executeScript("arguments[0].setAttribute('style','background:violet;border:40px solid green;')",ActiveAccounts );
			Thread.sleep(2000);
		 ActiveAccounts.click();
		}
	 
	 public void ClickonActiveContacts() throws InterruptedException
		{
		    js = (JavascriptExecutor)driver1;
			js.executeScript("arguments[0].setAttribute('style','background:violet;border:40px solid green;')",ActiveContacts );
			Thread.sleep(2000);
		 ActiveContacts.click();
		}
	 public void ClickonRunningProjects() throws InterruptedException
		{
		    js = (JavascriptExecutor)driver1;
			js.executeScript("arguments[0].setAttribute('style','background:violet;border:40px solid green;')",RunningProjects );
			Thread.sleep(2000);
		 RunningProjects.click();
		}
	 public void ClickonTeams() throws InterruptedException
		{
		    js = (JavascriptExecutor)driver1;
			js.executeScript("arguments[0].setAttribute('style','background:violet;border:40px solid green;')",Teams );
			Thread.sleep(2000);
		 Teams.click();
		}
	 
	public void sendAccountName() throws InterruptedException
	{
		js = (JavascriptExecutor)driver1;
		js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",AccountName );
		Thread.sleep(2000);
		AccountName.sendKeys("Emard-Mann");
	}
	 public void ClickonAccountSeachBtn() throws InterruptedException
		{
		 js = (JavascriptExecutor)driver1;
		 js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",AccountSeachBtn );
		 Thread.sleep(2000);
		 AccountSeachBtn.click();
		}
	 
	 public void ClickonContactSeachBtn() throws InterruptedException
		{
		 js = (JavascriptExecutor)driver1;
		 js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",ContactSeachBtn );
		 Thread.sleep(2000);
		 ContactSeachBtn.click();
		}
	 
	 public void ClickonProjectSeachBtn() throws InterruptedException
		{
		 js = (JavascriptExecutor)driver1;
		 js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",ProjectSeachBtn );
		 Thread.sleep(2000);
		 ProjectSeachBtn.click();
		}
	 
	 public void ClickonAccountClearBtn() throws InterruptedException
		{
		 js = (JavascriptExecutor)driver1;
		 js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",AccountClearBtn );
		 Thread.sleep(2000);
		 AccountClearBtn.click();
		}
	 
	 public void ClickonContactClearBtn() throws InterruptedException
		{
		 js = (JavascriptExecutor)driver1;
		 js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",ContactClearBtn );
		 Thread.sleep(2000);
		 ContactClearBtn.click();
		}
	 public void ClickonProjectClearBtn() throws InterruptedException
		{
		 js = (JavascriptExecutor)driver1;
		 js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",ProjectClearBtn );
		 Thread.sleep(2000);
		 ProjectClearBtn.click();
		}
	 
	 public void ClickonHomeTab() throws InterruptedException
		{ 
		 HomeTab.click();
		}
	 
	 public void sendContactName() throws InterruptedException
		{
			js = (JavascriptExecutor)driver1;
			js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",ContactFirstName );
			Thread.sleep(2000);
			ContactFirstName.sendKeys("Mason");
			js = (JavascriptExecutor)driver1;
			js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",ContactLastName );
			Thread.sleep(2000);
			ContactLastName.sendKeys("Nicolas");
		}
	 
	 public void sendProjectName() throws InterruptedException
		{
			js = (JavascriptExecutor)driver1;
			js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",ProjectName );
			Thread.sleep(2000);
			ProjectName.sendKeys("Hirthe-Grimes");
		}

}
