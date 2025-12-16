package eCommerce.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import eCommerce.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	WebDriver driver;
	
	@FindBy(css=".totalRow button")
	WebElement checkoutele;
	
	@FindBy(css=".cartSection h3")
	private List<WebElement> cartProducts;
	
	
	

		
	public Boolean VerifyProductDisplay(String productName) {
		
		Boolean match= cartProducts.stream().anyMatch(product-> product.getText().equalsIgnoreCase(productName));
		return match;
	}
	
	public checkoutpage goToCheckout() {
		
		checkoutele.click();
		return new checkoutpage(driver);

	}
	
}
