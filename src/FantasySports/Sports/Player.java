package FantasySports.Sports;

import java.util.Random;

public class Player implements SportsProfessional{
    int speed;
    int catching;
    int stamina;
    int power;
    String name;
    Team team;
    Team opponent;

    public void changeRating (int playerRating) {
        Random stat = new Random();
        int change_stat = stat.nextInt(3);

    }

    public int getRating () {
        return (speed + catching + stamina + power) / 4;
    }

    public int changeMorale (boolean gameResult) {
        return 0;
    }

    public String getName () {
        return name;
    }
}
