package com.cms.testcases;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cms.basetest.BaseTest;
import com.cms.utility.Utility;

public class Account_E2E_Flow extends BaseTest{
	private String SerchName;
	private String lastName;
	private String FName;
	private JavascriptExecutor js;
	private Actions act;
	private String accountId2 ;
	private SoftAssert sf;
	private String token;
	boolean isAccountcreated=false;
//	private WebDriverWait wait;
//	private String ActName;
//	private String AccountType;
//	private String Industry;
//	private String EmailId;
//	private String PhoneNo;
//	private String AddressLine1;
//	private String AddressLine2;
//	private String PostalCode;
//	private String Country;
//	private String State;
//	private String Website;
//	private String City;
//	private String path;
//	 private int rowNo;
//	 private int colNo;
	@BeforeClass
	@Parameters("browser")
	public void openUrl(String browser) throws IOException
	{
		initBrowser(browser);
		creatingObject();	
		Utility.showTooltip("Browser is Launched using Selenium Automation Tool");
	}

	@BeforeMethod
	public void LaunchUrl() throws IOException, InterruptedException
	{
		Thread.sleep(2000);
		launchUrl();
//		path ="C:\\Users\\ATLAS-ADMIN\\Downloads\\Test Sheet - Data (7).csv" ;
//		rowNo = 2;
//		colNo = 0;
//		Utility.showTooltip("then Google FireBase Pop-up open(SSO-Integration) using Automation Script.");
//		Thread.sleep(2000);
//		 ActName= getCellData(path, rowNo, 0);
//		 System.out.println(ActName);
//		 AccountType =getCellData(path, rowNo, 1);
//		 System.out.println(AccountType);
//		 Industry = getCellData(path, rowNo, 2);
//		 System.out.println(Industry);
//		 EmailId = getCellData(path, rowNo, 3);
//		 System.out.println(EmailId);
//		 PhoneNo = getCellData(path, rowNo, 4);
//		 System.out.println(PhoneNo);
//		 AddressLine1 =getCellData(path, rowNo, 6);
//		 System.out.println(AddressLine1);
//		 AddressLine2 = getCellData(path, rowNo, 7);
//		 System.out.println(AddressLine2);
//		 PostalCode =getCellData(path, rowNo, 9);
//		 System.out.println(PostalCode);
//		 Country =getCellData(path, rowNo, 10);
//		 System.out.println(Country);
//		 State =getCellData(path, rowNo, 11);
//		 System.out.println(State);
//		 Website =getCellData(path, rowNo, 5);
//		 System.out.println(Website);
//		 City =getCellData(path, rowNo, 8);
//		 System.out.println(City);
	}
	@Test(priority=1)
	public void VerifyAddNewAccountFunctionality() throws IOException, InterruptedException
	{	
			try {
				
				WebElement GoogleLogin = driverR.findElement(By.xpath("//*[name()='path' and contains(@d,'M215.103 0')]"));
				act = new Actions(driverR);
				act.moveToElement(GoogleLogin).perform();
				act.click().perform();
			Thread.sleep(2000);
			Set<String> Multi_Id = driverR.getWindowHandles();
			Iterator<String> itr = Multi_Id.iterator();
			String parent = itr.next();
			String child = itr.next();
			driverR.switchTo().window(child);
			Thread.sleep(2000);
			driverR.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("test040391@gmail.com");
			Thread.sleep(1000);
			driverR.findElement(By.xpath("//*[contains(text(),\"Next\")]")).click();
			Thread.sleep(3000);
			driverR.findElement(By.xpath("//*[@name=\"Passwd\"]")).sendKeys("A**tk681");
			Thread.sleep(1000);
			driverR.findElement(By.xpath("//*[contains(text(),\"Next\")]")).click();
			Thread.sleep(5000);
//			driverR.findElement(By.xpath("(//div[@class=\"applist\"])[3]")).click();
//			Thread.sleep(5000);
//			String parent2 = driverR.getWindowHandle();
//			System.out.println(parent2);
			driverR.switchTo().window(parent);
			Thread.sleep(2000);
			WebDriverWait wait = new WebDriverWait(driverR,Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"IntelleCustomer\"]")));
			driverR.findElement(By.xpath("//*[text()=\"IntelleCustomer\"]")).click();
			Thread.sleep(3000);
			for (Cookie cookie : driverR.manage().getCookies()) {
	            System.out.println(cookie.getName() + ": " + cookie.getValue());
	        }
			token = driverR.manage().getCookieNamed("sso_accesstoken").getValue();
			System.out.println(token);
			Set<String> Multi_Id2 = driverR.getWindowHandles();
			Iterator<String> itr2 = Multi_Id2.iterator();
			String parent2 = itr2.next();
//			System.out.println(parent2);
			String child2 = itr2.next();
			driverR.switchTo().window(child2);
			Thread.sleep(5000);
			WebElement profile = driverR.findElement(By.xpath("//div[contains(@class,'cursor-pointer relative group')]//div"));
			act = new Actions(driverR);
			act.moveToElement(profile).build().perform();
			String expected_id=driverR.findElement(By.xpath("//span[normalize-space()='test040391@gmail.com']")).getText();
			System.out.println(expected_id);
			String Actual_id ="test040391@gmail.com";
			sf= new SoftAssert();
			sf.assertEquals(Actual_id, expected_id);

//			driverR.findElement(By.xpath("//button[normalize-space()='Admin']")).click();
//		Thread.sleep(1000);
		hp.ClickonActiveAccounts();
		Thread.sleep(3000);
		//		log.info("Active Accounts page opens");
		//	SoftAssertion sf = new softAssertion();
		ap.ClickonAddnewBtn();
				Thread.sleep(2000);		
		//		ap.SendAccountName();
		SerchName=ap.SendAccountName("Aeis-smp");
				Thread.sleep(2000);
		ap.UploadImage("C:\\Users\\ATLAS-ADMIN\\eclipse-workspace\\AEIS-ContactCentre-Project8\\src\\test\\resources\\Images\\AEIS Logo 2023.png");
				Thread.sleep(2000);
		ap.SelectAccountType("Engineer");
				Thread.sleep(2000);
		//		ap.SelectAccountStatus();
		//		Thread.sleep(2000);
		ap.SelectIndustryStatus();
				Thread.sleep(2000);
		ap.SendEmail("Aeis");
				Thread.sleep(2000);
		ap.Sendphone("06122426252");
				Thread.sleep(2000);
		ap.Sendwebsite("www.aeis.com");
				Thread.sleep(2000);
		ap.SendAddress1("F-91,Surajpur");
				Thread.sleep(2000);
		ap.SendAddress2("Greater Noida");
				Thread.sleep(2000);
		ap.SendCity("Noida");
				Thread.sleep(2000);
		ap.SendPostal("201306");
				Thread.sleep(2000);
		ap.SelectCountryType("India");
				Thread.sleep(2000);
		ap.SelectState("Uttar Pradesh");
				Thread.sleep(2000);
		ap.ClickonSubmitBtn();
				Thread.sleep(3000);
		String SuccessfulMsg=driverR.findElement(By.xpath("//div[contains(text(),'Account created successfully.')]")).getText();
		System.out.println(SuccessfulMsg);
		//		sf = new SoftAssert ();
		String Actual1 = SuccessfulMsg;
		String Expected1="Account created successfully.";
		
