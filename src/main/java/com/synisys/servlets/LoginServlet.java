package com.synisys.servlets;

import com.synisys.data.UserData;
import com.synisys.data.bulkData.DummyUserData;
import com.synisys.dataManager.UserManager;
import com.synisys.dataManager.UserTokenManager;
import com.synisys.exeptions.wrongTokenException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getCookies()!= null){
            int tokenId = -1;
            int userId = -1;
            for (Cookie c : req.getCookies()) {
                if(c.getName().equals("tokenId")){
                    tokenId = Integer.parseInt(c.getValue());
                }
                else if(c.getName().equals("userId")){
                    userId = Integer.parseInt(c.getValue());
                }
            }
            UserTokenManager tokenManager = new UserTokenManager();
            UserManager userManager = new UserManager(DummyUserData.getInstance());
            try {
                if (tokenManager.getUserIdByTokenId(tokenId) == userId){
                    resp.setStatus(200);
                }

            } catch (wrongTokenException e) {
                resp.sendError(401);
            }
        }
        else resp.sendError(401);
    }
}
