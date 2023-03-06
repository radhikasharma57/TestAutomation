package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	
	public WebDriver driver;
	
	
	public WebDriver WebDriverManager() throws IOException
	
    {
		FileInputStream fis=new FileInputStream("C:\\RadhikaJava\\CucumberFramework\\src\\test\\resources\\global.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String url=prop.getProperty("QAUrl");
		if(driver == null)
		{
			
		System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver\\chromedriver.exe");
		driver=new ChromeDriver();
			
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));	
		driver.get(url);
		}
		return driver;
		
	}
	

}
