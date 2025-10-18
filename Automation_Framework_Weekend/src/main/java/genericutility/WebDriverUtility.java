package genericutility;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtility {
	
	/**
	 * This contains all the necessary and basic WebDriver of Selenium
	 * @param driver
	 */
	
	public void maximize(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	public Dimension getSize(WebDriver driver) {
		return driver.manage().window().getSize();
	}
	
	public void mouseHover(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
  
	//Do it for Drag and drop 
	public void dragAndDrop(WebDriver driver, WebElement source,WebElement target) {
        Actions act =new Actions(driver);
       act.dragAndDrop(source, target).perform();

}
       public void selectDropdown(WebElement element, int index) {
               Select s= new Select(element);
               s.selectByIndex(index);
       }

       public void selectDropdown(WebElement element, String  value) {
               Select s= new Select(element);
               s.selectByValue(value);

       }

       public void selectDropdown(String  text,WebElement element) {
               Select s= new Select(element);
               s.selectByVisibleText(text);

       }

       public void switchToFrame(WebDriver driver, int index) {
               driver.switchTo().frame(index);

       }

       public void switchToFrame(WebDriver driver, String nameOrdId) {
               driver.switchTo().frame(nameOrdId);

       }

       public void switchToFrame(WebDriver driver, WebElement frameElement) {
               driver.switchTo().frame(frameElement);

       }

  public void switchBackToMainPage(WebDriver driver) {
          driver.switchTo().defaultContent();

  }

  public Alert switchToAlert(WebDriver driver) {
          return driver.switchTo().alert();
  }


	public void getScreenshot(WebDriver driver) throws IOException {
        JavaUtility jutil = new JavaUtility();
        TakesScreenshot ts = (TakesScreenshot) driver;
         java.io.File temp = ts.getScreenshotAs(OutputType.FILE);
         File dest = new File("./screenshots/" + jutil.getSystemTime() + ".png");
         FileHandler.copy(temp, dest);
    

   }
	
   public void switchToWindow(WebDriver driver, String expUrl) {
	   Set<String> allWindowIds = driver.getWindowHandles();
	   for(String id:allWindowIds) {
		   driver.switchTo().window(id);
		   if(driver.getCurrentUrl().contains(expUrl)) {
			   break;
		   }
	   }
   }
   
   
   
   }
