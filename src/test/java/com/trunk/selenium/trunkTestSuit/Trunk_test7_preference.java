package com.trunk.selenium.trunkTestSuit;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
//import static org.hamcrest.CoreMatchers.*;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.Select;
//import java.util.regex.Pattern;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Trunk_test7_preference{
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
  public void testTrunkTest7() throws Exception {
	verificationErrors.append(key.login(baseUrl, driver));
    driver.findElement(By.className("icon-sakai-preferences")).click();
    //driver.findElement(By.xpath("(//li[contains(text(), 'Preferences')])")).click();
    
    driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[contains(text(), '')])")));

    Thread.sleep(5000);
    driver.findElement(By.cssSelector("img[alt=\"Move selected\"]")).click();
    driver.switchTo().defaultContent();
    driver.findElement(By.id("prefs_form:submit")).click();
    driver.findElement(By.id("prefs_form:cancel")).click();

    driver.switchTo().defaultContent();
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
