package Changemana_seq;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Changemana_tc002 {
@Test
	public void change_tc002() {
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
		driver.findElementById("filter").sendKeys("Change");
		driver.findElementById("filter").sendKeys(Keys.ENTER);
		driver.findElementByXPath("(//div[text()='Open'])[3]").click();
		driver.switchTo().frame("gsft_main");
		WebElement search=driver.findElementByXPath("(//input[@placeholder='Search'])[1]");
		search.sendKeys("CHG0000012",Keys.ENTER);
		driver.findElementByXPath("//td[@class='vt']").click();
		
		WebElement ele = driver.findElementById("change_request.state");
		Select dd1=new Select(ele);
		dd1.selectByIndex(1);
		
		driver.findElementById("lookup.change_request.assignment_group").click();
		Set<String> windowHandles = driver.getWindowHandles();
		ArrayList<String> listHandle = new ArrayList<String>(windowHandles);
		String secondHandle = listHandle.get(1);
		driver.switchTo().window(secondHandle);
		driver.findElementByLinkText("Software").click();
		driver.switchTo().window(listHandle.get(0));
		driver.switchTo().frame("gsft_main");
		String group = driver.findElementById("sys_display.change_request.assignment_group").getAttribute("value");
		
		driver.findElementById("lookup.change_request.assigned_to").click();
		Set<String> windows_itil=driver.getWindowHandles();
	    ArrayList<String> listConversion1=new ArrayList<String>(windows_itil);
	    driver.switchTo().window(listConversion1.get(1));
	    driver.findElementByLinkText("ITIL User").click();
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,-350)", "");
	    driver.findElementById("sysverb_update_bottom").click();
	    driver.switchTo().window(listHandle.get(0));
		driver.switchTo().frame("gsft_main");
	    String itil = driver.findElementById("sys_display.change_request.assigned_to").getAttribute("value");
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


