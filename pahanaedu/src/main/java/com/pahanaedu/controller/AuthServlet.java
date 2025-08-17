package com.pahanaedu.controller;

import com.pahanaedu.model.User;
import com.pahanaedu.service.AuthService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login") // This annotation can coexist with web.xml mapping for '/'
public class AuthServlet extends HttpServlet {

    private AuthService authService = new AuthService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // This method handles HTTP GET requests to the servlet.
        // As per web.xml, the root path "/" is mapped to this servlet,
        // so this doGet will be called when the user initially accesses the app.
        // It forwards the request to the index.jsp, which serves as the login page.
        // Path corrected based on user's clarification: index.jsp is directly under webapp/
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // This method handles HTTP POST requests (e.g., when a login form is submitted).
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // Use the AuthService to attempt login
        if (authService.login(username, password)) {
            // If login is successful, set a session attribute and redirect to the dashboard.
            resp.sendRedirect("dashboard.jsp"); // dashboard.jsp is assumed to be directly under webapp/ or handled by another servlet
        } else {
            // If login fails, set an error message and forward back to the login page (index.jsp).
            // Forwarding preserves the request attributes, allowing the JSP to display the error.
            req.setAttribute("error", "Invalid username or password");
            // Path corrected based on user's clarification: index.jsp is directly under webapp/
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }
}