		sf.assertEquals(Actual1, Expected1);
		isAccountcreated=true;
		System.out.println("************** Add New Account Functionality checked & Verified*************************************");
		//		sf.assertEquals(Actual1, Expected1);
		ap.SearchAccountName(SerchName);
//		WebDriverWait wait = new WebDriverWait(driverR,Duration.ofSeconds(20));
//		wait.until(ExpectedConditions)
					Thread.sleep(2000);
		ap.ClickonViewBtn();
		WebElement Act = driverR.findElement(By.xpath("//h3[contains(text(),'"+SerchName+"')]"));
		js = (JavascriptExecutor)driverR;
		js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",Act );
		//Thread.sleep(2000);
		String ActualActName = driverR.findElement(By.xpath("//h3[contains(text(),'"+SerchName+"')]")).getText();
		//			    String ActualActName = driverR.findElement(By.xpath("//h2[contains(text(),'Metric Consulting')]")).getText();
		System.out.println("Account Name on AccountDetail Page :=>"+ActualActName);
		String ExpectedActName = SerchName ;
		System.out.println("Account Name Searched :=>"+ExpectedActName);
		sf.assertEquals(ActualActName, ExpectedActName);
		System.out.println("************** Acount Name verified on Account Detail page*************************************");
		System.out.println();
		//			    driverR.findElement(By.xpath("//button[normalize-space()='Add New Project']")).click();
		//			    Thread.sleep(2000);
		/*			    pp.ClickonAddnewProject();
				Thread.sleep(1000);

//				String keyword = "Aeis-smp-ac04";
//				for(char letter:keyword.toCharArray())
//				{
//					pp.sendProjectName(Character.toString(letter));
//				}
				pp.sendProjectName("Aeis-smp-p04");
		        Thread.sleep(1000);
//		        WebElement accountOption = driverR.findElement(By.xpath("//li[@class='hover:bg-violet-500 hover:text-white px-1 py-1 cursor-pointer w-full']"));
//		        Actions act = new Actions(driverR);
//		        act.moveToElement(accountOption).click().build().perform();
		        pp.selectStartDate();
		        Thread.sleep(2000);
				pp.sendAddress1("F-91,Surajpur");
				Thread.sleep(1000);
				pp.sendAddress2("Site C ,surajPur");
				Thread.sleep(1000);
				pp.sendCity("Greater Noida");
				Thread.sleep(1000);
				pp.sendPostal("201306");
				Thread.sleep(1000);
				pp.SelectCountryType("India");
				Thread.sleep(1000);
//				pp.selectStatus();
//				Thread.sleep(1000);
				pp.selectState("Uttar Pradesh");
				Thread.sleep(1000);
				pp.ClickonSubmit();
				Thread.sleep(2000);
				String SuccessfulMsg2=driverR.findElement(By.xpath("//div[contains(text(),'Project created successfully.')]")).getText();
				System.out.println(SuccessfulMsg2);
//				sf = new SoftAssert ();
				String Actual2 = SuccessfulMsg;
				String Expected2="Project created successfully.";
				System.out.println("*****************Project created successfully*****************************");
				sf.assertEquals(Actual2, Expected2);
				Thread.sleep(1000);
//				sf.assertEquals(Actual2, Expected2);
				tp.ClickonViewBtn();
				Thread.sleep(1000);
				tp.ClickonAddnewTeam();
				Thread.sleep(1000);
				tp.sendTeamName("Aeis");
				Thread.sleep(1000);
				tp.ClickonSubmitBtn();
				System.out.println("********************New Team added Successfully*****************************");
				Thread.sleep(1000);
//				ap.ClickonViewBtn();
				driverR.findElement(By.xpath("//a[@class='text-violet-600 px-2 font-bold hover:text-violet-900 hover:scale-115 w-12']//*[name()='svg']")).click();
				Thread.sleep(1000);
				driverR.findElement(By.xpath("//button[normalize-space()='Add New Member']")).click();
				Thread.sleep(1000);
				driverR.findElement(By.xpath("//div[@class='form-container']//input[@id='contactFullName']")).sendKeys("Aeis");
				Thread.sleep(1000);
				driverR.findElement(By.xpath("(//ul[contains(@class,'w-full overflow-y-auto')]//li)[1]")).click();
				Thread.sleep(1000);
				WebElement Role = driverR.findElement(By.xpath("//div[@class='form-container']//select[@id='roleId']"));
				Select s1 = new Select(Role);
				s1.selectByIndex(1);
				Thread.sleep(1000);
				tp.ClickonSubmitBtn();
				System.out.println("Team member added successfully");						
		 */
//		WebElement additionalField = driverR.findElement(By.xpath("//select[@id='additionalFieldId']"));
//		Select s9 = new Select(additionalField);
//		s9.selectByIndex(1);
//		driverR.findElement(By.xpath("//input[@id='additionalFieldValue']")).sendKeys("Test");
//		Thread.sleep(1000);
//		driverR.findElement(By.xpath("//button[@class='btn-save']//*[name()='svg']")).click();
//		Thread.sleep(1000);
//		String ActualMsg3 = driverR.findElement(By.xpath("//div[contains(text(),'Additional data updated successfully.')]")).getText();
//		String ExpectMsg3="Additional data updated successfully.";
//		sf.assertEquals(ActualMsg3, ExpectMsg3);

