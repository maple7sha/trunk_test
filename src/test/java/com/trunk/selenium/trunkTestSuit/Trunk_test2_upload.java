package com.trunk.selenium.trunkTestSuit;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Trunk_test2_upload {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://trunk-stage.tufts.edu/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void test2New() throws Exception {
    driver.get(baseUrl + "/xsl-portal");
    driver.switchTo().frame(0);
    driver.findElement(By.id("eid")).clear();
    driver.findElement(By.id("eid")).sendKeys("@haowan");
    driver.findElement(By.id("pw")).clear();
    driver.findElement(By.id("pw")).sendKeys("nawoah1");
    driver.findElement(By.cssSelector("input[type=\"image\"]")).click();
    driver.findElement(By.id("eid")).clear();
    driver.findElement(By.id("eid")).sendKeys("@haowan");
    driver.findElement(By.id("pw")).clear();
    driver.findElement(By.id("pw")).sendKeys("nawoah");
    driver.findElement(By.id("submit")).click();
    try {
      assertTrue(isElementPresent(By.xpath("//div[@id=\"quickLinks\"]")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertTrue(isElementPresent(By.xpath("//ul[@id=\"siteLinkList\"]")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertTrue(isElementPresent(By.xpath("//div[@id=\"toolMenu\"]")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertTrue(isElementPresent(By.xpath("//div[@id=\"siteTitle\"]")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertTrue(isElementPresent(By.xpath("//div[@id=\"content\"]")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Warning: verifyTextPresent may require manual changes
    try {
      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*My Workspace[\\s\\S]*$"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Warning: verifyTextPresent may require manual changes
    try {
      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Home[\\s\\S]*$"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Warning: verifyTextPresent may require manual changes
    try {
      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*My Sites[\\s\\S]*$"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Warning: verifyTextPresent may require manual changes
    try {
      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Hello,[\\s\\S]*$"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Warning: verifyTextPresent may require manual changes
    try {
      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Logout[\\s\\S]*$"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Warning: verifyTextPresent may require manual changes
    try {
      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*My Communications[\\s\\S]*$"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Warning: verifyTextPresent may require manual changes
    try {
      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*My Tools[\\s\\S]*$"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Warning: verifyTextPresent may require manual changes
    try {
      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*My Settings[\\s\\S]*$"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Warning: verifyTextPresent may require manual changes
    try {
      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Help[\\s\\S]*$"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.cssSelector("a.icon-sakai-resources > span")).click();
    
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | Main281860a9xec2ex48c6xb231xf4128c8c726f | ]]
    // problem here! how to select the file there?
    driver.findElement(By.linkText("Upload Files")).click();
    driver.findElement(By.id("content_0")).clear();
    driver.findElement(By.id("content_0")).sendKeys("C:\\sample.txt");
    driver.findElement(By.id("description_0")).clear();
    driver.findElement(By.id("description_0")).sendKeys("this is a sample upload");
    new Select(driver.findElement(By.id("copyright_0"))).selectByVisibleText("I hold copyright.");
    driver.findElement(By.id("saveChanges")).click();
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
