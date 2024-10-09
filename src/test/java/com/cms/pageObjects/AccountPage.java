package com.cms.pageObjects;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.cms.utility.Utility;

public class AccountPage {

	public static WebDriver driver2;
	public static JavascriptExecutor js ;

	@FindBy(xpath="//button[normalize-space()='Add New Account']")
	private WebElement addnewAccount ;

	@FindBy(xpath="//input[@id='accountName']")
	private WebElement accountname ;

	@FindBy(xpath="//select[@name='accountTypeId']")
	private WebElement accountType ;

	@FindBy(xpath="//select[@id='accountStatusId']")
	private WebElement accountStatus ;

	@FindBy(xpath="//select[@name='industryId']")
	private WebElement industry ;

	@FindBy(xpath="//input[@id='emailId']")
	private WebElement  email;

	@FindBy(xpath="//input[@id='website']")
	private WebElement website ;

	@FindBy(xpath="//input[@placeholder='accountDesc']")
	private WebElement accountDesc ;

	@FindBy(xpath="//input[@id='phoneNo']")
	private WebElement phone ;

	@FindBy(xpath="//input[@id='address1']")
	private WebElement address1 ;

	@FindBy(xpath="//input[@id='address2']")
	private WebElement address2 ;

	@FindBy(xpath="//input[@id='city']")
	private WebElement city ;

	@FindBy(xpath="//input[@id='postalCode']")
	private WebElement postal ;

	@FindBy(xpath="//select[@id='stateId']")
	private WebElement  state;

	@FindBy(xpath="//input[@placeholder='latitude']")
	private WebElement latitude ;

	@FindBy(xpath="//input[@placeholder='longitude']")
	private WebElement longitude ;

	@FindBy(xpath="//button[normalize-space()='Submit']")
	private WebElement submit ;

	@FindBy(xpath="//input[@id='account_name']")
	private WebElement AccountFilter ;

	@FindBy(xpath="//button[@type='submit']")
	private WebElement Search ;

	@FindBy(xpath="//button[normalize-space()='Edit']")
	private WebElement Editbtn ;

	@FindBy(xpath="//input[@id='emailId']")
	private WebElement Email2 ;

	@FindBy(xpath="//li[normalize-space()='Next']")
	private WebElement Nextbtn ;

	@FindBy(xpath="//button[normalize-space()='Reset']")
	private WebElement Resetbtn ;

	@FindBy(xpath="//tbody/tr[2]/td[7]/div[1]/span[1]/a[1]//*[name()='svg']")
	private WebElement ViewBtn ;

	@FindBy(xpath="//select[@id='countryId']")
	private WebElement Country ;

	@FindBy(xpath="//select[@id='type_id']")
	private WebElement AccountFilterType ;

	@FindBy(xpath="//select[@id='status_id']")
	private WebElement AccountFilterStatus ;

	@FindBy(xpath="//select[@id='industry_id']")
	private WebElement AccountIndustryFilter ;

	@FindBy(xpath="//input[@id='imageFile']")
	private WebElement Image ;

	@FindBy(xpath="//button[normalize-space()='Clear']")
	private WebElement ClearBtn ;


	// *********Construction Declaration to initialize Data Member********	
	public AccountPage(WebDriver driverR)
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

	public void ClickonAddnewBtn() throws InterruptedException
	{
		js = (JavascriptExecutor)driver2;
		js.executeScript("arguments[0].setAttribute('style','background:violet;border:40px solid green;')",addnewAccount );
	//	Thread.sleep(1000);
		Utility.showCallout("it will click on Add New Account Button", addnewAccount);
		addnewAccount.click();
	}

	public String SendAccountName(String ActName) throws InterruptedException
	{
		js = (JavascriptExecutor)driver2;
		js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",accountname );
	//	Thread.sleep(1000);
		Utility.showCallout("it will Send account Name ", accountname);
		accountname.sendKeys(ActName+timestamp());
		return (ActName + timestamp());
	}
	public void SelectAccountType(String ActType) throws InterruptedException
	{
		js = (JavascriptExecutor)driver2;
		js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",accountType );
	//	Thread.sleep(1000);
		Utility.showCallout("Then It will Select Account type", accountType);
		Select s1 = new Select(accountType);
		s1.selectByVisibleText(ActType);
	}

