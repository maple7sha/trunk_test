package com.trunk.selenium.trunkTestSuit;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.*;

import java.util.Scanner;
/*import java.io.PrintStream;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select; */


public class Help_login {
	Scanner in = new Scanner(System.in); 
	private Help_verify verify_fun = new Help_verify();
	
	public String login(String baseUrl, WebDriver driver) throws InterruptedException{
		/* lesson learned: must know to switch to the frame!!
		 interestingly, we have to make it re-login for the script to proceed */
	    driver.get(baseUrl + "/xsl-portal");
	    driver.switchTo().frame(0);
	    
	    // verify home page info
	    String str = "";
		try {
		      assertTrue(verify_fun.isElementPresent(By.id("logo"), driver));
		      assertTrue(verify_fun.isElementPresent(By.id("welcome"), driver));
		      assertTrue(verify_fun.isElementPresent(By.id("middle_col"), driver));
		      assertTrue(verify_fun.isElementPresent(By.id("right_col"), driver));
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
	        assertTrue(verify_fun.isElementPresent(By.xpath("//div[@id=\"quickLinks\"]"), driver));
	      } catch (Error e) {
	        str += e.toString();
	      }
	      try {
	        assertTrue(verify_fun.isElementPresent(By.xpath("//ul[@id=\"siteLinkList\"]"), driver));
	      } catch (Error e) {
	    	str += e.toString();
	      }
	      try {
	        assertTrue(verify_fun.isElementPresent(By.xpath("//div[@id=\"toolMenu\"]"), driver));
	      } catch (Error e) {
	    	str += e.toString();
	      }
	      try {
	        assertTrue(verify_fun.isElementPresent(By.xpath("//div[@id=\"siteTitle\"]"), driver));
	      } catch (Error e) {
	    	str += e.toString();
	      }
	      try {
	        assertTrue(verify_fun.isElementPresent(By.xpath("//div[@id=\"content\"]"), driver));
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
}
