package com.todoist;

import com.todoist.pages.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

public class TaskTests extends WebDriverTests
{
    private static String email;
    private static String password;

    @BeforeClass
    public static void generateEmail()
    {
        UserDataLoader loader = new UserDataLoader();
        TestUser user = loader.Load();
        email = user.email;
        password = user.password;
    }

    @Before
    public void openRepositoryPage()
    {
        HomePage homePage = open();
        signIn(homePage);
    }

    private HomePage open()
    {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.open();
        return homePage;
    }

    private void signIn(HomePage homePage)
    {
        homePage.openSignInPage();
        SingInPage singInPage = PageFactory.initElements(driver, SingInPage.class);
        singInPage.fillLogin(email);
        singInPage.fillPassword(password);
        singInPage.signIn();
    }

    @Test
    public void createTask()
    {
        TasksPage page = PageFactory.initElements(driver, TasksPage.class);
        int previousAmount = page.GetNumberOfTasks();
        page.createRandomTask();
        int newAmount = page.GetNumberOfTasks();
        Assert.assertEquals(newAmount, previousAmount + 1);
    }

    @Test
    public void createWrongTask()
    {
        TasksPage page = PageFactory.initElements(driver, TasksPage.class);
        int previousAmount = page.GetNumberOfTasks();
        page.createTask("");
        int newAmount = page.GetNumberOfTasks();
        Assert.assertEquals(newAmount, previousAmount + 1);
    }

}
