import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Greenkart2 {

	public static void main(String[] args) {
        
		// array to array list for easy search 
		// Check whether name u extracted is present in array list or not
		
		System.setProperty("WebDriver.chrome.driver", "C:\\Users\\suhas\\Documents\\Chrome.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		String[] itemsneeded = { "Brocolli", "Cauliflower", "Cucumber" };
		List<WebElement> product = driver.findElements(By.cssSelector("h4.product-name"));
		for (int i = 0; i < product.size(); i++) {
			String name = product.get(i).getText();
			List itemNeededList = Arrays.asList("itemsneeded");
			if (itemNeededList.contains(name)) {
				driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();

			}
		}

	}

}
