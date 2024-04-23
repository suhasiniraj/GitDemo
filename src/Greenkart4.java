import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Greenkart4 {

	public static void main(String[] args) throws InterruptedException {
		// synchronization concepts
		System.setProperty("WebDriver.chrome.driver", "C:\\Users\\suhas\\Documents\\Chrome.exe");
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(5, offsecond.5);
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		String[] itemsneeded = { "Brocolli", "Cauliflower", "Cucumber", "Carrot", "Brinjal" };
		Greenkart4 green=new Greenkart4();
		green.addItems(driver, itemsneeded);
		green.cartItem(driver);

	}

	public void addItems(WebDriver driver, String[] itemsneeded) {
		int j = 0;
		List<WebElement> product = driver.findElements(By.cssSelector("h4.product-name"));
		for (int i = 0; i < product.size(); i++) {

			String[] name = product.get(i).getText().split("-"); // formating
			String formattedstring = name[0].trim(); // formating and removing whitespace

			List itemNeededList = Arrays.asList(itemsneeded);
			if (itemNeededList.contains(formattedstring)) {
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if (j == itemsneeded.length) {

					break;
				}

			}

		}
	}
	public void cartItem(WebDriver driver) throws InterruptedException
	{
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.cssSelector("div[class='cart-preview active'] button[type='button']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Enter promo code']")).sendKeys("RahulshettyAcademy");
		driver.findElement(By.cssSelector(".promoBtn")).click();
		driver.findElement(By.xpath("//button[normalize-space()='Place Order']")).click();
	}
}
