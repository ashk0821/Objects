package FantasySports.Sports;

public class Coach implements SportsProfessional{
    int coachRating;
    Player player;

    public void changeRating (int playerRating) {
        player.speed ++;
        player.catching ++;
        player.power ++;
        player.stamina ++;
    }

    public int changeMorale (boolean gameResult) {
        return 0;
    }

    public int getRating() {
        return coachRating;
    }

    public int playGame() {
        return 0;
    }
}
