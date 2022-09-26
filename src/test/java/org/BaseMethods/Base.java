package org.BaseMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Base {

    WebDriver driver;
    public Base(WebDriver driver){
        this.driver= driver;
    }

    public void click(By element){
        driver.findElement(element).click();
    }
    public void clear(By element){
        driver.findElement(element).clear();
    }
    public void back(){
        driver.navigate().back();
    }
    public void sendKeys(By element,String word){
        driver.findElement(element).sendKeys(word);
    }
    public void AssertText(String Expected,String Actual){
        Assert.assertEquals(Actual, Expected);
    }

    public String getText(By element){
        return driver.findElement(element).getText();
    }
    public void isDisplayed(By element){
        Assert.assertTrue(driver.findElement(element).isEnabled());
    }


}
