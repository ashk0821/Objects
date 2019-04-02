package FantasySports.Sports;

public class Coach implements SportsProfessional{
    public int coachRating;
    public int morale;
    public Team team;

    public void Train (Player player) {
        if (player.team == team) {
            player.speed++;
            player.catching++;
            player.power++;
            player.stamina++;
        }
        else {
            System.out.println("The coach and player have to be on the same team!!");
        }

        if (player.speed > 99 || player.catching > 99 || player.power > 99 || player.stamina > 99)
            System.out.println("The player's stats have to have a maximum of 99.");

        if (player.speed > 99)
            player.speed = 99;
        if (player.catching > 99)
            player.catching = 99;
        if (player.power > 99)
            player.catching = 99;
        if (player.stamina > 99)
            player.stamina = 99;
    }

    public void changeRating (boolean gameResult) {
        if (gameResult)
            coachRating ++;
        else
            coachRating --;
    }

    public int changeMorale (boolean gameResult) {
        if (gameResult)
            morale += 2;
        else
            morale --;

        return morale;
    }

    public int getRating() {
        return coachRating;
    }
}
