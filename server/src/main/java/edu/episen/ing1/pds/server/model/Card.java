package edu.episen.ing1.pds.server.model;

public class Card {
    private int id_card;

    private int permission_level;

    public Card(int id_card,int permission_level){
        this.id_card=id_card;

        this.permission_level=permission_level;


    }
    public Card(){



    }


    public int getId_card() {
        return id_card;
    }

    public void setId_card(int id) {
        this.id_card = id_card;
    }



    public int getPermission_level() {
        return permission_level;
    }

    public void setPermission_level(int permission_level) {
        this.permission_level = permission_level;
    }

    @Override
    public String toString() {
        return "Badges{" +
                "id_card=" + id_card +

                ", permission_level=" + permission_level +
                '}';
    }
}


