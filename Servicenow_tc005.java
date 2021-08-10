package Sequencial_tesng_incident;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Servicenow_tc005 {
@Test
	public void tc005_service() throws InterruptedException {
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
		Thread.sleep(3000);
		WebElement incident = driver.findElementByXPath("//div[text()='Incidents']");
		incident.click();
		driver.switchTo().frame("gsft_main");
		WebElement search =driver.findElementByXPath("(//input[@placeholder='Search'])[1]");
		search.sendKeys("INC0010870");
		search.sendKeys(Keys.ENTER);
		
		driver.findElementByXPath("//td[@class='vt']").click();
		driver.findElementById("sysverb_delete").click();
		driver.findElementById("ok_button").click();
		System.out.println("Incident deleted sucessfully");
		

	}

}
