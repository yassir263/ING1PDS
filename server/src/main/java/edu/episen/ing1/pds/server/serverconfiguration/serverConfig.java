package edu.episen.ing1.pds.server.serverconfiguration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;

public class serverConfig {
    final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private int port;
    private int nbrMax;

    public serverConfig() throws NullPointerException {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(System.getenv("SERVER_CONF")));
            ObjectMapper om = new ObjectMapper(new YAMLFactory());
            serverConfigModel sc = om.readValue(reader, serverConfigModel.class);

            this.port = sc.getPort();
            this.nbrMax = sc.getNbrMax();

            reader.close();
        } catch (IOException e) {

            e.getMessage();

        }
    }

    public int getPort() {
        return port;
    }

    public int getNbrMax() {
        return nbrMax;
    }
}