package com.cms.pageObjects;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cms.utility.Utility;

public class ContactPage {
	
	public static WebDriver driver2;
	public static JavascriptExecutor js ;
	public  Actions act;

	@FindBy(xpath="//div[@class='flex flex-row']//h2[contains(text(),'Active Contacts')]")
	private WebElement ActiveContact ;
	
	@FindBy(xpath="//span[normalize-space()='Contacts']")
	private WebElement Contacts ;
	
	@FindBy(xpath="//button[normalize-space()='Add New Contact']")
	private WebElement addnewContact ;

	@FindBy(xpath="//input[@id='firstName']")
	private WebElement Firstname ;
	
	@FindBy(xpath="//input[@id='lastName']")
	private WebElement LastName ;
	
	@FindBy(xpath="//div[@class='form-container']//select[@id='contactTypeId']")
	private WebElement ContactType ;
	
	@FindBy(xpath="//select[@id='contactStatusId']")
	private WebElement ContactStatus ;
	
	@FindBy(xpath="//input[@id='emailId']")
	private WebElement  Contactemail;
	
	@FindBy(xpath="//*[@name=\"accountDesc\"]")
	private WebElement ContactDesc ;
	
	@FindBy(xpath="//input[@id='phoneNo']")
	private WebElement Contactphone ;
	
	@FindBy(xpath="//input[@placeholder='Mobile No']")
	private WebElement ContactMob ;

	@FindBy(xpath="//button[normalize-space()='Submit']")
	private WebElement Submitbtn ;
	
	@FindBy(xpath="//button[normalize-space()='Submit']")
	private WebElement submit ;
	
	@FindBy(xpath="//input[@name='account_name']")
	private WebElement AccountFilter ;
	
	@FindBy(xpath="//button[@type='submit']//*[name()='svg']")
	private WebElement Search ;
	
	@FindBy(xpath="//li[normalize-space()='Next']")
	private WebElement Nextbtn ;
	
	@FindBy(xpath="//li[normalize-space()='Next']")
	private WebElement Resetbtn ;  
	
	@FindBy(xpath="//input[@placeholder='First Name']")
	private WebElement SearchFirstName ;
	
	@FindBy(xpath="//input[@id='last_name']")
	private WebElement SearchLastName ;
	
	@FindBy(xpath="//div[contains(text(),'Contact created successfully.')]")
	private WebElement SuccessMsg;
	
	@FindBy(xpath="//input[@id='imageFile']")
	private WebElement Image;
	
	@FindBy(xpath="//tbody/tr[2]/td[6]/div[1]/span[1]/a[1]//*[name()='svg']")
	private WebElement ContactView;
	
	@FindBy(xpath="//input[@id='contact_name_auto_search']")
	private WebElement ContactName;
	
	@FindBy(xpath="//tbody/tr[1]/td[6]/button[1]")
	private WebElement EditBtn;
	
	@FindBy(xpath="//button[normalize-space()='Search']")
	private WebElement SearchBtn;
	
	@FindBy(xpath="//select[@id='contactTypeId']")
	private WebElement CntTypeFilter;
	
	@FindBy(xpath="//select[@id='status_id']")
	private WebElement CntStatusFilter;
	
	@FindBy(xpath="//h2[text()=\"Certifications\"]/parent::div/div")
	private WebElement certBurgerBtn;
	
	@FindBy(xpath="(//li[text()=\"Add New\"])[2]")
	private WebElement AddcertBtn;
	
	@FindBy(xpath="//h2[text()=\"Qualifications\"]/parent::div/div")
	private WebElement QualiBurgerBtn;
	
	@FindBy(xpath="(//li[text()=\"Add New\"])[3]")
	private WebElement AddQualifiBtn;
	
	@FindBy(xpath="//h2[text()=\"Communication Channels\"]/parent::div/div")
	private WebElement commBurgerBtn;
	
	@FindBy(xpath="(//h2[text()=\"Communication Channels\"]/parent::div/div)/child::ul")
	private WebElement AddcommBtn;
	
	@FindBy(xpath="//h2[text()=\"Addresses\"]/parent::div/div")
	private WebElement AddressBurgerBtn;
	
	@FindBy(xpath="(//h2[text()=\"Addresses\"]/parent::div/div)/child::ul")
	private WebElement AddAddressBtn;
		
	@FindBy(xpath="//button[normalize-space()='Add New Asset Allocation']")
	private WebElement AddAssetAllocationBtn;
	
