package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Employee;

public class EmployeeDAO {
	private static final String INSERT_EMPLOYEE_SQL = "INSERT INTO employees (name, birthdate,address,gender, phone, position) VALUES (?, ?, ?, ?,?,?)";
	private static final String UPDATE_EMPLOYEE_SQL = "UPDATE employees SET name = ?, birthdate = ?, address = ?, gender = ?,phone=?,position=? WHERE id = ?";
	private static final String DELETE_EMPLOYEE_SQL = "DELETE FROM employees WHERE id = ?";
	private static final String SELECT_EMPLOYEE_BY_ID = "SELECT id, name, birthdate,address,gender, phone, position FROM employees WHERE id = ?";
	private static final String SELECT_ALL_EMPLOYEES_SQL = "SELECT * FROM employees";

    //insert
    public void insertEmployees(Employee employee) {
        System.out.println(INSERT_EMPLOYEE_SQL);

        try (Connection connection = DBConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE_SQL)) {
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getBirthdate());
            preparedStatement.setString(3, employee.getAddress());
            preparedStatement.setString(4, employee.getGender());
            preparedStatement.setString(5, employee.getPhone());
            preparedStatement.setString(6, employee.getPosition());
           

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //update
    public boolean updateEmployees(Employee employee) {
        boolean rowUpdated = false;
        try (Connection connection = DBConnect.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_EMPLOYEE_SQL)) {
        	statement.setString(1, employee.getName());
        	statement.setString(2, employee.getBirthdate());
        	statement.setString(3, employee.getAddress());
        	statement.setString(4, employee.getGender());
        	statement.setString(5, employee.getPhone());
        	statement.setString(6, employee.getPosition());
        
            statement.setInt(7, employee.getId());

            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }

    //select by id
    public Employee selectEmployee(int id) {
    	Employee employee = null;

        try (Connection connection = DBConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID)) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                String name = rs.getString("name");
                String birthdate = rs.getString("birthdate");
                String address = rs.getString("address");
                String gender = rs.getString("gender");
                String phone = rs.getString("phone");
                String position = rs.getString("position");
               

                employee = new Employee(id,name,birthdate,address,gender,phone,position);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    //select all
    public List<Employee> selectAllEmployees() {
        List<Employee> employees = new ArrayList<>();

        try (Connection connection = DBConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEES_SQL)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String birthdate = rs.getString("birthdate");
                String address = rs.getString("address");
                String gender = rs.getString("gender");
                String phone = rs.getString("phone");
                String position = rs.getString("position");

                employees.add(new Employee(id, name, birthdate,address,gender, phone, position));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    //delete
    public boolean deleteEmployee(int id) {
        boolean rowDeleted = false;
        try (Connection connection = DBConnect.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_EMPLOYEE_SQL)) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }

}