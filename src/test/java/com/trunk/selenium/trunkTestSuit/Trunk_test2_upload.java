package com.trunk.selenium.trunkTestSuit;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
//import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.Select;
//import java.util.regex.Pattern;

public class Trunk_test2_upload {
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
  public void testTrunkTest2() throws Exception {
	verificationErrors.append(login_key.login(baseUrl, driver));
	/* To verify the presence of menu elements of the webpage */
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
    driver.findElement(By.xpath("(//span[contains(text(), 'Resources')])")).click();
    /* Upload Files */
    driver.switchTo().frame(0);
    /* Trigger the dropdown menu!!! */
    Actions builder = new Actions(driver); 
    WebElement upload=driver.findElement(By.xpath("(//a[contains(text(), 'Upload Files')])"));
    WebElement menu=driver.findElement(By.xpath("(//li[contains(text(), 'Add')])"));
    builder.moveToElement(menu).build().perform();
    // have to click the menu after move to the right location!
    menu.click();              
    // Thread.sleep(2000);
    upload.click();
    
    //((JavascriptExecutor)driver).executeScript("javascript:document.getElementById('selectedItemId').value='/user/5005cc99-5e90-40d1-a623-2bf36885f5a9/';document.getElementById('rt_action').value='org.sakaiproject.content.types.fileUpload:create';document.getElementById('sakai_action').value='doDispatchAction';submitform('showForm');");        
    driver.findElement(By.id("content_0")).sendKeys(params.get_sample_txt());
    driver.findElement(By.id("description_0")).clear();
    driver.findElement(By.id("description_0")).sendKeys(params.get_uploadtxt_text());
    driver.findElement(By.id("newcopyright_0")).clear();
    driver.findElement(By.id("newcopyright_0")).sendKeys(params.get_cpright_text());
    driver.findElement(By.id("saveChanges")).click();
    /* Delete all uploaded files */
    driver.findElement(By.id("selectall")).click();
    
    ((JavascriptExecutor)driver).executeScript("javascript:document.getElementById('sakai_action').value='doMultiItemDispatch';document.getElementById('rt_action').value='delete';document.getElementById('showForm').submit();");
    driver.findElement(By.name("eventSubmit_doFinalizeDelete")).click();
    driver.switchTo().defaultContent();
    verificationErrors.append(logout_key.logout(driver));
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


// following code can be added to enrich the test cases
/**
driver.findElement(By.cssSelector("#9996 > img.dropdn")).click();
driver.findElement(By.linkText("Duplicate")).click();
driver.findElement(By.cssSelector("#9994 > img.dropdn")).click();
driver.findElement(By.xpath("(//a[contains(text(),'Move')])[3]")).click();
driver.findElement(By.cssSelector("#9996 > img.dropdn")).click();
driver.findElement(By.cssSelector("#9996 > img.dropdn")).click();
driver.findElement(By.id("bottompadding")).click();
driver.findElement(By.id("list3")).click();
driver.findElement(By.id("move-button")).click();
driver.findElement(By.id("list2")).click();
driver.findElement(By.id("copy-button")).click();
driver.findElement(By.id("menu-9998")).click();
driver.findElement(By.cssSelector("#9998 > img.dropdn")).click();
driver.findElement(By.xpath("//form[@id='showForm']/table/tbody/tr[2]/td[6]/ul")).click();
driver.findElement(By.cssSelector("#9998 > img.dropdn")).click();
driver.findElement(By.linkText("Reorder")).click();
driver.findElement(By.id("save")).click();
driver.findElement(By.xpath("(//a[contains(text(),'Edit Details')])[3]")).click();
driver.findElement(By.id("description_0")).clear();
driver.findElement(By.id("description_0")).sendKeys("this is a sample upload---detail edited");
driver.findElement(By.id("changeMimetype_0")).click();
new Select(driver.findElement(By.id("mime_category_0"))).selectByVisibleText("graphics");
new Select(driver.findElement(By.id("mime_category_0"))).selectByVisibleText("audio");
new Select(driver.findElement(By.id("mime_subtype_0"))).selectByVisibleText("mp3");
driver.findElement(By.id("finish_button")).click();
driver.findElement(By.xpath("(//a[contains(text(),'Upload New Version')])[2]")).click();
driver.findElement(By.id("content")).clear();
driver.findElement(By.id("content")).sendKeys("C:\\sample.txt");
driver.findElement(By.id("saveChanges")).click();
driver.findElement(By.xpath("(//a[contains(text(),'Move')])[3]")).click();
driver.findElement(By.xpath("(//a[contains(text(),'Remove')])[2]")).click();
driver.findElement(By.name("eventSubmit_doFinalizeDelete")).click();
driver.findElement(By.xpath("(//a[contains(text(),'Remove')])[2]")).click();
driver.findElement(By.name("eventSubmit_doFinalizeDelete")).click();
**/