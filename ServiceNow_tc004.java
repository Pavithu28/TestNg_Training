package Sequencial_tesng_incident;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNow_tc004 {
@Test
	public static void tc004_Service() {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://dev113545.service-now.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.switchTo().frame("gsft_main");
		driver.findElementById("user_name").sendKeys("admin");
		driver.findElementById("user_password").sendKeys("m3GkKEKU8atr");
		driver.findElementById("sysverb_login").click();
		driver.findElementById("filter").sendKeys("incident");
		driver.findElementById("filter").sendKeys(Keys.ENTER);
		WebElement inci = driver.findElementByXPath("//div[text()='Incidents']");
		inci.click();
		driver.switchTo().frame("gsft_main");
			WebElement cli = driver.findElementByXPath("(//button[@type='submit'])[1]");
			cli.click();
			String incNo = driver.findElementByXPath("//input[@id='incident.number']").getAttribute("value");
			System.out.println("Incident number: " + incNo);
			driver.findElementById("incident.short_description").sendKeys("customer application issue");
			driver.findElementByXPath("(//button[text()='Submit'])[2]").click();
			WebElement value = driver.findElementByXPath("(//input[@placeholder='Search'])[1]");
	value.sendKeys(incNo);
	value.sendKeys(Keys.ENTER);
	driver.findElementByXPath("//td[@class='vt']").click();
	WebElement Source = driver.findElementById("incident.urgency");
    Select dropDown=new Select(Source);
    dropDown.selectByIndex(0);
    WebElement Source1 = driver.findElementById("incident.state");
    Select dropDown1=new Select(Source1);
    dropDown1.selectByIndex(1);
    driver.findElementById("resolve_incident_bottom").click();
	}
}