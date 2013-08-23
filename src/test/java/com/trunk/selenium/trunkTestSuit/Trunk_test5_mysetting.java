package com.trunk.selenium.trunkTestSuit;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
//import static org.hamcrest.CoreMatchers.*;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.Select;
//import java.util.regex.Pattern;

public class Trunk_test5_mysetting {
  private WebDriver driver;
  private String baseUrl;
  //private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private Trunk_testHelper key = new Trunk_testHelper();
  //private Test_helper logout_key = new Test_helper();
  //private Help_params params = new Help_params();
  //private Help_verify verify_fun = new Help_verify();
  
  @Before
  public void setUp() throws Exception {
	driver = key.get_driver(driver);
    baseUrl = key.get_baseUrl();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testTrunkTest5() throws Exception {
	verificationErrors.append(key.login(baseUrl, driver));
	// go to profile tab and test
    driver.findElement(By.cssSelector("a.icon-sakai-profile2 > span")).click();
    driver.switchTo().frame(0);
    driver.findElement(By.name("message")).clear();
    driver.findElement(By.name("message")).sendKeys(key.get_saysth_text());
    driver.findElement(By.name(":submit")).click();
    driver.findElement(By.cssSelector("a.icon.pictures > span")).click();
    driver.findElement(By.name("addPictureContainer:choosePicture_mf_0")).sendKeys(key.get_sample_jpg());
    driver.findElement(By.name("addPictureContainer:submitPicture")).click();
    driver.findElement(By.cssSelector("img")).click();
    driver.findElement(By.name("galleryImageEdit:galleryImageEditForm:galleryImageOptionsContainer:galleryImageRemoveButton")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (key.isElementPresent(By.name("galleryImageEdit:galleryImageEditForm:galleryRemoveImageConfirmContainer:galleryRemoveImageConfirmButton"), driver)) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }
    driver.findElement(By.name("galleryImageEdit:galleryImageEditForm:galleryRemoveImageConfirmContainer:galleryRemoveImageConfirmButton")).click();
    driver.findElement(By.cssSelector("a.icon.preferences > span")).click();
    driver.findElement(By.cssSelector("a.icon.privacy > span")).click();
    driver.switchTo().defaultContent();  // change back to parent frame 
    driver.findElement(By.cssSelector("a.icon-sakai-membership > span")).click();
    driver.switchTo().frame(0);
    driver.findElement(By.linkText("Joinable Sites")).click();
    driver.findElement(By.linkText("Join")).click();
    driver.findElement(By.linkText("My Current Sites")).click();
    driver.findElement(By.id("check-2")).click();
    driver.findElement(By.name("eventSubmit_doGoto_unjoinconfirm")).click();
    driver.findElement(By.name("eventSubmit_doGoto_unjoinyes")).click();
    
    driver.switchTo().defaultContent();
    driver.findElement(By.cssSelector("a.icon-sakai-preferences > span")).click();
    driver.switchTo().frame(0);
    
    Thread.sleep(5000);
    driver.findElement(By.cssSelector("img[alt=\"Move selected\"]")).click();
    driver.findElement(By.cssSelector("img[alt=\"Remove all\"]")).click();
    driver.switchTo().defaultContent();
    driver.findElement(By.cssSelector("a.icon-sakai-singleuser > span")).click();
    driver.findElement(By.cssSelector("a.icon-sakai-sitesetup > span")).click();
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
