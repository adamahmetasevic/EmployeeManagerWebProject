package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/viewEmployeeServlet")
public class viewEmployeeServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the list of employees from the application scope
        ArrayList<Employee> employees = (ArrayList<Employee>) getServletContext().getAttribute("employees");
        
        // If the list is null, create a new one (this shouldn't happen if employees are added properly)
        if (employees == null) {
            employees = new ArrayList<>();
        }
        
        // Set the list of employees as an attribute in the request scope
        request.setAttribute("employees", employees);
        
        // Forward the request to the JSP page to display the list of employees
        request.getRequestDispatcher("viewEmployees.jsp").forward(request, response);
    }
}
