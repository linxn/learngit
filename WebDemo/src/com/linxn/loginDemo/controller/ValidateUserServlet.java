package com.linxn.loginDemo.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Linxn on 2017/3/27.
 */
@WebServlet(name = "ValidateUserServlet")
public class ValidateUserServlet extends HttpServlet {
    private String userName;
    private String password;



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       userName = request.getParameter("username");
       password = request.getParameter("password");

        if(userName.equals("linxn") && password.equals("linxn")){
            request.getRequestDispatcher("/loginDemo/wel.jsp").forward(request,response);
        }else{
            request.getRequestDispatcher("/loginDemo/login.jsp?situation=1").forward(request,response);
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
