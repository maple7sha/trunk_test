package com.trunk.selenium.trunkTestSuit;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Trunk_test5_mysetting {
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
  public void testTrunkTest5() throws Exception {
	login_key.login(baseUrl, driver);
	  
    driver.get(baseUrl + "/xsl-portal/site/%7E%40haowan/page/27a5411e-741f-4e3b-a5ca-59f8092f6993");
    driver.findElement(By.cssSelector("a.icon-sakai-profile2 > span")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | Main23db53f0x04b0x4048xab5fx6d7c76d1adc9 | ]]
    driver.findElement(By.name("message")).clear();
    driver.findElement(By.name("message")).sendKeys("say something");
    driver.findElement(By.name(":submit")).click();
    driver.findElement(By.cssSelector("a.icon.pictures > span")).click();
    driver.findElement(By.name("addPictureContainer:choosePicture_mf_0")).clear();
    driver.findElement(By.name("addPictureContainer:choosePicture_mf_0")).sendKeys("C:\\sample.jpg");
    driver.findElement(By.name("addPictureContainer:submitPicture")).click();
    driver.findElement(By.cssSelector("img")).click();
    driver.findElement(By.name("galleryImageEdit:galleryImageEditForm:galleryImageOptionsContainer:galleryImageRemoveButton")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.name("galleryImageEdit:galleryImageEditForm:galleryRemoveImageConfirmContainer:galleryRemoveImageConfirmButton"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.name("galleryImageEdit:galleryImageEditForm:galleryRemoveImageConfirmContainer:galleryRemoveImageConfirmButton")).click();
    driver.findElement(By.cssSelector("a.icon.preferences > span")).click();
    driver.findElement(By.cssSelector("a.icon.privacy > span")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | relative=up | ]]
    driver.findElement(By.cssSelector("a.icon-sakai-membership > span")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | Main6b5dd637x01fbx42ffx86bex4a1145c88515 | ]]
    driver.findElement(By.linkText("Joinable Sites")).click();
    driver.findElement(By.linkText("Join")).click();
    driver.findElement(By.linkText("My Current Sites")).click();
    driver.findElement(By.id("check-2")).click();
    driver.findElement(By.name("eventSubmit_doGoto_unjoinconfirm")).click();
    driver.findElement(By.name("eventSubmit_doGoto_unjoinyes")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | relative=up | ]]
    driver.findElement(By.cssSelector("a.icon-sakai-preferences > span")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | Main82343889x1968x44ecx8d79x35c9d6badb4f | ]]
    // ERROR: Caught exception [ERROR: Unsupported command [addSelection | name=prefs_form:_id35 | label=1st Year Portfolio]]
    driver.findElement(By.cssSelector("img[alt=\"Move selected\"]")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [addSelection | name=prefs_form:_id43 | label=1st Year Portfolio]]
    driver.findElement(By.cssSelector("img[alt=\"Remove all\"]")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | relative=up | ]]
    driver.findElement(By.cssSelector("a.icon-sakai-singleuser > span")).click();
    driver.findElement(By.cssSelector("a.icon-sakai-sitesetup > span")).click();
    driver.findElement(By.linkText("Logout")).click();
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
