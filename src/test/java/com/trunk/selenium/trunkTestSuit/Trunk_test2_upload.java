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
    
    driver.findElement(By.xpath("(//span[contains(text(), 'Resources')])")).click();    
    driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[contains(text(), '')])")));
    
    // Handle hidden menus
    Actions builder = new Actions(driver); 
    
    
    /*
    try {
        assertTrue(key.isElementPresent(By.className("menuOpen"), driver));
    } catch (Error e) {
        String err= e.toString() + "Cannot find Add menu \n";
        verificationErrors.append(err);
    }  
    driver.findElement(By.className("menuOpen")).click();
    

    */
    //WebElement menu = driver.findElement(By.className("menuOpen"));
    WebElement menu=driver.findElement(By.xpath("(//li[contains(text(), 'Add')])"));
    WebElement upload=driver.findElement(By.xpath("(//a[contains(text(), 'Upload Files')])"));
    builder.moveToElement(menu).click().build().perform();
    try {
        assertTrue(key.isElementPresent(By.xpath("(//a[contains(text(), 'Upload Files')])"), driver));
    } catch (Error e) {
        String err= e.toString() + "\n Cannot find Upload Files button in menu \n";
        verificationErrors.append(err);
    }  
    builder.moveToElement(upload).click().build().perform();
    // have to click the menu after move to the right location!
    

    //driver.findElement(By.xpath("(//a[contains(text(), 'Upload Files')])")).click();
    //builder.moveToElement(upload).build().perform();
  
    Thread.sleep(5000);
    
    
    
    try {
        assertTrue(key.isElementPresent(By.xpath("(//a[contains(text(), 'Upload Files Now')])"), driver));
    } catch (Error e) {
        String err= e.toString() + "\n Upload files now not present \n";
        verificationErrors.append(err);
    }    
    
    // upload files 
    driver.findElement(By.id("content_0")).sendKeys(key.get_sample_txt());
    driver.findElement(By.id("saveChanges")).submit();
  
    String xpath_to_txtaddr = String.format("//a[contains(text(), '%s')]", key.get_sample_txt());
    // verify that files are there 
    try {
        assertTrue(key.isElementPresent(By.xpath("(//a[contains(text(), 'sample.txt')])"), driver));
    } catch (Error e) {
        String err= e.toString() + "\n Uploaded text not present\n";
        verificationErrors.append(err);
    }    
    
 /*   // delete all uploaded files 
    driver.findElement(By.id("selectall")).click();
    ((JavascriptExecutor)driver).executeScript("javascript:document.getElementById('sakai_action').value='doMultiItemDispatch';document.getElementById('rt_action').value='delete';document.getElementById('showForm').submit();");
    driver.findElement(By.name("eventSubmit_doFinalizeDelete")).click();
    driver.switchTo().defaultContent();
    
    // verify the files are deleted
    if(key.isElementPresent(By.xpath(xpath_to_txtaddr), driver)){
    	Thread.sleep(3000);
    }
    if(key.isElementPresent(By.xpath(xpath_to_txtaddr), driver)){
    	verificationErrors.append("\n line 88, Trunk_test2_upload, program should deleted all uploaded files \n");
    }
  */
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

