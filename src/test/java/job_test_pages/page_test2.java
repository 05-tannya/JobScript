package job_test_pages;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import job_pages.base_class;
import job_pages_2.login_class;
import job_pages_2.page_class1;
import job_pages_2.page_class2;

public class page_test2 extends base_class {
	public login_class l;
	public page_class1 p1;
	public page_class2 p2;
	WebDriverWait wait;
	
	public page_test2() throws IOException {
		super();
	}

	@BeforeMethod // calling the driver from parent class(DriverBase class)	
	public void setUp() throws IOException  {	
		initialization();
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		l= new login_class();
		p1 = new page_class1();
		p2 = new page_class2();
		p1 = l.login_credentials();
	    p2=p1.click_on_job_icon();
		}
	

	
	@Test(priority =1)
	public void open_job_profile_and_company_url_in_new_tab() throws InterruptedException {
		p2.click_on_filter();
		Thread.sleep(8000);
		
	List<WebElement> A= p2.list_of_job_profile();		
		for( WebElement each_element : A) {
			//clicking on job profile to open it in the right panel of same screen
			each_element.click();
		
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'job-details-jobs-unified-top-card__company-name')]/a[contains(@class, 'app-aware-link') and contains(@target,'_self')]")));
			//open the company url in new tab 
			System.out.println("success");
			String linkURL= p2.company_link().getAttribute("href");
			System.out.print("PRINT THE COMPANY URL" + linkURL);
	//		 WebElement link = driver.findElement(By.linkText(linkURL));

		JavascriptExecutor js = (JavascriptExecutor) driver;// creating java script executor to open link in new tab 
		js.executeScript("window.open(arguments[0], '_blank');", linkURL);
	/*	        List<String> tabs = new ArrayList<>(driver.getWindowHandles());//navigating the user to new tab 
		        driver.switchTo().window(tabs.get(1));*/
		System.out.println("Start switching");
		//Switch to new tab 
			Set<String>  handles = driver.getWindowHandles();
			Iterator<String> it = handles.iterator();
			String originalWindow = it.next();
			System.out.println("ORIGINAL WINDOW HANDLES ");
			String childWindow = it.next();
			driver.switchTo().window(childWindow);
			//wait until new tab completely loads 
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".org-company-follow-button")));
            p2.tab_switching();
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".ember-text-field.ember-view")));
            p2.people_filter();
            JavascriptExecutor js1 = (JavascriptExecutor) driver;
            // Scroll down by 1000 pixels
            js.executeScript("window.scrollBy(0,500)");
            System.out.println("SUCCESSFUL SCROLLING OF THE SCREEN");
            // Close the new tab and switch back to the original window
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains (@aria-label,'connect')]")));
            List<WebElement> connects = p2.sendConnectionRequest();
            for(WebElement connect : connects) {
            	try {
                    connect.click();
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Send']"))).click();
                    System.out.println("Connection request sent successfully");
                } catch (Exception e) {
                    System.out.println("Error while sending connection request: " + e.getMessage());
                }
            
        
            	//wait for confirmation pop up and click on send without a note 
            	Thread.sleep(4000);
            	p2.sendWithoutAnote();
            	System.out.println("CONNECTION REQUEST SENT");       	
            }
            driver.close();
            driver.switchTo().window(originalWindow);
		        			
		}
			
	}
	@AfterMethod
	public void tearDown() {
    driver.quit();
   
}
}
