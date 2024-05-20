package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;


public class TestCase extends BaseTest {

	HomePage homePage;
	
	//To list down the To-do Items
	
	String todoitem1 = "Important client meeting at 11 am";
	String todoitem2 = "Attend mandatory Training at 4 pm";
	String todoitem3 = "Send mail to Teammate";
	String todoitem4 = "Cancel 5 pm Meeting";
	
	@BeforeClass
	public void createHomePageObject() {
		homePage = new HomePage(driver);
	}
	
	/* User adding to-dos items for the day*/
	
	@Test (priority = 1, description = "User should able to add to-do items in list")
	public void createToDoList() throws InterruptedException {
		
		Thread.sleep(1000);
		homePage.addItem(todoitem1);
		Assert.assertTrue(homePage.verifyTextInList(todoitem1), todoitem1  + " is not visible");		
		homePage.addItem(todoitem2);
		Assert.assertTrue(homePage.verifyTextInList(todoitem2), todoitem2  + " is not visible");		
		homePage.addItem(todoitem3);
		Assert.assertTrue(homePage.verifyTextInList(todoitem3), todoitem3  + " is not visible");
		System.out.println("Priority 1 Test case Executed Successfully");
		Thread.sleep(1500);
	}
	
	/* User adding the items in to-dos*/
	
	@Test (priority = 2, description = "New item getting added in the list should be shown at the bottom of the list")
	public void newItemIsLast() throws InterruptedException {
		
		Thread.sleep(1000);		
		homePage = new HomePage(driver);
		homePage.addItem(todoitem4);
		Assert.assertEquals(homePage.getLastItemName(), todoitem4, "Last Item doesn't match");
		System.out.println("Priority 2 Test case Executed Successfully");		
	}
	
	/* User marking the to-do as completed*/
	
	@Test (priority = 3, description = "Task which is completed should be marked as completed")
	public void strikeOutItem() throws InterruptedException {
		
		Thread.sleep(1000);
		Assert.assertEquals(homePage.markItemCompleted(todoitem4), "completed", "Item is not marked completed");
		System.out.println("Priority 3 Test case Executed Successfully");
		}
	
	/* User view on Active list of to-dos */
	
	@Test (priority = 4, description = "Active tasks should be displayed in Active tab")
	public void clickActiveItems() throws InterruptedException {
		
		Thread.sleep(2500);
		homePage.activeItems();
		System.out.println("Priority 4 Test case Executed Successfully");
	}
	
	/* User view on Completed to-dos */
	
	@Test (priority = 5, description = "Completed tasks should be displayed in completed tab")
	public void clickcompletedItems() throws InterruptedException {
		
		Thread.sleep(2500);
		homePage.completedItems();
		System.out.println("Priority 5 Test case Executed Successfully");
	}
	
	/* User clears on Completed to-dos */
	
	@Test (priority = 6, description = "Clear completed tasks in clear completed tab")
	public void clearcompletedItems() throws InterruptedException {
		
		Thread.sleep(2500);
		homePage.clearcompletedItems();
		System.out.println("Priority 6 Test case Executed Successfully");
	}
	
/* User view on All pending to-dos */
	
	@Test (priority = 7, description = "User should view only on Pending tasks in all to-dos")
	public void clickAllItems() throws InterruptedException {
		
		Thread.sleep(2500);
		homePage.allListItems();
		System.out.println("Priority 7 Test case Executed Successfully");
		Thread.sleep(2500);
	}
			
}
