package com.todoist.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class TasksPage
{
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By projectLocator = By.xpath("//*[@id=\"projects_list\"]/li");

    private final By submitButtonLocator = By.id("reactist-modal-box-13");

    @FindBy(xpath = "//*[@id=\"list_holder\"]/div[2]/div[1]/div/button")
    private WebElement signUpButton;

    @FindBy(xpath = "//*[@id=\"edit_project_modal_field_name\"]")
    private WebElement nameInput;

    @FindBy(xpath = "/html/body/reach-portal/div[3]/div/div/div[3]/div/form/footer/button[2]")
    private WebElement submitButton;


    public TasksPage(WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(driver, 400);
    }


    public void createRandomTask()
    {
        String name = randomName();
        createTask(name);
    }

    public void createTask(String name)
    {
        try
        {
            signUpButton.click();
            Thread.sleep(500);
            nameInput.sendKeys(name);
            Thread.sleep(500);
            submitButton.click();
            Thread.sleep(1000);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public String randomName()
    {
        int leftLimit = 97;
        int rightLimit = 122;
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++)
        {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }

        return buffer.toString();
    }

    public int GetNumberOfTasks()
    {
        List<WebElement> listFromXpath = driver.findElements(projectLocator);
        return listFromXpath.size();
    }
}
