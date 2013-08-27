package com.trunk.selenium.trunkTestSuit;

import static org.junit.Assert.assertTrue;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.*;
//import java.util.logging.FileHandler;
//import java.util.logging.Handler;

public class Trunk_testHelper {
	
/* ++++ START OF LOGIN ++++ */
	Scanner in = new Scanner(System.in); 
	//private Logger logger = Logger.getLogger ("");
	//private Help_verify verify_fun = new Help_verify();	
	public String login(String baseUrl, WebDriver driver) throws InterruptedException, Exception, IOException{
		// suppressing all html warning messages; handler to output messages to "testLog.log" (currently commented out)
		// Handler handler = new FileHandler("testLog.log");
		// Logger.getLogger("").addHandler(handler);  // static access 
		Logger.getLogger("").setLevel(Level.OFF);
		
		/* lesson learned: must know to switch to the frame!!
		 interestingly, we have to make it re-login for the script to proceed */
	    driver.get(baseUrl + "/xsl-portal");
	    driver.switchTo().frame(0);
	    
	    // verify home page info
	    String str = "";
		try {
		      assertTrue(isElementPresent(By.id("logo"), driver));
		      assertTrue(isElementPresent(By.id("welcome"), driver));
		      assertTrue(isElementPresent(By.id("middle_col"), driver));
		      assertTrue(isElementPresent(By.id("right_col"), driver));
		} catch (Error e) {
		      str = e.toString();
		}
	    
		// login
	    driver.findElement(By.id("eid")).clear();
	    driver.findElement(By.id("eid")).sendKeys("wrong uname");
	    driver.findElement(By.id("pw")).clear();
	    driver.findElement(By.id("pw")).sendKeys("wrong password");
	    driver.findElement(By.cssSelector("input[type=\"image\"]")).click();
	
	    // re-login
	    Thread.sleep(500);
	    driver.findElement(By.id("eid")).sendKeys(getUname());
	    driver.findElement(By.id("pw")).sendKeys(getPword());
	    driver.findElement(By.id("submit")).click();
	    
	    // verify all elements in the home page
	    try {
	        assertTrue(isElementPresent(By.xpath("//div[@id=\"quickLinks\"]"), driver));
	      } catch (Error e) {
	        str += e.toString();
	      }
	      try {
	        assertTrue(isElementPresent(By.xpath("//ul[@id=\"siteLinkList\"]"), driver));
	      } catch (Error e) {
	    	str += e.toString();
	      }
	      try {
	        assertTrue(isElementPresent(By.xpath("//div[@id=\"toolMenu\"]"), driver));
	      } catch (Error e) {
	    	str += e.toString();
	      }
	      try {
	        assertTrue(isElementPresent(By.xpath("//div[@id=\"siteTitle\"]"), driver));
	      } catch (Error e) {
	    	str += e.toString();
	      }
	      try {
	        assertTrue(isElementPresent(By.xpath("//div[@id=\"content\"]"), driver));
	      } catch (Error e) {
	    	str += e.toString();
	      }
	      try {
	        assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*My Workspace[\\s\\S]*$"));
	      } catch (Error e) {
	    	str += e.toString();
	      }
	      try {
	        assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Home[\\s\\S]*$"));
	      } catch (Error e) {
	    	  str += e.toString();
	      }
	      try {
	        assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*My Sites[\\s\\S]*$"));
	      } catch (Error e) {
	    	  str += e.toString();
	      }
	      try {
	        assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Hello,[\\s\\S]*$"));
	      } catch (Error e) {
	    	  str += e.toString();
	      }
	      try {
	        assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Logout[\\s\\S]*$"));
	      } catch (Error e) {
	    	  str += e.toString();
	      }
	      try {
	        assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Help[\\s\\S]*$"));
	      } catch (Error e) {
	    	  str += e.toString();
	      }
	    
	    return str;
	}
	
	/* get username and password */
	private String getUname(){
		//System.out.println("Enter Username");
		//String Uname = in.nextLine();
		
		return "@haowan";
	}	
	private String getPword(){
		//System.out.println("Enter Password");
		//String Pword = in.nextLine();
		
		return "nawoah";
	}
/* ---- END OF LOGIN ---- */
	
	
	
/* ++++ START OF LOGOUT ++++ */
	public String logout(WebDriver driver) {
		driver.switchTo().defaultContent();
		driver.findElement(By.cssSelector("a[title=\"Logout\"]")).click();
		
		driver.switchTo().frame(0);
		String str = "";
		try {
		      assertTrue(isElementPresent(By.id("logo"), driver));
		      assertTrue(isElementPresent(By.id("welcome"), driver));
		      assertTrue(isElementPresent(By.id("middle_col"), driver));
		      assertTrue(isElementPresent(By.id("right_col"), driver));
		} catch (Error e) {
		      str = e.toString();
		}
		

		return str;
	}
/* ---- END OF LOGOUT ---- */
	
	
	
/* ++++ START OF verification func ++++ */
	public boolean isElementPresent(By by, WebDriver driver) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }
	
	public boolean isAlertPresent(WebDriver driver) {
		try {
		  driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	}

	public String closeAlertAndGetItsText(boolean acceptNextAlert, WebDriver driver) {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	}
/* ---- END OF verification func ---- */
	  
	
	
/* ++++ START OF params func ++++ */
	public String get_sample_txt(){
		return "C:\\Users\\VEK\\Desktop\\sample.txt";
	}
		
	public String get_sample_jpg(){
		return "C:\\Users\\VEK\\Desktop\\sample.jpg";
	}
		
	public String get_baseUrl(){
		return "https://trunk-stage.tufts.edu/";
	}
	
	public String get_uploadtxt_text(){
		return "this is to upload a .txt file";
	}
		
	public String get_cpright_text(){
		return "copyright owned by the file producers";
	}
		
	public String get_search_text(){
		return "news";
	}
		
	public String get_saysth_text(){
		return "I am happy today";
	}
		
	public HtmlUnitDriver get_driver(HtmlUnitDriver driver){
		driver = new HtmlUnitDriver();
		// JS must be enabled to allow test2 upload selector to work
		driver.setJavascriptEnabled(true);  
		return driver;
	}
/* ---- END OF params func ---- */
}
