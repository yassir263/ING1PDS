package edu.episen.ing1.pds;
import org.apache.log4j.BasicConfigurator;

import java.io.IOException;

public class mainClient {
    public static void main(String[] args) throws Exception {
        BasicConfigurator.configure();
        ClientToServer ctv = new ClientToServer();
        ctv.clientListen();
        Request req = new Request("getEmployee");

        req = ctv.sendRequest(req);
        System.out.println(req);
    }
}
