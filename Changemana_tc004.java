package Changemana_seq;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Changemana_tc004 {
@Test
	public void changeTc004() {
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
		search.sendKeys("CHG0000015",Keys.ENTER);
		
		driver.findElementByXPath("//td[@class='vt']").click();
		driver.findElementById("sysverb_delete").click();
		driver.findElementById("ok_button").click();
		WebElement search1=driver.findElementByXPath("(//input[@placeholder='Search'])[1]");
		search1.sendKeys("CHG0000012",Keys.ENTER);
		String text = driver.findElementByXPath("//td[text()='No records to display']").getText();
		String text1="No records to display";
		if(text1.equals(text))
			System.out.println("Deleted Successfully");
		else
			System.out.println("Not Deleted Successfully");
		
	}

}