	public void SelectAccountStatus(String status) throws InterruptedException
	{
		js = (JavascriptExecutor)driver2;
		js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",accountStatus );
	//	Thread.sleep(1000);
		Utility.showCallout("Then It will Select Account Status", accountStatus);
		Select s2 = new Select(accountStatus);
		s2.selectByVisibleText(status);
	}

	public void SelectIndustryStatus() throws InterruptedException
	{
		js = (JavascriptExecutor)driver2;
		js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",industry );
	//	Thread.sleep(1000);
		Utility.showCallout("Then It will Select Industry", industry);
		Select s3 = new Select(industry);
		s3.selectByIndex(1);
	}
	public void SendEmail(String emailid) throws InterruptedException
	{
		js = (JavascriptExecutor)driver2;
		js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",email );
	//	Thread.sleep(1000);
		Utility.showCallout("Then It will Send Email", email);
		email.sendKeys(emailid +timestamp()+"@gmail.com");
	}

	public void Sendwebsite(String Website) throws InterruptedException
	{
		js = (JavascriptExecutor)driver2;
		js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",website );
	//	Thread.sleep(1000);
		Utility.showCallout("Then It will Send WebSite", website);
		website.sendKeys(Website);
	}

	public void SendaccountDesc() throws InterruptedException
	{
		js = (JavascriptExecutor)driver2;
		js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",accountDesc );
	//	Thread.sleep(1000);
		accountDesc.sendKeys("Testing");
	}

	public void Sendphone(String phoneNo) throws InterruptedException
	{
		js = (JavascriptExecutor)driver2;
		js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",phone );
	//	Thread.sleep(1000);
		Utility.showCallout("Then It will Enter Phone", phone);
		phone.sendKeys(phoneNo);
	}

	public void SendAddress1(String address) throws InterruptedException
	{
		js = (JavascriptExecutor)driver2;
		js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",address1 );
	//	Thread.sleep(1000);
		Utility.showCallout("Then It will Enter Address", address1);
		address1.sendKeys(address);
	}
	public void SendAddress2(String addressNm) throws InterruptedException
	{
		js = (JavascriptExecutor)driver2;
		js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",address2 );
	//	Thread.sleep(1000);
		Utility.showCallout("Then It will Enter Address Detail", address2);
		address2.sendKeys(addressNm);
	}

	public void SendCity(String CityName) throws InterruptedException
	{
		js = (JavascriptExecutor)driver2;
		js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",city );
	//	Thread.sleep(1000);
		Utility.showCallout("Then It will enter City Name", city);
		city.sendKeys(CityName);
	}
	public void SendPostal(String Code) throws InterruptedException
	{
		js = (JavascriptExecutor)driver2;
		js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",postal );
	//	Thread.sleep(1000);
		Utility.showCallout("Then It will Send Postal Code", postal);
		postal.sendKeys(Code);
	}
	public void SelectState(String StateName) throws InterruptedException
	{
		js = (JavascriptExecutor)driver2;
		js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",state );
	//	Thread.sleep(1000);
		Utility.showCallout("Then It will Select State Name", state);
		Select s4 = new Select(state);
		s4.selectByVisibleText(StateName);
	}

	public void Sendlatitude() throws InterruptedException
	{
		js = (JavascriptExecutor)driver2;
		js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",latitude );
	//	Thread.sleep(1000);
		latitude.sendKeys("16.00713500");
	}
	public void Sendlongitude() throws InterruptedException
	{
		js = (JavascriptExecutor)driver2;
		js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",longitude );
	//	Thread.sleep(2000);
		longitude.sendKeys("16.00713500");
	}

	public void ClickonSubmitBtn() throws InterruptedException
	{
		js = (JavascriptExecutor)driver2;
		js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",submit );
		Utility.showCallout("Then It will click on Submit Button", submit);
	//	Thread.sleep(1000);
		submit.click();

	}

	public void SearchAccountName(String ActName) throws InterruptedException
	{
		js = (JavascriptExecutor)driver2;
		js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",AccountFilter );
	//	Thread.sleep(1000);
		Utility.showCallout("Then It will Search Newly Created Account Name", AccountFilter);
		AccountFilter.sendKeys(ActName);
	//	Thread.sleep(1000);
		Utility.showCallout("Then It will Click on Search Btn", Search);
		js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",Search );
		Search.click();

	}
	public void ClickonNextBtn() throws InterruptedException
	{
		js = (JavascriptExecutor)driver2;
		js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",Nextbtn );
	//	Thread.sleep(1000);
		Nextbtn.click();	
	}
	public void ClickonEditBtn() throws InterruptedException
	{
		js = (JavascriptExecutor)driver2;
		js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",Editbtn );
	//	Thread.sleep(1000);
		Editbtn.click();	
		js = (JavascriptExecutor)driver2;
		js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",accountStatus );
	//	Thread.sleep(1000);
		Select s6 = new Select(accountStatus);
		s6.selectByIndex(1);
		js = (JavascriptExecutor)driver2;
		js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",state );
	//	Thread.sleep(1000);
		Select s8 = new Select(state);
		s8.selectByIndex(2);
	}

