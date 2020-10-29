package ncl.CommonAction;

public class SelectionType {
	public enum elementType{
		Id,
		ClassName,
		Xpath,
		CssClector,
		Linktext,
		Name,
		PartialLinkText,
		TagName
	}

	public enum WaitCondition{
		elementToBeSelected,
		ElementIsVisible,
		ElementToBeClickable,
		textToBePresentInElement,
		visibilityOfElementLocated,
		alertIsPresent
	}

}
