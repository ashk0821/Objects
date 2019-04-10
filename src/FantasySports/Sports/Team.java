package FantasySports.Sports;
import com.sun.org.apache.xpath.internal.operations.String;

import java.util.ArrayList;
import java.util.Random;

public class Team implements SportsProfessional{
    public int team_morale;
    int teamRating;
    int number_of_players;
    public int teamFinalRating;
    public java.lang.String team_name;
    public Coach coach;
    int teamBonusPoints = 0; // since team rating is just an average, this is just an account of W/L
    ArrayList<Player> players = new ArrayList<>();

    public Team(int team_morale, int number_of_players, int teamFinalRating, java.lang.String team_name, Coach coach) {
        this.team_morale = team_morale;
        this.number_of_players = number_of_players;
        this.teamFinalRating = teamFinalRating;
        this.team_name = team_name;
        this.coach = coach;
    }

    public void changeRating (boolean gameResult) {
        if (gameResult)
            teamBonusPoints ++;
        else
            teamBonusPoints --;
    }

    public int changeMorale (boolean gameResult) {
        Team result = new Team(team_morale, number_of_players, teamFinalRating, team_name, coach);
        result.gamePlayed(gameResult);

        if (gameResult)
            team_morale ++;
        else {
            team_morale --;
        }
        return team_morale;
    }

    public int getRating() {
        teamFinalRating = teamRating / number_of_players;
        return teamFinalRating;
    }

    public int getFinalRating() {
        teamRating = 0;

        for (int i=0; i<players.size(); i++) {
            teamRating += players.get(i).getRating();
        }
        if (number_of_players == 0)
            throw new ArithmeticException("/ by 0");
        return teamRating / number_of_players + teamBonusPoints;
    }

    public Team playGame (Team opponent) {
        Random rand = new Random(); //https://stackoverflow.com/questions/5887709/getting-random-numbers-in-java

        Team team = new Team(team_morale, number_of_players, teamFinalRating, team_name, coach);
        int myRating = team.getFinalRating();
        opponent = new Team(opponent.team_morale, opponent.number_of_players, opponent.teamFinalRating, opponent.team_name, opponent.coach);
        int yourRating = opponent.getFinalRating();

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
        Team opponent = new Team(team_morale, number_of_players, teamFinalRating, team_name, coach);
        if (playGame(opponent) == opponent)
            did_i_win =  false;
        else
            did_i_win = true;

        changeRating(did_i_win);
    }

    public void draft (Player player) {
        players.add(player);
        teamRating += player.getRating();
        number_of_players ++;
    }

    public java.lang.String getPlayers() {
        java.lang.String roster = "";

        for (int i=0; i<players.size(); i++)
            roster += players.get(i).name + ", ";

        return roster;
    }
}
