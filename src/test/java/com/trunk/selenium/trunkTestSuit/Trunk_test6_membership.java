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

public class Trunk_test6_membership{
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
  public void testTrunkTest6() throws Exception {
	verificationErrors.append(key.login(baseUrl, driver));
    driver.findElement(By.xpath("(//span[contains(text(), 'Membership')])")).click();
    driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[contains(text(), '')])")));
    driver.findElement(By.linkText("Joinable Sites")).click();
    driver.findElement(By.linkText("Join")).click();
    driver.findElement(By.linkText("My Current Sites")).click();
    driver.findElement(By.id("check-1")).click();
    driver.findElement(By.name("eventSubmit_doGoto_unjoinconfirm")).click();
    driver.findElement(By.name("eventSubmit_doGoto_unjoinyes")).click();
    
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
