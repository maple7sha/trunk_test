package com.trunk.selenium.trunkTestSuit;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
//import java.util.regex.Pattern;
//import static org.hamcrest.CoreMatchers.*;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class Trunk_test4_communication {
  private WebDriver driver;
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
  public void testTrunkTest4() throws Exception {
	verificationErrors.append(key.login(baseUrl, driver));

    driver.findElement(By.cssSelector("a.icon-sakai-announcements > span")).click();
    driver.findElement(By.cssSelector("a.icon-sakai-schedule > span")).click();
    driver.switchTo().frame(0);
    driver.findElement(By.linkText("Add")).click();
    driver.findElement(By.id("activitytitle")).clear();
    driver.findElement(By.id("activitytitle")).sendKeys("new event");
    new Select(driver.findElement(By.id("startHour"))).selectByVisibleText("1");
    new Select(driver.findElement(By.id("yearSelect"))).selectByVisibleText("2017");
    driver.findElement(By.name("eventSubmit_doAdd")).click();
    driver.findElement(By.linkText("Merge")).click();
    driver.findElement(By.name("eventSubmit_doUpdate")).click();
    driver.findElement(By.linkText("Fields")).click();
    driver.findElement(By.name("eventSubmit_doUpdate")).click();
    driver.findElement(By.linkText("Permissions")).click();
    driver.findElement(By.name("eventSubmit_doSave")).click();
    driver.findElement(By.linkText("new event")).click();
    driver.findElement(By.name("eventSubmit_doDelete")).click();
    driver.findElement(By.name("eventSubmit_doConfirm")).click();
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
