package com.todoist.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage
{
    private final String url = "https://todoist.com/";

    @FindBy(linkText = "Log in")
    private WebElement logInButton;

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By singUpLocator = By.linkText("Sign up");

    private final By singIn = By.id("email");

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(driver, 60);
    }

    public void open()
    {
        driver.get(url);
    }

    public void openSignInPage()
    {
        logInButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(singIn));
    }

    public void openSignUpPage()
    {
        driver.findElement(singUpLocator).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(singIn));
    }
}