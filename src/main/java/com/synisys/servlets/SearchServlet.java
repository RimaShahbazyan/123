package com.synisys.servlets;

import com.synisys.dataManager.SearchDataManager;
import com.synisys.dataManager.JsonManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/Search")
public class SearchServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String text = req.getReader().readLine();
        SearchDataManager data = new SearchDataManager();
        if (text == null)
            text = "";
        String respBody = JsonManager.arrayListToJson(data.contains(text));
        resp.getWriter().print(respBody);
    }
}
