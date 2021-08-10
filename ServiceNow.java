package Sequencial_tesng_incident;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ServiceNow extends Baseclass {
@Test
	public void createNumber() throws InterruptedException {
		
	
	driver.findElementById("filter").sendKeys("incident");
	driver.findElementById("filter").sendKeys(Keys.ENTER);
	WebElement incident = driver.findElementByXPath("//div[text()='Incidents']");
	incident.click();
	driver.switchTo().frame("gsft_main");
	WebElement clickbut = driver.findElementByXPath("(//button[@type='submit'])[1]");
	clickbut.click();
	String inc1 = driver.findElementByXPath("//input[@id='incident.number']").getAttribute("value");
	System.out.println("Incident number: " + inc1);
	driver.findElementById("incident.short_description").sendKeys("Short description - TC001");
	driver.findElementByXPath("(//button[text()='Submit'])[2]").click();
	WebElement value = driver.findElementByXPath("(//input[@placeholder='Search'])[1]");
	value.sendKeys(inc1);
	value.sendKeys(Keys.ENTER);
	String inci2 = driver.findElementByClassName("vt").getText();
	System.out.println("Incident ID is"+inci2);
	if (inc1.equals(inci2)) {
		System.out.println("Created sucessfully");
		
	} else {
		System.out.println("Not Created sucessfully");

	}
	}
}
	
	