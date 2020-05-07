package steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class OnlineAuctionSteps {

	WebDriver driver;

	@Given("^Open the Online Auction application$")
	public void open_the_Online_Auction_application() throws Throwable {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\CSS\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:8089/OnlineAuctionWeb/");
	}

	@When("^Click on Seller link$")
	public void click_on_Seller_link() throws Throwable {
		driver.findElement(By.linkText("Seller")).click();
	}

	@When("^Enter username and password$")
	public void enter_username_and_password() throws Throwable {
		driver.findElement(By.id("LoginAction_username")).sendKeys("root");
		driver.findElement(By.id("LoginAction_password")).sendKeys("admin");
		driver.findElement(By.id("LoginAction_0")).click();

	}

	@Then("^Verify user is successfully logged in$")
	public void verify_user_is_successfully_logged_in() throws Throwable {

		String actual = driver.getTitle();
		//System.out.println(actual);
		String expected = "Seller Login";
		if (actual.equalsIgnoreCase(expected)) {
			System.out.println("User Logged in successfully");
		} else {
			System.out.println("User failed to Log in");
		}

	}

	@When("^Click on add product link$")
	public void click_on_add_product_link() throws Throwable {
		//driver.findElement(By.linkText("AddProduct")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Add Product')]")).click();
	}

	@When("^Enter product name and product model$")
	public void enter_product_name_and_product_model() throws Throwable {
		driver.findElement(By.id("AddProductAction_product_name")).sendKeys("Lenovo");
		driver.findElement(By.id("AddProductAction_product_model")).sendKeys("T420");
		
	}

	@When("^Click on Add button$")
	public void click_on_Add_button() throws Throwable {
		driver.findElement(By.id("AddProductAction_0")).click();
		
	}

	@Then("^Verify product is added successfully$")
	public void verify_product_is_added_successfully() throws Throwable {
		String actual = driver.getTitle();
	//	System.out.println(actual);
		String expected = "Add Product Success";
		
		if (actual.equalsIgnoreCase(expected)) {
			System.out.println("Product added successfully");
		} else {
			System.out.println("error accored!");
		}
		
	}
	
	@When("^Click on bidder link$")
	public void click_on_bidder_link() throws Throwable {
		driver.findElement(By.xpath("//a[contains(text(),'Bidder')]")).click();
		//driver.findElement(By.linkText("Bidder")).click();
	}

	@When("^Select bid link against a product to bid$")
	public void select_bid_link_against_a_product_to_bid() throws Throwable {
	
		driver.findElement(By.xpath("//a[contains(text(),'Bid')]")).click();
	}

	@When("^Enter bidder details and save$")
	public void enter_bidder_details_and_save() throws Throwable {
	
		driver.findElement(By.id("AddBidderAction_product_name")).sendKeys("Lenovo");
		driver.findElement(By.id("AddBidderAction_auction_prize")).sendKeys("25000");
		driver.findElement(By.id("AddBidderAction_name")).sendKeys("Kumar");
		driver.findElement(By.id("AddBidderAction_email")).sendKeys("kumar@gmail.com");
		driver.findElement(By.id("AddBidderAction_phone")).sendKeys("9999999999");
		driver.findElement(By.id("AddBidderAction_address")).sendKeys("Chennai");
		driver.findElement(By.id("AddBidderAction_0")).click();
	}

	@Then("^Verify bidder details are added successfully$")
	public void verify_bidder_details_are_added_successfully() throws Throwable {
		String actual = driver.getTitle();
	//	System.out.println(actual);
		String expected = "Add Bidder Success";
		
		if (actual.equalsIgnoreCase(expected)) {
			System.out.println("Bidder added successfully");
		} else {
			System.out.println("error accored!");
		}
	
	}
	
	@When("^Click on view product link$")
	public void click_on_view_product_link() throws Throwable {
		driver.findElement(By.xpath("//a[contains(text(),'View Products')]")).click();
	}

	@When("^Click on close bid button$")
	public void click_on_close_bid_button() throws Throwable {
		driver.findElement(By.xpath("//a[contains(text(),'Close Bid')]")).click();
	}

	@Then("^Verify bidding winner details displayed for that product$")
	public void verify_bidding_winner_details_displayed_for_that_product() throws Throwable {
		String actual = driver.findElement(By.xpath("//h2[contains(text(),'Bidding Winner')]")).getText();
		String expected = "Bidding Winner";
		if (actual.equalsIgnoreCase(expected)) {
			System.out.println("Bidding winner details displayed successfully");
		} else {
			System.out.println("error accored!");
		}
	}

}