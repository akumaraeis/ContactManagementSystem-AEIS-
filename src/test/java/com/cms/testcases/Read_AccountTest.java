package com.cms.testcases;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cms.basetest.BaseTest;

public class Read_AccountTest extends BaseTest{

	public SoftAssert sf;
	public static Logger log;
	public static Select s1;
	public static Select s2;
	public static Select s3;
	public static Select s4;
	public static Select s5;
	private String SerchName;

	public static JavascriptExecutor js;

	@BeforeClass

	public void openUrl() throws IOException
	{
		initBrowser("Local");
		creatingObject();	 
	}

	@BeforeMethod

	public void LaunchUrl() throws IOException, InterruptedException
	{

		launchUrl();
	}

	@Test(priority=1)
	public void VerifyAddNewAccountFunctionality() throws IOException, InterruptedException
	{
		int flag=0;

		//		log.info("ChromeBrowser is launched");
		Thread.sleep(2000);
		//		log.info("URL Is Launched");
		hp.ClickonActiveAccounts();
		Thread.sleep(3000);
		int rowno = driverR.findElements(By.xpath("//*[@class=\"card-body\"]/table/tbody/tr")).size();
		System.out.println(rowno);
		int colno = driverR.findElements(By.xpath("//*[@class=\"card-body\"]/table/tbody/tr[1]/td")).size();
		System.out.println(colno);

		for ( int r=1; r<=rowno ; r++)
		{			
		//		String data=driverR.findElement(By.xpath("//*[@class=\"card-body\"]/table/tbody/tr["+r+"]/td[2]")).getText();
		//		System.out.print(data);
		//	System.out.println();
						String data1=driverR.findElement(By.xpath("//*[@class=\"card-body\"]/table/tbody/tr["+r+"]/td[2]")).getText();
						System.out.println(data1);
						String data2=driverR.findElement(By.xpath("//*[@class=\"card-body\"]/table/tbody/tr["+(r+1)+"]/td[2]")).getText();
						
						if(data1==data2)
						{
							flag++;
							
							if (flag>0)
							{
								System.out.println("Duplicate account available");
							}
						}
						
		}
		
	

		WebElement nextBtn = driverR.findElement(By.xpath("//li[normalize-space()='Next']"));
		String nextAttr = nextBtn.getAttribute("class");


		while(!nextAttr.contains("disable"))
		{
			ap.ClickonNextBtn();
			Thread.sleep(2000);
			int rowno1 = driverR.findElements(By.xpath("//*[@class=\"card-body\"]/table/tbody/tr")).size();
			int colno2 = driverR.findElements(By.xpath("//*[@class=\"card-body\"]/table/tbody/tr[1]/td")).size();			
			for ( int r=1; r<=rowno1 ; r++)
			{
				for(int j=r+1;j<=rowno1 ;j++)
				{
					String data1=driverR.findElement(By.xpath("//*[@class=\"card-body\"]/table/tbody/tr["+r+"]/td[2]")).getText();
					String data2=driverR.findElement(By.xpath("//*[@class=\"card-body\"]/table/tbody/tr["+j+"]/td[2]")).getText();
					
					if(data1==data2)
					{
						
						flag++;
					}
				//	System.out.print(data);
				System.out.println();
				}
					
			}
			
			
			nextBtn = driverR.findElement(By.xpath("//li[normalize-space()='Next']"));
			nextAttr = nextBtn.getAttribute("class");
			JavascriptExecutor js = (JavascriptExecutor)driverR;
			js.executeScript("window.scrollBy(0,1200)");
			ap.ClickonNextBtn();


		}

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
	//	

}



