package Changemana_seq;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Changemana_tc003 {
@Test
	public void changeTc003() {
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
		search.sendKeys("CHG0000013",Keys.ENTER);
		driver.findElementByXPath("//td[@class='vt']").click();
		driver.findElementByXPath("//span[text()='Schedule']").click();
		driver.findElementById("change_request.start_date.ui_policy_sensitive").click();
		driver.findElementByXPath("//button[contains(@class,'icon-check-circle btn')]").click();
		driver.findElementById("change_request.end_date.ui_policy_sensitive").click();
		driver.findElementByXPath("//button[contains(@class,'icon-check-circle btn')]").click();
		driver.findElementById("label.ni.change_request.cab_required").click();
		driver.findElementById("change_request.cab_date.ui_policy_sensitive").click();
		driver.findElementByXPath("//td[text()='Go to Today']").click();
		driver.findElementById("sysverb_update_bottom");
		
	
	
	}

}
