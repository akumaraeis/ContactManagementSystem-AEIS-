package com.cms.testcases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cms.basetest.BaseTest;

public class E2ETest extends BaseTest{
	
	public String ActName ="Metric Consulting";
	public String ActualPrCount;
	public JavascriptExecutor js;
	
@BeforeClass
	public void openUrl() throws IOException
	{
	
	
		
//		initBrowser(br);
	//	initBrowser(Machine);
	initBrowser("Local");
//		log = LogManager.getLogger(HomeTest.class);
//		log.info("Browser is launched");
		creatingObject();	 
	}
	
@BeforeMethod
public void LaunchUrl() throws IOException, InterruptedException
{
	
	launchUrl();
}


	@Test(priority=1)
	public void VerifyAccountDetail() throws IOException, InterruptedException
	{
		System.out.println("--------------TestCase 1->Verfiy The Account Name ---------------------------------------");
	hp.ClickonActiveAccounts();
	Thread.sleep(2000);
    String SearchAcName = ap.SearchAccountName2(ActName);
    Thread.sleep(2000);
    ap.ClickonViewBtn();
    Thread.sleep(2000);
    WebElement Act = driverR.findElement(By.xpath("//h2[contains(text(),'"+ActName+"')]"));
    js = (JavascriptExecutor)driverR;
	js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",Act );
	Thread.sleep(2000);
    
    String ActualActName = driverR.findElement(By.xpath("//h2[contains(text(),'"+ActName+"')]")).getText();
//    String ActualActName = driverR.findElement(By.xpath("//h2[contains(text(),'Metric Consulting')]")).getText();
    System.out.println("Account Name on AccountDetail Page :=>"+ActualActName);
    String ExpectedActName = SearchAcName ;
    System.out.println("Account Name Searched :=>"+ExpectedActName);
    Assert.assertEquals(ActualActName, ExpectedActName);
    System.out.println("************** Acount Name verified on Account Detail page*************************************");
    System.out.println();
	}
	
	@Test(priority=2,dependsOnMethods={"VerifyAccountDetail"})
    public void verifyRunningProject() throws InterruptedException, IOException
    {
		System.out.println("--------------TestCase 2->Verfiy The Project Details with count ---------------------------------------");
		WebElement prcnt = driverR.findElement(By.xpath("//p[normalize-space()='1']"));
		js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",prcnt );
		Thread.sleep(2000);
    ActualPrCount = driverR.findElement(By.xpath("//p[normalize-space()='1']")).getText();
    System.out.println("Running Project Count on Top :=>"+ActualPrCount);
    WebElement prlcnt = driverR.findElement(By.xpath("//div[@class='card-body']//table//tbody//tr[1]"));
    js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",prlcnt );
    Thread.sleep(2000);
    int ExpectedProjectList = driverR.findElements(By.xpath("//div[@class='card-body']//table//tbody//tr")).size();
    System.out.println("Project Count on Running Project List :=>"+ExpectedProjectList);
    String ExpectedPrCount = String.valueOf(ExpectedProjectList);
    Assert.assertEquals(ActualPrCount, ExpectedPrCount);
    System.out.println("************** Project Count on top with count on project List is verified*********************");
    Thread.sleep(2000);
    System.out.println();
    }
	
	@Test(priority=3,dependsOnMethods={"verifyRunningProject"})
    public void VerifyTeamsDetail() throws InterruptedException
    {
		System.out.println("--------------TestCase 3->Verfiy The Team detail with Count ---------------------------------------");
    ap.ClickonViewBtn();
    Thread.sleep(2000);
    WebElement tmc = driverR.findElement(By.xpath("//*[@class=\"card-body stats\"]//p"));
    js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",tmc );
    WebElement tmlc = driverR.findElement(By.xpath("//*[@class=\"card-body stats\"]//p"));
    js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",tmlc );
    String ActualTmCount = driverR.findElement(By.xpath("//*[@class=\"card-body stats\"]//p")).getText();
    System.out.println("Teams Count for this project on Top :=>"+ActualTmCount);
    int TeamList=driverR.findElements(By.xpath("//div[@class='card-body']//table//tbody//tr")).size();
    System.out.println("List Count in Team List :=>"+TeamList);
    String ExpectedTmCount = String.valueOf(TeamList);
    Assert.assertEquals(ActualTmCount, ExpectedTmCount);
    System.out.println("************** Team Count on top with count on Team List is verified*************************************");
    Thread.sleep(2000);
    System.out.println();
    }
    
	
	@Test(priority=4 )
    public void VerifyTeamMember() throws InterruptedException, IOException 
    {

		VerifyAccountDetail();
		verifyRunningProject();
		VerifyTeamsDetail();
		
		System.out.println("--------------TestCase4-Verfiy The TeamMember Count & Detail----------------------------");
    ap.ClickonViewBtn();
    WebElement ac4 = driverR.findElement(By.xpath("//span[normalize-space()='Account Name:']"));
    js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",ac4 );
    String ActualAccName = driverR.findElement(By.xpath("//span[@title='Metric Consulting']")).getText();
    String ExactAccName = ActName;
    Assert.assertEquals(ActualAccName, ExactAccName);
    WebElement pr4 = driverR.findElement(By.xpath("//span[normalize-space()='Project Name:']"));
    js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",pr4 );
    String ActualPrjName=driverR.findElement(By.xpath("//span[@title='Call Out Rates']")).getText();
    String ExpPrjName= ActualPrCount;
    Thread.sleep(2000);
    String ActualMemCount = driverR.findElement(By.xpath("//*[@class=\"card-body stats\"]//p")).getText();
    System.out.println("Teams Member Count for this project on Top :=>"+ActualMemCount);
    int MemberList=driverR.findElements(By.xpath("//div[@class='card-body']//table//tbody//tr")).size();
    System.out.println("List Count in Team member List :=>"+MemberList);
    String ExpectedMemCount = String.valueOf(MemberList);
    Assert.assertEquals(ActualMemCount, ExpectedMemCount);
    System.out.println("************** Team Member Count on top with count on Team Member List is verified*************************************");
    Thread.sleep(2000);
    driverR.findElement(By.xpath("//button[normalize-space()='View']")).click();
    String TmNameonPopup = driverR.findElement(By.xpath("(//div[@role='dialog']//div//p)[1]")).getText();
    System.out.println(TmNameonPopup);
    String TmNameonDetail = driverR.findElement(By.xpath("//h2[normalize-space()='Team Name: METC/METC-0001']")).getText();
    System.out.println(TmNameonDetail);
    Assert.assertEquals(TmNameonDetail, TmNameonPopup);
    String ContNameonList = driverR.findElement(By.xpath("//span[@class='font-semibold pb-1 text-left']")).getText();
    System.out.println(ContNameonList);
    String ContNameonPopup = driverR.findElement(By.xpath("")).getText();
    System.out.println(ContNameonPopup);
    }
    
    
    
	
   
	
//	
//	@AfterMethod
//	public void closeURL()
//	{
//		driverR.navigate().to("about:blank");
//	}
//	
//		
		



	@AfterClass
	public void closebrowser()
	{
		teardown();
	}
}
	
	


