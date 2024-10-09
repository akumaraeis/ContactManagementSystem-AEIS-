package com.cms.testcases;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

public class AssetsTest extends BaseTest {
	private SoftAssert sf;
	private String token;
	private Actions act;
	private String SearchAsset;
	private String assetId2;

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
	public void VerifyAddAssetFunctionality() throws IOException, InterruptedException
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
			driverR.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("akumar@aeis.com");
			Thread.sleep(1000);
			driverR.findElement(By.xpath("//*[contains(text(),\"Next\")]")).click();
			Thread.sleep(3000);
			driverR.findElement(By.xpath("//*[@name=\"Passwd\"]")).sendKeys("A425534k@");
			Thread.sleep(1000);
			driverR.findElement(By.xpath("//*[contains(text(),\"Next\")]")).click();
			Thread.sleep(5000);
			//		driverR.findElement(By.xpath("(//div[@class=\"applist\"])[3]")).click();
			//		Thread.sleep(5000);
			//		String parent2 = driverR.getWindowHandle();
			//		System.out.println(parent2);
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
			asp.ClickonSetting();
			Thread.sleep(3000);
			asp.ClickonAssets();
			Thread.sleep(3000);
			asp.ClickonAddnewassets();
			Thread.sleep(1000);
		    SearchAsset = asp.sendAssetsName("Test");
		    Thread.sleep(1000);
		    asp.sendAssetsQuantity("02");
		    Thread.sleep(1000);
		    asp.sendAssetsDescript("Test");
		    Thread.sleep(1000);
		    asp.ClickonSubmitBtn();
		    Thread.sleep(3000);
//			String Expected=asp.sendSearchAssetsName(assets);
//			Thread.sleep(1000);
//			String Actual = driverR.findElement(By.xpath("//*[contains(text(),'"+assets+"'")).getText();
//			System.out.println(Actual);
//			Assert.assertEquals(Actual, Expected);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@Test(priority=2,dependsOnMethods= "VerifyAddAssetFunctionality")

	void GetAssetList()
	{
		HashMap data = new HashMap();
		data.put("asset_name", SearchAsset);
		String AssetId = given()
				.contentType("application/json")
				.headers("Authorization",token)
				.body(data)

				.when()
				.get("http://34.131.1.179/api/v1/assets")
				.jsonPath().getString("data");

		Pattern pattern = Pattern.compile("contactId:(\\d+)");

		// Match the pattern against the input string
		Matcher matcher = pattern.matcher(AssetId);


		//      Check if a match is found
		if (matcher.find()) {
			// Extract the value of contact_id
			assetId2 = matcher.group(1);
			System.out.println("Asset ID: " + assetId2);
		} else {
			System.out.println("Asset ID not found.");
		}
	}
	@Test(priority=3,dependsOnMethods= {"GetAssetList"})
	void DeleteContact()
	{
		HashMap data = new HashMap();
		data.put("assetId",  assetId2);

		System.out.println("found ContactId detail for edit functions : "+assetId2);
		given()
		.contentType("application/json")
		.headers("Authorization",token)
		.body(data)

		.when()
		.post("http://34.131.1.179/api/v1/assets/delete-asset")

		.then()
		.statusCode(200)
		.log().all();
		System.out.println("******Created Contact deletion Functionality is verified************");		
	}
	@Test(priority=4 , dependsOnMethods="VerifyAddAssetFunctionality")
	public void SearchCreatedContact2() throws InterruptedException
	{
		asp.ClickonAssets();
		Thread.sleep(2000);
		asp.sendSearchAssetsName(SearchAsset);
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
