package com.synisys.entities;

public class UserToken implements Token{
    private int tokenId;
    private int userId;
    private static int tokenGen = 0;

    public UserToken ( int userId) {
        this.tokenId = tokenGen;
        this.userId = userId;
        tokenGen ++;
    }

    public int getTokenId() {
        return tokenId;
    }

    public int getUserId() {
        return userId;
    }
}
