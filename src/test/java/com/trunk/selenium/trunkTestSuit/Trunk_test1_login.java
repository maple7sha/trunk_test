package com.trunk.selenium.trunkTestSuit;

import java.io.PrintStream;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Trunk_test1_login {
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
  public void testTrunkTest1() throws Exception {
	System.out.print("start of the test \n");
	System.out.print(System.getProperty("user.supp"));
	System.out.print(System.getProperty("user.name"));
	System.out.print("end of the test \n");
	System.getProperties().list(System.out);
	System.exit(0);
	
	
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
