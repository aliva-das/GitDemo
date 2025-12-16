package eCommerce.tests;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import eCommerce.AbstractComponents.OrdersPage;
import eCommerce.TestComponenets.BaseTest;
import eCommerce.pageobjects.CartPage;
import eCommerce.pageobjects.ConfirmationPage;
import eCommerce.pageobjects.ProductCatalogue;
import eCommerce.pageobjects.checkoutpage;

public class StandAloneTest extends BaseTest {
  
	String productName = "ZARA COAT 3";
      @Test(dataProvider="getData", groups= {"Purchase"})
      
      public void submitOrder(HashMap<String,String> input)  {

	
		
		ProductCatalogue productcatalogue = landingpage.loginApplication(input.get("email"), input.get("password"));
		@SuppressWarnings("unused")
		List<WebElement> products = productcatalogue.getProductList();
		productcatalogue.addProductToCart(input.get("product"));
		CartPage cartpage = productcatalogue.goToCartPage();
		
		Boolean match= cartpage.VerifyProductDisplay(input.get("product"));
		Assert.assertTrue(match);
		checkoutpage checkoutpage= cartpage.goToCheckout();
		checkoutpage.selectCountry("India");
		ConfirmationPage confirmationpage =checkoutpage.submitOrder();
		String confirmmessage=confirmationpage.getConfirmationMessage();
		Assert.assertTrue(confirmmessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
      }
		//To verify if Zara Coat 3 is displaying in orders page
		
		@Test(dependsOnMethods= {"submitOrder"})
		public void OrderHistoryTest() {
			ProductCatalogue productcatalogue = landingpage.loginApplication("aliva.august20@gmail.com", "Password@20");
			OrdersPage orderpage= productcatalogue.goToOrdersPage();
			Assert.assertTrue(orderpage.VerifyOdrerDisplay(productName));
			
		}
		
	
		@DataProvider
		public Object[][] getData() throws IOException{
			
			List<HashMap<String,String>> data= getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\eCommerce\\data\\PurchaseOrder.json");
			return new Object[][] {{data.get(0)},{data.get(1)}};
		}
}
		
			
		/*	HashMap<String,String> map= new HashMap<String,String>();
			map.put("email", "aliva.august20@gmail.com");
			map.put("password", "Password@20");
			map.put("product", "ZARA COAT 3");
			
			HashMap<String,String> map1= new HashMap<String,String>();
			map1.put("email", "lily@gmail.com");
			map1.put("password", "Password@20");
			map1.put("product", "ADIDAS ORIGINAL");
			
			
			
			//return new Object[][] {{"aliva.august20@gmail.com","Password@20","ZARA COAT 3"},{"lily@gmail.com","Password@20","ADIDAS ORIGINAL"}}; */
			
			
		
	




