package Sequencial_tesng_incident;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNow_tc002 {
@Test
	public void tc002_Servicenow() throws InterruptedException {
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
		Thread.sleep(3000);
		WebElement incident = driver.findElementByXPath("//div[text()='Incidents']");
		incident.click();
		driver.switchTo().frame("gsft_main");
		WebElement search =driver.findElementByXPath("(//input[@placeholder='Search'])[1]");
		search.sendKeys("INC0010870");
		search.sendKeys(Keys.ENTER);
		driver.findElementByXPath("//td[@class='vt']").click();
	driver.findElementById("incident.short_description").clear();
	driver.findElementById("incident.short_description").sendKeys("Invoice error for  Customer");
	WebElement Source = driver.findElementById("incident.urgency");
    Select dd1=new Select(Source);
    dd1.selectByIndex(0);
    WebElement Source1 = driver.findElementById("incident.state");
    Select dd2=new Select(Source1);
    dd2.selectByIndex(1);
    Thread.sleep(3000);
    driver.findElementById("sysverb_update_bottom").click();
    System.out.println("Status Changed sucessfully");
    //driver.switchTo().frame("gsft_main");
    driver.findElementByXPath("//*[@id=\"b55fbec4c0a800090088e83d7ff500de\"]/div/div").click();
	WebElement search1 =driver.findElementByXPath("(//input[@placeholder='Search'])[1]");
	search1.sendKeys("INC0010870");
	search1.sendKeys(Keys.ENTER);
	driver.findElementByXPath("//a[@class='linked formlink']").click();
	String text = driver.findElementByXPath("//*[@id=\"incident.priority\"]/option[4]").getText();
	if("3-Moderate".equals(text))
	{
	System.out.println("priority also updated");
	}
		//how to check the priority status	
		

		
		
	}
		
	}


