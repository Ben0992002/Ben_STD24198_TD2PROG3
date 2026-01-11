package org.example;

public class Player {
    public int id;
    public String name;
    public int age;
    public Team team;

    public Player(int id, String name, int age, Team team) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.team = team;
    }

    public String getTeamName() {
        if (this.team != null) {
            return this.team.name;
        }
        return "Pas d'équipe";
    }
}
