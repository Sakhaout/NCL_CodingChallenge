package ncl.CommonAction;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
                case textToBePresentInElement:
                    elmt = wait.until(ExpectedConditions.elementToBeClickable(element));
                    break;
                case visibilityOfElementLocated:
                    elmt = wait.until(ExpectedConditions.elementToBeClickable(element));
                    break;
                case alertIsPresent:
                    elmt = wait.until(ExpectedConditions.elementToBeClickable(element));
                    break;
			default:
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
    
    public static void enterText(String elementid, SelectionType.elementType elementType, String enterText) throws Exception {
        SelectionType.WaitCondition waitCondition = SelectionType.WaitCondition.ElementToBeClickable;
        WebElement element = explicitWait(get_ByElement(elementid, elementType),waitCondition);
        element.click();
    	element.sendKeys(enterText);
    }
    
    public static List <WebElement> getWebElements(String elementid, SelectionType.elementType elementType) throws Exception {
    	List<WebElement> elements = null;
		switch (elementType){
		case Id:
			elements = driver.findElements(get_ByElement(elementid, elementType));
			break;
		case ClassName:
			elements = driver.findElements(get_ByElement(elementid, elementType));
			break;
		case Xpath:
			elements = driver.findElements(get_ByElement(elementid, elementType));
			break;
		case CssClector:
			elements = driver.findElements(get_ByElement(elementid, elementType));
			break;
		case Linktext:
			elements = driver.findElements(get_ByElement(elementid, elementType));
			break;
		case Name:
			elements = driver.findElements(get_ByElement(elementid, elementType));
			break;
		case PartialLinkText:
			elements = driver.findElements(get_ByElement(elementid, elementType));
			break;
		case TagName:
			elements = driver.findElements(get_ByElement(elementid, elementType));
			break;
		default:
			throw new Exception("Element Not Found");
		}
		return elements;
    	
    }
    
    public static boolean isDisplayed(WebElement elementid) throws Exception {
    	SelectionType.WaitCondition waitCondition = SelectionType.WaitCondition.visibilityOfElementLocated;
    	boolean isDisplayed = elementid.isDisplayed();
    	return isDisplayed;
    }
	
    public static void getIframe() {
        List<WebElement> f = driver.findElements(By.tagName("frame"));
        System.out.println("Total number " + f.size());
        //return f.size();
    }
    
    public static void clickInJavaScript(WebElement elementid) throws Exception {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("arguments[0].click();", elementid);
    }
    
    public static void getTextInJavaScript(WebElement elementid) throws Exception {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("return arguments[0].value;", elementid);
    }
    
    public static void scrollIntoView(WebElement elementid) {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("arguments[0].scrollIntoView(true);", elementid);
    }

}
