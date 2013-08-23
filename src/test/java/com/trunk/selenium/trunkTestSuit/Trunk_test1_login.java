package com.trunk.selenium.trunkTestSuit;

import java.io.PrintStream;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
//import org.openqa.selenium.*;
//import java.util.regex.Pattern;
//import static org.hamcrest.CoreMatchers.*;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.Select;
//import com.gargoylesoftware.htmlunit.BrowserVersion;

public class Trunk_test1_login {
  //private WebDriver driver;
  private HtmlUnitDriver driver;
  private String baseUrl;
  private StringBuffer verificationErrors = new StringBuffer();
  private Trunk_testHelper key = new Trunk_testHelper();
  //private Test_helper logout_key = new Test_helper();
  //private Help_params params = new Help_params();
  //private Help_verify verify_fun = new Help_verify();
  //private boolean acceptNextAlert = true;
  
  @Before
  public void setUp() throws Exception {
	driver = key.get_driver(driver);
    baseUrl = key.get_baseUrl();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testTrunkTest1() throws Exception {
	verificationErrors.append(key.login(baseUrl, driver));
    verificationErrors.append(key.logout(driver));
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