	@FindBy(xpath="//input[@id='certificationTitle']")
	private WebElement Certification;

	@FindBy(xpath="//input[@id='certificateNumber']")
	private WebElement certificateNumber;
	
	@FindBy(xpath="//input[@id='certificationDate']")
	private WebElement certificationDate;
	
	@FindBy(xpath="//input[@id='certificationExpirationDate']")
	private WebElement certificationExpirationDate;
	
	@FindBy(xpath="//select[@id='qualificationId']")
	private WebElement QualifiText;
	
	@FindBy(xpath="//input[@id='qualificationDate']")
	private WebElement qualificationDate;
	
	@FindBy(xpath="//input[@id='qualificationCompletionDate']")
	private WebElement qualificationCompletionDate;
	
	@FindBy(xpath="//select[@id='channelId']")
	private WebElement Comm;
	
	@FindBy(xpath="//input[@id='channelValue']")
	private WebElement channelValue;
	
	@FindBy(xpath="//select[@id='isPrefered']")
	private WebElement Prefer;
	
	@FindBy(xpath="//select[@id='addressTypeId']")
	private WebElement add;
	
	@FindBy(xpath="//input[@id='address1']")
	private WebElement address1;
	
	@FindBy(xpath="//input[@id='address2']")
	private WebElement address2;
	
	@FindBy(xpath="//input[@id='city']")
	private WebElement city;
	
	@FindBy(xpath="//input[@id='postalCode']")
	private WebElement postalCode;
	
	@FindBy(xpath="//select[@id='countryId']")
	private WebElement Country;
	
	@FindBy(xpath="//select[@id='stateId']")
	private WebElement State;
	
	@FindBy(xpath="//div[contains(text(),'Address created successfully.')]")
	private WebElement AddAlert;
	
	@FindBy(xpath="//input[@id='assetName']")
	private WebElement assetName;
	
	@FindBy(xpath="//div[@class='form-container']//input[@id='projectName']")
	private WebElement inputField;
	
	@FindBy(xpath="//input[@id='allocationDate']")
	private WebElement allocationDate;
	
	@FindBy(xpath="//select[@id='additionalFieldId']")
	private WebElement AddField;
	
	@FindBy(xpath="//input[@id='additionalFieldValue']")
	private WebElement additionalFieldValue;
	
	@FindBy(xpath="//*[@class=\\\"flex justify-end w-full\\\"]//div")
	private WebElement editimageBtn;
	
	@FindBy(xpath="//li[contains(@class,'hover:bg-violet-500 hover:text-white px-1 py-1 cursor-pointer w-full')]")
	private WebElement CertificateNumber2;
	
//**********Constructor creation*******************************	
	    public ContactPage(WebDriver driverR)
		{
			driver2 = driverR;
			PageFactory.initElements(driverR, this);
		}
//********time stamp *******************************************
	    public static String timestamp()
	    {
	    	//return new SimpleDateFormat("yyyyddHHmm").format(new Date(10));
	    	LocalDateTime dt=LocalDateTime.now();
	    	DateTimeFormatter df = DateTimeFormatter.ofPattern("ddhhmm");
	    	String mydata=dt.format(df);
	    	return mydata;
	    	
//	    	Random random = new Random();
//	    	int RandomNo = random.nextInt(1001);
//			return RandomNo;	    	
	    }
	    
	    public void ClickonActiveContact() throws InterruptedException
		{
	    	Utility.ExplicitWait(ActiveContact);
		    js = (JavascriptExecutor)driver2;
			js.executeScript("arguments[0].setAttribute('style','background:violet;border:40px solid green;')",ActiveContact );
//			Thread.sleep(1000);
			Utility.showCallout("then it will Click on Active Account",ActiveContact);
			Thread.sleep(2000);
			ActiveContact.click();
		}
	    
	    public void ClickonContact() throws InterruptedException
		{
		    js = (JavascriptExecutor)driver2;
			js.executeScript("arguments[0].setAttribute('style','background:violet;border:40px solid green;')",Contacts );
//			Thread.sleep(1000);
			Contacts.click();
		}
	    
	    public void ClickonAddnewBtn() throws InterruptedException
		{
	    	Utility.ExplicitWait(addnewContact);
		    js = (JavascriptExecutor)driver2;
			js.executeScript("arguments[0].setAttribute('style','background:violet;border:40px solid green;')",addnewContact );
			Utility.showCallout("then it will Click on AddNewButton",addnewContact);
			Thread.sleep(2000);
			addnewContact.click();
		}
	    
