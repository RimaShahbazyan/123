package com.synisys.exeptions;

public class wrongTokenException extends Throwable {
    @Override
    public String getMessage() {
        return "The token is incorrect";
    }
}
