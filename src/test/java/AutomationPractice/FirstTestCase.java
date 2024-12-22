package AutomationPractice;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

public class FirstTestCase {
    public static void main(String[] args) 
    {
  
    	//System.out.println("Hello World");
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\manali\\Downloads\\chromedriver-win64/chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
    	
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

