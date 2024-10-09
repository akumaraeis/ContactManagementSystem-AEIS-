package com.cms.basetest;



import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.cms.listener.Listener;
import com.cms.pageObjects.AccountPage;
import com.cms.pageObjects.AssetsPage;
import com.cms.pageObjects.ContactPage;
import com.cms.pageObjects.HomePage;
import com.cms.pageObjects.ProjectPage;
import com.cms.pageObjects.TeamPage;
import com.cms.utility.ReadConfig;



public class BaseTest{
	
	// public ReadConfig rc;
	
	

	public static RemoteWebDriver driverR;
//	public static WebDriver driverR;
//    public String baseurl = rc.getApplicationURL();
    public static  WebDriver driverL;
    public HomePage hp ;
    public AccountPage ap;
    public ContactPage cp;
    public ProjectPage pp;
    public TeamPage tp;
    public AssetsPage asp;
    
	
		//****To Run Code in Virtual Cloud Machine.
	public void initBrowser(String Browsername ) throws IOException
	{
		 
	switch(Browsername.toLowerCase())
	{
	case "firefox" :
		
		 FirefoxOptions firefoxOptions = new FirefoxOptions();
         firefoxOptions.addArguments("--start-maximized");
         firefoxOptions.addArguments("--incognito");
         firefoxOptions.addArguments("--disable-notifications");
//       firefoxOptions.addArguments("--disable-blink-features=AutomationControlled");
         firefoxOptions.addArguments("--disable-extensions");
         
         driverR = new FirefoxDriver(firefoxOptions);
		break;
	case "chrome" :
		  ChromeOptions chromeOptions = new ChromeOptions();
          chromeOptions.addArguments("start-maximized");
          chromeOptions.addArguments("--incognito");
          chromeOptions.addArguments("--disable-notifications");
          chromeOptions.addArguments("--disable-blink-features=AutomationControlled");
          chromeOptions.addArguments("--disable-extensions");
//          chromeOptions.addArguments("--headless");
//          chromeOptions.addArguments("--no-sandbox");
//          chromeOptions.addArguments("--disable-dev-shm-usage");
		driverR = new ChromeDriver(chromeOptions);
//		options.addArguments("--disable-web-security");
//        options.addArguments("--disable-site-isolation-trials");
		
//		driverR = new FirefoxDriver();
//        driverR= new EdgeDriver();
		break;
	case "edge" :
		 EdgeOptions edgeOptions = new EdgeOptions();
         edgeOptions.addArguments("start-maximized");
         edgeOptions.addArguments("--incognito");
         edgeOptions.addArguments("--disable-notifications");
         edgeOptions.addArguments("--disable-blink-features=AutomationControlled");
         edgeOptions.addArguments("--disable-extensions");
         driverR = new EdgeDriver(edgeOptions);
			default:
		System.err.println("Please provide valid Machine_Name");
		break;
	}
	driverR.manage().window().maximize();
	driverR.manage().deleteAllCookies();
	
//	driverR.manage().deleteAllCookies();
	
	}
	
	

	public void launchUrl() throws IOException, InterruptedException
	{
		driverR.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	//	driverR.get(baseurl);
	//	driverR.get(getFile("baseurl"));
	//	driverR.get("http://34.131.88.222/");
		driverR.get("https://login.aeislab.com/dashboardsso");
		Thread.sleep(2000);
	
	}
	
	public  String getFile(String filename) throws IOException
	{
		Properties prop = new Properties();
		String p1 = "C:\\Users\\ATLAS-ADMIN\\eclipse-workspace\\AEIS-ContactCentre-Project8\\Test Sheet - Data (9).csv" ;
		FileInputStream fis = new FileInputStream(p1);
		prop.load(fis);
		String data = prop.getProperty(filename);
		return data;
	}
	
	 public  String getCellData(String filePath, int row, int col) {
    String cellData = null;
    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
        String line;
        int currentRow = 0;

        while ((line = br.readLine()) != null) {
            if (currentRow == row) {
                String[] columns = line.split(",");
                if (col < columns.length) {
                    cellData = columns[col];
            }
                break;
            }
            currentRow++;

        }
    } catch (IOException e) {
        e.printStackTrace();
    }
 
    return cellData;
	 }
	
	 public void creatingObject() throws IOException
	 {
		   hp = new HomePage(driverR);
		   ap = new AccountPage(driverR);
		   cp = new ContactPage(driverR);
		   pp = new ProjectPage(driverR); 
		   tp = new TeamPage(driverR); 
		   asp = new AssetsPage(driverR); 		   
	 }
	

	public void teardown()
	{
		driverR.quit();
	}

}
