package FantasySports.Sports;
import com.sun.org.apache.xpath.internal.operations.String;

import java.util.ArrayList;
import java.util.Random;

public class Team implements SportsProfessional{
    public int team_morale;
    public int teamRating;
    ArrayList<Player> players = new ArrayList<>();

    public void changeRating (int teamRating, boolean gameResult) {
        if (gameResult)
            this.teamRating += teamRating;
        else
            this.teamRating -= teamRating;
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

    public Team playGame (Team opponent) {
        Random rand = new Random(); //https://stackoverflow.com/questions/5887709/getting-random-numbers-in-java

        Team team = new Team();
        int myRating = team.getRating();
        opponent = new Team();
        int yourRating = opponent.getRating();

        int ratingDifference = Math.abs(myRating-yourRating);
        System.out.println(ratingDifference);
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

        changeRating(teamRating, did_i_win);
    }

    public void draft (Player player) {
        players.add(player);
    }

    public java.lang.String getPlayers() {
        java.lang.String roster = "";

        for (int i=0; i<players.size(); i++)
            roster += players.get(i);

        return roster;
    }
}
