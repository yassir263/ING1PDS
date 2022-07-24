package edu.episen.ing1.pds.view;

import edu.episen.ing1.pds.ClientToServer;
import edu.episen.ing1.pds.Request;
import org.apache.log4j.BasicConfigurator;

import javax.swing.*;
import java.io.IOException;

public class Information extends JFrame {

    public Information() throws Exception {
        this.setTitle("OneBuilding");
        this.setSize(900, 300);
        BasicConfigurator.configure();
        ClientToServer ctv = new ClientToServer();
        ctv.clientListen();
        Request req = new Request("getBadgesId");

        req = ctv.sendRequest(req);
        System.out.println(req);

    }

    public static void main(String[] args) throws Exception {
        Information  info = new Information();
        info.setVisible(true);
        }




    }

