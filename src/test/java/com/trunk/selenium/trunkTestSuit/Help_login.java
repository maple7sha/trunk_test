package com.trunk.selenium.trunkTestSuit;

import org.openqa.selenium.By;
import java.io.PrintStream;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Help_login {
	public void login(String baseUrl, WebDriver driver){
		// lesson learned: must know to switch to the frame!!
		
		// interestingly, we have to make it relogin for the script to proceed
	    driver.get(baseUrl + "/xsl-portal");
	    driver.switchTo().frame(0);
	    driver.findElement(By.id("eid")).clear();
	    driver.findElement(By.id("eid")).sendKeys("@haowan");
	    driver.findElement(By.id("pw")).clear();
	    driver.findElement(By.id("pw")).sendKeys("nawoah1");
	    driver.findElement(By.cssSelector("input[type=\"image\"]")).click();
	    driver.findElement(By.id("eid")).clear();
	    driver.findElement(By.id("eid")).sendKeys("@haowan");
	    driver.findElement(By.id("pw")).clear();
	    driver.findElement(By.id("pw")).sendKeys("nawoah");
	    driver.findElement(By.id("submit")).click();
	    
	}
}
