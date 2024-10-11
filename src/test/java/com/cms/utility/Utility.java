package com.cms.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cms.basetest.BaseTest;

public class Utility extends BaseTest {
	
	
    public static String captureScreenshot(String testName, String status) {
        TakesScreenshot ts = (TakesScreenshot) driverR;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destination = "C:\\Users\\ATLAS-ADMIN\\eclipse-workspace\\AEIS-ContactCentre-Project8\\AEIS-CMS-Screenshots\\ContactCenter_" + testName + "_" + status + ".jpg";
        File finalDestination = new File(destination);
        try {
            FileHandler.copy(source, finalDestination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destination; // Return the path to add screenshot in the report
    }

    // Method to wait for visibility of WebElement
    public static WebElement ExplicitWait(WebElement element) {
    	WebDriverWait wait = new WebDriverWait(driverR,Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
//	public static void ExplicitWait(WebElement ele)
//	{
//		WebDriverWait wait = new WebDriverWait(driverR,Duration.ofSeconds(50));
//		wait.until(ExpectedConditions.visibilityOf(ele));
//		
//	}
	
	  public static void ExplicitClickWait(WebElement ele) {
	        WebDriverWait wait = new WebDriverWait(driverR, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(ele)));
//	        loginButton.click();
	    }
	  
//	public static void ExplicitWait2(WebElement ele)
//{
//	WebDriverWait wait = new WebDriverWait(driverR,Duration.ofSeconds(50));
//	wait.until(ExpectedConditions.elementToBeClickable(ele));
//}

	 public static void showTooltip(String message) {
	        String script = "var tooltip = document.createElement('div');" +
	                        "tooltip.innerHTML = '" + message + "';" +
	                        "tooltip.style.position = 'fixed';" +
	                        "tooltip.style.top = '80px';" +
	                        "tooltip.style.left = '50%';" +
	                        "tooltip.style.padding = '25px';" +
	                        "tooltip.style.backgroundColor = 'green';" +
	                        "tooltip.style.color = 'white';" +
	                        "tooltip.style.border = '1px solid black';" +
	                        "tooltip.style.zIndex = '10000';" +
	                        "document.body.appendChild(tooltip);" +
	                        "setTimeout(function() { document.body.removeChild(tooltip); }, 2000);";

	        ((JavascriptExecutor) driverR).executeScript(script);
	    }
	 public static void showCallout(String message , WebElement element) {
		  int x = element.getLocation().getX();
	        int y = element.getLocation().getY();

	        // Adjust position for the callout
	        int calloutX = x;
	        int calloutY = y-60;  // Place the callout above the element

/*	        String script2 = "var callout = document.createElement('div');" +
                 "callout.innerHTML = '" + message + "';" +
                 "callout.style.position = 'absolute';" +
                 "callout.style.left = '" + calloutX + "px';" +
                 "callout.style.top = '" + calloutY + "px';" +
                 "callout.style.padding = '10px';" +
                 "callout.style.backgroundColor = 'red';" + // Light blue color
                 "callout.style.border = '1px solid #000';" +
                 "callout.style.borderRadius = '5px';" +
                 "callout.style.boxShadow = '0 0 10px rgba(0, 0, 0, 0.1)';" +
                 "callout.style.zIndex = '10000';" +
                 "callout.style.display = 'flex';" +
                 "callout.style.alignItems = 'center';" +
                 "var arrow = document.createElement('div');" +
                 "arrow.style.width = '6px';" + // Bold arrow
                 "arrow.style.height = '100px';" + // Long arrow
                 "arrow.style.backgroundColor = '#000';" + // Black color
                 "arrow.style.position = 'absolute';" +
                 "arrow.style.left = '-20px';" +  // Adjust to position the arrow to the left of the callout
                 "arrow.style.top = '5px';" + // Adjust to position the arrow down from the top of the callout
               //  "arrow.style.transform = 'rotate(-45deg)';" +  // Incline the arrow
//                 "arrow.style.transformOrigin = 'top left';" +
//                 "callout.appendChild(arrow);" +
//                 "var arrowHead = document.createElement('div');" +
//                 "arrowHead.style.position = 'absolute';" +
//                 "arrowHead.style.fontSize = '60px';" +
//                 "arrowHead.style.color = '#000';" + // Black color
//                 "arrowHead.style.left = '0px';" +  // Adjust to position the arrowhead at the end of the arrow
//                 "arrowHead.style.top = '0px';" + // Adjust to position the arrowhead down from the top of the callout
//                 "arrowHead.innerHTML = '&#x279E;';" + // Unicode for ➤
//                 "callout.appendChild(arrowHead);" +
//                 "document.body.appendChild(callout);" +
                 "setTimeout(function() { document.body.removeChild(callout); }, 3000);";

	        ((JavascriptExecutor) driverR).executeScript(script2);
	*/
	        String script2 =  "var callout = document.createElement('div');" +
         "callout.innerHTML = '" + message + "';" +
         "callout.style.position = 'absolute';" +
         "callout.style.left = '" + calloutX + "px';" +
         "callout.style.top = '" + calloutY + "px';" +
         "callout.style.padding = '10px';" +
         "callout.style.backgroundColor = 'green';" + 
         "callout.style.color = 'white';" + 
         "callout.style.border = '1px white';" +
         "callout.style.borderRadius = '5px';" +
         "callout.style.boxShadow = '0 0 10px rgba(0, 0, 0, 0.1)';" +
         "callout.style.zIndex = '10000';" +
         "callout.style.display = 'flex';" +
         "callout.style.alignItems = 'center';" +
         "var arrow = document.createElement('div');" +
         "arrow.style.width = '0';" +
         "arrow.style.height = '0';" +
         "arrow.style.borderLeft =  '10px solid transparent';" +
         "arrow.style.borderRight = '10px solid transparent';" +
         "arrow.style.borderTop = 'white';" + // Same light blue color
         "arrow.style.position = 'absolute';" +
         "arrow.style.left = '10px';" +
         "arrow.style.top = '100%';" +
         "callout.appendChild(arrow);" +
         "document.body.appendChild(callout);" +
         "setTimeout(function() { document.body.removeChild(callout); }, 1000);";
	        ((JavascriptExecutor) driverR).executeScript(script2);
	    }
	 /*
		public static String getScreenshot() throws IOException
		{
		TakesScreenshot ts = (TakesScreenshot)driverR;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		File dest = new File ("C:\\Users\\ATLAS-ADMIN\\eclipse-workspace\\AEIS-ContactCentre-Project8\\AEIS-CMS-Screenshots"+timeStamp+".jpg");
		//File dest = new File ("C:\\Users\\ATLAS-ADMIN\\eclipse-workspace\\AEIS-DMS1\\AEIS-DMS-Screenshots\\No"+System.currentTimeMillis()+".jpg");
		FileHandler.copy(src, dest);
		
		String screenshotpath = dest.getAbsolutePath();
		return screenshotpath;
		
		}
  */
	}


