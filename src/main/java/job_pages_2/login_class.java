package job_pages_2;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import job_pages.base_class;

public class login_class extends base_class {
	
	@FindBy(id = "username")
	WebElement Username;
	
	@FindBy(id = "password")
	WebElement Password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement SignIn;
	
	
	public login_class() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	public page_class1 login_credentials() throws IOException {
    	Username.sendKeys("mittaltannya@gmail.com");
    	Password.sendKeys("Tannya0305#");		
    	SignIn.click();
    	//rememberme.click();
    	//as soon as button is clicked we are landed on home page . THUS IT SHOULD RETURN HOMEPAGE CLASS OBJEC    	
    	return new page_class1();
    }

}
