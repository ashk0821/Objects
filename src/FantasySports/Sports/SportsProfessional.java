package FantasySports.Sports;

public interface SportsProfessional {
    abstract public int changeRating (int playerRating);

    abstract public int changeMorale (boolean gameResult);

    public int getRating();

    public int playGame();
}
