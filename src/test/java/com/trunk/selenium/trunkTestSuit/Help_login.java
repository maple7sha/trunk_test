package com.trunk.selenium.trunkTestSuit;

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
	public void login(String baseUrl, WebDriver driver) throws InterruptedException{
		/* lesson learned: must know to switch to the frame!!
		 interestingly, we have to make it re-login for the script to proceed */
	    driver.get(baseUrl + "/xsl-portal");
	    driver.switchTo().frame(0);
	    driver.findElement(By.id("eid")).clear();
	    driver.findElement(By.id("eid")).sendKeys("wrong uname");
	    driver.findElement(By.id("pw")).clear();
	    driver.findElement(By.id("pw")).sendKeys("wrong password");
	    driver.findElement(By.cssSelector("input[type=\"image\"]")).click();
	    
	    Thread.sleep(500);
	    // re-login
	    driver.findElement(By.id("eid")).sendKeys(getUname());
	    driver.findElement(By.id("pw")).sendKeys(getPword());
	    driver.findElement(By.id("submit")).click();
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


