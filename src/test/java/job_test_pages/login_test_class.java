package job_test_pages;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import job_pages.base_class;
import job_pages_2.login_class;

public class login_test_class extends base_class  {


	public login_class l ;
	
	public login_test_class() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
//	@Parameters("para_name")
	@BeforeMethod
	public void setup() throws IOException  {	
		initialization();
		l = new login_class(); //creating the object of login page class , so that we can access the locaters and actions of all the elements present there 
	}
	
	@Test
	public void login_to_linkedIn() throws IOException {
	 l.login_credentials();
	 
}
	@Test
	public void login() throws IOException {
	 //l.login_credentials();
		System.out.println(Thread.currentThread().getId());}
	 
	 @Test
		public void login_to() throws IOException {
		// l.login_credentials();
		 System.out.println(Thread.currentThread().getId());
	}
	@AfterMethod
	public void tearDown() {
    driver.quit();
}}
