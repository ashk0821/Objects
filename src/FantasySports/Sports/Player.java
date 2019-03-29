package FantasySports.Sports;

import java.util.Random;

public class Player implements SportsProfessional{
    int speed;
    int catching;
    int stamina;
    int power;
    int morale;
    String name;

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
}
