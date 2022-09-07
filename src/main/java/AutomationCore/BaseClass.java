package AutomationCore;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.google.common.io.Files;

public class BaseClass {
	public WebDriver driver;
	public static Properties prop;
	FileInputStream fs;
	public WebDriver BrowserInitialization(String browsername) throws InterruptedException	{
		
		if(browsername.equalsIgnoreCase("Chrome"))
		{
		
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Aswathy\\eclipse-workspace\\Billing\\src\\\\main\\resources\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
			
			
		}
		else if(browsername.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Aswathy\\eclipse-workspace\\Billing\\src\\main\\resources\\Driver\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		return driver;
		
		}
	public void PropBase() throws IOException
	{
		prop=new Properties();
		fs=new FileInputStream(System.getProperty("C:\\Users\\Aswathy\\eclipse-workspace\\Amazon\\src\\main\\java\\TestData\\TestdataFile.properties"));
		prop.load(fs);
	}
	public String getScreenshotPath(String testcasename, WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destinationfile=System.getProperty("user.dir")+"\\test-output\\"+testcasename+".png";
		Files.copy(source,new File(destinationfile));
		return destinationfile;
	}

}
