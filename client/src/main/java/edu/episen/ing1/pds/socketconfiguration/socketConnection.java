package edu.episen.ing1.pds.socketconfiguration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class socketConnection {
    final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private String ip;
    private int port;

    public socketConnection() throws NullPointerException {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(System.getenv("SOCKET_CONNECTION_CONF")));
            ObjectMapper om = new ObjectMapper(new YAMLFactory());
            socketConnectionModel sc = om.readValue(reader, socketConnectionModel.class);

            this.ip = sc.getIp();
            this.port = sc.getPort();

            reader.close();
        } catch (IOException e) {

            e.getMessage();

        }
    }

    public int getPort() {
        return port;
    }

    public String getIp() {
        return ip;
    }
}