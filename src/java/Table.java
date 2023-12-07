/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Admin
 */
@WebServlet(urlPatterns = {"/table"})
public class Table extends HttpServlet {

    private StudentDAO studentDAO;

    public void init() {
        studentDAO = new StudentDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        session.setAttribute("id", request.getParameter("id"));
        session.setAttribute("name", request.getParameter("name"));
        session.setAttribute("dob", request.getParameter("dob"));
        session.setAttribute("department", request.getParameter("department"));

        List<Student> students = studentDAO.getStudents();
        request.setAttribute("listStudent", students);
        RequestDispatcher dispatcher = getServletConfig().getServletContext().getRequestDispatcher("/studentlist.jsp");
        dispatcher.forward(request, response);
    }
}
