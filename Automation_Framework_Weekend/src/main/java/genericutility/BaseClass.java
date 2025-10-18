package genericutility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass {
	public static ExtentReports ereport;
	public static ExtentTest test;
	public static WebDriver driver;
	
	public JavaUtility jutil = new  JavaUtility();
	public WebDriverUtility wutil = new  WebDriverUtility();
	public FileUtility futil = new  FileUtility();
	public ExcelUtility eutil = new  ExcelUtility();
	
	@BeforeSuite
	public void reportConfig() {
		ExtentSparkReporter spark = new ExtentSparkReporter("./HTML_reports/ExtentReports_"+jutil.getSystemTime()+".html");
		ereport = new ExtentReports();
		ereport.attachReporter(spark);
	}
	
	@BeforeClass
	public void openBrowser() throws IOException {
		WebDriver driver= new ChromeDriver();
		wutil.maximize(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get(futil.getDataFromProperty("url"));
	}
	
	@AfterClass
	public void closeBrowser() {
    driver.quit();
	}
	
	
	
	@AfterSuite
	public void reportBackup() {
		ereport.flush();
	}

}
