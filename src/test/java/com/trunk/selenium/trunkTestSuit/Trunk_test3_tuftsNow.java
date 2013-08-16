package com.trunk.selenium.trunkTestSuit;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Trunk_test3_tuftsNow {
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
  public void testTrunkTest3() throws Exception {
	login_key.login(baseUrl, driver);

	driver.findElement(By.xpath("(//span[contains(text(), 'Tufts Now')])")).click();   
	
    //driver.switchTo().frame(1);
    driver.findElement(By.id("menu-965")).click();
    driver.findElement(By.id("menu-980")).click();
    driver.findElement(By.id("edit-keys")).clear();
    driver.findElement(By.id("edit-keys")).sendKeys("what is this");
    driver.findElement(By.id("edit-submit")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | relative=up | ]]
    driver.findElement(By.linkText("Options")).click();
    new Select(driver.findElement(By.id("height"))).selectByVisibleText("750 pixels");
    //driver.findElement(By.name("eventSubmit_doConfigure_update")).click();
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
