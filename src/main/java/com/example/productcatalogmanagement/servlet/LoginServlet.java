package com.example.productcatalogmanagement.servlet;

import com.example.productcatalogmanagement.repo.UserRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();

        String userName = request.getParameter("user-name");
        String userPassword = request.getParameter("password");

        UserRepository userRepository = (UserRepository) getServletContext().getAttribute("userRepo");
        boolean isUserExist = userRepository.findUser(userName, userPassword);
        if(isUserExist){
            session.setAttribute("user-auth", userName);
            System.out.println("user Logged in.");
            response.sendRedirect("products");
        }else {
            response.getWriter().println("Failure to login: username or password incorrect");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
