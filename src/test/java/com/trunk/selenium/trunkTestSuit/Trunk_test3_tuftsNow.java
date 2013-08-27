package com.trunk.selenium.trunkTestSuit;

import java.util.concurrent.TimeUnit;
//import java.util.logging.Level;
//import java.util.logging.Logger;

//import org.apache.commons.logging.LogFactory;
import org.junit.*;
import static org.junit.Assert.*;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;
//import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.*;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import java.util.regex.Pattern;
//import static org.hamcrest.CoreMatchers.*;

//import com.gargoylesoftware.htmlunit.BrowserVersion;

public class Trunk_test3_tuftsNow {
  private HtmlUnitDriver driver;
  private String baseUrl;
  //private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private Trunk_testHelper key = new Trunk_testHelper();
  //private Test_helper logout_key = new Test_helper();
  //private Help_params params = new Help_params();
  
  @Before
  public void setUp() throws Exception {
	driver = key.get_driver(driver);
    baseUrl = key.get_baseUrl();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testTrunkTest3() throws Exception {
	  

	    
	verificationErrors.append(key.login(baseUrl, driver));
	driver.findElement(By.xpath("(//span[contains(text(), 'Tufts Now')])")).click();
	// got to switch to outer frame first, then switch to inner frame!!!!!
	
	driver.switchTo().frame(0);
	driver.switchTo().frame(driver.findElement(By.id("wciframe")));
    driver.findElement(By.id("menu-965")).click();
    driver.findElement(By.id("menu-980")).click();
    driver.findElement(By.id("edit-keys")).clear();
    driver.findElement(By.id("edit-keys")).sendKeys(key.get_search_text());
    driver.findElement(By.id("edit-submit")).click();
    
    //driver.switchTo().defaultContent();
    //driver.switchTo().frame(0);
    //driver.findElement(By.linkText("Options")).click();
    // Thread.sleep(3000);  // wait 500ms to ensure proper loading before proceeding to next check
    // driver.switchTo().frame(driver.findElement(By.id("Main92aad4ecx6d34x48c1x956fx03ce02da9145")));
    // (By.xpath("(//li[contains(text(), 'Add')])")	
    //new Select(driver.findElement(By.id("height"))).selectByVisibleText("750 pixels");
    //driver.findElement(By.name("eventSubmit_doConfigure_update")).click();
    // driver.switchTo().frame(0);
    // driver.switchTo().frame(driver.findElement(By.id("wciframe")));
	//driver.switchTo().frame(0);
    //driver.findElement(By.linkText("Options")).click();
    //driver.findElement(By.name("eventSubmit_doConfigure_update")).click();
    
    
    verificationErrors.append(key.logout(driver));
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
}
