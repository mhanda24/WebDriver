package dropdown;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class BootStrapDropDown2 {

	static WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "C:/seleniumIO/Selenium_Jars/chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://www.w3schools.com/bootstrap/bootstrap_dropdowns.asp");
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		

	}

	@Test
	public void BootdropdownTest() {

		
		WebElement element = driver.findElement(By.xpath("//button[@id='menu3']"));

		JavascriptExecutor ex = (JavascriptExecutor)driver;
		ex.executeScript("arguments[0].click();", element);
			
		driver.findElement(By.xpath("//button[@id='menu3']")).click();

		List<WebElement> drop_Down_btn = driver.findElements(By.xpath("//*[@id='main']/div[9]/ul[1]/li/a"));
		System.out.println("Number of Items in the dropdown is " + drop_Down_btn.size());

		for (WebElement element1 : drop_Down_btn) {
			String dropDown_Value = element1.getAttribute("innerHTML");
			
						
			if(dropDown_Value.contentEquals("Active")){
				element1.click();
				break;
			}
			
		System.out.println(dropDown_Value);

		}
	}

	@AfterClass
	public void afterClass() {
	}

}
