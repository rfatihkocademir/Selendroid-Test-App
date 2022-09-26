package org.example;


import org.BaseMethods.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;



public class AppTest
{
    WebDriver driver = DriverSetter.setUp();
    Base android = new Base(driver);
    public AppTest() throws MalformedURLException {
    }
    By allowButton = By.id("com.android.permissioncontroller:id/continue_button");
    By skipUpdatePopUp = By.id("android:id/button1");
    By ENButton = By.id("io.selendroid.testapp:id/buttonTest");
    By PopMessageText = By.id("android:id/message");
    By NoButton = By.id("android:id/button2");
    By ChromeButton = By.id("io.selendroid.testapp:id/buttonStartWebview");
    By DropDown = By.id("io.selendroid.testapp:id/spinner_webdriver_test_data");
    By AlertTitle = By.id("android:id/alertTitle");
    By WebviewArea = By.id("io.selendroid.testapp:id/webviewTable");
    By WebViewTitle = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.TableLayout/android.widget.TableRow[4]/android.webkit.WebView/android.webkit.WebView/android.widget.TextView");
    By NameInput = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.TableLayout/android.widget.TableRow[4]/android.webkit.WebView/android.webkit.WebView/android.view.View/android.widget.EditText");
    By CarDropDown = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.TableLayout/android.widget.TableRow[4]/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View");
    By SelectedCar = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[2]");
    By SendMeButton = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.TableLayout/android.widget.TableRow[4]/android.webkit.WebView/android.webkit.WebView/android.view.View/android.widget.Button");
    By WebViewGivenName = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.TableLayout/android.widget.TableRow[4]/android.webkit.WebView/android.webkit.WebView/android.widget.TextView[4]");
    By GotoHomepage = By.id("io.selendroid.testapp:id/goBack");
    By ProgressBarOpenButton = By.id("io.selendroid.testapp:id/waitingButtonTest");
    By ProgressBarView = By.id("android:id/parentPanel");
    By DisplayTextViewButton = By.id("io.selendroid.testapp:id/visibleButtonTest");
    By VisibleText = By.id("io.selendroid.testapp:id/visibleTextView");
    By DisplayToastButton = By.id("io.selendroid.testapp:id/showToastButton");
    By ToastMessage = By.id("android:id/content");
    By ShowPopUpButton = By.id("io.selendroid.testapp:id/showPopupWindowButton");
    By CheckBox = By.id("io.selendroid.testapp:id/input_adds_check_box");
    By AppTitle = By.id("android:id/title");
    @BeforeTest
    public void BeforeTest(){
        android.click(allowButton);
        android.click(skipUpdatePopUp);
    }

    @Test
    public void AppTitleCheckCase(){
        android.AssertText("selendroid-test-app",android.getText(AppTitle));
    }
    @Test
    public void ENButtonCase(){

        android.click(ENButton);
        String Text = android.getText(PopMessageText);
        android.AssertText("This will end the activity",Text);
        android.click(NoButton);
    }
    @Test
    public void ChromeButtonCase(){
        String sendNameText = "Ramazan";
        android.click(ChromeButton);
        android.clear(NameInput);
        android.sendKeys(NameInput,sendNameText);
        android.click(DropDown);
        String Text = android.getText(AlertTitle);
        android.AssertText("Webdriver Test File",Text);
        android.back();
        android.click(CarDropDown);
        android.click(SelectedCar);
        android.click(SendMeButton);
        String ActualText = android.getText(WebViewGivenName);
        android.AssertText("\""+sendNameText+"\"",ActualText);
        android.click(GotoHomepage);
    }
    @Test
    public void ProgressBarCase(){
        android.click(ProgressBarOpenButton);
        android.isDisplayed(ProgressBarView);
        android.isDisplayed(ProgressBarView);
        android.back();
    }
    @Test
    public void CheckBoxCase(){
        Assert.assertTrue(!driver.findElement(CheckBox).isSelected());
        android.click(CheckBox);
        Assert.assertFalse(driver.findElement(CheckBox).isSelected());
    }
    @AfterTest
    public void tearDown(){
        DriverSetter.endOfTest();
    }
}
