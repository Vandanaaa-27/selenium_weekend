package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
      @FindBy(linkText = "Log out")
      private WebElement logoutLink;
      
      @FindBy(linkText = "BOOKS")
      private WebElement booksLink;
      
      @FindBy(linkText = "COMPUTERS")
      private WebElement computersLink;
      
      public HomePage(WebDriver driver) {
     	 PageFactory.initElements(driver, this);
}

	  public WebElement getLogoutLink() {
		  return logoutLink;
	  }

	  public void setLogoutLink(WebElement logoutLink) {
		  this.logoutLink = logoutLink;
	  }

	  public WebElement getBooksLink() {
		  return booksLink;
	  }

	  public void setBooksLink(WebElement booksLink) {
		  this.booksLink = booksLink;
	  }

	  public WebElement getComputersLink() {
		  return computersLink;
	  }

	  public void setComputersLink(WebElement computersLink) {
		  this.computersLink = computersLink;
	  }
}
