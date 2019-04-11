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
    ArrayList<Player> players = new ArrayList<>();
    boolean did_i_win;

    public Team(int team_morale, int number_of_players, int teamFinalRating, java.lang.String team_name, Coach coach) {
        this.team_morale = team_morale;
        this.number_of_players = number_of_players;
        this.teamFinalRating = teamFinalRating;
        this.team_name = team_name;
        this.coach = coach;
    }

    public void changeRating (boolean gameResult) {
        if (gameResult)
            team_morale ++;
        else
            team_morale --;
    }

    public int changeMorale (boolean gameResult) {
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
        return (teamRating / number_of_players) + team_morale;
    }

    public Team playGame (Team opponent) {
        Random rand = new Random(); //https://stackoverflow.com/questions/5887709/getting-random-numbers-in-java

        Team team = new Team(team_morale, number_of_players, teamFinalRating, team_name, coach);
        int myRating = team.teamFinalRating;
        opponent = new Team(opponent.team_morale, opponent.number_of_players, opponent.teamFinalRating, opponent.team_name, opponent.coach);
        int yourRating = opponent.teamFinalRating;

        int ratingDifference = Math.abs(myRating-yourRating);
        int results = rand.nextInt(ratingDifference);

        if (results >= 3) {
            if (myRating > yourRating) {
                did_i_win = true;
                team_morale++;
                opponent.team_morale--;
                return team;
            }
            did_i_win = false;
            opponent.team_morale++;
            team_morale--;
            return opponent;
        }

        else if (results <= 3) {
            int chance = rand.nextInt(2);
            if (chance == 0) {
                did_i_win = true;
                team_morale++;
                opponent.team_morale--;
                return team;
            }
        }
        did_i_win = false;
        team_morale--;
        opponent.team_morale++;
        return opponent;
    }

   /* private void gamePlayed (boolean did_i_win) { // calls on playGame
        Team opponent = new Team(team_morale, number_of_players, teamFinalRating, team_name, coach);
        if (playGame(opponent) == opponent)
            did_i_win =  false;
        else
            did_i_win = true;

        changeRating(did_i_win);
    }*/

    public Team winnerWas (Team opponent) {
        Team team = new Team(team_morale, number_of_players, teamFinalRating, team_name, coach);
        opponent = new Team(opponent.team_morale, opponent.number_of_players, opponent.teamFinalRating, opponent.team_name, opponent.coach);
        if (!did_i_win) {
            team_morale --;
            return opponent;
        }
        team_morale ++;
        return team;
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
