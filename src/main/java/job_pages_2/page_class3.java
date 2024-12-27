package job_pages_2;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import job_pages.base_class;

public class page_class3 extends base_class{
// MY NETWORK 
	
	
	@FindBy(xpath ="//span[@aria-label= 'Show more in manage my network list']")
	WebElement arrow_icon;
	
	@FindBy(xpath = "//a[@href='/mynetwork/invite-connect/connections/']")
	WebElement all_connections;
	
	@FindBy(xpath = "//button[starts-with(@aria-label,'Send a message to')]")
	List<WebElement> message_button;
	
	
	
	
	//@FindBy(xpath = "//a[@href='/mynetwork/invite-connect/connections/']")
	//WebElement all_connections;
	//@FindBy(xpath = "//a[@href='/mynetwork/invite-connect/connections/']")
	//WebElement all_connections;
	
	
	
	public page_class3() throws IOException {
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	

	public void openAllConnections() {
		arrow_icon.click();
        all_connections.click();
	}
	public List<WebElement> message_button(){
		return message_button();
	}
}