		//    *****Adding Additional Data*******************
		WebElement AddField = driverR.findElement(By.xpath("//select[@id='additionalFieldId']"));
		Select s10 = new Select(AddField);
		s10.selectByIndex(1);
		Thread.sleep(1000);
		driverR.findElement(By.xpath("//input[@id='additionalFieldValue']")).sendKeys("Test");
		Thread.sleep(1000);
		driverR.findElement(By.xpath("//button[contains(@class,'btn-save')]//*[name()='svg']")).click();
		Thread.sleep(3000);
//		WebElement AddFieldAlert = driverR.findElement(By.xpath("//*[contains(text(),'Additional data updated successfully.')]"));

		WebElement AddFieldAlert=driverR.findElement(By.xpath("//div[@role='alert']//div[2]"));
        Utility.ExplicitWait(AddFieldAlert);
		String Actual8=AddFieldAlert.getText();
		System.out.println("Additional Data Alert Msg:-"+Actual8);
		String Expected8 ="Additional data updated successfully.";
//		sf.assertEquals(Actual8, Expected8);

		//    *****Edit Image functionality*******************	
		JavascriptExecutor js3 = (JavascriptExecutor)driverR;
		js3.executeScript("window.scrollBy(0,-1200)", "");
		WebElement editimageBtn = driverR.findElement(By.xpath("//*[@class=\"flex justify-end w-full\"]//div"));
		Actions act = new Actions(driverR);
		act.moveToElement(editimageBtn).build().perform();
		Thread.sleep(1000);
		driverR.findElement(By.xpath("(//div[contains(@class,\"!text-gray-700 text-sm cursor-pointer relative\")])/child::ul//li")).click();
		Thread.sleep(1000);
		driverR.findElement(By.xpath("//input[@id='imageFile']")).sendKeys("C:\\Users\\ATLAS-ADMIN\\eclipse-workspace\\AEIS-ContactCentre-Project8\\src\\test\\resources\\Images\\Testing.jpg");
		Thread.sleep(1000);
		driverR.findElement(By.xpath("//button[normalize-space()='Submit']")).click();
//		Thread.sleep(3000);
//		WebElement MsgAlert = driverR.findElement(By.xpath("//div[contains(text(),'Image uploaded successfully')]"));

