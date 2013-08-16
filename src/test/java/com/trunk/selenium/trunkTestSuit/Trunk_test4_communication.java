package com.trunk.selenium.trunkTestSuit;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Trunk_test4_communication {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  Help_login login_key = new Help_login();
  
  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://trunk-stage.tufts.edu/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testTrunkTest4() throws Exception {
	login_key.login(baseUrl, driver);
	  
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
    driver.get(baseUrl + "/xsl-portal/site/%7E%40haowan/page/fe0e955a-c1e3-42af-8ce3-0a06ceb12e9a");
    driver.findElement(By.cssSelector("a.icon-sakai-announcements > span")).click();
    driver.findElement(By.cssSelector("a.icon-sakai-schedule > span")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | Main55f9c3d7xd2aex4f42x84e4xe14f79917a8d | ]]
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
    driver.findElement(By.cssSelector("a[title=\"Logout\"]")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
