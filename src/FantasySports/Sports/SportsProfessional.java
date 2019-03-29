package FantasySports.Sports;

public interface SportsProfessional {
    abstract public void changeRating (int playerRating, boolean gameResult);

    abstract public int changeMorale (boolean gameResult);

    public int getRating();

}
