package FantasySports.Sports;
import java.util.Random;

public class Team implements SportsProfessional{
    int team_morale = 0;
    int teamRating = 50;
    public void changeRating (int teamRating) {
        boolean did_i_win = false;
        Team result = new Team();
        result.gamePlayed(did_i_win);
        if (did_i_win)
            teamRating ++;
        else
            teamRating --;
        this.teamRating = teamRating;
    }

    public int changeMorale (boolean gameResult) {
        Team result = new Team();
        result.gamePlayed(gameResult);

        if (gameResult)
            team_morale ++;
        else {
            team_morale --;
        }
        return team_morale;
    }

    public int getRating() {
        return teamRating;
    }

    Team playGame (Team opponent) {
        Random rand = new Random(); //https://stackoverflow.com/questions/5887709/getting-random-numbers-in-java

        Team team = new Team();
        int myRating = team.getRating();
        opponent = new Team();
        int yourRating = opponent.getRating();

        int ratingDifference = Math.abs(myRating-yourRating);
        int results = rand.nextInt(ratingDifference);

        if (results >= 3) {
            if (myRating > yourRating)
                return team;
            return opponent;
        }

        int chance = rand.nextInt(1);
        if (chance == 0)
            return team;
        return opponent;
    }

    private void gamePlayed (boolean did_i_win) { // calls on playGame
        Team opponent = new Team();
        if (playGame(opponent) == opponent)
            did_i_win =  false;
        else
            did_i_win = true;
    }
}
