package testingtestcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ValidatingMandatoryFields {
	
	WebDriver driver; 
	WebDriverWait wait; 
	
	@Test
	public void Mandatoryfields() throws InterruptedException
	{
		
		System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.sovtech.co.za/contact-us/");

		wait = new WebDriverWait(driver, 10);

		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("hs-form-iframe-0"));
		
		WebElement submitButton = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='submit']")));
		submitButton.click();
		Thread.sleep(3000);
		
		WebElement nameMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[1]/form[1]/div[1]/ul[1]/li[1]/label[1]")));
		
		String expectedmessage = "Please complete this required field.";
		String actualmessage = nameMessage.getText();
		
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
