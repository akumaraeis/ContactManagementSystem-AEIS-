package com.cms.pageObjects;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AssetsPage {
	public static WebDriver driver2;
	public static JavascriptExecutor js ;
	
	@FindBy(xpath="//button[normalize-space()='Add New Asset']")
	private WebElement addnewAssets ;
	
	@FindBy(xpath="//select[@id='projectId']")
	private WebElement projectList ;
	
	@FindBy(xpath="//select[@id='assetId']")
	private WebElement assetsList ;
	
	@FindBy(xpath="//select[@id='contactId']")
	private WebElement contactList ;

	@FindBy(xpath="//select[@id='contactId']")
	private WebElement searchAsset ;
	
	@FindBy(xpath="//button[normalize-space()='Submit']")
	private WebElement submit ;
	
	@FindBy(xpath="(//*[contains(text(),\"Assets\")])[1]")
	private WebElement Assets ;
	
	@FindBy(xpath="//span[normalize-space()='Settings']")
	private WebElement Settings ;
	
	@FindBy(xpath="//input[@id='assetName']")
	private WebElement AssetName ;
	
	@FindBy(xpath="//input[@id='quantity']")
	private WebElement Quantity ;
	
	@FindBy(xpath="//input[@id='assetDesc']")
	private WebElement Description ;
	
// *********Construction Declaration to initialize Data Member********	
	    public AssetsPage(WebDriver driverR)
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
	    
	    public void ClickonAssets() throws InterruptedException
		{
		    js = (JavascriptExecutor)driver2;
			js.executeScript("arguments[0].setAttribute('style','background:violet;border:40px solid green;')",Assets );
			Thread.sleep(1000);
			Assets.click();
		}
	    
	    public void ClickonSetting() throws InterruptedException
		{
		    js = (JavascriptExecutor)driver2;
			js.executeScript("arguments[0].setAttribute('style','background:violet;border:40px solid green;')",Settings );
			Thread.sleep(1000);
			Settings.click();
		}
 
	    public void ClickonAddnewassets() throws InterruptedException
		{
		    js = (JavascriptExecutor)driver2;
			js.executeScript("arguments[0].setAttribute('style','background:violet;border:40px solid green;')",addnewAssets );
			Thread.sleep(1000);
			addnewAssets.click();
		}
	    
	    public void selectProjectType() throws InterruptedException
		{
		    js = (JavascriptExecutor)driver2;
			js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",projectList );
			Thread.sleep(1000);
			Select s1 = new Select(projectList);
			s1.selectByIndex(2);
		}
	    
	    public String selectAssetType() throws InterruptedException
		{
		    js = (JavascriptExecutor)driver2;
			js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",assetsList );
			Thread.sleep(1000);
			Select s2 = new Select(assetsList);
			s2.selectByIndex(2);
			List<WebElement> Options = s2.getOptions();
			String AssetsList2=Options.get(2).getText();
			return AssetsList2;
			
//			Iterator<WebElement> itr = Options.iterator();
//			while(itr.hasNext())
//			{
//				String OptionList = itr.next().getText();
//				System.out.println(OptionList);
//				
//				
//			}
		}
	    
	    public void selectContactType() throws InterruptedException
		{
		    js = (JavascriptExecutor)driver2;
			js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",contactList );
			Thread.sleep(1000);
			Select s3 = new Select(contactList);
			s3.selectByIndex(2);
		}
	    public void ClickonSubmitBtn() throws InterruptedException
	 		{
	 		    js = (JavascriptExecutor)driver2;
	 			js.executeScript("arguments[0].setAttribute('style','background:violet;border:40px solid green;')",submit );
	 			Thread.sleep(1000);
	 			submit.click();
	 		}
	    
	    public String sendSearchAssetsName(String Assset) throws InterruptedException
		{
		    js = (JavascriptExecutor)driver2;
			js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",searchAsset );
			Thread.sleep(1000);
			searchAsset.sendKeys(Assset);
			return Assset;
		}

	    public String sendAssetsName(String Assset) throws InterruptedException
		{
		    js = (JavascriptExecutor)driver2;
			js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",AssetName );
			Thread.sleep(1000);
			AssetName.sendKeys(Assset);
			return Assset;
		}
	    
	    public void sendAssetsDescript(String Descrip) throws InterruptedException
		{
		    js = (JavascriptExecutor)driver2;
			js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",Description );
			Thread.sleep(1000);
			Description.sendKeys(Descrip);
		}

	    public void sendAssetsQuantity(String Qty) throws InterruptedException
		{
		    js = (JavascriptExecutor)driver2;
			js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",Quantity );
			Thread.sleep(1000);
			Quantity.sendKeys(Qty);
		}
}
