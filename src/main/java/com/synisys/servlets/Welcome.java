package com.synisys.servlets;

import com.synisys.data.bulkData.DummyUserData;
import com.synisys.dataManager.UserManager;
import com.synisys.entities.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/welcome")
public class Welcome extends HttpServlet {

    @Override
    public void init() {

    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter out;
        User user;
        DummyUserData data = DummyUserData.getInstance();
        UserManager usMan = new UserManager(data);
        int userId = -1;
        for (Cookie c : req.getCookies()) {
            if (c.getName().equals("userId")) {
                userId = Integer.parseInt(c.getValue());
            }
        }
        user = usMan.getUserByUserId(userId);
        out = resp.getWriter();

        out.println("<h1>" +
                "Welcome " + user.getName() + " " +
                user.getSurname() +
                "</h1>" +
                "<a href=\"http://localhost:8010/Search.html\">Search Friends</a>");
    }
}