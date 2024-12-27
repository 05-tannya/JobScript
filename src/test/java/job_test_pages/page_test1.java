package job_test_pages;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import job_pages.base_class;
import job_pages_2.login_class;
import job_pages_2.page_class1;
import job_pages_2.page_class2;

public class page_test1 extends base_class {
	
	login_class l;
	page_class1 p1;
	page_class2 p2;

	
	public page_test1() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod // calling the driver from parent class(DriverBase class)	
	public void setup() throws IOException  {	
		initialization();
		
		l= new login_class();
		p1 = l.login_credentials(); //creating the object of page class1 , so that we can access the locaters and actions of all the elements present there 
	}
	
	@Test
	public void get_the_title() throws IOException {
		p2=p1.click_on_job_icon();
	}
	
	@AfterMethod
	public void tearDown() {
    driver.quit();
   
}

}
