package edu.episen.ing1.pds.socketconfiguration;

public class socketConnectionModel {
    private String ip;
    private int port;

    public String getIp() {
        return ip;
    }

    public int getPort() {
        return port;
    }

    @Override
    public String toString() {
        return "ServerConfigModel{" +
                "Port='" + port + '\'' +
                ", IP='" + ip + '\'' +
                '}';
    }
}