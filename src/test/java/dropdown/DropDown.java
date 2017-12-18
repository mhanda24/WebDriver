package dropdown;

import org.testng.annotations.Test;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class DropDown {
	static WebDriver driver;
	
	@BeforeClass
	  public void beforeClass() {
		
		
		System.setProperty("webdriver.chrome.driver","C:/seleniumIO/Selenium_Jars/chromedriver.exe" );
		driver = new ChromeDriver();
		driver.navigate().to("http://demoqa.com/registration");
	  }

	
	
	@Test
  public void test1() throws InterruptedException {
		
		System.out.println("Test Ran successfully");
		WebElement month = driver.findElement(By.id("mm_date_8"));
		WebElement day = driver.findElement(By.id("dd_date_8"));
		WebElement year = driver.findElement(By.id("yy_date_8"));
		
		
		Select month_DropDown = new Select(month);
		WebElement defaultMonth = month_DropDown.getFirstSelectedOption();
		System.out.println("Default value is " + defaultMonth.getText());
		
		month_DropDown.selectByValue("8");
		
		WebElement selectedMonth = month_DropDown.getFirstSelectedOption();
		System.out.println("Default value is " + selectedMonth.getText());
		
		List<WebElement> month_List = month_DropDown.getOptions();
		
		System.out.println("Total month count " + month_List.size());
		
		for(WebElement ml : month_List){
			String Month_Name = ml.getText();
			System.out.println(Month_Name);
		}
		
		
		
		Thread.sleep(3000);
		
		Select day_DropDown = new Select(day);
		day_DropDown.selectByVisibleText("20");
		
		WebElement selectedDay = month_DropDown.getFirstSelectedOption();
		System.out.println("Default value is " + selectedDay.getText());
		
		Thread.sleep(3000);
		
		Select year_DropDown = new Select(year);
		year_DropDown.selectByVisibleText("2014");
		
		WebElement selectedYear = month_DropDown.getFirstSelectedOption();
		System.out.println("Default value is " + selectedYear.getText());
  }
	
	@AfterClass
	public void afterClass(){
		
		//driver.quit();
	}
  
}
