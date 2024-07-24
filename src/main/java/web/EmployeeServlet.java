package web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDAO;
import model.Employee;
	
@WebServlet("/EmployeeServlet")


public class EmployeeServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;
	      private EmployeeDAO employeeDAO;
	    
	    public EmployeeServlet() {
	       this.employeeDAO = new EmployeeDAO();
	        
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
		}
	    
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String action = request.getServletPath();

	        try {
	            switch (action) {
	                case "/newEmployee":
	                    showNewFormEmployee(request, response);
	                    break;
	                case "/insertEmployee":
	                    insertEmployee(request, response);
	                    break;
	                case "/deleteEmployee":
	                    deleteEmployee(request, response);
	                    break;
	                case "/editEmployee":
	                    showEditFormEmployee(request, response);
	                    break;
	                case "/updateEmployee":
	                    updateEmployee(request, response);
	                    break;
	                default:
	                    listEmployees(request, response);
	                    break;
	            }  
	        } catch (SQLException ex) {
	            throw new ServletException(ex);
	        }
		}

		private void showNewFormEmployee(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        RequestDispatcher dispatcher = request.getRequestDispatcher("employee-form.jsp");
	        dispatcher.forward(request, response);
	    }

	    private void insertEmployee(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException {
	        String name = request.getParameter("name");
	        String birthdate = request.getParameter("birthdate");
	        String address = request.getParameter("address");
	        String gender = request.getParameter("gender");
	        String phone = request.getParameter("phone");
	        String position = request.getParameter("position");
	       
	        Employee newEmployee = new Employee(name,birthdate,address,gender, phone, position);
	        employeeDAO.insertEmployees(newEmployee);
	        response.sendRedirect("list_employee");
	    }

	    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException {
	        int id = Integer.parseInt(request.getParameter("id"));
	        employeeDAO.deleteEmployee(id);
	        response.sendRedirect("list_employee");
	    }

	    private void showEditFormEmployee(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, ServletException, IOException {
	        int id = Integer.parseInt(request.getParameter("id"));
	        Employee existingEmployee = employeeDAO.selectEmployee(id);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("employee-form.jsp");
	        request.setAttribute("Employee", existingEmployee);
	        dispatcher.forward(request, response);
	    }

	    private void updateEmployee(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException {
	        int id = Integer.parseInt(request.getParameter("id"));
	        String name = request.getParameter("name");
	        String birthdate = request.getParameter("birthdate");
	        String address = request.getParameter("address");
	        String gender = request.getParameter("gender");
	        String phone = request.getParameter("phone");
	        String position = request.getParameter("position");
	       

	        Employee employee = new Employee(id, name, birthdate,address,gender, phone, position);
	        employeeDAO.updateEmployees(employee);
	        response.sendRedirect("list_employee");
	    }

	    private void listEmployees(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException, ServletException {
	        List<Employee> listEmployees = employeeDAO.selectAllEmployees();
	        request.setAttribute("listEmployees", listEmployees);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("employee-list.jsp");
	        dispatcher.forward(request, response);
	    }
		
	}
	

