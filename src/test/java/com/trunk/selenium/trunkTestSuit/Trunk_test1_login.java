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
  //private Help_verify verify_fun = new Help_verify();
  
  @Before
  public void setUp() throws Exception {
	driver = params.get_driver(driver);
    baseUrl = params.get_baseUrl();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testTrunkTest1() throws Exception {
	verificationErrors.append(login_key.login(baseUrl, driver));
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
