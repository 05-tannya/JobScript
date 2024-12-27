package job_pages_2;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import job_pages.base_class;

public class page_class1 extends base_class {
	
	
	@FindBy(xpath = "//a[@href='https://www.linkedin.com/jobs/?']")
	WebElement job_icon;
	
	@FindBy(xpath = "//a[@href='https://www.linkedin.com/mynetwork/?\']")
	WebElement network_icon;

	public page_class1() throws IOException {
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	public page_class2 click_on_job_icon() throws IOException {
		job_icon.click();
		return new page_class2();
	}
	public page_class3 clickOnNetworkIcon() throws IOException {
		network_icon.click();
		return new page_class3();
	}

}
