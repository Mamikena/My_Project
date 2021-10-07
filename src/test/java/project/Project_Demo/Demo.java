package project.Project_Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Demo {
	
	WebDriver driver; 
	WebDriverWait wait; 
	
    @Test(priority=1)
	public void openbrowser()
	{
		
		   System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
		   
		  driver = new ChromeDriver();
		   
		   driver.manage().window().maximize();
		   
		   driver.get("https://www.sovtech.co.za/contact-us/");
	}
	
	
	@Test(priority=2)
	public void Login() throws InterruptedException
	{
		wait = new WebDriverWait(driver, 10);
		//Find frame or iframe and switch
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("hs-form-iframe-0"));

		//Now find the element 
		WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("your_name")));
		name.sendKeys("Hilda");
		Thread.sleep(3000);
		
		WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
		email.sendKeys("molisiwa@gmail.com");
        Thread.sleep(3000);
		
		WebElement phoneNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mobilephone")));
		phoneNumber.sendKeys("0735453278");
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
	}
	
//	//(priority=2)
//	@Test
// public void Mandatoryfileds()
// {
//		//click on the button without capturing the mandatory fields


	
//		
//	
//
//		//Find frame or iframe and switch
//		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("hs-form-iframe-0"));
//		WebElement submitButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='submit']")));
//        submitButton.click();
// }

}
