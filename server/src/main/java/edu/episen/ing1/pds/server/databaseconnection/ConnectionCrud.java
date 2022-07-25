package edu.episen.ing1.pds.server.databaseconnection;

import edu.episen.ing1.pds.server.model.Card;
import edu.episen.ing1.pds.server.model.Employee;
import edu.episen.ing1.pds.view.Problem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;

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


    public Object getBadges() throws SQLException {
        ArrayList<Card> cards = new ArrayList<Card>();
        String sql = "Select * from public.\"accesscard\";";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        StringBuilder result = new StringBuilder();
        while (rs.next()) {
            result.append("\n").append(rs.getArray("id"));
            cards.add(new Card(rs.getInt("id"),rs.getInt("permission_level")));
        }
        return cards;

    }

    public Object getEmployee() throws SQLException {
        ArrayList<Employee> emps = new ArrayList<Employee>();

        String sql = "Select * from public.\"employee\";";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        StringBuilder result = new StringBuilder();
        while (rs.next()) {
            result.append("\n").append(rs.getArray("id_employee"));
            emps.add(new Employee(rs.getInt("id_employee"),rs.getString("name"),rs.getInt("accesscard")));



        }


        return emps;

    }
    public void addProblem( Object value) throws SQLException {


        String sql = "INSERT INTO problems (msg) VALUES ('"+value+" ');";
        Statement smt = connection.createStatement();
        smt.executeQuery(sql);
    }


}