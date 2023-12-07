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

@WebServlet(urlPatterns = {"/test"})
public class Test extends HttpServlet {

    private StudentDAO studentDAO;

    public void init() {
        studentDAO = new StudentDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        studentDAO.updateStudent(request.getParameter("id"));

        HttpSession session = request.getSession();

        if (session.getAttribute("id") != null) {
            request.setAttribute("id", session.getAttribute("id"));
        }

        if (session.getAttribute("name") != null) {
            request.setAttribute("name", session.getAttribute("name"));
        }

        if (session.getAttribute("dob") != null) {
            request.setAttribute("dob", session.getAttribute("dob"));
        }

        if (session.getAttribute("department") != null) {
            request.setAttribute("department", session.getAttribute("department"));
        }

        RequestDispatcher dispatcher = getServletConfig().getServletContext().getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletConfig().getServletContext().getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }
}
