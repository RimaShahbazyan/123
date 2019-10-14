package com.synisys.servlets;

import com.synisys.data.bulkData.DummyUserData;
import com.synisys.dataManager.UserManager;
import com.synisys.dataManager.UserTokenManager;
import com.synisys.entities.User;
import com.synisys.exeptions.wrongTokenException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/auth")
public class AuthorizationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
        if (req.getCookies() != null) {
            int tokenId = -1;
            Cookie tokenIdCookie = null;
            int userId = -1;
            Cookie userIdCookie = null;
            for (Cookie c : req.getCookies()) {
                if (c.getName().equals("tokenId")) {
                    tokenId = Integer.parseInt(c.getValue());
                    tokenIdCookie = c;
                } else if (c.getName().equals("userId")) {
                    userId = Integer.parseInt(c.getValue());
                    userIdCookie = c;
                }
            }
            UserTokenManager tokenManager = new UserTokenManager();
            UserManager userManager = new UserManager(DummyUserData.getInstance());
            try {
                if (tokenManager.getUserIdByTokenId(tokenId) == userId) {
                    tokenIdCookie.setMaxAge(60 * 20 * 60);
                    userIdCookie.setMaxAge(60 * 20 * 60);
                    resp.sendRedirect("/welcome");
                }

            } catch (wrongTokenException e) {
                e.getMessage();
            }
        }
        else resp.sendError(401);
    } catch (Exception e) {
            PrintWriter out;
            User user;
            DummyUserData data = DummyUserData.getInstance();
            UserManager usMan = new UserManager(data);
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            out = resp.getWriter();
            user = usMan.getUserByEmail(email);
            if (user.getPassword().equals(password)) {
                UserTokenManager tokenManager = new UserTokenManager();
                String tokenId = Integer.toString(tokenManager.addToken(user.getId()).getTokenId());
                Cookie tCookie = new Cookie("tokenId",tokenId);
                tCookie.setMaxAge(10*60*60);
                Cookie uCookie = new Cookie("userId",Integer.toString(user.getId()));
                uCookie.setMaxAge(10*60*60);
                resp.addCookie(tCookie);
                resp.addCookie(uCookie);
                resp.sendRedirect("/welcome");
            } else {
                resp.sendError(401);
            }
        }
    }


}
