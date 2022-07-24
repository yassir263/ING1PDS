package edu.episen.ing1.pds.view;
import edu.episen.ing1.pds.ClientToServer;
import edu.episen.ing1.pds.Request;
import org.apache.log4j.BasicConfigurator;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.io.IOException;

public class Showall extends JFrame {
    public Showall() throws Exception {
        super();

        setTitle("OneBuilding");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BasicConfigurator.configure();
        ClientToServer ctv = new ClientToServer();
        ctv.clientListen();
        Request req = new Request("getEmployee");

        req = ctv.sendRequest(req);
        System.out.println(req);










    }

    public static void main(String[] args) throws Exception {
        new Showall().setVisible(true);



    }

    }

