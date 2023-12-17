package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

import static stepdefinition.SharedSD.getDriver;

public class Base {

    public WebElement webAction(By locator)
    {
       WebElement element =  getDriver().findElement(locator);
       return element ;
    }

    public void clickOn(By locator)
    {
       // getDriver().findElement(locator).click();
   /*  WebElement webElement =  webAction(locator);
        webElement.click();*/
        webAction(locator).click();
    }

    public void setValue(By locator,String value)
    {
        webAction(locator).sendKeys(value);
    }

    public void selectFromDropDown(By locator,String value)
    {
        WebElement wb = webAction(locator);
        Select sel = new Select(wb);
        sel.selectByVisibleText(value);
    }

    public String getTextValue(By locator)
    {
        return webAction(locator).getText();
    }

    public ArrayList<String> getElementTextList(By locator)
    {
        List<WebElement> wblList = getDriver().findElements(locator);
        ArrayList<String> txtList = new ArrayList<>();

        for (WebElement wb :wblList)
        {
            txtList.add(wb.getText());
        }

        return txtList;
    }
}
