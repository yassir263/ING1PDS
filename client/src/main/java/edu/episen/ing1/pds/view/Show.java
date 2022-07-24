package edu.episen.ing1.pds.view;

import edu.episen.ing1.pds.ClientToServer;
import edu.episen.ing1.pds.Request;
import org.apache.log4j.BasicConfigurator;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;


public class Show extends JFrame {
    JButton show;
    String txt;
    String txt1;
    public Show() throws Exception {
        super();
        this.setTitle("OneBuilding");
        this.setSize(600, 300);
        JPanel fenetre=new JPanel();
        JPanel recherche=new JPanel();
        JPanel nume=new JPanel();
        JLabel search;
        JLabel num;
        JLabel name;
        JTextComponent num1 = new JTextArea() ;
        num1.setPreferredSize(new Dimension(100,20));

        txt = "ouria";
        txt1="wayle";

        JTextComponent name1=new JTextArea()  ;
        name1.setPreferredSize(new Dimension(100,20));
        num=new JLabel("Numéro de badge");

        recherche.add(num);
        recherche.add(num1);


        name=new JLabel("Nom de l'employé");

        nume.add(name);
        nume.add(name1);
        search=new JLabel("Recherche");
        show=new JButton("Chercher");

        fenetre.setLayout(new BoxLayout(fenetre, BoxLayout.PAGE_AXIS));
        fenetre.add(search);
        fenetre.add(recherche);
        fenetre.add(nume);
        fenetre.add(show);

        this.getContentPane().add(fenetre);
        this.setVisible(true);


    }

    public static void main(String[] args) throws Exception {

        Show show = new Show();
        new Show().setVisible(true);
    }
}
