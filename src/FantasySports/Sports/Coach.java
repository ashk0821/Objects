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
