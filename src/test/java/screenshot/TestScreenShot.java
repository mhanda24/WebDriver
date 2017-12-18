package screenshot;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestScreenShot {
	static WebDriver driver;
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver","C:/seleniumIO/Selenium_Jars/chromedriver.exe" );
		driver = new ChromeDriver();
		driver.navigate().to("https://google.com");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
	}
	
		
	
  @Test
  public void f() throws IOException {
	  
	  driver.findElement(By.name("q")).sendKeys("Selenium");
	  System.out.println("first line");
	  TakesScreenshot ts = ((TakesScreenshot)driver);
	  System.out.println("Second line");
	  File source= ts.getScreenshotAs(OutputType.FILE);
	  System.out.println("Third line");
	  FileUtils.copyFile(source, new File("./screenshots/google.png"));
	  
	  System.out.println("Screenshot Taken");
	  
	//driver.close();
  }
}
