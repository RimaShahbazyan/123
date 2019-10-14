package com.synisys.data.bulkData;

import com.synisys.data.UserData;
import com.synisys.entities.User;

public class DummyUserData implements UserData {
    private static DummyUserData ourInstance = new DummyUserData();
    private User[] users;
    public static DummyUserData getInstance() {
        return ourInstance;
    }

    private DummyUserData() {
        String[] names = {"Meri", "Anna", "Valod", "Vazgen"};
        String[] surnames = {"Khachatryan", "Poghosyan", "Minasyan", "Mkrtchyan"};
        String[] emails = {"mk@gmail.com", "annpogh@gmail.com", "valodik2005@yahoo.com",
                "Vazgen.Mkrtchyan@gmail.com"};
        String[] passwords = {"123456", "anushik-pupushik", "!@#123", "veryStrongPassword"};
        init(names,surnames, emails,passwords);
    }
    private void init(String[] names, String[] surnames, String[] emails, String[] password) {
        users = new User[emails.length];
        for (int i = 0; i < emails.length; i++) {
            User newUser = new User(names[i], surnames[i], emails[i], password[i]);
            users[i]= newUser;
        }
    }

    public User[] getUsers() {
        return users;
    }
}

