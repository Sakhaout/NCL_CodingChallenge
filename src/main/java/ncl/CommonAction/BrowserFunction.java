package ncl.CommonAction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ncl.BasePage.BasePage;

public class BrowserFunction extends BasePage{

	
	/**
	 * This function will return By WebElement
	 * @param elementid
	 * @param elementType
	 * @return
	 * @throws Exception
	 */
	public static By get_ByElement(String elementid, SelectionType.elementType elementType) throws Exception{
		By element = null;
		switch (elementType){
		case Id:
			element = By.id(elementid);
			break;
		case ClassName:
			element = By.className(elementid);
			break;
		case Xpath:
			element = By.xpath(elementid);
			break;
		case CssClector:
			element = By.cssSelector(elementid);
			break;
		case Linktext:
			element = By.linkText(elementid);
			break;
		case Name:
			element = By.name(elementid);
			break;
		case PartialLinkText:
			element = By.partialLinkText(elementid);
			break;
		case TagName:
			element = By.tagName(elementid);
			break;
		default:
			throw new Exception("Element Not Found");
		}
		return element;
	}
	
	

	/**
	 * This function will return WebElement
	 * @param elementid
	 * @param elementType
	 * @return
	 * @throws Exception
	 */
	public static WebElement get_WebElements(String elementid, SelectionType.elementType elementType) throws Exception{
		WebElement element = null;
		switch (elementType){
		case Id:
			element = driver.findElement(get_ByElement(elementid, elementType));
			break;
		case ClassName:
			element = driver.findElement(get_ByElement(elementid, elementType));
			break;
		case Xpath:
			element = driver.findElement(get_ByElement(elementid, elementType));
			break;
		case CssClector:
			element = driver.findElement(get_ByElement(elementid, elementType));
			break;
		case Linktext:
			element = driver.findElement(get_ByElement(elementid, elementType));
			break;
		case Name:
			element = driver.findElement(get_ByElement(elementid, elementType));
			break;
		case PartialLinkText:
			element = driver.findElement(get_ByElement(elementid, elementType));
			break;
		case TagName:
			element = driver.findElement(get_ByElement(elementid, elementType));
			break;
		default:
			throw new Exception("Element Not Found");
		}
		return element;
	}
	
	/**
	 *
	 * @param element
	 * @param waitCondition
	 * @return
	 */
    public static WebElement explicitWait(By element, SelectionType.WaitCondition waitCondition){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement elmt = null;

        try{
            // wait for element.
            switch (waitCondition){
                case ElementIsVisible:
                    elmt = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
                    break;
                case ElementToBeClickable:
                    elmt = wait.until(ExpectedConditions.elementToBeClickable(element));
                    break;
            }
        }
        catch (Exception ex){
        	System.out.println("Fail" + ex.getMessage());
        }

        return elmt;
    }
    
    /**
     * 
     * @param elementid
     * @param elementType
     * @throws Exception
     */
    public static void clickOn(String elementid, SelectionType.elementType elementType) throws Exception{
        SelectionType.WaitCondition waitCondition = SelectionType.WaitCondition.ElementToBeClickable;
        WebElement element = explicitWait(get_ByElement(elementid, elementType),waitCondition);
        element.click();
    }
    
    /**
     * 
     * @param elementid
     * @param elementType
     * @return
     * @throws Exception
     */
    public static String getText(String elementid, SelectionType.elementType elementType) throws Exception {
    	String text = null;
    	SelectionType.WaitCondition waitCondition = SelectionType.WaitCondition.ElementIsVisible;
    	WebElement element = explicitWait(get_ByElement(elementid, elementType),waitCondition);
    	text = element.getText();
    	return text;
    }
    
    /**
     * 
     * @return
     */
    public static String getTitle() {
    	String title = null;
    	title = driver.getTitle();
    	return title;
    }
	

}