	    public String SendFirstName(String Fname) throws InterruptedException
		{
		    js = (JavascriptExecutor)driver2;
			js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",Firstname );
	        Utility.showCallout("then it will Enter Contact First Name",Firstname);
			Thread.sleep(2000);
			Firstname.sendKeys(Fname);
		    return Fname;
		}
	    
	    public String SendLastName(String Lname) throws InterruptedException
		{
		    js = (JavascriptExecutor)driver2;
			js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",LastName );
			Utility.showCallout("then it will Enter Contact Last Name",LastName);
			Thread.sleep(2000);
			LastName.sendKeys(Lname+timestamp());
			return Lname+timestamp();
		}
	    
	    public String SelectContactType(String ContctType) throws InterruptedException
		{
		    js = (JavascriptExecutor)driver2;
			js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",ContactType );
			Utility.showCallout("then it will Select Contact Type",ContactType);
			Thread.sleep(2000);
			Select s1 = new Select(ContactType);
			s1.selectByVisibleText(ContctType);	
			return ContctType;
		}
	    public String SelectCntTypeFilter(String ContctType2) throws InterruptedException
		{
		    js = (JavascriptExecutor)driver2;
			js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",CntTypeFilter );
			Utility.showCallout("then it will Select Contact Type Filter",CntTypeFilter);
			Thread.sleep(2000);
			Select s8 = new Select(CntTypeFilter);
			s8.selectByVisibleText(ContctType2);	
			return ContctType2;
		}
	    public String SelectCntStatusFilter(String ContctStatus2) throws InterruptedException
		{
		    js = (JavascriptExecutor)driver2;
			js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",CntStatusFilter );
//			Thread.sleep(1000);
			Select s9 = new Select(CntStatusFilter);
			s9.selectByVisibleText(ContctStatus2);	
			return ContctStatus2;
		}
	    public String SelectContactStatus(String StatusNm) throws InterruptedException
		{
		    js = (JavascriptExecutor)driver2;
			js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",ContactStatus );
			Utility.showCallout("then it will Select Contact Type Filter",ContactStatus);
			Thread.sleep(2000);
			Select s2 = new Select(ContactStatus);
			s2.selectByVisibleText(StatusNm);;	
			return StatusNm;
		}
	    public String SelectCntStatusfilter(String StatusNm) throws InterruptedException
		{
		    js = (JavascriptExecutor)driver2;
			js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",ContactStatus );
//			Thread.sleep(1000);
			Select s2 = new Select(ContactStatus);
			s2.selectByVisibleText(StatusNm);;	
			return StatusNm;
		}
	    public String SendEmail(String Email) throws InterruptedException
		{
		    js = (JavascriptExecutor)driver2;
			js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",Contactemail );
			Utility.showCallout("then it will Enter Contact Email",Contactemail);
			Thread.sleep(2000);
			Contactemail.sendKeys(Email+timestamp()+"@gmail.com");
			return Email+timestamp()+"@gmail.com";
		}
	    public void SendDesc() throws InterruptedException
		{
		    js = (JavascriptExecutor)driver2;
			js.executeScript("arguments[0].setAttribute('style','background:violet;border:40px solid green;')",ContactDesc );
//			Utility.showCallout("then it will Enter Contact Email",Contactemail);
			Thread.sleep(3000);
			ContactDesc.sendKeys("Testing Contact");
		}
	    
	    public void SendContactphone() throws InterruptedException
		{
		    js = (JavascriptExecutor)driver2;
			js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",Contactphone );
			Utility.showCallout("then it will Enter Contact Phone No.",Contactphone);
			Thread.sleep(2000);
			Contactphone.sendKeys("0612222"+timestamp());
		}
	    
	    public void SendMobile() throws InterruptedException
		{
		    js = (JavascriptExecutor)driver2;
			js.executeScript("arguments[0].setAttribute('style','background:violet;border:40px solid green;')",ContactMob );
//			Thread.sleep(1000);
			ContactMob.sendKeys("843084"+timestamp());
		}
	    public void ClickonSubmitBtn() throws InterruptedException
		{
		    js = (JavascriptExecutor)driver2;
			js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",submit );
			Utility.showCallout("then it will Click on Submit Button",submit);
			Thread.sleep(2000);
			submit.click();	
		}
	
