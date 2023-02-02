package src;
import java.time.Duration;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Sandbox_FikriPutraFerindra {
	
	//@Ignore
	@Test
	public void SB07_01_viewNewsDetails() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		driver.manage().window().maximize();
		driver.get("https://sandbox.soc-conferences.com/cms/admin/login.php");
		Thread.sleep(1000);
		//open sandbox website
		
		driver.findElement(By.xpath("//*[@id=\"idemail\"]")).sendKeys("sandbox@soc-conferences.com"); //Input email
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"idpass\"]")).sendKeys("Abc123123"); //Input password
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"idconf\"]")).sendKeys("SANDBOX23"); //Choose Sandbox23 for Conference
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@name='submit'][@value='login']")).click(); //click Login button
		String alert = driver.switchTo().alert().getText();//identify message
		String msg = "Login Successful";
		if(msg.equals(alert)) {
			Assert.assertEquals(msg, alert);
		    Thread.sleep(1000);
			System.out.println("User Login Successful");		
		}else {
			Thread.sleep(1000);
			System.out.println("User Login Failed");
			driver.quit();
		}
		driver.switchTo().alert().accept(); //click OK for confirmation dialog
		Thread.sleep(1000);
		
		//click news navigation bar
		driver.findElement(By.xpath("/html/body/nav/div[2]/a")).click();
		Thread.sleep(1000);
		
		//click news details
		WebElement NewsDetails = driver.findElement(By.xpath("/html/body/div/div/div/table/tbody/tr/td/a/button")); 
		NewsDetails.click();
		Thread.sleep(1000);
		
		//finish testcase
		Assert.assertNotNull(NewsDetails);
		System.out.println("Test case success - SB07_01 - View News Details");
		Thread.sleep(1000);
		
		//quit browser
		driver.quit();
	}
	
	//@Ignore
	@Test
	public void SB08_01_downloadFile() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		driver.manage().window().maximize();
		driver.get("https://sandbox.soc-conferences.com/cms/admin/login.php");
		Thread.sleep(1000);
		//open sandbox website
		
		driver.findElement(By.xpath("//*[@id=\"idemail\"]")).sendKeys("sandbox@soc-conferences.com"); //Input email
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"idpass\"]")).sendKeys("Abc123123"); //Input password
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"idconf\"]")).sendKeys("SANDBOX23"); //Choose Sandbox23 for Conference
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@name='submit'][@value='login']")).click(); //click Login button
		String alert = driver.switchTo().alert().getText();//identify message
		String msg = "Login Successful";
		if(msg.equals(alert)) {
			Assert.assertEquals(msg, alert);
		    Thread.sleep(1000);
			System.out.println("User Login Successful");		
		}else {
			Thread.sleep(1000);
			System.out.println("User Login Failed");
			driver.quit();
		}
		driver.switchTo().alert().accept(); //click OK for confirmation dialog
		Thread.sleep(1000);
		
		//click news navigation bar
		driver.findElement(By.xpath("/html/body/nav/div[2]/a")).click();
		Thread.sleep(1000);
		
		//click news details
		driver.findElement(By.xpath("/html/body/div/div/div/table/tbody/tr/td/a/button")).click();
		Thread.sleep(1000);
		
		//click download button
		WebElement downloadButton = driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/table/tbody/tr/td/a/button")); 
		downloadButton.click();
		Thread.sleep(1000);
		
		//finish testcase
		Assert.assertNotNull(downloadButton);
		System.out.println("Test case success - SB08_01 - Download File");
		Thread.sleep(1000);
				
		//quit browser
		driver.quit();
	}
	
	//@Ignore
	@Test
	public void SB09_01_deleteNews() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		driver.manage().window().maximize();
		driver.get("https://sandbox.soc-conferences.com/cms/admin/login.php");
		Thread.sleep(1000);
		//open sandbox website
		
		driver.findElement(By.xpath("//*[@id=\"idemail\"]")).sendKeys("sandbox@soc-conferences.com"); //Input email
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"idpass\"]")).sendKeys("Abc123123"); //Input password
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"idconf\"]")).sendKeys("SANDBOX23"); //Choose Sandbox23 for Conference
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@name='submit'][@value='login']")).click(); //click Login button
		String alert = driver.switchTo().alert().getText();//identify message
		String msg = "Login Successful";
		if(msg.equals(alert)) {
			Assert.assertEquals(msg, alert);
		    Thread.sleep(1000);
			System.out.println("User Login Successful");		
		}else {
			Thread.sleep(1000);
			System.out.println("Test case Failed - SB09_01 - User Login Failed");
			driver.quit();
		}
		driver.switchTo().alert().accept(); //click OK for confirmation dialog
		Thread.sleep(1000);
		
		//click trash button to delete news
		WebElement deleteButton = driver.findElement(By.xpath("/html/body/div/div/div/table/tbody/tr/td/a[2]/button")); 
		deleteButton.click();
		Thread.sleep(1000);
		
		//click OK for confirmation delete news dialog
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		
		//identify delete news message
		String alert_message = driver.switchTo().alert().getText();
		String delete_message = "Success";
		if(delete_message.equals(alert_message)) {
			Assert.assertEquals(delete_message, alert_message);
			System.out.println("Test case success - SB09_01 - Delete Button");
			driver.switchTo().alert().accept();
			Thread.sleep(1000);
			//quit browser
			driver.quit();
		}else {
			Thread.sleep(1000);
			System.out.println("Test case Failed - SB09_01 - Delete News Failed");
			Assert.assertEquals(delete_message, alert_message);
			//quit browser
			driver.quit();
		}
	}
	
	//@Ignore
	@Test
	public void SB10_01_viewMessageDetails() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		driver.manage().window().maximize();
		driver.get("https://sandbox.soc-conferences.com/cms/admin/login.php");
		Thread.sleep(1000);
		//open sandbox website
		
		driver.findElement(By.xpath("//*[@id=\"idemail\"]")).sendKeys("sandbox@soc-conferences.com"); //Input email
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"idpass\"]")).sendKeys("Abc123123"); //Input password
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"idconf\"]")).sendKeys("SANDBOX23"); //Choose Sandbox23 for Conference
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@name='submit'][@value='login']")).click(); //click Login button
		String alert = driver.switchTo().alert().getText();//identify message
		String msg = "Login Successful";
		if(msg.equals(alert)) {
			Assert.assertEquals(msg, alert);
		    Thread.sleep(1000);
			System.out.println("User Login Successful");		
		}else {
			Thread.sleep(1000);
			System.out.println("User Login Failed");
			driver.quit();
		}
		driver.switchTo().alert().accept(); //click OK for confirmation dialog
		Thread.sleep(1000);
		
		//click message navigation bar
		driver.findElement(By.xpath("/html/body/nav/div[2]/a[8]")).click();
		Thread.sleep(1000);
		
		//click on folder icon to see messsage details
		WebElement viewMessageDetail = driver.findElement(By.xpath("/html/body/div/div/ul/div/table/tbody/tr/td/a[2]/button")); 
		viewMessageDetail.click();
		Thread.sleep(1000);
		
		//finish testcase
		Assert.assertNotNull(viewMessageDetail);
		System.out.println("Test case success - SB10_01 - View Message Details");
		Thread.sleep(1000);
								
		//quit browser
		driver.quit();
	}
	
	//@Ignore
	@Test
	public void SB11_01_replyMessage() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		driver.manage().window().maximize();
		driver.get("https://sandbox.soc-conferences.com/cms/admin/login.php");
		Thread.sleep(1000);
		//open sandbox website
		
		driver.findElement(By.xpath("//*[@id=\"idemail\"]")).sendKeys("sandbox@soc-conferences.com"); //Input email
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"idpass\"]")).sendKeys("Abc123123"); //Input password
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"idconf\"]")).sendKeys("SANDBOX23"); //Choose Sandbox23 for Conference
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@name='submit'][@value='login']")).click(); //click Login button
		String alert = driver.switchTo().alert().getText();//identify message
		String msg = "Login Successful";
		if(msg.equals(alert)) {
			Assert.assertEquals(msg, alert);
		    Thread.sleep(1000);
			System.out.println("User Login Successful");		
		}else {
			Thread.sleep(1000);
			System.out.println("User Login Failed");
			driver.quit();
		}
		driver.switchTo().alert().accept(); //click OK for confirmation dialog
		Thread.sleep(1000);
		
		//click message navigation bar
		driver.findElement(By.xpath("/html/body/nav/div[2]/a[8]")).click();
		Thread.sleep(1000);
		
		//click on folder icon to see messsage details
		driver.findElement(By.xpath("/html/body/div/div/ul/div/table/tbody/tr/td/a[2]/button")).click();
		Thread.sleep(1000);
		
		//click reply button
		driver.findElement(By.xpath("/html/body/div/div/div/a")).click();
		Thread.sleep(1000);
	
		//write the message and click reply button
		WebElement idmessage = driver.findElement(By.xpath("//*[@id=\"idmessage\"]"));
		idmessage.sendKeys("Hello World Java too");
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div/div/div/div/form/p/input")).click();
		Thread.sleep(1000);
		
		//click OK for confirmation reply message dialog
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		
		//click OK for confirmation dialog
		driver.switchTo().alert().accept();
		Thread.sleep(1000);		
		
		//finish testcase
		Assert.assertNotNull(idmessage);
		System.out.println("Test case success - SB11_01 - Reply Message");
		Thread.sleep(1000);
										
		//quit browser
		driver.quit();
	}

	//@Ignore
	@Test
	public void SB12_01_searchAuthorButtonName() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		driver.manage().window().maximize();
		driver.get("https://sandbox.soc-conferences.com/cms/admin/login.php");
		Thread.sleep(1000);
		//open sandbox website
		
		driver.findElement(By.xpath("//*[@id=\"idemail\"]")).sendKeys("sandbox@soc-conferences.com"); //Input email
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"idpass\"]")).sendKeys("Abc123123"); //Input password
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"idconf\"]")).sendKeys("SANDBOX23"); //Choose Sandbox23 for Conference
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@name='submit'][@value='login']")).click(); //click Login button
		String alert = driver.switchTo().alert().getText();//identify message
		String msg = "Login Successful";
		if(msg.equals(alert)) {
			Assert.assertEquals(msg, alert);
		    Thread.sleep(1000);
			System.out.println("User Login Successful");		
		}else {
			Thread.sleep(1000);
			System.out.println("User Login Failed");
			driver.quit();
		}
		driver.switchTo().alert().accept(); //click OK for confirmation dialog
		Thread.sleep(1000);
		
		//click on Author navigation button
		driver.findElement(By.xpath("/html/body/nav/div[2]/a[3]")).click();
		Thread.sleep(1000);
		
		//fill in the name of the author
		WebElement authorName = driver.findElement(By.xpath("//*[@id=\"idtitle\"]"));
		authorName.sendKeys("Fetoy");
		Thread.sleep(1000);
		
		//click an option search for Author's Name
		driver.findElement(By.xpath("/html/body/div/div/div/form/div[2]/select/option")).click();
		Thread.sleep(1000);
		
		//click on search button
		driver.findElement(By.xpath("/html/body/div/div/div/form/div[3]/button")).click();
		Thread.sleep(1000);
		
		//finish testcase
		Assert.assertNotNull(authorName);
		System.out.println("Test case success - SB012_01 - Search Author Button by Author Name");
		Thread.sleep(1000);
												
		//quit browser
		driver.quit();
	}
	
	//@Ignore
	@Test
	public void SB12_02_searchAuthorButtonEmail() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		driver.manage().window().maximize();
		driver.get("https://sandbox.soc-conferences.com/cms/admin/login.php");
		Thread.sleep(1000);
		//open sandbox website
		
		driver.findElement(By.xpath("//*[@id=\"idemail\"]")).sendKeys("sandbox@soc-conferences.com"); //Input email
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"idpass\"]")).sendKeys("Abc123123"); //Input password
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"idconf\"]")).sendKeys("SANDBOX23"); //Choose Sandbox23 for Conference
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@name='submit'][@value='login']")).click(); //click Login button
		String alert = driver.switchTo().alert().getText();//identify message
		String msg = "Login Successful";
		if(msg.equals(alert)) {
			Assert.assertEquals(msg, alert);
		    Thread.sleep(1000);
			System.out.println("User Login Successful");		
		}else {
			Thread.sleep(1000);
			System.out.println("User Login Failed");
			driver.quit();
		}
		driver.switchTo().alert().accept(); //click OK for confirmation dialog
		Thread.sleep(1000);
		
		//click on Author navigation bar
		driver.findElement(By.xpath("/html/body/nav/div[2]/a[3]")).click();
		Thread.sleep(1000);
		
		//fill in the email of the author
		WebElement AuthorEmail = driver.findElement(By.xpath("//*[@id=\"idtitle\"]"));
		AuthorEmail.sendKeys("fetoy69875@cmeinbox.com");
		Thread.sleep(1000);
				
		//click an option search for email
		driver.findElement(By.xpath("/html/body/div/div/div/form/div[2]/select/option[2]")).click();
		Thread.sleep(1000);
				
		//click on search button
		driver.findElement(By.xpath("/html/body/div/div/div/form/div[3]/button")).click();
		Thread.sleep(1000);
				
		//finish testcase
		Assert.assertNotNull(AuthorEmail);
		System.out.println("Test case success - SB012_02 - Search Author Button by Email");
		Thread.sleep(1000);
														
		//quit browser
		driver.quit();
	}
	
	//@Ignore
	@Test
	public void SB12_03_searchAuthorButtonOrganization() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		driver.manage().window().maximize();
		driver.get("https://sandbox.soc-conferences.com/cms/admin/login.php");
		Thread.sleep(1000);
		//open sandbox website
		
		driver.findElement(By.xpath("//*[@id=\"idemail\"]")).sendKeys("sandbox@soc-conferences.com"); //Input email
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"idpass\"]")).sendKeys("Abc123123"); //Input password
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"idconf\"]")).sendKeys("SANDBOX23"); //Choose Sandbox23 for Conference
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@name='submit'][@value='login']")).click(); //click Login button
		String alert = driver.switchTo().alert().getText();//identify message
		String msg = "Login Successful";
		if(msg.equals(alert)) {
			Assert.assertEquals(msg, alert);
		    Thread.sleep(1000);
			System.out.println("User Login Successful");		
		}else {
			Thread.sleep(1000);
			System.out.println("User Login Failed");
			driver.quit();
		}
		driver.switchTo().alert().accept(); //click OK for confirmation dialog
		Thread.sleep(1000);
		
		//click on Author navigation bar
		driver.findElement(By.xpath("/html/body/nav/div[2]/a[3]")).click();
		Thread.sleep(1000);
				
		//fill in the organization of the author
		WebElement AuthorOrg = driver.findElement(By.xpath("//*[@id=\"idtitle\"]"));
		AuthorOrg.sendKeys("UUM");
		Thread.sleep(1000);
						
		//click an option search for organization
		driver.findElement(By.xpath("/html/body/div/div/div/form/div[2]/select/option[3]")).click();
		Thread.sleep(1000);
						
		//click on search button
		driver.findElement(By.xpath("/html/body/div/div/div/form/div[3]/button")).click();
		Thread.sleep(1000);
						
		//finish testcase
		Assert.assertNotNull(AuthorOrg);
		System.out.println("Test case success - SB012_03 - Search Author Button by Organization");
		Thread.sleep(1000);
																
		//quit browser
		driver.quit();
	}
	
	//@Ignore
	@Test
	public void SB13_01_deleteButton() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		driver.manage().window().maximize();
		driver.get("https://sandbox.soc-conferences.com/cms/admin/login.php");
		Thread.sleep(1000);
		//open sandbox website
		
		driver.findElement(By.xpath("//*[@id=\"idemail\"]")).sendKeys("sandbox@soc-conferences.com"); //Input email
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"idpass\"]")).sendKeys("Abc123123"); //Input password
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"idconf\"]")).sendKeys("SANDBOX23"); //Choose Sandbox23 for Conference
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@name='submit'][@value='login']")).click(); //click Login button
		String alert = driver.switchTo().alert().getText();//identify message
		String msg = "Login Successful";
		if(msg.equals(alert)) {
			Assert.assertEquals(msg, alert);
		    Thread.sleep(1000);
			System.out.println("User Login Successful");		
		}else {
			Thread.sleep(1000);
			System.out.println("Test case Failed - SB13_01 - User Login Failed");
			driver.quit();
		}
		driver.switchTo().alert().accept(); //click OK for confirmation dialog
		Thread.sleep(1000);
		
		//click Author navigation bar
		driver.findElement(By.xpath("/html/body/nav/div[2]/a[3]")).click();
		Thread.sleep(1000);
		
		//fill in the name of the author
		WebElement authorName = driver.findElement(By.xpath("//*[@id=\"idtitle\"]"));
		authorName.sendKeys("Fikri");
		Thread.sleep(1000);
				
		//click an option search for Author's Name
		driver.findElement(By.xpath("/html/body/div/div/div/form/div[2]/select/option")).click();
		Thread.sleep(1000);
				
		//click on search button
		driver.findElement(By.xpath("/html/body/div/div/div/form/div[3]/button")).click();
		Thread.sleep(1000);
		
		//click on more button
		driver.findElement(By.xpath("/html/body/div/div/table/tbody/tr/td/a/button")).click();
		Thread.sleep(1000);
		
		//click on delete button
		WebElement deletebutton = driver.findElement(By.xpath("/html/body/div/div/div/div/div/a/button")); 
		deletebutton.click();
		Thread.sleep(1000);
		
		//click to confirm delete author
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		
		//identify delete message
		String alert_message = driver.switchTo().alert().getText();
		String delete_message = "Success";
		if(delete_message.equals(alert_message)) {
			Assert.assertEquals(delete_message, alert_message);
		    System.out.println("Test case success - SB13_01 - Delete Button");
			driver.switchTo().alert().accept();
			Thread.sleep(1000);
			//quit browser
			driver.quit();
		}else {
			Thread.sleep(1000);
			System.out.println("Test case Failed - SB13_01 - Delete Author Failed");
			Assert.assertEquals(delete_message, alert_message);
			//quit browser
			driver.quit();
		}
	}
	
	//@Ignore
	@Test
	public void SB14_01_sendMessageButton() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://sandbox.soc-conferences.com/cms/reviewer/login.php");
		Thread.sleep(1000);
		//open sandbox website
		
		driver.findElement(By.xpath("//*[@id=\"idemail\"]")).sendKeys("xoyayi2968@khaxan.com"); //Input email
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"idpass\"]")).sendKeys("Qwerty12345"); // Input password
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@name='submit'][@value='login']")).click(); //click Login button
		String alert = driver.switchTo().alert().getText();//identify message
		String msg = "Login Success";
		if(msg.equals(alert)) {
			Assert.assertEquals(msg, alert);
		    Thread.sleep(1000);
			System.out.println("User Login Successful");		
		}else {
			Thread.sleep(1000);
			System.out.println("User Login Failed");
			driver.quit();
		}
		driver.switchTo().alert().accept(); //click OK for confirmation dialog
		Thread.sleep(1000);
		
		//click Message on nav bar
		driver.findElement(By.xpath("/html/body/nav/div[2]/a[3]")).click(); 
		Thread.sleep(1000);
		
		//click on "new Message" button	
		driver.findElement(By.xpath("/html/body/div/div/a/div")).click(); 
		Thread.sleep(1000);
		
		//write title and message
		driver.findElement(By.xpath("//*[@id=\"idtitle\"]")).sendKeys("What are the roles of Reviewer?");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"idmessage\"]")).sendKeys("Need a full context on how to be a successful reviewer");
		Thread.sleep(1000);
		
		//send the messages by clicking on "send" button
		WebElement sendbutton = driver.findElement(By.xpath("/html/body/div/div/div/div/div/form/p/input")); 
		sendbutton.click(); 
		Thread.sleep(1000);
		
		//click OK to confirm the message
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		
		//click OK to confirmation dialog
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		
		//finish testcase
		Assert.assertNotNull(sendbutton);
		System.out.println("Test case success - SB014_01 - Send Message Button");
		Thread.sleep(1000);
																		
		//quit browser
		driver.quit();
	}
}
