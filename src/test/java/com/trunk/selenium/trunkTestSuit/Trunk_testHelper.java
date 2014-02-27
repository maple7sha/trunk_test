package com.trunk.selenium.trunkTestSuit;

import static org.junit.Assert.assertTrue;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.*;
import org.openqa.selenium.*;


public class Trunk_testHelper {
	
	private static Logger theLogger = Logger.getLogger(Trunk_testHelper.class.getName());
/* ++++ START OF LOGIN ++++ */
	Scanner in = new Scanner(System.in);
	public String login(String baseUrl, WebDriver driver) throws InterruptedException, Exception, IOException{
		// suppressing all html warning messages; handler to output messages to "testLog.log" (currently commented out)
		// Handler handler = new FileHandler("testLog.log");
		// Logger.getLogger("").addHandler(handler);  // static access
		Logger.getLogger("").setLevel(Level.OFF); //log every message with severe level

		// error string
		String str = "";
		
		// verify favicon
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUrl + "favicon.ico");
		if(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Status report[\\s\\S]*$")){
			str += "favicon NOT FOUND";
		}
		
		// switch to main frame to start testing
	    driver.get(baseUrl + "/xsl-portal");
	    driver.switchTo().frame(0);

	    // verify home page info
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
		String uname = System.getProperty("sakaiHostUsername");
		if(uname==null) {
			theLogger.severe("sakaiHost username not found");
			System.exit(1);
		}
		return uname;
	}
	private String getPword(){
		String pword = System.getProperty("sakaiHostPassword");
		if(pword==null) {
			theLogger.severe("sakaiHostPassword not found");
			System.exit(1);
		}
		return pword;
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

		String txtaddr = System.getProperty("sampletxt_addr");
		if(txtaddr==null) {
			theLogger.severe("directory to sample.txt not correctly passed in");
			System.exit(1);
		}
		else if(!txtaddr.endsWith(".txt")){
			theLogger.severe("Wrong type of file is uploaded; TXT file expected");
			System.exit(1);
		}
		return txtaddr;
	}

	public String get_sample_jpg(){
		String jpgaddr = System.getProperty("samplejpg_addr");
		if(jpgaddr==null) {
			theLogger.severe("directory to sample.jpg not correctly passed in");
			System.exit(1);
		}
		// Requirement for the type of images of files to be uploaded: jpg, png, gif, tif
		else if(!(jpgaddr.endsWith(".jpg")||jpgaddr.endsWith(".png")||jpgaddr.endsWith(".gif")||jpgaddr.endsWith(".tif"))){
			theLogger.severe("Wrong type of file is uploaded; image file expected");
			System.exit(1);
		}
		return jpgaddr;
	}

	public String get_baseUrl(){
		// baseUrl passed in as a System property via Jenkins
		String baseUrl = System.getProperty("sakaiHostName"); 
		if(baseUrl==null) {
			theLogger.severe("host site name (trunk/trunk-stage) not properly passed in");
			System.exit(1);
		}
		return baseUrl;
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