	 public void SearchContactName(String ActName) throws InterruptedException
		{
		    js = (JavascriptExecutor)driver2;
			js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",ContactName );
			Utility.showCallout("Now it will search newly created Contact to verify -add New Contact Functionality",ContactName);
			Thread.sleep(2000);
			ContactName.sendKeys(ActName);
//			js = (JavascriptExecutor)driver2;
//			js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",SearchLastName );
//				Thread.sleep(2000);		
//				SearchLastName.sendKeys(ActName);
//			Thread.sleep(1000);
			js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",Search );
			Search.click();
		
		}
	 
	 public void ClickonNextBtn() throws InterruptedException
		{
		    js = (JavascriptExecutor)driver2;
			js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",Nextbtn );
//			Thread.sleep(1000);
			Nextbtn.click();	
		}
	
	 public String ValidateContactCreation() throws InterruptedException
		{
		    js = (JavascriptExecutor)driver2;
			js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",SuccessMsg );
//			Thread.sleep(1000);
			Utility.ExplicitWait(SuccessMsg);
			String ConfirmationMsg = SuccessMsg.getText();
			return ConfirmationMsg; 	
		}
	 
	 public void UploadImage() throws InterruptedException
		{
		    js = (JavascriptExecutor)driver2;
			js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",Image );
			Utility.showCallout("then it will Upload Image",Image);
			Thread.sleep(2000);
			Image.sendKeys("C:\\Users\\ATLAS-ADMIN\\eclipse-workspace\\AEIS-ContactCentre-Project8\\src\\test\\resources\\Images\\AEIS Logo 2023.png");	
		}
	 
	 public void ClickonContactView() throws InterruptedException
		{
		    js = (JavascriptExecutor)driver2;
			js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",ContactView);
			Utility.showCallout("then it will Click on View Button",ContactView);
			Thread.sleep(2000);
			ContactView.click();	
		}
	  public void ClickonEditBtn() throws InterruptedException
			{
			    js = (JavascriptExecutor)driver2;
				js.executeScript("arguments[0].setAttribute('style','background:violet;border:40px solid green;')",EditBtn );
				Utility.showCallout("then it will Click on Edit Button",EditBtn);
				Thread.sleep(2000);
				EditBtn.click();
			}
	  public void EditEmailField(String EditedEmail) throws InterruptedException
		{
		    js = (JavascriptExecutor)driver2;
			js.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid green;')",Contactemail);
			Utility.showCallout("then it will Click on Edit Email Field",Contactemail);
			Thread.sleep(2000);
			Contactemail.clear();
//			Thread.sleep(1000);
			Contactemail.sendKeys(EditedEmail);
		}
	  public void ClickonSearchBtn() throws InterruptedException
		{
		    js = (JavascriptExecutor)driver2;
			js.executeScript("arguments[0].setAttribute('style','background:violet;border:40px solid green;')",SearchBtn );
			Utility.showCallout("then it will Click on Search Button",SearchBtn);
			Thread.sleep(2000);
			SearchBtn.click();
		}
	  public void ClickonCertBtn() throws InterruptedException
		{
	 
		 act=new Actions(driver2);
		act.moveToElement(certBurgerBtn).build().perform();
			Thread.sleep(2000);
			Utility.showCallout("then it will Click on AddCertBtn Button",AddcertBtn);
			Thread.sleep(2000);
		Utility.ExplicitWait(AddcertBtn);
		AddcertBtn.click();
		}
	  public void ClickonQualificationBtn() throws InterruptedException
		{		   
			act.moveToElement(QualiBurgerBtn).build().perform();
			Thread.sleep(2000);		
			Utility.showCallout("Qualification Detail Entered Using Automation Script", AddQualifiBtn);
			Thread.sleep(2000);	
			Utility.ExplicitWait(AddQualifiBtn);
			AddQualifiBtn.click();
		
		}
	  public void ClickonCommunicationBtn() throws InterruptedException
		{
			act.moveToElement(commBurgerBtn).build().perform();
			Thread.sleep(2000);
			Utility.showCallout("then it will Click on AddCommunication Button",AddcommBtn);
			Thread.sleep(2000);
			//	WebElement commAddBtn = driverR.findElement(By.xpath("(//li[text()=\"Add New\"])[4]"));
			//	Utility.ExplicitWait(commAddBtn);
			AddcommBtn.click();
		}  
	  
	  public void ClickonAddressBtn() throws InterruptedException
		{
			act.moveToElement(AddressBurgerBtn).build().perform();
			Thread.sleep(2000);
			Utility.showCallout("then it will Click on Add Address Button",AddAddressBtn);
			Thread.sleep(3000);
			//	WebElement commAddBtn = driverR.findElement(By.xpath("(//li[text()=\"Add New\"])[4]"));
			//	Utility.ExplicitWait(commAddBtn);
//			Utility.ExplicitWait(AddAddressBtn);
			Utility.ExplicitClickWait(AddAddressBtn);
			AddAddressBtn.click();
		} 
	  
