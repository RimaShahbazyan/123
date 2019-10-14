package com.synisys.dataManager;

import com.synisys.data.bulkData.TokenData;
import com.synisys.entities.Token;
import com.synisys.entities.UserToken;
import com.synisys.exeptions.wrongTokenException;

import java.util.ArrayList;

public class UserTokenManager {
    private ArrayList<Token> userTokens;
    public UserTokenManager(){
        userTokens = TokenData.getTokenData().getUserTokens();
    }
    public int getUserIdByTokenId(int tokenId) throws wrongTokenException {
        for(Token t : userTokens){
            if (t.getTokenId() == tokenId) {
                return ((UserToken)t).getUserId();
            }
        }
        throw new wrongTokenException();
    }
    public Token addToken(int uId){
        Token newT = new UserToken(uId);
        userTokens.add(newT);
        return newT;
    }
}
