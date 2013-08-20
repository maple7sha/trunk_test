package com.trunk.selenium.trunkTestSuit;

//import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
//import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Trunk_test3_tuftsNow {
  private WebDriver driver;
  private String baseUrl;
  //private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private Help_login login_key = new Help_login();
  private Help_logout logout_key = new Help_logout();
  private Help_params params = new Help_params();
  
  @Before
  public void setUp() throws Exception {
	  driver = params.get_driver(driver);
    baseUrl = params.get_baseUrl();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testTrunkTest3() throws Exception {
	verificationErrors.append(login_key.login(baseUrl, driver));

	driver.findElement(By.xpath("(//span[contains(text(), 'Tufts Now')])")).click();
	// got to switch to outer frame first, then switch to inner frame!!!!!
	driver.switchTo().frame(0);
    driver.findElement(By.linkText("Options")).click();
    new Select(driver.findElement(By.id("height"))).selectByVisibleText("750 pixels");
    driver.findElement(By.name("eventSubmit_doConfigure_update")).click();
    driver.switchTo().frame(0);
    driver.switchTo().frame(driver.findElement(By.id("wciframe")));
    driver.findElement(By.id("menu-965")).click();
    driver.findElement(By.id("menu-980")).click();
    driver.findElement(By.id("edit-keys")).clear();
    driver.findElement(By.id("edit-keys")).sendKeys(params.get_search_text());
    driver.findElement(By.id("edit-submit")).click();
    
    verificationErrors.append(logout_key.logout(driver));
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