	  public void ClickonAssetsAllocation() throws InterruptedException
		{
			Utility.showCallout("then it will Click on Add Assets Allocation Button",AddAssetAllocationBtn);
			Thread.sleep(2000);
			//	WebElement commAddBtn = driverR.findElement(By.xpath("(//li[text()=\"Add New\"])[4]"));
			//	Utility.ExplicitWait(commAddBtn);
			Utility.ExplicitClickWait(AddAssetAllocationBtn);
			AddAssetAllocationBtn.click();
		} 
	  
	  public void SendCertification() throws InterruptedException
		{
		  Utility.showCallout("Certification name Entered Using Automation Script", Certification);
			Certification.sendKeys("AEIS");
			Thread.sleep(2000);
			WebDriverWait wait2 = new WebDriverWait(driver2, Duration.ofSeconds(10));
			 WebElement firstOption = wait2.until(
			            ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[contains(@class,\"w-full overflow-y-auto max-h-32\")]/li[1]"))
			        );

			        // Click the first option
			        firstOption.click();
			        Thread.sleep(2000);
			    }
		
	  
	  public void SendCertificateNumber() throws InterruptedException
		{
			
//		  driver2.findElement(By.xpath("//li[contains(@class,'hover:bg-violet-500 hover:text-white px-1 py-1 cursor-pointer w-full')]"));
			Utility.showCallout("Certification Number Entered Using Automation Script", certificateNumber);
			certificateNumber.sendKeys("CERT/2024/65231");
			Thread.sleep(2000);
		} 

	  public void SendCertificationDate() throws InterruptedException
		{
			Utility.showCallout("Certification Date Entered Using Automation Script", certificationDate);
			certificationDate.sendKeys("02-06-2020");
			Thread.sleep(2000);

		} 
	  public void SendCertificationExpiryDate() throws InterruptedException
		{
			Utility.showCallout("Certification Expiry Date Entered Using Automation Script", certificationExpirationDate);
			certificationExpirationDate.sendKeys("01-06-2030");
			Thread.sleep(2000);

		} 
	  public void ClickonSubmit() throws InterruptedException
			{
//			driver2.findElement(By.xpath("//button[normalize-space()='Submit']")).click();
			Utility.showCallout("Click On Submit Button Using Automation Script", Submitbtn);
			Submitbtn.click();
			Thread.sleep(2000);
			} 
	  public void SelectQualificationText() throws InterruptedException
			{
			Select s1 =new Select(QualifiText);
			s1.selectByVisibleText("M. Tech");
			Thread.sleep(2000);
			} 
	  public void SendQualificationDate() throws InterruptedException
			{
			Utility.showCallout("Then it will enter Qualification Date", qualificationDate);
			qualificationDate.sendKeys("02-04-2000");
			Thread.sleep(2000);
			} 
	  public void SendQualificationCompleteDate() throws InterruptedException
			{
			Utility.showCallout("Then it will enter Qualification CompletionDate", qualificationCompletionDate);
			qualificationCompletionDate.sendKeys("02-04-2002");
			Thread.sleep(2000);
			} 

	  public void SelectCommunication() throws InterruptedException
			{
			Utility.showCallout("Then it will Select Communication", Comm);
			Utility.ExplicitWait(Comm);
			Select s2 =new Select(Comm);
			s2.selectByVisibleText("Google Meet");
			Thread.sleep(2000);

			} 
	  public void SendChannelValue() throws InterruptedException
			{
			Utility.showCallout("Then it will Enter Value", channelValue);
			channelValue.sendKeys("Test");
			Thread.sleep(2000);
			} 

	  public void SelectChannelPrefer() throws InterruptedException
			{
			Utility.showCallout("Then it will Select Prefer Value", Prefer);
			Utility.ExplicitWait(Prefer);
			Select s3 = new Select(Prefer);
			s3.selectByVisibleText("Yes");
			Thread.sleep(2000);
			} 

	  public void SelectAddressType() throws InterruptedException
			{
			Utility.showCallout("Then it will Select Prefer Value", add);
			Utility.ExplicitWait(add);
			Select s4 = new Select(add);
			s4.selectByVisibleText("Office");
			Thread.sleep(2000);
			} 

