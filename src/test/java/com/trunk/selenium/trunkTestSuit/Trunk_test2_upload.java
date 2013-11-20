package com.trunk.selenium.trunkTestSuit;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.interactions.Actions;

public class Trunk_test2_upload {private HtmlUnitDriver driver;
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
  public void testTrunkTest2() throws Exception {
	verificationErrors.append(key.login(baseUrl, driver));
	// To verify the presence of menu elements of the webpage
    try {
      assertTrue(key.isElementPresent(By.xpath("//div[@id=\"quickLinks\"]"), driver));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertTrue(key.isElementPresent(By.xpath("//ul[@id=\"siteLinkList\"]"), driver));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertTrue(key.isElementPresent(By.xpath("//div[@id=\"toolMenu\"]"), driver));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertTrue(key.isElementPresent(By.xpath("//div[@id=\"siteTitle\"]"), driver));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertTrue(key.isElementPresent(By.xpath("//div[@id=\"content\"]"), driver));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    
    driver.findElement(By.xpath("(//span[contains(text(), 'Resources')])")).click();
    // Upload Files 
    driver.switchTo().frame(0);
    // Trigger the dropdown menu 
    Actions builder = new Actions(driver); 
    WebElement upload=driver.findElement(By.xpath("(//a[contains(text(), 'Upload Files')])"));
    WebElement menu=driver.findElement(By.xpath("(//li[contains(text(), 'Add')])"));
    builder.moveToElement(menu).build().perform();
    // have to click the menu after move to the right location!
    menu.click();              
    upload.click();
    // upload files 
    driver.findElement(By.id("content_0")).sendKeys(key.get_sample_txt());
    driver.findElement(By.id("description_0")).clear();
    driver.findElement(By.id("description_0")).sendKeys(key.get_uploadtxt_text());
    driver.findElement(By.id("newcopyright_0")).clear();
    driver.findElement(By.id("newcopyright_0")).sendKeys(key.get_cpright_text());
    driver.findElement(By.id("saveChanges")).click();
    
    // verify that files are there 
    try {
        assertTrue(key.isElementPresent(By.xpath("//a[contains(text(), 'sample.txt')]"), driver));
    } catch (Error e) {
        verificationErrors.append(e.toString());
    }    
    
    // delete all uploaded files 
    driver.findElement(By.id("selectall")).click();
    ((JavascriptExecutor)driver).executeScript("javascript:document.getElementById('sakai_action').value='doMultiItemDispatch';document.getElementById('rt_action').value='delete';document.getElementById('showForm').submit();");
    driver.findElement(By.name("eventSubmit_doFinalizeDelete")).click();
    driver.switchTo().defaultContent();
    
    // verify the files are deleted
    try {
        assertFalse(key.isElementPresent(By.xpath("//a[contains(text(), 'sample.txt')]"), driver));
    } catch (Error e) {
        verificationErrors.append(e.toString());
    }
    
    verificationErrors.append(key.logout(driver));
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      System.out.println(verificationErrorString);
      fail(verificationErrorString);
    }
  }
}

