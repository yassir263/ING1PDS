package edu.episen.ing1.pds.server.databaseconnection;

import edu.episen.ing1.pds.server.databaseconfiguration.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class JBDCconnection {
    Database database = new Database();
    private ArrayList<Connection> connections = new ArrayList<Connection>();

    public JBDCconnection (){
    }

    public void addNewConnection(){
        try{
            Connection conn = DriverManager.getConnection(database.getUrl(), database.getUser(), database.getPassword());
            connections.add(conn);
            System.out.println("new connection added");
        } catch (SQLException throwables) {
            System.out.println("Error : " + throwables.getMessage());
            throwables.printStackTrace();
        }
    }

    public void closeConnection(int index){
        try{
            connections.get(index).close();
            System.out.println("Closed");
        }catch (SQLException throwables) {
            System.out.println("Error : " + throwables.getMessage());
            throwables.printStackTrace();
        }
    }

    public void closeAllConnections(){
        for(int i=0; i<connections.size(); i++){
            closeConnection(i);
        }
    }

    public Connection removeConnection(int index){
        if(index < connections.size()){
            closeConnection(index);
            return connections.remove(index);
        }else{
            System.out.println("No connection found in this index");
            return null;
        }
    }

    public ArrayList<Connection> removeAllConnections(){
        ArrayList<Connection> deletedConnections = new ArrayList<Connection>();
        for(int i=0; i<connections.size(); i++){
            deletedConnections.add(removeConnection(i));
        }
        return deletedConnections;
    }

    public Connection getConnection(int index){
        if(index < connections.size()){
            return connections.get(index);
        }else{
            System.out.println("No connection found in this index");
            return null;
        }
    }

    public ArrayList<Connection> getConnections(){
        return this.connections;
    }
}
