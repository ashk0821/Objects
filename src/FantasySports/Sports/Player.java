package FantasySports.Sports;

import java.util.Random;

public class Player implements SportsProfessional{
    public int speed;
    public int catching;
    public int stamina;
    public int power;
    public int morale;
    public String name;
    public Team team;

    public void changeRating (int playerRating, boolean gameResult) {
        Random stat_to_change = new Random();
        int stat = stat_to_change.nextInt(3);
        if (gameResult) {
            if (stat == 0)
                speed += 3;
            else if (stat == 1)
                catching += 3;
            else if (stat == 2)
                stamina += 3;
            else
                power += 3;
        }

        else {
        if (stat == 0)
            speed -= 2;
        else if (stat == 1)
            catching -= 2;
        else if (stat == 2)
            stamina -= 2;
        else
            power -= 2;
        }
    }

    public int getRating () {
        return (speed + catching + stamina + power) / 4;
    }

    public int changeMorale (boolean gameResult) {
        if (gameResult)
            morale += 2;
        else
            morale --;

        return morale;
    }

    public String getName () {
        return name;
    }

    public Team getTeam () {
        return team;
    }

    public String toString() {
        return "Hi, my name is " + getName() + " and I play for " + getTeam() + ". My overall rating is " + getRating();
    }
}
