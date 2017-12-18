package dropdown;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class BootStrapDropDown {
	
	static WebDriver driver;
	
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver","C:/seleniumIO/Selenium_Jars/chromedriver.exe" );
		driver = new ChromeDriver();
		driver.navigate().to("https://www.w3schools.com/bootstrap/bootstrap_dropdowns.asp");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
	}

	@Test
	public void BootdropdownTest() {
	
	driver.findElement(By.id("menu1")).click();	
	
	List<WebElement> drop_Down_btn = driver.findElements(By.xpath("//*[@id='main']/div[3]/ul[1]/li/a"));
	System.out.println("Number of Items in the dropdown is " + drop_Down_btn.size());
	
	for (WebElement element : drop_Down_btn){
		String dropDown_Value = element.getAttribute("innerHTML");
		
				
		if(dropDown_Value.contentEquals("CSS")){
			element.click();
			break;
		}
		System.out.println(dropDown_Value);
		
		
	}
	}

	@AfterClass
	public void afterClass() {
	}

}
