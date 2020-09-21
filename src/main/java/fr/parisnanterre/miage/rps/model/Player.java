package fr.parisnanterre.miage.rps.model;

import java.util.LinkedList;
import java.util.List;

public class Player {

    private String nom;
    private int score;
    private LinkedList<RPSEnum> mouvement = new LinkedList<>();
    private int cpt=0;


    public Player(String n, LinkedList<RPSEnum> m) {
        this.nom = n;
        this.score = score;
        this.mouvement = m;
    }

    public Player(String n1) {
        this.nom = n1;
        this.score = 0;
        for (int i = 0; i < 10; i++){
            this.mouvement.add(RPSEnum.hazard());
        }
    }

    public RPSEnum getNextMove() {
        try {
            return this.mouvement.get(this.cpt++);
        } catch (Exception e) {
            return null;
        }
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


}
