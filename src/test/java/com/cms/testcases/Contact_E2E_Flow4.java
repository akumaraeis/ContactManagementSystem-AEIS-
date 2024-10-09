package com.cms.testcases;
import org.openqa.selenium.Cookie;

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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
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

public class Contact_E2E_Flow4 extends BaseTest{
	private String SerchName;
	private String lastName;
	private String FName;
	private JavascriptExecutor js;
	private Actions act;
	private String emailId;
	private String contactId2;
	private String token;
	private SoftAssert sf;
	boolean isContactCreated = false;
	
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
		Utility.showTooltip("then Google FireBase Pop-up open(SSO-Integration) using Automation Script.");
		Thread.sleep(2000);
		 
	}
	@Test(priority=1)
	public void VerifyAddNewContactFunctionality() throws IOException, InterruptedException
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
			driverR.switchTo().window(parent);
			Thread.sleep(2000);
			WebDriverWait wait = new WebDriverWait(driverR,Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"IntelleCustomer\"]")));
			driverR.findElement(By.xpath("//*[text()=\"IntelleCustomer\"]")).click();
			Utility.showTooltip("Now Contact Management Application open using Automation Script.");
			Thread.sleep(3000);
			for (Cookie cookie : driverR.manage().getCookies()) {
				System.out.println(cookie.getName() + ": " + cookie.getValue());
			}
			token = driverR.manage().getCookieNamed("sso_accesstoken").getValue();
			System.out.println(token);
			Set<String> Multi_Id2 = driverR.getWindowHandles();
			Iterator<String> itr2 = Multi_Id2.iterator();
			String parent2 = itr2.next();
			//		System.out.println(parent2);
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

			cp.ClickonActiveContact();
			cp.ClickonAddnewBtn();			
			FName = cp.SendFirstName("Aeis-");			
			lastName = cp.SendLastName("Smp");
			cp.SelectContactType("Engineer");
			emailId = cp.SendEmail("aeis");
			cp.SendContactphone();
			cp.UploadImage();
			cp.SelectContactStatus("Active");
			cp.ClickonSubmitBtn();
			String ActualMsg = cp.ValidateContactCreation();
			System.out.println(ActualMsg);
			String Expected ="Contact created successfully.";

			sf.assertEquals(ActualMsg, Expected);
			System.out.println("********Contact Created Successfully*******");
			Thread.sleep(2000);
			isContactCreated=true;
			//********************************************************************************************						
			cp.SearchContactName(FName+" "+lastName);
			String Actual2 = driverR.findElement(By.xpath("//span[@class='font-semibold pb-1 text-left']")).getText();
			System.out.println(Actual2);
			String Expected2 = FName+" "+lastName;
			System.out.println(Expected);
			sf.assertEquals(Actual2, Expected2);
			cp.ClickonContactView();
			Thread.sleep(2000);
			String Actual3=driverR.findElement(By.xpath("//h3[contains(normalize-space(),'"+FName+"')]")).getText();
			String Expected3=FName+" "+lastName;
			sf.assertEquals(Actual3, Expected3,"Contact created is verified on searching same contact");
			System.out.println("*******Created Contact Searched Successfully*******");
			Thread.sleep(2000);
			cp.ClickonCertBtn();
			Thread.sleep(2000);
			cp.SendCertification();
			//		    driverR.findElement(By.xpath("//li[contains(@class,'hover:bg-violet-500 hover:text-white px-1 py-1 cursor-pointer w-full')]")).click();			
			cp.SendCertificateNumber();
			cp.SendCertificationDate();
			cp.SendCertificationExpiryDate();
			cp.ClickonSubmit();
			Thread.sleep(3000);
			Utility.showTooltip("Certification is added successfully using Automation Script");
			String Actual4 = driverR.findElement(By.xpath(" //div[contains(text(),'Certification created successfully.')]")).getText();
			String Expected4 = "Certification created successfully.";
			sf.assertEquals(Actual4, Expected4);
			System.out.println("*******Certification added Successfully*******");
