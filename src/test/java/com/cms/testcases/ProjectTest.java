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
import org.openqa.selenium.interactions.Action;
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

public class ProjectTest extends BaseTest{


	public SoftAssert sf;
	public static Logger log;
	public static Select s1;
	public static Select s2;
	public static Select s3;
	public static Select s4;
	public static Select s5;
	private String SerchName;
	private  String lastName;
	private  String  SearchProjectName;
	public static JavascriptExecutor js;
	private String token;
	private Actions act;
	private  String projectId2;
	private String teamSearched;
	private String teamId2;
	private boolean isTeamCreated =false;
	
	
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
	public void VerifyAddNewProjectFunctionality() throws IOException, InterruptedException
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
			//		driverR.findElement(By.xpath("(//div[@class=\"applist\"])[3]")).click();
			//		Thread.sleep(5000);
			//		String parent2 = driverR.getWindowHandle();
			//		System.out.println(parent2);
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
			//		System.out.println(parent2);
			String child2 = itr2.next();
			driverR.switchTo().window(child2);
			Thread.sleep(2000);
			try
			{	
			hp.ClickonRunningProjects();
			Thread.sleep(2000);
			pp.ClickonAddnewProject();
			Thread.sleep(1000);
			SearchProjectName = pp.sendProjectName("Aeis");
			Thread.sleep(1000);
			pp.sendAccountName("Aeis-smp");
			Thread.sleep(1000);
			//        WebElement accountOption = driverR.findElement(By.xpath("//li[@class='hover:bg-violet-500 hover:text-white px-1 py-1 cursor-pointer w-full']"));
			//        Actions act = new Actions(driverR);
			//        act.moveToElement(accountOption).click().build().perform();
			pp.selectStartDate();
			Thread.sleep(2000);
			pp.sendAddress1("F-91 ,SurajPur");
			Thread.sleep(1000);
			pp.sendAddress2("Site C");
			Thread.sleep(1000);
			pp.sendCity("greater Noida");
			Thread.sleep(1000);
			pp.sendPostal("201306");
			Thread.sleep(1000);
			pp.SelectCountryType("India");
			Thread.sleep(1000);
			//		pp.selectStatus();
			//		Thread.sleep(1000);
			pp.selectState("Uttar Pradesh");
			Thread.sleep(1000);
			pp.ClickonSubmit();
			Thread.sleep(1000);
			pp.sendProjectToSearch(SearchProjectName);
			Thread.sleep(1000);
			pp.ClickonSearch();
			pp.ClickonViewBtn();
			Thread.sleep(2000);
			pp.ClickOnAddNewTeamBtn();
			Thread.sleep(1000);
			teamSearched = tp.sendTeamName("aeis");
			Thread.sleep(1000);
			isTeamCreated=true;
			tp.ClickonSubmitBtn();
			Thread.sleep(1000);
			WebElement AddField = driverR.findElement(By.xpath("//select[@id='additionalFieldId']"));
			Select s10 = new Select(AddField);
			s10.selectByVisibleText("Office_address");
			Thread.sleep(1000);
			driverR.findElement(By.xpath("//input[@id='additionalFieldValue']")).sendKeys("Test");
			Thread.sleep(1000);
			driverR.findElement(By.xpath("//button[contains(@class,'btn-save')]//*[name()='svg']")).click();
			Thread.sleep(3000);
			WebDriverWait wait2 = new WebDriverWait(driverR,Duration.ofSeconds(20));
			wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Additional data updated successfully.')]")));
			String ActualSuccessMsg=driverR.findElement(By.xpath("//div[contains(text(),'Additional data updated successfully.')]")).getText();
			String ExpectedSuccessMsg ="Additional data updated successfully.";
			sf = new SoftAssert();
			sf.assertEquals(ActualSuccessMsg, ExpectedSuccessMsg);

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
//	@Test(priority=2 ,dependsOnMethods= "VerifyAddNewProjectFunctionality" )
	public void VerifySearchProjectFunctionality() throws InterruptedException
	{
		try {
			//			WebDriverWait wait = new WebDriverWait(driverR,Duration.ofSeconds(20));
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"IntelleCustomer\"]")));
			driverR.findElement(By.xpath("//*[text()=\"IntelleCustomer\"]")).click();
			Thread.sleep(2000);
			hp.ClickonRunningProjects();
			Thread.sleep(2000);
			Thread.sleep(2000);
			String Expected2 =pp.sendProjectToSearch(SearchProjectName);
			System.out.println(Expected2);
			Thread.sleep(1000);
			pp.selectProjectStatus("Active");
			Thread.sleep(1000);
			pp.ClickonSearch();
			Thread.sleep(2000);
			String Actual2 = driverR.findElement(By.xpath("//td[contains(text(),'"+Expected2+"')]")).getText();
			System.out.println(Actual2);
			sf.assertEquals(Actual2, Expected2);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test(priority=3 ,dependsOnMethods="VerifyAddNewProjectFunctionality")
	public void GetProject() throws InterruptedException
	{
		HashMap data = new HashMap();
		data.put("project_name", SearchProjectName);
		String projectId = given()
				.contentType("application/json")
				.headers("Authorization",token)
				.body(data)

				.when()
				.get("http://34.131.1.179/api/v1/projects")
				.jsonPath().getString("data");

		Pattern pattern = Pattern.compile("projectId:(\\d+)");

		// Match the pattern against the input string
		Matcher matcher = pattern.matcher(projectId);


		//	      Check if a match is found
		if (matcher.find()) {
			// Extract the value of contact_id
			projectId2 = matcher.group(1);
			System.out.println("project ID: " + projectId2);
		} else {
			System.out.println("project ID not found.");
		}

	}
	@Test(priority=4,dependsOnMethods= "GetProject")

	void DeleteProject()
	{
		HashMap data = new HashMap();
		data.put("projectId",  projectId2);
		System.out.println("found projectId detail for delete functions : "+projectId2);
		given()
		.contentType("application/json")
		.headers("Authorization",token)
		.body(data)

		.when()
		.post("http://34.131.1.179/api/v1/projects/delete-project")

		.then()
		.statusCode(200)
		.log().all();
		System.out.println("******Created projectId deletion Functionality is verified************");

	}
	@Test(priority=5 ,dependsOnMethods="VerifyAddNewProjectFunctionality")
	public void GetTeam() throws InterruptedException
	{
		if(isTeamCreated==true)
		{
		HashMap data = new HashMap();
		data.put("team_name", teamSearched);
		String teamId = given()
				.contentType("application/json")
				.headers("Authorization",token)
				.body(data)

				.when()
				.get("http://34.131.1.179/api/v1/teams")
				.jsonPath().getString("data");

		Pattern pattern = Pattern.compile("teamId:(\\d+)");

		// Match the pattern against the input string
		Matcher matcher = pattern.matcher(teamId);


		//	      Check if a match is found
		if (matcher.find()) {
			// Extract the value of contact_id
			 teamId2 = matcher.group(1);
			System.out.println("Team ID: " + teamId2);
		} else {
			System.out.println("Team ID not found.");
		}
		}
		else
		{
			System.out.println("Team not created");
		}

	}
	
	@Test(priority=6,dependsOnMethods= "GetTeam")
	void DeleteTeam()
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
	@Test(priority=7)
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


