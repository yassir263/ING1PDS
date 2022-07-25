package edu.episen.ing1.pds.view;

import edu.episen.ing1.pds.ClientToServer;
import edu.episen.ing1.pds.Request;
import org.apache.log4j.BasicConfigurator;


import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Problem extends JFrame implements ActionListener {
    public static Object txt;
    JButton conf;

    public Problem() throws Exception {
        this.setTitle("OneBuilding");
        this.setSize(700, 300);
        this.setLocationRelativeTo(null);

        JTextField bdg = new JTextField();
        bdg.addKeyListener(new java.awt.event.KeyAdapter() {
                               public void keyPressed(java.awt.event.KeyEvent e) {
                                   txt = bdg.getText();
                               }
                           });

        bdg.setPreferredSize(new Dimension(30,10));
        JLabel numbdg=new JLabel("Entrer le numéro du badge concerné:");

         conf = new JButton("Confirmer");
         conf.addActionListener(this);

        JPanel fenetre = new JPanel();
        fenetre.setLayout(new BoxLayout(fenetre, BoxLayout.LINE_AXIS));
        fenetre.add(numbdg);
        fenetre.add(bdg);
        fenetre.add(conf);
        this.getContentPane().add(fenetre);
        this.setVisible(true);


    }
    public static void main(String[] args) throws Exception {
        Problem  prb = new Problem();

    }
    public void actionPerformed(ActionEvent evt) {
        Object source =evt.getSource();
        if (source == conf){

            BasicConfigurator.configure();
            ClientToServer ctv = new ClientToServer();
            try {
                ctv.clientListen();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Request req = new Request("addProblem");



            try {
                req = ctv.sendRequest(req);


            } catch (Exception e) {
                e.printStackTrace();
            }


        }

        }


    public static Object Datainserted() {
        System.out.println(txt);
        return txt;
    }
}
