package Sequencial_tesng_incident;


import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Servicenow_tc003 {
@Test
	public void tc003_Service() throws InterruptedException {
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
		
		driver.findElementByXPath("(//div[text() ='Open'])[1]").click();
		driver.switchTo().frame("gsft_main");
		//search for incident
		driver.findElementByXPath("(//input[@class='form-control'])[1]").sendKeys("INC0000013", Keys.ENTER);
		Thread.sleep(3000);
		driver.findElementByXPath("//td[@class='vt']").click();
		
		driver.findElementById("lookup.incident.assignment_group").click();
		Set<String> windowHandles = driver.getWindowHandles();
		ArrayList<String> listHandle = new ArrayList<String>(windowHandles);
		String secondHandle = listHandle.get(1);
		driver.switchTo().window(secondHandle);
		driver.findElementByXPath("//span[text()='Press Enter from within the input to submit the search.']/following::input").sendKeys("Software",Keys.ENTER);
		driver.findElementByXPath("//a[text()='Software']").click();
		driver.switchTo().window(listHandle.get(0));
		driver.switchTo().frame("gsft_main");
		String group = driver.findElementById("sys_display.incident.assignment_group").getAttribute("value");
		
    driver.findElementById("lookup.incident.assigned_to").click();
    Set<String> windows_itil=driver.getWindowHandles();
    ArrayList<String> listConversion1=new ArrayList<String>(windows_itil);
    driver.switchTo().window(listConversion1.get(1));
    driver.findElementByLinkText("ITIL User").click();	
    driver.findElementByXPath("//span[text()='Press Enter from within the input to submit the search.']/following::input").sendKeys("ITIL",Keys.ENTER);
    driver.findElementByXPath("//a[text()='ITIL User']").click();
    driver.switchTo().window(listHandle.get(0));
	driver.switchTo().frame("gsft_main");
	String itil = driver.findElementById("sys_display.incident.assigned_to").getAttribute("value");
	driver.findElementById("sysverb_update_bottom").click();
	String to = driver.findElementByLinkText("Software").getText();
	String to1 = driver.findElementByLinkText("ITIL User").getText();
	if((group.equals(to))&&(itil.equals(to1)))
	{
	System.out.println("Updated Successfuly");
	}
	else
		System.out.println("Not Updated successfully");
	
	}

}
