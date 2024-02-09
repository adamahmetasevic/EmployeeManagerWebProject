package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addEmployeeServlet")

public class addEmployeeServlet extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve parameters from the form
        String name = request.getParameter("name");
        String position = request.getParameter("position");
        
        // Create a new Employee object with generated ID
        Employee newEmployee = new Employee(generateEmployeeId(), name, position);
        
        // Retrieve the existing list of employees from the application scope
        @SuppressWarnings("unchecked")
        
		ArrayList<Employee> employees = (ArrayList<Employee>) getServletContext().getAttribute("employees");
        
        // If the list is null, create a new one
        if (employees == null) {
            employees = new ArrayList<>();
        }
        
        // Add the new employee to the list
        employees.add(newEmployee);
        
        // Set the updated list of employees back into the application scope
        getServletContext().setAttribute("employees", employees);
        
        // Forward the request to the JSP page to display the list of employees
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
    
    // Method to generate a unique employee ID
    private int generateEmployeeId() {
        return EmployeeIdGenerator.getNextEmployeeId();
    }


    
    class EmployeeIdGenerator {
        private static int nextEmployeeId = 1;

        public static synchronized int getNextEmployeeId() {
            return nextEmployeeId++;
        }
    }

}
