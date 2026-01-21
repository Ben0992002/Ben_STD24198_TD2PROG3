package org.example;

public class Player {
    public int id;
    public String name;
    public int age;
    public PlayerPositionEnum position;
    public Team team;
    public Integer goalNb;

    public Player(int id, String name, int age, PlayerPositionEnum position, Team team, Integer goalNb) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.position = position;
        this.team = team;
        this.goalNb = goalNb;
    }
}
