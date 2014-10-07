package com.trunk.selenium.trunkTestSuit;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.interactions.Actions;

//import org.apache.commons.logging.LogFactory;


public class Trunk_test3_tuftsNow {
  private HtmlUnitDriver driver;
  private String baseUrl;
  private StringBuffer verificationErrors = new StringBuffer();
  private Trunk_testHelper key = new Trunk_testHelper();
  
  @Before
  public void setUp() throws Exception {
	driver = key.get_driver(driver);
    baseUrl = key.get_baseUrl();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testTrunkTest3() throws Exception {
    String str = "";
	verificationErrors.append(key.login(baseUrl, driver));
	driver.findElement(By.xpath("(//span[contains(text(), 'Tufts Now')])")).click();
	// got to switch to outer frame first, then switch to inner frame
	
    driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[contains(text(), '')])")));
    //driver.switchTo().frame(driver.findElement(By.id("id92aad4ec_6d34_48c1_956f_03ce02da9145")));
    
    try {
      assertTrue(driver.findElements(By.className("js")) != null);
    } catch (Error e) {
      str += e.toString() + " Tufts Now iframe not present \n";
    }
    
    //driver.switchTo().frame(0);
    verificationErrors.append(str);
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
