package com.todoist.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SingInPage
{
    private final WebDriver driver;
    private final WebDriverWait wait;


    @FindBy(name = "email")
    private WebElement loginElement;

    @FindBy(id = "password")
    private WebElement passwordElement;

    @FindBy(css = "[class=\"submit_btn ist_button ist_button_red sel_login\"]")
    private WebElement signInButton;

    @FindBy(linkText = "Sign up")
    private WebElement signUpButton;

    private final By errors = By.cssSelector("[class=\"error_msg\"]");

    private final By taskLocator = By.cssSelector("[class=\"plus_add_button\"]");

    public SingInPage(WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(driver, 60);
    }

    public void fillLogin(String login)
    {
        loginElement.sendKeys(login);
    }

    public void fillPassword(String password)
    {
        passwordElement.sendKeys(password);
    }

    public void signIn()
    {
        signInButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(taskLocator));

    }

    public void signUp()
    {
        signUpButton.click();
    }

    public String getCurrentUrl()
    {
        return driver.getCurrentUrl();
    }

    public boolean hasErrorMessages()
    {
        return driver.findElements(errors).size() > 0;
    }
}