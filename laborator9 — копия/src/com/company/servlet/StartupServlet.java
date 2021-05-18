package com.company.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import com.company.classes.Ad;
import com.company.classes.AdList;
import com.company.classes.AdListHelper;
import com.company.classes.UserList;
import com.company.classes.UserListHelper;

/**
 * Servlet implementation class StartupServlet
 */
@WebServlet("/StartupServlet")
public class StartupServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        UserList userList =
                UserListHelper.readUserList(getServletContext());

        getServletContext().setAttribute("users", userList);

        AdList adList = AdListHelper.readAdList(getServletContext());

        getServletContext().setAttribute("ads", adList);
        for (Ad ad: adList.getAds()) {

            ad.setAuthor(userList.findUser(ad.getAuthorId()));

            ad.setLastModified(ad.getLastModified());
        }
    }

}
