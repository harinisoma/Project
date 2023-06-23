package basePackage;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utility.TimeUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;

public class BaseClass {

	public static Properties prop=new Properties();
	public static WebDriver driver;
	
	//Step 1 to create constructor of the class
	public BaseClass() {
		try {
			FileInputStream file=new FileInputStream("C:\\Users\\Harini\\eclipse-workspace\\selenium\\src\\test\\java\\envirinmentvariables\\Configuration.properties");
                prop.load(file);		
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException a) {
			a.printStackTrace();
		}
	}
	
	//Step 2 use all the child commands
	 @SuppressWarnings("deprecation")
	public static void initiate() {
		 String browsername=prop.getProperty("browser");
		//String browsername=prop.getProperty("browser");
		if(browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if (browsername.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		//driver.manage().timeouts().pageLoadTimeout(TimeUtils.timepage, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TimeUtils.timepage,TimeUnit.SECONDS);
		//driver.get(prop.getProperty("http://orangehrm.qedgetech.com/symfony/web/index.php/auth/login"));
		driver.get(prop.getProperty("Username"));
		driver.get(prop.getProperty("Password"));
		driver.manage().window().minimize();
		driver.manage().window().fullscreen();
		driver.quit();	
	}

 public static void screenshots(String Filename) {
		 //File file = ((TakesScreenshot)driver).getScreenShotAs(OutputType.FILE);
	 File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	try {
		FileUtils.copyFile(file, new File("C:\\Users\\Harini\\eclipse-workspace\\selenium\\src\\test\\java\\screenshots\\Screenshots" +Filename+".jpg"));
	}
	catch (IOException e) {
		e.printStackTrace();
	}
}
}
