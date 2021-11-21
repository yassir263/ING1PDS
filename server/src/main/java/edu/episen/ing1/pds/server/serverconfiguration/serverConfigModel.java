package edu.episen.ing1.pds.server.serverconfiguration;

public class serverConfigModel {
    private int port;
    private int nbrMax;

    public int getNbrMax() {
        return nbrMax;
    }

    public int getPort() {
        return port;
    }

    @Override
    public String toString() {
        return "ServerConfigModel{" +
                "Port='" + port + '\'' +
                ", NbrMac='" + nbrMax + '\'' +
                '}';
    }
}