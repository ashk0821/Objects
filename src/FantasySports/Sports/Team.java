package FantasySports.Sports;
import com.sun.org.apache.xpath.internal.operations.String;

import java.util.ArrayList;
import java.util.Random;

public class Team implements SportsProfessional{
    int teamRating;
    int number_of_players;
    public int teamFinalRating;
    public java.lang.String team_name;
    public Coach coach;
    ArrayList<Player> players = new ArrayList<>();
    boolean did_i_win;
    public int[] record = new int[3];

    public Team(int number_of_players, int teamFinalRating, java.lang.String team_name, Coach coach) {
        this.number_of_players = number_of_players;
        this.teamFinalRating = teamFinalRating;
        this.team_name = team_name;
        this.coach = coach;
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
        return (teamRating / number_of_players);
    }

    public Team playGame (Team opponent) {
        Random rand = new Random(); //https://stackoverflow.com/questions/5887709/getting-random-numbers-in-java

        //Team team = new Team(number_of_players, teamFinalRating, team_name, coach);
        int myRating = this.teamFinalRating;
        opponent = new Team(opponent.number_of_players, opponent.teamFinalRating, opponent.team_name, opponent.coach);
        int yourRating = opponent.teamFinalRating;

        int ratingDifference = Math.abs(myRating-yourRating);
        int results = rand.nextInt(ratingDifference);

        if (results >= 3) {
            if (myRating > yourRating) {
                did_i_win = true;
                return this;
            }
            did_i_win = false;
            return opponent;
        }

        else if (results <= 3) {
            int chance = rand.nextInt(2);
            if (chance == 0) {
                did_i_win = true;
                return this;
            }
        }
        did_i_win = false;
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
        //Team team = new Team(number_of_players, teamFinalRating, team_name, coach);
        opponent = new Team(opponent.number_of_players, opponent.teamFinalRating, opponent.team_name, opponent.coach);
        if (!did_i_win) {
            for (int i=0; i<record.length; i++) {
                if (this.record[i] == 0) {
                    record[i] = 1;
                    break;
                }
            }

            for (int i=0; i<opponent.record.length; i++) {
                if (opponent.record[i] == 0) {
                    opponent.record[i] = 3;
                    break;
                }
            }
            return opponent;
        }
        for (int i=0; i<record.length; i++) {
            if (this.record[i] == 0) {
                this.record[i] = 3;
                break;
            }
        }

        for (int i=0; i<opponent.record.length; i++) {
            if (opponent.record[i] == 0) {
                opponent.record[i] = 1;
                break;
            }
        }
        return this;
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

    public int getTotal() {
        int total = 0;

        for (int i=0; i<record.length; i++) {
            total += record[i];
        }
        return total;
    }
}
