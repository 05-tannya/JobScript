package job_test_pages;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import job_pages.base_class;
import job_pages_2.login_class;
import job_pages_2.page_class1;
import job_pages_2.page_class2;
import job_pages_2.page_class3;

public class page_test3 extends base_class {
	
	
	public login_class l;
	public page_class1 p1;
	//public page_class2 p2;
	public page_class3 p3; 
	WebDriverWait wait;
	
	public page_test3() throws IOException {
		super();
	}

	@BeforeMethod // calling the driver from parent class(DriverBase class)	
	public void setUp() throws IOException  {	
		initialization();
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		l= new login_class();
		p1 = l.login_credentials();
		p1 = new page_class1();
		p3 = new page_class3();
		p3=p1.clickOnNetworkIcon();
		//p2 = new page_class2();
	   // p2=p1.click_on_job_icon();
		}
	@Test
	public void open_inbox_throughMessageCTA() {
		p3.openAllConnections();
      List<WebElement> buttons =   p3.message_button();
      for(WebElement button : buttons ) {
    	  button .click();
    	  wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".msg-convo-wrapper")));
    	  WebElement w = driver.findElement(By.cssSelector(".update-components-mini-update-v2"));
    	  if( !w.isDisplayed()) {
    		  //insert message in the text box and click on send button 
    		  driver.findElement(By.xpath("//div[@aria-label = 'Write a message…'])")).sendKeys("dummy text message");
    		  driver.findElement(By.cssSelector(".msg-form__send-button")).click();
    		  
    	  }
      }
		
	}
	

}
