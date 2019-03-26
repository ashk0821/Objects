package FantasySports.Sports;

public class Player implements SportsProfessional{
    int speed;
    int catching;
    int stamina;
    int power;
    String name;

    public void changeRating (int playerRating) {

    }

    public int changeMorale (boolean gameResult) {
        return 0;
    }

    public int getRating() {
        return (speed + catching + stamina + power) / 4;
    }

    public int playGame() {
        return 0;
    }

    public String getName () {
        return name;
    }
}
