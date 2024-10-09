package com.cms.pageObjects;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TeamPage {
	
	public static WebDriver driver2;
	public static JavascriptExecutor js ;
	
	@FindBy(xpath="//button[normalize-space()='Add New Team']")
	private WebElement addnewTeam ;
	
	@FindBy(xpath="//input[@id='teamName']")
	private WebElement teamName ;
	
	@FindBy(xpath="//div[@class='form-container']//input[@id='projectName']")
	private WebElement projectList ;
	
	@FindBy(xpath="//input[@id='team_name']")
	private WebElement searchTeamName ;
	
	@FindBy(xpath="//button[@type='submit']//*[name()='svg']")
	private WebElement searchBtn ;
	
	@FindBy(xpath="//button[normalize-space()='Submit']")
	private WebElement submit ;
	
	@FindBy(xpath="//a[@class='btn-view']")
	private WebElement ViewBtn ;
	
	@FindBy(xpath="//button[normalize-space()='Add New Member']")
	private WebElement addNewMember ;
	
	@FindBy(xpath="//div[contains(@class,'control-input relative')]//input[@id='contactFullName']")
	private WebElement addNewContact ;
	
	@FindBy(xpath="//select[@id='roleId']")
	private WebElement ContactRole ;
	
	@FindBy(xpath="//div[@class='control-input relative']//input[@id='contactFullName']")
	private WebElement Contact ;
	
// *********Construction Declaration to initialize Data Member********	
	    public TeamPage(WebDriver driverR)
		{
			driver2 = driverR;
			PageFactory.initElements(driverR, this);
		}
//********time stamp Creation *******************************************
	    public static String timestamp()
	    {
	    	//return new SimpleDateFormat("yyyyddHHmm").format(new Date(10));
	    	LocalDateTime dt=LocalDateTime.now();
	    	DateTimeFormatter df = DateTimeFormatter.ofPattern("ddhhmm");
	    	String mydata=dt.format(df);
	    	return mydata;
	    	
	    }
//************** Method Declaration *************************************
	    
	    public void ClickonAddnewTeam() throws InterruptedException
		{
		    js = (JavascriptExecutor)driver2;
			js.executeScript("arguments[0].setAttribute('style','background:violet;border:40px solid green;')",addnewTeam );
			Thread.sleep(1000);
			addnewTeam.click();
		}
	    
	    public String sendTeamName(String Team) throws InterruptedException
		{
		    js = (JavascriptExecutor)driver2;
			js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",teamName );
			Thread.sleep(1000);
			teamName.sendKeys(Team+ timestamp());
			return Team+ timestamp();
		}
	    
	    public void sendProjectName() throws InterruptedException
		{
		    js = (JavascriptExecutor)driver2;
			js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",projectList );
			Thread.sleep(1000);
			String input="Aeis-smp";
			for(char letter:input.toCharArray())
			{
				projectList.sendKeys(String.valueOf(letter));
				Thread.sleep(100);
			}
			Thread.sleep(1000);
			driver2.findElement(By.xpath("(//*[contains(@class,\"hover:bg-violet-500 hover:text-white\")])[1]")).click();
		}
	    public void ClickonSubmitBtn() throws InterruptedException
	 		{
	 		    js = (JavascriptExecutor)driver2;
	 			js.executeScript("arguments[0].setAttribute('style','background:violet;border:40px solid green;')",submit );
	 			Thread.sleep(1000);
	 			submit.click();
	 		}
	   
	    public void ClickonsearchBtn() throws InterruptedException
 		{
 		    js = (JavascriptExecutor)driver2;
 			js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",searchBtn );
 			Thread.sleep(1000);
 			searchBtn.click();
 		}
	    
	    public String sendSearchTeamName(String Team) throws InterruptedException
		{
		    js = (JavascriptExecutor)driver2;
			js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",searchTeamName );
			Thread.sleep(1000);
			searchTeamName.sendKeys(Team);
			return Team;
		}
	    public void ClickonViewBtn() throws InterruptedException
 		{
 		    js = (JavascriptExecutor)driver2;
 			js.executeScript("arguments[0].setAttribute('style','background:violet;border:40px solid green;')",ViewBtn );
 			Thread.sleep(1000);
 			js.executeScript("arguments[0].click()", ViewBtn);
 			ViewBtn.click();
 		}
	    public void ClickonAddNewMemberBtn() throws InterruptedException
	 		{
	 		    js = (JavascriptExecutor)driver2;
	 			js.executeScript("arguments[0].setAttribute('style','background:violet;border:40px solid green;')",addNewMember );
	 			Thread.sleep(1000);
	 			addNewMember.click();
	 		}
	    public void SendContactName(String CntctName) throws InterruptedException
 		{
 		    js = (JavascriptExecutor)driver2;
 			js.executeScript("arguments[0].setAttribute('style','background:violet;border:40px solid green;')",Contact );
 			Thread.sleep(1000);
 			String cntct=CntctName;
 			for(char letter: cntct.toCharArray())
 			{
 				addNewContact.sendKeys(String.valueOf(letter));
 				Thread.sleep(100);
 			}
 			driver2.findElement(By.xpath("//li[normalize-space()='"+CntctName+"']")).click();
 			Thread.sleep(1000);
 		}
	    public void SelectRole() throws InterruptedException
 		{
 		    js = (JavascriptExecutor)driver2;
 			js.executeScript("arguments[0].setAttribute('style','background:violet;border:40px solid green;')",ContactRole );
 			Select s2 = new Select(ContactRole);
 			s2.selectByIndex(1);
 			Thread.sleep(1000);
 			submit.click();
 		}
	    
	    
}
