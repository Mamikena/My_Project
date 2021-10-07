package testingtestcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;




public class EmailValidation{
	
	@Test
	public void EmailValidate() throws InterruptedException
	{
		WebDriver driver; 
		WebDriverWait wait; 
		
		System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.sovtech.co.za/contact-us/");

		wait = new WebDriverWait(driver, 10);

		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("hs-form-iframe-0"));
		
		// Now find the element
				WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("your_name")));
				name.sendKeys("Hilda");
				Thread.sleep(3000);

				WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
				email.sendKeys("testing@test.com");
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

				WebElement checkbox = wait.until(
						ExpectedConditions.visibilityOfElementLocated(By.name("LEGAL_CONSENT.subscription_type_10841063")));
				checkbox.click();
				Thread.sleep(3000);

		
		WebElement submitButton = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='submit']")));
		submitButton.click();
		Thread.sleep(3000);
		
		WebElement emailErrorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[1]/form[1]/div[2]/ul[1]/li[1]/label[1]")));
		
		String expectedmessage = "Please enter a valid email address.";
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