//			boolean Certificate = driverR.findElement(By.xpath("//*[contains(@class,\"flex flex-col h-ful w-full !max-h-96 min-w-max overflow\")]")).isDisplayed();
//			System.out.println(Certificate);
//			sf.assertTrue(Certificate);

			cp.ClickonQualificationBtn();
			cp.SelectQualificationText();
			cp.SendQualificationDate();
			cp.SendQualificationCompleteDate();
			cp.ClickonSubmit();
			Thread.sleep(3000);
			Utility.showTooltip("Qualification Details added Successfully");
			String Actual5 = driverR.findElement(By.xpath("//div[contains(text(),'Qualification created successfully.')]")).getText();
			System.out.println(Actual5);
			String Expected5 = "Qualification created successfully.";
			sf.assertEquals(Actual5, Expected5);
			System.out.println("*******Qualification added Successfully*******");
			boolean Qualification = driverR.findElement(By.xpath("//*[contains(@class,\"p-4 flex flex-col h-full min-h-20 !max-h-96 !overflow\")]")).isDisplayed();
			System.out.println(Qualification);
			sf.assertTrue(Qualification);

			cp.ClickonCommunicationBtn();
			cp.SelectCommunication();
			cp.SendChannelValue();
			cp.SelectChannelPrefer();
			cp.ClickonSubmit();
			Thread.sleep(3000);
			String Actual6 = driverR.findElement(By.xpath("//div[contains(text(),'Communication Channel created successfully.')]")).getText();
			System.out.println(Actual6);
			String Expected6 = "Communication Channel created successfully.";
			sf.assertEquals(Actual6, Expected6);
			System.out.println("*******Communication created Successfully*******");	
			boolean commChannel = driverR.findElement(By.xpath("//*[contains(@class,\"p-4 flex flex-row w-full overflow\")]")).isDisplayed();
			System.out.println(commChannel);
			sf.assertTrue(commChannel);
			Utility.showTooltip("Communication Channel added Successfully");

			cp.ClickonAddressBtn();
			cp.SelectAddressType();
			cp.SendAddress1();
			cp.SendAddress2();
			cp.SendCity();
			cp.SendPostalCode();
			cp.SelectCountry();
			cp.SelectState() ;
			cp.ClickonSubmit();	
			Thread.sleep(3000);
			WebElement AddAlert = driverR.findElement(By.xpath("//div[contains(text(),'Address created successfully.')]"));
			Utility.ExplicitWait(AddAlert);
			String Actual8 = driverR.findElement(By.xpath("//div[contains(text(),'Address created successfully.')]")).getText();
			String Expected8 = "Address created successfully.";
			System.out.println("*******Address created Successfully*******");
			sf.assertEquals(Actual8, Expected8, "Address created verified");
			JavascriptExecutor js2 = (JavascriptExecutor)driverR;
			js2.executeScript("window.scrollBy(0,1200)","");
			Thread.sleep(2000);

			cp.ClickonAssetsAllocation();
			cp.SendAssetName();
			cp.SendInputField();
			cp.SendAllocationDate();
			cp.ClickonSubmit();
			Thread.sleep(3000);
			String Actual9 = driverR.findElement(By.xpath("//div[contains(text(),'Asset allocated successfully.')]")).getText();
			String Expected9 = "Asset allocated successfully.";
			sf.assertEquals(Actual9, Expected9);
			System.out.println("*******Asset allocated successfully*******");


			//**********Adding Additional Detail*******************
			cp.SendAdditionalDetail();
			cp.SendAdditionalFieldValue();		
			driverR.findElement(By.xpath("//button[contains(@class,'btn-save')]//*[name()='svg']")).click();
			Thread.sleep(3000);
			WebDriverWait wait2 = new WebDriverWait(driverR,Duration.ofSeconds(20));
			wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Additional data updated successfully.')]")));
			String ActualSuccessMsg=driverR.findElement(By.xpath("//div[contains(text(),'Additional data updated successfully.')]")).getText();
			String ExpectedSuccessMsg ="Additional data updated successfully.";
			sf.assertEquals(ActualSuccessMsg, ExpectedSuccessMsg);

			//****************************Edit Image Functionality******************
			cp.editImage();
			cp.ClickonSubmit();
			Thread.sleep(3000);
			String ActualImgSuccess = driverR.findElement(By.xpath("//div[contains(text(),'Image uploaded successfully.')]")).getText();
			System.out.println(ActualImgSuccess);
			String ExpectedMsg = "Image uploaded successfully.";
			sf.assertEquals(ActualImgSuccess, ExpectedMsg);
	        
		}

		catch (Exception e)
		{
			e.printStackTrace();			
		}
	} 
	
	@Test(priority=2,dependsOnMethods= "VerifyAddNewContactFunctionality")
	void GetContact()
	{
		if(isContactCreated==true)
		{
		HashMap data = new HashMap();
		data.put("email", emailId );
		String ContactId = given()
				.contentType("application/json")
				.headers("Authorization",token)
				.body(data)

				.when()
				.get("http://34.131.1.179/api/v1/contacts")
				.jsonPath().getString("data");

		Pattern pattern = Pattern.compile("contactId:(\\d+)");

		// Match the pattern against the input string
		Matcher matcher = pattern.matcher(ContactId);


		//      Check if a match is found
		if (matcher.find()) {
			// Extract the value of contact_id
			contactId2 = matcher.group(1);
			System.out.println("Contact ID: " + contactId2);
		} else {
			System.out.println("Contact ID not found.");
		}
		}
		else
		{
			System.out.println("Contact Not Found");
		}
		
		}
	
		
 @Test(priority=3,dependsOnMethods= {"GetContact"})
	void DeleteContact()
	{
		HashMap data = new HashMap();
		data.put("contactId",  contactId2);

		System.out.println("found ContactId detail for edit functions : "+contactId2);
		given()
		.contentType("application/json")
		.headers("Authorization",token)
		.body(data)

		.when()
		.post("http://34.131.1.179/api/v1/contacts/delete-contact")

		.then()
		.statusCode(200)
		.log().all();
		System.out.println("******Created Contact deletion Functionality is verified************");	
		
	 }
	

//	@Test(priority=4 , dependsOnMethods="VerifyAddNewContactFunctionality")
	public void SearchCreatedContact2() throws InterruptedException
	{
		driverR.findElement(By.xpath("//*[text()=\"IntelleCustomer\"]")).click();
		Thread.sleep(3000);
		cp.ClickonActiveContact();
		Thread.sleep(1000);
		cp.SearchContactName(FName+" "+lastName);
		Thread.sleep(1000);
		String Actual1=driverR.findElement(By.xpath("//td[@class='td-not-found']")).getText();
		String Expected1="Record not found.";
//		sf.assertEquals(Actual1, Expected1);
		
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
		//	driverR.close();
	}
	@AfterClass
	public void closebrowser()
	{

		teardown();
	}

}
