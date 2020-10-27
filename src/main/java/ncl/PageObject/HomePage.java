package ncl.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import ncl.BasePage.BasePage;
import ncl.CommonAction.BrowserFunction;
import ncl.CommonAction.SelectionType;

public class HomePage extends BasePage{

	private String Destination_xPath = "//span[@class='e1_toggle_single' and text()='Destination']";
	private String DestinationName_xpath = "//span[@class='e5_label' and text()='Australia & New Zealand Cruises']";
	private String Apply_btn_xpath = "//div[@class='c22_menu_wrap']//a[@class='link-2' and text()='Apply']";
	private String date_xpath = "//span[@class='e1_toggle_single' and text()='Dates']";
	private String calederDate_xpath = "//li[@data-year='2021' and @data-value='December']";
	private String ApplyDate_btn_xpath = "//div[@class='c22_menu -center-md-up']//a[@class='link-2' and text()='Apply']";
	private String FindACruise_xpath = "//a[@class='btn btn-secondary btn-lg btn-short']";
	private String ViewCruise_xpath = "//li[@class='favoritesList_item']//a[@aria-label='View Cruise']";
	private String PricesList_xPath = "//li[@class='listing_item']//span[@class='headline-1 -variant-3']";



	public String calederDate_xpathBreake(String year, String months) {
		String xPath=null;
		String beforeYear = "//li[@data-year='";
		String afterYear = "' and @data-value='";
		String afterMonths = "']";
		xPath = beforeYear+year+afterYear+months+afterMonths;
		return xPath;
	}
	
	public String DestinationName_xpathBreaker(String destinationName) {
		String xPath = null;
		String beforeDestination = "//span[@class='e5_label' and text()='";
		String afterDestination = "']";
		xPath = beforeDestination+destinationName+afterDestination;
		return xPath;
	}

	public void searchDestination(String destinationName) throws InterruptedException {
		try {
			BrowserFunction.clickOn(Destination_xPath, SelectionType.elementType.Xpath);
			BrowserFunction.clickOn(DestinationName_xpathBreaker(destinationName), SelectionType.elementType.Xpath);
			BrowserFunction.clickOn(Apply_btn_xpath, SelectionType.elementType.Xpath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public void selectDate(String year, String months) {
		try {
			BrowserFunction.clickOn(date_xpath, SelectionType.elementType.Xpath);
			BrowserFunction.clickOn(calederDate_xpathBreake(year, months), SelectionType.elementType.Xpath);
			BrowserFunction.clickOn(ApplyDate_btn_xpath, SelectionType.elementType.Xpath);
			BrowserFunction.clickOn(FindACruise_xpath, SelectionType.elementType.Xpath);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void getPriceFromList() {
		List<WebElement> elements = driver.findElements(By.xpath(PricesList_xPath));
	    System.out.println("Number of elements:" +elements.size());
	    for (int i=0; i<elements.size();i++){
	        System.out.println("Price List--> " + elements.get(i).getText());
	      }
		
	}




}
