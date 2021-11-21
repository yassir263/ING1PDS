package edu.episen.ing1.pds.server.databaseconfiguration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Database {
    final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    String url;
    String driver;
    String user;
    String password;

    public Database() throws NullPointerException {

        try {
            Reader reader = Files.newBufferedReader(Paths.get(System.getenv("DATABASE_CONF")));
            ObjectMapper om = new ObjectMapper(new YAMLFactory());
            DatabaseModel sc = om.readValue(reader, DatabaseModel.class);

            this.url = sc.getUrl();
            this.driver = sc.getDriver();
            this.user = sc.getUser();
            this.password= sc.getPassword();
            reader.close();
        } catch (IOException e) {

            e.getMessage();

        }
    }

    public String getUrl() {
        return url;
    }

    public String getDriver() {
        return driver;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}