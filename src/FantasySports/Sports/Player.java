package FantasySports.Sports;

import com.sun.org.apache.xpath.internal.operations.String;

import java.util.Random;

public class Player implements SportsProfessional{
    public int speed;
    public int catching;
    public int stamina;
    public int power;
    public java.lang.String name;
    public Team team;

    public Player(int speed, int catching, int stamina, int power, java.lang.String name, Team team) {
        this.speed = speed;
        this.catching = catching;
        this.stamina = stamina;
        this.power = power;
        this.name = name;
        this.team = team;
    }


    public int getRating () {
        return (speed + catching + stamina + power) / 4;
    }

    public java.lang.String getName () {
        return name;
    }

    public java.lang.String getTeam () {
        return team.team_name;
    }

    public java.lang.String toString() {
        return "Hi, my name is " + getName() + " and I play for " + getTeam() + ". My overall rating is " + getRating() + "!";
    }
}
