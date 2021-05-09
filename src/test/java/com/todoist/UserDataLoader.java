package com.todoist;

import java.util.Map;

public class UserDataLoader
{
    public TestUser Load()
    {
        Map<String, String> env = System.getenv();
        String email = "haiduchyk.t@gmail.com";
        String password = "qwe12345678";
        TestUser testUser = new TestUser();
        testUser.email = email;
        testUser.password = password;
        return testUser;
    }
}