	public String SendEditEmail2() throws InterruptedException
	{
		js = (JavascriptExecutor)driver2;
		js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",accountname );
	//	Thread.sleep(1000);
		accountname.clear();
	//	Thread.sleep(1000);
		accountname.sendKeys("Edited"+timestamp());
		return ("Edited"+timestamp());
	}

	public void SearchEditedAccountName(String ActName2) throws InterruptedException
	{
		js = (JavascriptExecutor)driver2;
		js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",AccountFilter );
	//	Thread.sleep(1000);
		AccountFilter.sendKeys( ActName2);
	//	Thread.sleep(1000);
		js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",Search );
		Search.click();
	}
	public void ClickonResetBtn() throws InterruptedException
	{
		js = (JavascriptExecutor)driver2;
		js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",Resetbtn );
	//	Thread.sleep(1000);
		Resetbtn.click();

	}
	public String getTextAccountNameField()
	{
		String AccountText=accountname.getAttribute("value");
		return AccountText;
	}

	public void ClickonViewBtn() throws InterruptedException
	{
		js = (JavascriptExecutor)driver2;
		js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",ViewBtn );
	//	Thread.sleep(1000);
		ViewBtn.click();

	}
	public String SearchAccountName2(String ActName) throws InterruptedException
	{
		js = (JavascriptExecutor)driver2;
		js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",AccountFilter );
	//	Thread.sleep(1000);
		AccountFilter.sendKeys(ActName);
	//	Thread.sleep(1000);
		js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",Search );
		Search.click();
		return ActName;
	}

	public void SearchAccountName3(String ActName) throws InterruptedException
	{
		js = (JavascriptExecutor)driver2;
		js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",AccountFilter );
	//	Thread.sleep(1000);
		AccountFilter.sendKeys(ActName);
		Thread.sleep(1000);
	}

	public void SelectCountryType(String CountryName) throws InterruptedException
	{
		js = (JavascriptExecutor)driver2;
		js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",Country );
	//	Thread.sleep(1000);
		Utility.showCallout("Then It will Select Country", Country);
		Select s9 = new Select(Country);
		s9.selectByVisibleText(CountryName);
	}

	public String SelectAccountFilterType(String FilterType) throws InterruptedException
	{
		js = (JavascriptExecutor)driver2;
		js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",AccountFilterType );
	//	Thread.sleep(1000);
		Select s10 = new Select(AccountFilterType);
		s10.selectByVisibleText(FilterType);
		return FilterType;
	}

	public void ClickonSearchBtn() throws InterruptedException
	{
		js = (JavascriptExecutor)driver2;
		js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",Search );
	//	Thread.sleep(1000);
		Search.click();
	}

	public String SelectAccountStatusFilter(String StatusType) throws InterruptedException
	{
		js = (JavascriptExecutor)driver2;
		js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",AccountFilterStatus );
	//	Thread.sleep(1000);
		Select s11 = new Select(AccountFilterStatus);
		s11.selectByVisibleText(StatusType);
		return StatusType;
	}

	public String SelectAccountIndustryFilter(String IndustryFilter2) throws InterruptedException
	{
		js = (JavascriptExecutor)driver2;
		js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",AccountIndustryFilter );
	//	Thread.sleep(1000);
		Select s12 = new Select(AccountIndustryFilter);
		s12.selectByVisibleText(IndustryFilter2);
		return IndustryFilter2;
	}

	public void UploadImage(String imgpath) throws InterruptedException
	{
		js = (JavascriptExecutor)driver2;
		js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",Image );
	//	Thread.sleep(1000);
		Utility.showCallout("it will upload image", Image);
		Image.sendKeys(imgpath);
	}

	public void ClickonClearBtn() throws InterruptedException
	{
		js = (JavascriptExecutor)driver2;
		js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",ClearBtn );
	//	Thread.sleep(1000);
		ClearBtn.click();
	}




}






