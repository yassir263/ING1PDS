package edu.episen.ing1.pds.view;


import javax.swing.* ;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Badge extends JFrame implements ActionListener {
    JButton show;
    JButton showall;
    JButton signal;
    JButton verify;
    JButton infos;
    String companyName;

    JTextComponent num1;
    JTextComponent name1;

    public Badge(String companyName) {
        this.companyName=companyName;
        this.setTitle("OneBuilding");
        this.setSize(600, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        JPanel boutons=new JPanel();
        JPanel recherche=new JPanel();
        JPanel nume=new JPanel();
        JPanel fenetre=new JPanel();



        JLabel num;
        JLabel name;




         
        showall=new JButton("Afficher toute la liste");
        showall.addActionListener(this);
        signal=new JButton("Signaler un problème");
        signal.addActionListener(this);
        verify=new JButton("Vérifier les autorisations");
        verify.addActionListener(this);
        infos=new JButton("Informations");
        infos.addActionListener(this);
        boutons.add(showall);
        boutons.add(signal);
        boutons.add(verify);
        boutons.add(infos);









        fenetre.setLayout(new BoxLayout(fenetre, BoxLayout.PAGE_AXIS));

        show=new JButton("Chercher");
        show.addActionListener(this);

        fenetre.add(recherche);
        fenetre.add(nume);
        fenetre.add(show);
        fenetre.add(boutons);

        this.getContentPane().add(fenetre);
        this.setVisible(true);

    }


    public static void main (String [] args) {

        Badge badge = new Badge("Fritel Inc.");
    }
    //public void Showall();{
      //  connection con = new connectionc ;

    //}
    @Override
    public void actionPerformed(ActionEvent evt) {
        Object source =evt.getSource();

         if (source == showall)
        {
            Showall showall= null;
            try {
                showall = new Showall();
            } catch (Exception e) {
                e.printStackTrace();
            }
            showall.setVisible(true);
        }
       else if (source == show)
        {
            Show show = null;
            try {
                show = new Show();
            } catch (Exception e) {
                e.printStackTrace();
            }
            show.setVisible(true);
        }





        else if (source == verify) {
            Verify  verif = new Verify() ;
        }
        else if(source == signal) {
             Problem prob = null;
             try {
                 prob = new Problem();
             } catch (Exception e) {
                 e.printStackTrace();
             }
             prob.setVisible(true);
        }
        else if(source == infos)
        {
            Information info = null;
            try {
                info = new Information();
            } catch (Exception e) {
                e.printStackTrace();
            }
            info.setVisible(true);
        }


    }



}
