package com.qa.cineverse.selenium;

import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class Seltestfel {
    WebDriver driver;
    //ExtentsReports report;
    ExtentTest test;

    @BeforeTest
    public void startReport(){

    }





   public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\felix\\Automation Tests\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.gmail.com/");
        driver.manage().window().maximize();

   }

}