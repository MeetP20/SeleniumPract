package AutomationPractice;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

public class FirstTestCase {
    public static void main(String[] args) 
    {
  
    	//System.out.println("Hello World");
    	System.setProperty("webdriver.chrome.driver", "/usr/lib/chromium-browser/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
  		options.addArguments("--disable-gpu");
    	WebDriver driver = new ChromeDriver(options);
    	
    	driver.get("https://demo.opencart.com/");
    	
    	String title = driver.getTitle();
    	if(title.equals("Your Store"))
    	{
    		System.out.println("Test Passed");
    	}
    	else
    	{
    		System.out.println("Test Failed");
    	}
    	
    	driver.quit();
        
    }
}

