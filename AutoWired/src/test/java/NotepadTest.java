import java.net.URL;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.windows.WindowsDriver;

public class NotepadTest {
	private static WindowsDriver  notepadSession = null;
	public static String getDate(){
	 LocalDate date = LocalDate.now();
	 return date.toString();
	 }
	
	@BeforeClass
	 public static void setUp() {
	 try {
	 DesiredCapabilities capabilities = new DesiredCapabilities();
	 capabilities.setCapability("app", "C:\\Windows\\System32\\notepad.exe");
	 capabilities.setCapability("platformName","Windows 10");
	 capabilities.setCapability("deviceName", "LAPTOP-PJV4T4TI");
	 notepadSession  = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
	 notepadSession.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	} catch (Exception e) {
	 e.printStackTrace();
	  }
	 }
	
	@AfterMethod
	 public void cleanApp(){
	 notepadSession.quit();
	 setUp();
	 }
	
	@AfterSuite
	 public void tearDown(){
	 notepadSession.quit();
	 }
	
	@Test
	 public void checkAboutWindow() {
	 notepadSession.findElementByName("Help").click();
	 notepadSession.findElementByName("About Notepad").click();
	 notepadSession.findElementByName("OK").click();
	 }
	
//	@Test
//	 public void sendTestText(){
//	 notepadSession.findElementByName("Edit").sendKeys(getDate());
//
//	 notepadSession.findElementByName("Edit").clear();
//	 }
//	
//	
//	@Test()
//	 public void pressTimeAndDateButton(){
//		notepadSession.findElementByName("Edit").click();
//		((WebElement) notepadSession.findElementsByAccessibilityId("26")).click();
//		Assert.assertNotNull(notepadSession.findElementByName("Edit"));
//		notepadSession.findElementByName("Edit").clear();
//	  }
	 }