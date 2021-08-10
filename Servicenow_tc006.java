package Sequencial_tesng_incident;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

	public class Servicenow_tc006 extends Baseclass {
@Test	
		public void tc006_Service() {
			
			driver.findElementById("filter").sendKeys("incident");
			driver.findElementById("filter").sendKeys(Keys.ENTER);
			WebElement incident = driver.findElementByXPath("//div[text()='Incidents']");
			incident.click();
			driver.switchTo().frame("gsft_main");
				WebElement clickbut = driver.findElementByXPath("(//button[@type='submit'])[1]");
				clickbut.click();
				driver.findElementByXPath("(//button[text()='Submit'])[2]").click();
				driver.findElementById("sysverb_insert_bottom").click();
				
		}
	
}