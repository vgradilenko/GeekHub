package com.geekhub.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test {
    public static void main(String[] args) throws Exception {
        Connection connection = createConnection("root", "qwerty13", "geo");

        String getTop5CountryByCountRegion =
                "SELECT country.name, " +
                        "       Count(region.id) AS region " +
                        "FROM   country " +
                        "       JOIN region " +
                        "         ON region.country_id = country.id " +
                        "GROUP  BY country.id " +
                        "ORDER  BY region DESC, " +
                        "          country.name ASC " +
                        "LIMIT  5";

        String getTop5CountryByCity =
                "SELECT country.name, " +
                "       Count(city.id) AS city " +
                "FROM   country " +
                "       JOIN region " +
                "         ON region.country_id = country.id " +
                "       JOIN city " +
                "         ON city.region_id = region.id " +
                "GROUP  BY country.id " +
                "ORDER  BY city DESC, " +
                "          country.name ASC " +
                "LIMIT  5";

        String getInfoByAllCountry =
                "SELECT" +
                        "  country.name, " +
                        "  count(DISTINCT region.id) AS countByRegion, " +
                        "  count(city.id)            AS countByCity " +
                        "FROM country " +
                        "  INNER JOIN region ON region.country_id = country.id " +
                        "  INNER JOIN city ON city.region_id = region.id " +
                        "GROUP BY country.id " +
                        "ORDER BY country.name ASC, countByRegion, countByCity DESC";

        PreparedStatement info = connection.prepareStatement(getInfoByAllCountry);
        ResultSet fromDb = info.executeQuery();

        while (fromDb.next()) {
            System.out.printf("Country: %s, counted regions: %d, counted cites: %d \n",
                    fromDb.getString(1), fromDb.getInt(2), fromDb.getInt(3));
        }

        connection.close();
    }

    private static Connection createConnection(String login, String password, String dbName) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName, login, password);
        return connection;
    }
}
