package com.synisys.dataManager;

import com.synisys.data.UserData;
import com.synisys.entities.User;

public class UserManager {
    private User[] users;
    public UserManager (UserData userData){
        users = userData.getUsers();
    }
    public User getUserByEmail(String email){
        for (User user : users){
            if( user.getEmail() .equals( email))
                return user;
        }
        return null;
    }
    public User getUserByUserId(int uId){
        for (User user : users){
            if( user.getId()==( uId))
                return user;
        }
        return null;
    }
}
