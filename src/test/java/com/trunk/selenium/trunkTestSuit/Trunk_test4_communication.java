package com.trunk.selenium.trunkTestSuit;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;

public class Trunk_test4_communication {
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
  public void testTrunkTest4() throws Exception {
	verificationErrors.append(key.login(baseUrl, driver));
	driver.findElement(By.xpath("(//span[contains(text(), 'Announcements')])")).click();
    driver.findElement(By.xpath("(//span[contains(text(), 'Calendar')])")).click();
    driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[contains(text(), '')])")));
    driver.findElement(By.xpath("(//a[contains(text(), 'Add')])")).click();
    driver.findElement(By.cssSelector("input[name=\"eventSubmit_doCancel\"]")).sendKeys(Keys.RETURN);

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
