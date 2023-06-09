package com.example.ls12.model;

import com.example.ls12.entity.User;
import com.example.ls12.service.DbService;
import com.example.ls12.service.DbServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet( value = "/login")
public class LoginServlet extends HttpServlet {
    private DbService dbService;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("login.jsp").forward(request,response);
    }

    @Override
    public void init() throws ServletException {
        dbService = new DbServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password=request.getParameter("password");

        User user = dbService.getUserByEmail(email);

        if( user != null ){
            if(email.equals(user.getEmail()) && password.equals(user.getPassword())){

                HttpSession userSession = request.getSession();
                userSession.setAttribute("userEmail", user.getEmail());

                response.sendRedirect("/");

            }else{
                response.sendRedirect("/login?email=" + email + "error=2");
            }
        } else{
            response.sendRedirect("/login?error=1");
        }


    }
}
