package testCases;

import ncl.BasePage.BasePage;
import ncl.PageObject.HomePage;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class HomePageTest extends BasePage{
	private HomePage homePageObj = new HomePage();
	
	public HomePageTest() {
		super();
	}
	
	@Parameters({"browser"})
	@BeforeClass
	public void setUp(String browser){
		initialition(browser);
	}

	@Test
	public void VerifyWeAreInCruiseDetail() {
		try {
			homePageObj.searchDestination("Alaska Cruises");
			homePageObj.selectDate("2021","April");
			homePageObj.selectViewCruise();
			Assert.assertTrue(homePageObj.AtLeastOneCategoryMetaPriceMatch());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
