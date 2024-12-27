package job_pages_2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import job_pages.base_class;

public class page_class2 extends base_class {
	
	
	@FindBy(xpath = "//input[contains(@id , 'jobs-search-box-keyword-id-ember')]")
	WebElement Job_filter;
	
	@FindBy(css =".full-width.artdeco-entity-lockup__title.ember-view")
    List <WebElement> Job_profile_link;
	
	@FindBy(xpath = "//div[contains(@class,'job-details-jobs-unified-top-card__company-name')]/a[contains(@class, 'app-aware-link') and contains(@target,'_self')] ")
	WebElement Company_link;
	
	@FindBy(xpath = "//a[contains(@id, 'ember') and contains(@class, 'org-page-navigation__item-anchor')  and normalize-space()='People']")
	WebElement People_tab;
	
	@FindBy(xpath = "//input[@id='people-search-keywords']")
	WebElement peopleFilter;
	
	@FindBy(xpath = "//button[contains (@aria-label,'connect')]")
	List<WebElement> connect_cta;
	
	@FindBy(xpath = "//button[@aria-label='Send without a note']")
    WebElement sendWithoutANoteCta;	
	
	@FindBy(xpath = "//button[@aria-label='View all accepted invitations']")
    WebElement ViewAll;	
	
	public page_class2() throws IOException {
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	public void click_on_filter() {
		Job_filter.click();
		Job_filter.sendKeys("quality");
		Job_filter.sendKeys(Keys.ENTER);
	}
	
	public List<WebElement> list_of_job_profile() { // opening the job profile on the right section of the screen 
	    	return Job_profile_link;
	}
	public WebElement company_link() {
		return Company_link;	
	}
	
	public void tab_switching() {
		People_tab.click();
	}
	public void people_filter() {
		peopleFilter.sendKeys("recruiters");
		peopleFilter.sendKeys(Keys.ENTER);
	}
	public List<WebElement> sendConnectionRequest() throws InterruptedException {
		return connect_cta;
	}
	
	public void sendWithoutAnote() {
		sendWithoutANoteCta.click();
	}
	

}
