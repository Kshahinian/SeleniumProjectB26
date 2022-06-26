package com.cydeo.test.day7_testNG_dropdown_alert_iframe;

import com.cydeo.test.utilities.WebDriverFactory;
import com.google.common.base.Verify;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.w3c.dom.Text;

import java.util.concurrent.TimeUnit;

public class T1_Simple_Dropdown {

    //    TC #1: Verifying “Simple dropdown” and “State selection” dropdown default values
    //      1. Open Chrome browser

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){

        // set up chrome and create WebDriver instance
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //      2. Go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }



    @Test
    public void simpleDropdownTest(){


        //      3. Verify “Simple dropdown” default selected value is correct
        //          Expected: “Please select an option”
        Select simpleDropDown = new Select(driver.findElement(By.id("dropdown")));

        String actualDefaultDropdown = simpleDropDown.getFirstSelectedOption().getText();
        String expectedDefaultSimpleDropdown = "Please select an option";

        Assert.assertEquals(actualDefaultDropdown, expectedDefaultSimpleDropdown, "Simple Dropdown verification failed.");


    }

    @Test
    public void stateDropDown(){
        //      4. Verify “State selection” default selected value is correct
        //          Expected: “Select a State”
        Select stateDropDown = new Select(driver.findElement(By.id("state")));
        String actualStateDefaultText = stateDropDown.getFirstSelectedOption().getText();
        String expectedStateDefaultText = "Select a State";

        Assert.assertEquals(actualStateDefaultText, expectedStateDefaultText, "State dropdown verification failed.");

    }

}
