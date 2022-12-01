package Testbase;




import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Testbase {

	
	public static WebDriver driver;// without creating object we can call by class name directly 
	
	public static WebDriver getInstance() {
		
		//System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		//driver=new ChromeDriver();
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		driver=new FirefoxDriver();
		
		driver.manage().window().maximize();
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		return driver;
		
	}
	
}
