package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Team t1 = new Team(1, "Real Madrid");

        Player p1 = new Player(101, "Vinicius", 23, t1);
        Player p2 = new Player(102, "Bellingham", 20, t1);

        System.out.println("Le joueur " + p1.name + " joue au " + p1.getTeamName());

        List<Player> maListe = new ArrayList<>();
        maListe.add(p1);
        maListe.add(p2);

        DataRetriever dr = new DataRetriever();
        dr.savePlayers(maListe);
    }
}