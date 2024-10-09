package com.cms.testcases;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
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

public class TeamTest extends BaseTest{
	public SoftAssert sf;
	public static Logger log;
	public static Select s1;
	public static Select s2;
	public static Select s3;
	public static Select s4;
	public static Select s5;
	private String SerchName;
	private String lastName;
	private String token;
	private Actions act;
	private String teamSearched ;
	private String teamId2;

	public static JavascriptExecutor js;
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
		launchUrl();
		Utility.showTooltip("Google FireBase Pop-up open(SSO-Integration.");
	}
	@Test(priority=1)
	public void VerifyAddNewTeamFunctionality() throws IOException, InterruptedException
	{
		try
		{	
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
		Thread.sleep(3000);
		for (Cookie cookie : driverR.manage().getCookies()) {
            System.out.println(cookie.getName() + ": " + cookie.getValue());
        }
		 token = driverR.manage().getCookieNamed("sso_accesstoken").getValue();
		System.out.println(token);
		Set<String> Multi_Id2 = driverR.getWindowHandles();
		Iterator<String> itr2 = Multi_Id2.iterator();
		String parent2 = itr2.next();
		String child2 = itr2.next();
		driverR.switchTo().window(child2);
		Thread.sleep(2000);
		hp.ClickonTeams();
		Thread.sleep(2000);
		tp.ClickonAddnewTeam();
		teamSearched = tp.sendTeamName("Aeis");
		tp.sendProjectName();
		tp.ClickonSubmitBtn();
		Thread.sleep(2000);
		tp.sendSearchTeamName(teamSearched);
		Thread.sleep(2000);
		tp.ClickonsearchBtn();
		Thread.sleep(2000);
		tp.ClickonViewBtn();
		Thread.sleep(1000);
		tp.ClickonAddNewMemberBtn();
		Thread.sleep(1000);
		tp.SendContactName("Aeis- smp-1801");
		Thread.sleep(1000);
		tp.SelectRole();
		Thread.sleep(1000);
		tp.ClickonSubmitBtn();
		Thread.sleep(1000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
	}
	
	
	@Test(priority=2 )
	public void VerifyTeamSearchfunctionality() throws InterruptedException
	{
		hp.ClickonTeams();
		Thread.sleep(1000);
		String Expected2 = tp.sendSearchTeamName("Test Team");
		tp.ClickonsearchBtn();
		Thread.sleep(1000);
		System.out.println(Expected2);
		String Actual2 = driverR.findElement(By.xpath("//td[contains(text(),'"+Expected2+"')]")).getText();
		System.out.println(Expected2);
		SoftAssert sf = new SoftAssert();
		sf.assertEquals(Actual2, Expected2,"Team created verified");
	}
	@Test(priority=3 ,dependsOnMethods="VerifyAddNewTeamFunctionality")
	public void GetTeam() throws InterruptedException
	{
		HashMap data = new HashMap();
		data.put("team_name", teamSearched);
		String projectId = given()
				.contentType("application/json")
				.headers("Authorization",token)
				.body(data)

				.when()
				.get("http://34.131.1.179/api/v1/teams")
				.jsonPath().getString("data");

		Pattern pattern = Pattern.compile("teamId:(\\d+)");

		// Match the pattern against the input string
		Matcher matcher = pattern.matcher(projectId);


		//	      Check if a match is found
		if (matcher.find()) {
			// Extract the value of contact_id
			 teamId2 = matcher.group(1);
			System.out.println("Team ID: " + teamId2);
		} else {
			System.out.println("Team ID not found.");
		}

	}
	
	@Test(priority=4,dependsOnMethods= "GetTeam")
	void DeleteProject()
	{
		HashMap data = new HashMap();
		data.put("teamId",  teamId2);
		System.out.println("found TeamId detail for delete functions : "+teamId2);
		given()
		.contentType("application/json")
		.headers("Authorization",token)
		.body(data)

		.when()
		.post("http://34.131.1.179/api/v1/teams/delete-team")

		.then()
		.statusCode(200)
		.log().all();
		System.out.println("******Created TeamId deletion Functionality is verified************");

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
