package FantasySports.Sports;

public class Coach implements SportsProfessional{
    int coachRating;
    Player player;
    int morale;

    public void changeRating (int playerRating, boolean gameResult) {
        player.speed ++;
        player.catching ++;
        player.power ++;
        player.stamina ++;
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
