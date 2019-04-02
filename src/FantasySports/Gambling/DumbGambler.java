package FantasySports.Gambling;

import FantasySports.Sports.Team;
import java.util.ArrayList;
import java.util.Random;

public class DumbGambler implements Gambler {
    public Team chosen;
    public Team winner;
    public Team loser;
    int currentBalance=1000;

    public void bet (Team a, Team b) {
        Random team = new Random();
        int random_team = team.nextInt(1);

        if (random_team == 0)
            chosen = a;
        else
            chosen = b;
    }

    public void winnerWas () {
        Team picked = chosen;
        Team enemy = new Team();
        if (picked.playGame(enemy) == picked) {
            winner = chosen;
            loser = enemy;
        }
        else {
            winner = enemy;
            loser = chosen;
        }
    }

    public double balance() {
        if (currentBalance == 0)
            return 0;

        if (winner == chosen) {
            if (winner.getRating() >= loser.getRating())
                currentBalance += 100;
            else
                currentBalance += 200;
        }
        else {
            if (winner.getRating() >= loser.getRating())
                currentBalance -= 100;
            else
                currentBalance -= 200;
        }

        if (currentBalance <= 0)
            currentBalance = 0;

        return currentBalance;
    }

    public ArrayList<Double> gamblingHistory() {
        ArrayList<Double> history = new ArrayList<>();
        history.add(balance());
        return history;
    }
}
