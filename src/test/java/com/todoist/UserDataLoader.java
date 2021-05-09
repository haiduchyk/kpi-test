package com.todoist;

import java.util.Map;

public class UserDataLoader
{
    public TestUser Load()
    {
        Map<String, String> env = System.getenv();
        String email = env.get("EMAIL");
        String password = env.get("PASSWORD");
        TestUser testUser = new TestUser();
        testUser.email = email;
        testUser.password = password;
        return testUser;
    }
}