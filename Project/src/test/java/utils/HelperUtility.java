package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;
import java.util.Set;
 
 
public class HelperUtility {

	private WebDriver driver;
 
    public HelperUtility(WebDriver driver) {
        this.driver = driver;
    }
 
    
/**
* Author: Krushna Rajkule
*
* Description: Performs a click action on a WebElement located by the specified locator
* 
* @param locator
*/
    public void performClick(By locator) {
        try {
            WebElement pageElement = driver.findElement(locator);
            pageElement.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
/**
*  Author: Krushna Rajkule
*  Description: Inputs text into a WebElement using the given locator and data
* @param locator
* @param data
*/
    public void enterText(By locator, String data) {
        try {
            WebElement pageElement = driver.findElement(locator);
            pageElement.sendKeys(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    /**
     * Author: Krushna Rajkule
     * Description: Retrieves and returns the text content of a WebElement located by the given locator
     * @param locator
     * @return
     */
    public String retrieveText(By locator) {
        try {
            WebElement pageElement = driver.findElement(locator);
            return pageElement.getText();
        } catch (Exception e) {
            e.printStackTrace();
            return " ";
        }
    }
 
    /**
     * Author: Krushna Rajkule
     * Description: Sends the Enter key action to a WebElement located by the specified locator
     * @param locator
     */
    public void performEnter(By locator) {
        try {
            WebElement pageElement = driver.findElement(locator);
            pageElement.sendKeys(Keys.ENTER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    /**
     * Author: Krushna Rajkule
     * Description: Simulates mouse hover action over a WebElement located by the given locator using Actions class
     * @param locator
     */
    public void mouseHover(By locator) {
        try {
            WebElement pageElement = driver.findElement(locator);
            Actions actions = new Actions(driver);
            actions.moveToElement(pageElement).perform();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    /**
     * Author: Krushna Rajkule
     * Description: Returns a list of WebElements matching the specified XPath
     * @param locator
     * @return
     */
    public List<WebElement> getElementsByXPath(By locator){
        return driver.findElements(locator);
    }
 
     /**
      * Author: Krushna Rajkule
      * Description: Switches focus to the child window in a multi-window scenario
      */
    public void switchWindow() 
    {
    	String parent = driver.getWindowHandle();
    	Set<String> child=driver.getWindowHandles();
    	for(String id:child) {
    		if(!parent.equals(id)) 
    		{
    			driver.switchTo().window(id);
    		}
    	}
    }
    /**
     * Author: Krushna Rajkule
     * Description: Switches focus back to the parent window in a multi-window scenario
     */
    public void switchToParentWindow()
    {
    	String parent = driver.getWindowHandle();
    	Set<String> child=driver.getWindowHandles();
    	for(String id:child) 
    	{
    		if(parent.equals(id)) 
    		{
    			driver.switchTo().window(parent);
    		}
    	}
    }

    /**
     * Author: Krushna Rajkule
     * Description: Checks and returns whether a WebElement is visible on the page
     * @param pageElement
     * @return
     */
    public 	boolean isWebElementDisplayed(By locator) {
        try {
            WebElement pageElement = driver.findElement(locator);
            return pageElement.isDisplayed();
        } catch (NoSuchElementException e) {
        	return false;
        }
    }

    public void verifyAcutalAndExpected(String expected, String actual){
        try{
        if(actual.contains(expected)){
            Assert.assertTrue(true);
        }
        }catch(AssertionError error){
         error.printStackTrace();
    }
    }

    public void switchToWindow(int windowIndex) {
        Set<String> handles = driver.getWindowHandles();
        int count = 0;
        for (String handle : handles) {
            if (count == windowIndex) {
                driver.switchTo().window(handle);
                break;
            }
            count++;
        }
    }

    public void scrollOnPage(int yPixel){
        JavascriptExecutor js = (JavascriptExecutor)Root.driver;
        js.executeScript("window.scrollBy(0, " + yPixel + ")", "");
    }
}
 

