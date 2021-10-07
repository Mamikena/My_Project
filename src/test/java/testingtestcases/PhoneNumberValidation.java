package testingtestcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class PhoneNumberValidation {
	
	WebDriver driver; 
	WebDriverWait wait; 
	
	 @Test
	 public void InvalidphoneNumber() throws InterruptedException
	{
			System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");

			driver = new ChromeDriver();

			driver.manage().window().maximize();
			
		 driver.get("https://www.sovtech.co.za/contact-us/");
		 
		 wait = new WebDriverWait(driver, 10);
		 wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("hs-form-iframe-0"));

			//Now find the element 
			WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("your_name")));
			name.sendKeys("Hilda");
			Thread.sleep(3000);
			
			WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
			email.sendKeys("molisiwa@gmail.com");
	        Thread.sleep(3000);
			
	     //Test Invalid phone number
			WebElement phoneNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mobilephone")));
			phoneNumber.sendKeys("0123");
	        Thread.sleep(3000);
			
			WebElement companySize = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("numemployees")));
			Select select_box = new Select(companySize);
			select_box.selectByVisibleText("5-25");
	      Thread.sleep(3000);
			
			WebElement messageHelp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("message")));
			messageHelp.sendKeys("Testing text field ....");
	     Thread.sleep(3000);
			
	     WebElement checkbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("LEGAL_CONSENT.subscription_type_10841063")));
	     checkbox.click();
	     Thread.sleep(3000);
	     
	     WebElement submitButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='submit']")));
	     submitButton.click();
  
        WebElement emailErrorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[1]/form[1]/div[3]/ul[1]/li[1]/label[1]")));
		
		String expectedmessage = "The number you entered is not in range.";
		String actualmessage = emailErrorMessage.getText();
		
		if(actualmessage.equals(expectedmessage))
		{
			System.out.println("Actual and expected results are the same" + actualmessage);
		}else
		{
			System.out.println("Actual and expected results are not the same" + actualmessage);
		}
   
     driver.close();
	}

	

}
