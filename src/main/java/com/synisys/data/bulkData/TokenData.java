package com.synisys.data.bulkData;

import com.synisys.entities.Token;

import java.util.ArrayList;
import java.util.ArrayList;

public class TokenData {
    private static TokenData ourInstance = new TokenData();
    private ArrayList<Token> userTokens ;
    public static TokenData getTokenData() {
        return ourInstance;
    }

    private TokenData() {
        userTokens = new ArrayList<Token>();
    }

    public ArrayList<Token> getUserTokens() {
        return userTokens;
    }
}
