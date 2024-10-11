package com.cms.pageObjects;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProjectPage {
	public static WebDriver driver2;
	public static JavascriptExecutor js ;
	
	@FindBy(xpath="//button[normalize-space()='Add New Project']")
	private WebElement addnewProject ;
	
	@FindBy(xpath="//input[@id='projectName']")
	private WebElement projectName ;
	
	@FindBy(xpath="(//input[@id='startDate'])[2]")
	private WebElement StartDate ;
	
	@FindBy(xpath="//div[@class='form-container']//input[@id='accountName']")
	private WebElement account ;

	@FindBy(xpath="//input[@id='address1']")
	private WebElement address1 ;
	
	@FindBy(xpath="//input[@id='address2']")
	private WebElement address2 ;
	
	@FindBy(xpath="//input[@id='city']")
	private WebElement city ;
	
	@FindBy(xpath="//input[@id='postalCode']")
	private WebElement postal ;

	@FindBy(xpath="//select[@id='projectStatusId']")
	private WebElement Status ;

	@FindBy(xpath="//select[@id='stateId']")
	private WebElement stateId ;

	@FindBy(xpath="//select[@id='status_id']")
	private WebElement projectStatusSearch ;

	@FindBy(xpath="//input[@id='project_name']")
	private WebElement projectSearch ;
	
	@FindBy(xpath="//button[contains(@type,'submit')]")
	private WebElement SearchBtn ;
	
	@FindBy(xpath="//button[normalize-space()='Submit']")
	private WebElement submit ;
	
	@FindBy(xpath="//select[@id='countryId']")
	private WebElement Country ;
	
	@FindBy(xpath="//tbody/tr[1]/td[6]/button[1]")
	private WebElement EditBtn ;
	
	@FindBy(xpath="//a[@class='btn-view']")
	private WebElement ViewBtn ;
	
	@FindBy(xpath="//button[normalize-space()='Add New Team']")
	private WebElement AddNewBtn ;
	
// *********Construction Declaration to initialize Data Member********	
	    public ProjectPage(WebDriver driverR)
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
	    
	    public void ClickonAddnewProject() throws InterruptedException
		{
		    js = (JavascriptExecutor)driver2;
			js.executeScript("arguments[0].setAttribute('style','background:violet;border:40px solid green;')",addnewProject );
			Thread.sleep(1000);
			addnewProject.click();
		}
	    
	    public String sendProjectName(String ProjectName) throws InterruptedException
		{
		    js = (JavascriptExecutor)driver2;
			js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",projectName );
			Thread.sleep(1000);
			projectName.sendKeys(ProjectName+ timestamp());
			return ProjectName+ timestamp();
		}
	    
	    public void sendAccountName(String AccountName ) throws InterruptedException
		{
		    js = (JavascriptExecutor)driver2;
			js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",account );
			Thread.sleep(1000);
	//		account.sendKeys(AccountName);
			String keyword =AccountName;
			for(char letter :keyword.toCharArray())
			{
				account.sendKeys(Character.toString(letter));
				Thread.sleep(100);
			}
			List<WebElement> suggestions = driver2.findElements(By.xpath("//ul[@class=\"w-full overflow-y-auto max-h-32\"]"));
			for(WebElement suggestion:suggestions)
			{
				System.out.println(suggestion.getText());
			}

			for(WebElement suggestion:suggestions)
			{
				if(suggestion.getText().contains(AccountName))
				{
					    
						suggestion.click();
						//    			Actions act = new Actions(driverR);
						//    			act.moveToElement(suggestion).perform();
						//    			act.click().perform();
						break;
					}
			}
		//	account.sendKeys(Keys.ENTER);		
	//		Thread.sleep(2000);
//			driver2.findElement(By.xpath("//li[@class='hover:bg-violet-500 hover:text-white px-1 py-1 cursor-pointer w-full']")).click();
//	        WebElement accountOption = driver2.findElement(By.xpath("//li[@class='hover:bg-violet-500 hover:text-white px-1 py-1 cursor-pointer w-full']"));
//	        Actions act = new Actions(driver2);
//	        act.moveToElement(accountOption).click().build().perform();

		
		}
	    
	    public void sendAddress1(String Address1) throws InterruptedException
		{
		    js = (JavascriptExecutor)driver2;
			js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",address1 );
			Thread.sleep(1000);
			address1.sendKeys(Address1);
		}
	    
	    public void sendAddress2(String Address2) throws InterruptedException
		{
		    js = (JavascriptExecutor)driver2;
			js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",address2 );
			Thread.sleep(1000);
			address2.sendKeys(Address2);
		}
	    
	    public void sendCity(String City) throws InterruptedException
		{
		    js = (JavascriptExecutor)driver2;
			js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",city );
			Thread.sleep(1000);
			city.sendKeys(City);
		}
	   
	    public void sendPostal(String Code) throws InterruptedException
		{
		    js = (JavascriptExecutor)driver2;
			js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",postal );
			Thread.sleep(1000);
			postal.sendKeys(Code);
		}
	    
	    public void selectStatus(String StateName) throws InterruptedException
	  		{
	  		    js = (JavascriptExecutor)driver2;
	  			js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",Status );
	  			Thread.sleep(1000);
	  			Select s2 = new Select(Status);
				s2.selectByVisibleText(StateName);
	  		}
	    
	    public void selectState(String StateName) throws InterruptedException
  		{
  		    js = (JavascriptExecutor)driver2;
  			js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",stateId );
  			Thread.sleep(1000);
  			Select s3 = new Select(stateId);
			s3.selectByVisibleText(StateName);
  		}
	    
	    public void ClickonSubmit() throws InterruptedException
		{
		    js = (JavascriptExecutor)driver2;
			js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",submit );
			Thread.sleep(1000);
			submit.click();
		}
	    
	    public String sendProjectToSearch(String projectName) throws InterruptedException
		{
		    js = (JavascriptExecutor)driver2;
			js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",projectSearch );
			Thread.sleep(1000);
			projectSearch.sendKeys(projectName);
			Thread.sleep(2000);
//			SearchBtn.click();
			return projectName;
		}
	    
	    public void selectProjectStatus(String Status) throws InterruptedException
  		{
  		    js = (JavascriptExecutor)driver2;
  			js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",projectStatusSearch );
  			Thread.sleep(1000);
  			Select s4 = new Select(projectStatusSearch);
			s4.selectByVisibleText(Status);
  		}  
	    public void ClickonSearch() throws InterruptedException
		{
		    js = (JavascriptExecutor)driver2;
			js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",SearchBtn );
			Thread.sleep(1000);
			SearchBtn.click();
		}
	    public void selectStartDate() throws InterruptedException
  		{
  		    js = (JavascriptExecutor)driver2;
  			js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",StartDate );
  			Thread.sleep(1000);
  			StartDate.sendKeys("20-02-2020");
  		}
	    public void SelectCountryType(String CountryName) throws InterruptedException
		{
		    js = (JavascriptExecutor)driver2;
			js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",Country );
			Thread.sleep(1000);
		Select s9 = new Select(Country);
		s9.selectByVisibleText(CountryName);
		}
	    public void ClickonEditBtn() throws InterruptedException
		{
		    js = (JavascriptExecutor)driver2;
			js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",EditBtn );
			Thread.sleep(1000);
			EditBtn.click();
		}
	    public void ClickonViewBtn() throws InterruptedException
		{
		    js = (JavascriptExecutor)driver2;
			js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",ViewBtn );
			Thread.sleep(1000);
			ViewBtn.click();
		}
	    public void ClickOnAddNewTeamBtn() throws InterruptedException
		{
		    js = (JavascriptExecutor)driver2;
			js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",AddNewBtn );
			Thread.sleep(1000);
			AddNewBtn.click();
		}
	    
}

