package ncl.PageObject;

import java.util.List;

import org.openqa.selenium.WebElement;

import ncl.CommonAction.BrowserFunction;
import ncl.CommonAction.SelectionType;

public class HomePage{

	//WebElements
	private String Destination_xPath = "//span[@class='e1_toggle_single' and text()='Destination']";
	private String DestinationName_xpath = "//span[@class='e5_label' and text()='Australia & New Zealand Cruises']";
	private String Apply_btn_xpath = "//div[@class='c22_menu_wrap']//a[@class='link-2' and text()='Apply']";
	private String date_xpath = "//span[@class='e1_toggle_single' and text()='Dates']";
	private String calederDate_xpath = "//li[@data-year='2021' and @data-value='December']";
	private String ApplyDate_btn_xpath = "//div[@class='c22_menu -center-md-up']//a[@class='link-2' and text()='Apply']";
	private String FindACruise_xpath = "//a[@class='btn btn-secondary btn-lg btn-short']";
	private String ViewCruise_xpath = "//a[@class='btn btn-secondary btn-lg' and @aria-label='View Cruise']";  //li[@class='listing_item']//a[@aria-label='View Cruise']";
	private String PricesList_xPath = "//li[@class='listing_item']//span[@class='headline-1 -variant-3']";
	private String DatePriceList_xPath = "//ul[@data-js='carousel-items']//a[@class='c165_link']"; //ul[@data-js='carousel-items']"; //"//ul[@data-js='carousel-items']//a[@class='c165_link']";

	private String PriceAmount = null;

	// Generating customize xPath for entering date.
	public String calederDate_xpathBreake(String year, String months) {
		String xPath=null;
		String beforeYear = "//li[@data-year='";
		String afterYear = "' and @data-value='";
		String afterMonths = "']";
		xPath = beforeYear+year+afterYear+months+afterMonths;
		return xPath;
	}

	/**
	 *  Generating customize xPath for entering Destination.
	 * @param destinationName
	 * @return
	 */
	public String DestinationName_xpathBreaker(String destinationName) {
		String xPath = null;
		String beforeDestination = "//span[@class='e5_label' and text()='";
		String afterDestination = "']";
		xPath = beforeDestination+destinationName+afterDestination;
		return xPath;
	}

	/**
	 * Select the destination using this function
	 * @param destinationName
	 * @throws InterruptedException
	 */
	public void searchDestination(String destinationName) throws InterruptedException {
		try {
			BrowserFunction.clickOn(Destination_xPath, SelectionType.elementType.Xpath);
			BrowserFunction.clickOn(DestinationName_xpathBreaker(destinationName), SelectionType.elementType.Xpath);
			BrowserFunction.clickOn(Apply_btn_xpath, SelectionType.elementType.Xpath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/**
	 * Select the date from the calender using this function
	 * @param year
	 * @param months
	 */
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


	private String getPriceAmount(int index) {
		String str = null;
		List<WebElement> elements;
		try {
			elements = BrowserFunction.getWebElements(PricesList_xPath, SelectionType.elementType.Xpath);
			if(BrowserFunction.isDisplayed(elements.get(index))) {
				System.out.println("Get Price Amount for Cruises Tour:" +elements.get(index).getText());
				str = elements.get(index).getText();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}

	public void selectViewCruise() {
		List<WebElement> elements;
		try {
			elements = BrowserFunction.getWebElements(ViewCruise_xpath, SelectionType.elementType.Xpath);
			System.out.println("Total Number of Suggestion Cruises Tour:" +elements.size());
			for (int i=0; i<elements.size();i++){
				if(BrowserFunction.isDisplayed(elements.get(i))) {
					PriceAmount = getPriceAmount(i);
					BrowserFunction.clickInJavaScript(elements.get(i));
					break;
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	public ArrayList<String> getPriceListFromDatesPrices(){
//		ArrayList<String> priceList = new ArrayList<String>();
//		List<WebElement> elements;
//		try {
//			elements = BrowserFunction.getWebElements(DatePriceList_xPath, SelectionType.elementType.Xpath);
//			for (int i=0; i<elements.size();i++){
//				System.out.println("Price List--> "+elements.get(i).getText());
//				String price = elements.get(i).getText();
//				priceList.add(price);
//				
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println("Price SIZE--> "+priceList.size());
//		return priceList;
//
//	}

	public boolean AtLeastOneCategoryMetaPriceMatch(){
		List<WebElement> elements;
		try {
			elements = BrowserFunction.getWebElements(DatePriceList_xPath, SelectionType.elementType.Xpath);
			for(int i=0; i<elements.size();i++){
				System.out.println("Price List--> "+elements.get(i).getText());
				String price = elements.get(i).getText();
				if(PriceAmount.equals(price)) {
					return true;
				}					
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;

	}




}
