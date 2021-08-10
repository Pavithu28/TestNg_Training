package Changemana_seq;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Changemana_tc001 {
@Test(dataProvider="sendData")
	public void changeTc001(String des) {
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
			driver.findElementByXPath("(//div[text()='Create New'])[3]").click();
		    driver.switchTo().frame("gsft_main");
		    driver.findElementByXPath("//div[@uib-tooltip='ITIL Mode 1 Normal Change']").click();
		      
		    String chanum= driver.findElementById("change_request.number").getAttribute("value");
		    System.out.println(chanum);
		     
		    driver.findElementByXPath("//input[@id='change_request.short_description']").sendKeys(des);
		    driver.findElementById("sysverb_insert_bottom").click();
		    driver.switchTo().defaultContent();
		    driver.findElementByXPath("(//div[text()='Open'])[3]").click();
		    driver.switchTo().frame("gsft_main");
		    WebElement search=driver.findElementByXPath("(//input[@placeholder='Search'])[1]");
		   search.sendKeys(chanum,Keys.ENTER);
		   String actual= driver.findElementByXPath("(//td[@class='vt'])[2]").getText();
		    System.out.println(actual);
		    String exp="change request is send";
		    if(actual.equals(exp)) {
		    	 System.out.println("Changes description done successfully");
		     }
		    else {
		    	 System.out.println("Changes description is not done successfully");
		     }
		      
}  

 @DataProvider			
public String[][] sendData()
{
	String[][] data=new String[1][1];
	data[0][0]="change request is send";
	return data;
}
}
		

