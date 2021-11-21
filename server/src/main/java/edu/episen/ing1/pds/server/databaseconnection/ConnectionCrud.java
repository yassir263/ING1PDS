package edu.episen.ing1.pds.server.databaseconnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class ConnectionCrud {
    private Connection connection;
    private final static Logger logger = LoggerFactory.getLogger(ConnectionCrud.class.getName());

    public ConnectionCrud() {
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }


    public String getBadgesId() throws SQLException {
        String sql = "Select * from public.\"Badges\";";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        String result = "";
        while (rs.next()) {
            result += rs.getArray("id") + "\n";
        }
        return result;

    }

    public String getEmployee() throws SQLException {
        String sql = "Select * from public.\"employee\";";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        StringBuilder result = new StringBuilder();
        while (rs.next()) {
            result.append(rs.getArray("id_employee")).append(rs.getArray("name")).append(rs.getArray("accesscard")).append("\n");


        }
        return result.toString();

    }


}