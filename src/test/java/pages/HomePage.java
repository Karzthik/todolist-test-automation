package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.WebDriverWrapper;

public class HomePage {

	@FindBy(xpath = "//header[@class='header']//input")
	WebElement txtInput;
	
	private String listItemName = "//ul[@class='todo-list']//li[contains(.,'<value>')]";
	private String input = "//input";
	private String label = "//label";
	private String listItems = "//ul[@class='todo-list']//li";
	private String itemNameByIndex = "//ul[@class='todo-list']//li[<index>]";
	private String completedItems="//*[@id=\"root\"]/footer/ul/li[3]/a";
	private String activeItems="//*[@id=\"root\"]/footer/ul/li[2]/a";
	private String allListItems="//*[@id=\"root\"]/footer/ul/li[1]/a";
	private String clearcompletedItems="//*[@id=\"root\"]/footer/button";

	private WebDriver driver;
	WebDriverWrapper wrapper;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wrapper = new WebDriverWrapper(driver);
		System.out.println(this.driver.getCurrentUrl());
	}
	
	public void addItem(String text) {
		txtInput.sendKeys(text);
		txtInput.sendKeys(Keys.ENTER);
		wrapper.wait(1500);
	}
	
	public boolean verifyTextInList(String text) {
		String txtElement = listItemName.replace("<value>", text);
		try {
			return driver.findElement(By.xpath(txtElement)).isDisplayed();
		} catch (Exception ex) {
			return false;
		}
	}	
		
	public void completedItems() {
		WebElement element =  driver.findElement(By.xpath(completedItems));
		element.click();		
	}
	
	public void allListItems() {
		WebElement element =  driver.findElement(By.xpath(allListItems));
		element.click();		
	}
	
	public void activeItems() {
		WebElement element =  driver.findElement(By.xpath(activeItems));
		element.click();		
	}
	
	public void clearcompletedItems() {
		WebElement element =  driver.findElement(By.xpath(clearcompletedItems));
		element.click();		
	}
	
	private int getNumberOfItems() {
		return driver.findElements(By.xpath(listItems)).size();
	}
	
	public String getLastItemName() {
		itemNameByIndex = itemNameByIndex.replace("<index>", getNumberOfItems() + "");
		return driver.findElement(By.xpath(itemNameByIndex + label)).getText();
	}
	
	public String markItemCompleted(String text) {
		String txtElement = listItemName.replace("<value>", text);
		driver.findElement(By.xpath(txtElement + input)).click();
		return driver.findElement(By.xpath(txtElement)).getAttribute("class");
	}
	
	}