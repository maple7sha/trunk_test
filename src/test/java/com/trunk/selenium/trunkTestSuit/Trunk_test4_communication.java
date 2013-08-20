package com.trunk.selenium.trunkTestSuit;

//import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
//import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Trunk_test4_communication {
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
  public void testTrunkTest4() throws Exception {
	login_key.login(baseUrl, driver);

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
