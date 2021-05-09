package com.todoist;

import com.todoist.pages.HomePage;
import com.todoist.pages.SingInPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

public class SingInTests extends WebDriverTests
{
    private final String url = "https://todoist.com/app/today";

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
    public void openSignInPage()
    {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.open();
        homePage.openSignInPage();
    }

    @Test
    public void singInWithEmail()
    {
        SingInPage singInPage = PageFactory.initElements(driver, SingInPage.class);
        singInPage.fillLogin(email);
        singInPage.fillPassword(password);
        singInPage.signIn();

        Assert.assertEquals(url, singInPage.getCurrentUrl());
    }

    @Test
    public void singInWrongPassword()
    {
        SingInPage singInPage = PageFactory.initElements(driver, SingInPage.class);
        singInPage.fillLogin(email);
        singInPage.fillPassword("wrong_password");
        singInPage.signIn();

        Assert.assertTrue(singInPage.hasErrorMessages());
    }

    @Test
    public void openSingUp()
    {
        SingInPage singInPage = PageFactory.initElements(driver, SingInPage.class);
        singInPage.signUp();
        Assert.assertEquals(url, singInPage.getCurrentUrl());
    }
}