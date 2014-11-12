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

public class Trunk_test5_mysetting {
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
  public void testTrunkTest5() throws Exception {
	verificationErrors.append(key.login(baseUrl, driver));
    driver.findElement(By.xpath("(//span[contains(text(), 'Profile2')])")).click();
    driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[contains(text(), '')])")));
    //driver.findElement(By.xpath("(//span[contains(text(), 'Calendar')])")).click();
    //driver.findElement(By.xpath("(//a[contains(text(), 'Add')])")).click();
    //driver.findElement(By.cssSelector("input[name=\"eventSubmit_doCancel\"]")).sendKeys(Keys.RETURN);    
    
    // test adding new message
    driver.findElement(By.name("message")).clear();
    driver.findElement(By.name("message")).sendKeys(key.get_saysth_text());
    driver.findElement(By.name(":submit")).click();
    // test adding & removing pictures
    driver.findElement(By.cssSelector("a.icon.pictures > span")).click();
    driver.findElement(By.name("addPictureContainer:choosePicture_mf_0")).sendKeys(key.get_sample_jpg());
    driver.findElement(By.name("addPictureContainer:submitPicture")).click();
    
    driver.findElement(By.cssSelector("a.icon.preferences > span")).click();
    driver.findElement(By.cssSelector("a.icon.privacy > span")).click();
      
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
