package FantasySports.Sports;

public class Coach implements SportsProfessional{
    public int coachRating;
    public int morale;

    public void Train (Player player) {
        player.speed ++;
        player.catching ++;
        player.power ++;
        player.stamina++;
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
