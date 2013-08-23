package com.trunk.selenium.trunkTestSuit;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/* Logout and breakdown the whole code? */

public class Test_helper {
	private Help_verify verify_fun = new Help_verify();
	
	public String logout(WebDriver driver) {
		driver.findElement(By.cssSelector("a[title=\"Logout\"]")).click();
		
		driver.switchTo().frame(0);
		String str = "";
		try {
		      assertTrue(verify_fun.isElementPresent(By.id("logo"), driver));
		      assertTrue(verify_fun.isElementPresent(By.id("welcome"), driver));
		      assertTrue(verify_fun.isElementPresent(By.id("middle_col"), driver));
		      assertTrue(verify_fun.isElementPresent(By.id("right_col"), driver));
		} catch (Error e) {
		      str = e.toString();
		}
		return str;
	}
	
	
	
	
}