		WebElement ImgAlert = driverR.findElement(By.xpath("//div[contains(text(),'Image uploaded successfully')]"));
		Utility.ExplicitWait(ImgAlert);
		String ActualImgSuccess = driverR.findElement(By.xpath("//div[contains(text(),'Image uploaded successfully')]")).getText();
		System.out.println(ActualImgSuccess);
		String ExpectedMsg = "Image uploaded successfully.";
		sf.assertEquals(ActualImgSuccess, ExpectedMsg);
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}  

	@Test(priority=2,dependsOnMethods= "VerifyAddNewAccountFunctionality")
	void GetAccount()
	{
		if(isAccountcreated==true)
		{
		HashMap data = new HashMap();
		data.put("account_name", SerchName);
		String accountId = given()
				.contentType("application/json")
				.headers("Authorization",token)
				.body(data)

				.when()
				.get("http://34.131.1.179/api/v1/accounts")
				.jsonPath().getString("data");

		Pattern pattern = Pattern.compile("accountId:(\\d+)");

		// Match the pattern against the input string
		Matcher matcher = pattern.matcher(accountId);


		//	      Check if a match is found
		if (matcher.find()) {
			// Extract the value of contact_id
			accountId2 = matcher.group(1);
			System.out.println("account ID: " + accountId2);
		} else {
			System.out.println("account ID not found.");
		}
		}
		else
		{
			System.out.println("Account Not Found");
		}

	}
	
	@Test(priority=3,dependsOnMethods= "GetAccount")
	void DeleteContact()
	{

		HashMap data = new HashMap();
		data.put("accountId",  accountId2);
		System.out.println("found accountId detail for delete functions : "+accountId2);
		given()
		.contentType("application/json")
		.headers("Authorization",token)
		.body(data)

		.when()
		.post("http://34.131.1.179/api/v1/accounts/delete-account")

		.then()
		.statusCode(200)
		.log().all();
		System.out.println("******Created Account deletion Functionality is verified************");
		

	}
	//@Test(priority=4)
	public void SearchCreatedAccount2() throws InterruptedException
	{
		driverR.findElement(By.xpath("//*[text()=\"IntelleCustomer\"]")).click();
		Thread.sleep(3000);
		ap.SearchAccountName(SerchName);
		Thread.sleep(1000);
		//		ap.ClickonViewBtn();
		//		 WebElement Act = driverR.findElement(By.xpath("//h2[contains(text(),'"+SerchName+"')]"));
		//		 JavascriptExecutor js = (JavascriptExecutor)driverR;
		//			js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",Act );
		//			Thread.sleep(2000);
		//		    
		//		    String ActualActName = driverR.findElement(By.xpath("//h2[contains(text(),'"+SerchName+"')]")).getText();
		////		    String ActualActName = driverR.findElement(By.xpath("//h2[contains(text(),'Metric Consulting')]")).getText();
		//		    System.out.println("Account Name on AccountDetail Page :=>"+ActualActName);
		//		    String ExpectedActName = SerchName ;
		//		    System.out.println("Account Name Searched :=>"+ExpectedActName);
		//		    Assert.assertEquals(ActualActName, ExpectedActName);
		//		    System.out.println("************** Acount Name verified on Account Detail page*************************************");
		//		    System.out.println();
		String Actual1=driverR.findElement(By.xpath("//td[@class='td-not-found']")).getText();
//		System.out.println(Actual1);
		System.out.println(Actual1);
		String Expected1="Record not found.";
		sf.assertEquals(Actual1, Expected1);
	}
	
	@Test(priority=5)
    public void AllValidationCheck()
    {
		sf.assertAll();
    }
	@AfterMethod
	public void closeURL()
	{
		driverR.navigate().to("about:blank");
	}
	@AfterClass
	public void closebrowser()
	{
		
		teardown();
	}

}
