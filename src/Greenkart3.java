import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Greenkart3 {

	public static void main(String[] args) {
		//formatting the name of item using trim & split
		// counting the number of time loop executes
		
		System.setProperty("WebDriver.chrome.driver", "C:\\Users\\suhas\\Documents\\Chrome.exe");
		WebDriver driver = new ChromeDriver();
		int j=0;
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		String[] itemsneeded = { "Brocolli", "Cauliflower", "Cucumber","Carrot","Brinjal" };
		List<WebElement> product = driver.findElements(By.cssSelector("h4.product-name"));
		for (int i = 0; i < product.size(); i++) {
			
			String[] name = product.get(i).getText().split("-");   //formating
			String formattedstring= name[0].trim();       //formating and removing whitespace
			
			List itemNeededList = Arrays.asList(itemsneeded);
			if (itemNeededList.contains(formattedstring)) {
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if(j==itemsneeded.length)
				{
				
				break;
				}
				

			}
	}

	}
}
