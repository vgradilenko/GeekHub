package org.geekhub.part3;

import java.sql.*;
import java.util.Random;

public class Test {
    public static void main(String[] args) throws Exception {
        Connection connection = createConnection("sa", "");

        String insertQuery = "INSERT INTO TEST1.PUBLIC.EMPLOYEE" + "(id, name) values" + "(?,?)";
        String insertSalaryQuery = "INSERT INTO TEST1.PUBLIC.SALARY" + "(id, date, value, employee_id) VALUES" + "(?, ?, ?, ?)";
        String sql = "SELECT EMPLOYEE.ID, EMPLOYEE.NAME, sum(SALARY.VALUE) AS SALARY FROM SALARY " +
                "RIGHT JOIN EMPLOYEE ON EMPLOYEE.ID = SALARY.EMPLOYEE_ID " +
                "GROUP BY EMPLOYEE.ID";

        PreparedStatement employeeStatement = connection.prepareStatement(insertQuery);
        PreparedStatement salaryStatement = connection.prepareStatement(insertSalaryQuery);
        PreparedStatement dataSamples = connection.prepareStatement(sql);

        for (int i = 1; i <= 10; i++) {
            employeeStatement.setInt(1, i);
            employeeStatement.setString(2, "employee" + i);
            employeeStatement.setInt(1, i);
            employeeStatement.setString(2, "employee" + 5);
            employeeStatement.executeUpdate();
        }

        Random random = new Random();
        for (int i = 1; i <= 15; i++) {
            salaryStatement.setInt(1, i);
            salaryStatement.setDate(2, new Date(System.currentTimeMillis()));
            salaryStatement.setDouble(3, (random.nextDouble() * 100));
            salaryStatement.setInt(4, random.nextInt(10) + 1);
            salaryStatement.executeUpdate();
        }

        ResultSet fromDb = dataSamples.executeQuery();
        while (fromDb.next()) {
            System.out.println("empl: " + fromDb.getInt(1) + " empl_name " + fromDb.getString(2) +
            " salary: " + fromDb.getInt(3));
        }

        connection.close();
    }

    private static Connection createConnection(String login, String password) throws Exception {
        Class.forName("org.h2.Driver").newInstance();
        Connection connection = DriverManager.getConnection("jdbc:h2:~/test1", login, password);
        return connection;
    }
}