	  public void SendAddress1() throws InterruptedException
			{
			Utility.showCallout("Then it will Enter Address1", address1);
			Utility.ExplicitWait(address1);
			address1.sendKeys("F-91,Surajpur");
			Thread.sleep(2000);
			} 

	  public void SendAddress2() throws InterruptedException
			{
			Utility.showCallout("Then it will Enter Address2", address2);
			Utility.ExplicitWait(address2);
			address2.sendKeys("Industrial Area");
			Thread.sleep(2000);
			} 

	  public void SendCity() throws InterruptedException
			{
			Utility.showCallout("Then it will Enter City", city);
			Utility.ExplicitWait(city);
			city.sendKeys("Greater Noida");
			Thread.sleep(2000);
			} 

	  public void SendPostalCode() throws InterruptedException
			{
			Utility.showCallout("Then it will Enter postalCode", postalCode);
			Utility.ExplicitWait(postalCode);
			postalCode.sendKeys("201306");
			Thread.sleep(2000);
			} 

	  public void SelectCountry() throws InterruptedException
			{
			Utility.showCallout("Then it will Enter Country", Country);
			Utility.ExplicitWait(Country);
			Select s5 = new Select(Country);
			s5.selectByVisibleText("India");
			Thread.sleep(2000);
			} 

	  public void SelectState() throws InterruptedException
			{
			Utility.showCallout("Then it will Enter State", State);
			Utility.ExplicitWait(State);
			Select s6 = new Select(State);
			s6.selectByVisibleText("Uttar Pradesh");
			Thread.sleep(2000);
			} 

	  public void SendAssetName() throws InterruptedException
			{
			Utility.showCallout("Then it will Enter Asset Name", assetName);
			Utility.ExplicitWait(assetName);
			assetName.sendKeys("Microscope");
			Thread.sleep(2000);
			driver2.findElement(By.xpath("//li[normalize-space()='Microscope']")).click();
			Thread.sleep(2000);
			} 

	  public void SendInputField() throws InterruptedException
			{

			Utility.showCallout("Then it will Enter Project Name", inputField);
			Utility.ExplicitWait(inputField);
			Thread.sleep(2000);
				String keyword ="Aeis-smp-";
				for(char letter :keyword.toCharArray())
				{
					inputField.sendKeys(Character.toString(letter));
					Thread.sleep(100);
				}
				List<WebElement> suggestions = driver2.findElements(By.xpath("//ul[@class=\"w-full overflow-y-auto max-h-32\"]"));
				for(WebElement suggestion:suggestions)
				{
					System.out.println(suggestion.getText());
				}

				for(WebElement suggestion:suggestions)
				{
					if(suggestion.getText().contains("Aeis-smp-p126"))
					{
						    
							suggestion.click();
							//    			Actions act = new Actions(driverR);
							//    			act.moveToElement(suggestion).perform();
							//    			act.click().perform();
							break;
						}
				}
			}
	  
			
	  public void SendAllocationDate() throws InterruptedException
		{
			Utility.showCallout("Then it will Enter Asset Allocation Date", allocationDate);
			allocationDate.sendKeys("05-08-2020");
			Thread.sleep(2000);

		} 

	  public void SendAdditionalDetail() throws InterruptedException
		{
			Utility.showCallout("Then it will Provide Additional Data Field ", AddField);
			Utility.ExplicitWait(AddField);
			Select s10 = new Select(AddField);
			s10.selectByVisibleText("ship_toOfficeAddress");
			Thread.sleep(2000);

		} 
	  
	  public void SendAdditionalFieldValue() throws InterruptedException
		{
			Utility.showCallout("Then it will Enter additionalFieldValue", additionalFieldValue);
			additionalFieldValue.sendKeys("Test");
			Thread.sleep(2000);

		} 

	  public void editImage() throws InterruptedException
		{
			Utility.showTooltip("Now ,Automation Script will change Image.");
			act.moveToElement(editimageBtn).build().perform();
			Thread.sleep(2000);
			driver2.findElement(By.xpath("(//div[contains(@class,\"!text-gray-700 text-sm cursor-pointer relative\")])/child::ul//li")).click();
			Thread.sleep(2000);
			driver2.findElement(By.xpath("//input[@id='imageFile']")).sendKeys("C:\\Users\\ATLAS-ADMIN\\eclipse-workspace\\AEIS-ContactCentre-Project8\\src\\test\\resources\\Images\\Testing.png");
			Thread.sleep(2000);
		} 

}
