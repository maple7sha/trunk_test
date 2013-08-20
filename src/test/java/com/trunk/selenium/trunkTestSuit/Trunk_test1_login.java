package com.trunk.selenium.trunkTestSuit;

import java.io.PrintStream;
//import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
//import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.Select;

public class Trunk_test1_login {
  private WebDriver driver;
  private String baseUrl;
  //private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private Help_login login_key = new Help_login();
  private Help_logout logout_key = new Help_logout();
  private Help_params params = new Help_params();
  private Help_verify verify_fun = new Help_verify();
  
  @Before
  public void setUp() throws Exception {
	driver = params.get_driver(driver);
    baseUrl = params.get_baseUrl();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testTrunkTest1() throws Exception {
	login_key.login(baseUrl, driver);
    try {
      assertTrue(verify_fun.isElementPresent(By.xpath("//div[@id=\"quickLinks\"]"), driver));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertTrue(verify_fun.isElementPresent(By.xpath("//ul[@id=\"siteLinkList\"]"), driver));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertTrue(verify_fun.isElementPresent(By.xpath("//div[@id=\"toolMenu\"]"), driver));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertTrue(verify_fun.isElementPresent(By.xpath("//div[@id=\"siteTitle\"]"), driver));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertTrue(verify_fun.isElementPresent(By.xpath("//div[@id=\"content\"]"), driver));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Warning: verifyTextPresent may require manual changes
    try {
      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*My Workspace[\\s\\S]*$"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Warning: verifyTextPresent may require manual changes
    try {
      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Home[\\s\\S]*$"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Warning: verifyTextPresent may require manual changes
    try {
      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*My Sites[\\s\\S]*$"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Warning: verifyTextPresent may require manual changes
    try {
      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Hello,[\\s\\S]*$"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Warning: verifyTextPresent may require manual changes
    try {
      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Logout[\\s\\S]*$"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Help[\\s\\S]*$"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    verificationErrors.append(logout_key.logout(driver));
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      PrintStream out = System.out;
      out.println(verificationErrorString);
      fail(verificationErrorString);
    }
  }
}
