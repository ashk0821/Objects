package FantasySports.Gambling;

import FantasySports.Sports.Team;
import java.util.ArrayList;
import java.util.Random;

public class SmartGambler implements Gambler {
    public Team other;
    public Team chosen;
    public Team winner;
    public Team loser;
    public int currentBalance=1000;

    public void bet (Team a, Team b) {
        if (a.getRating() >= b.getRating()) {
            chosen = a;
            other = b;
        }
        else {
            chosen = b;
            other = a;
        }
    }

    public void winnerWas () {
        Team picked = chosen;
        Team enemy = new Team(0,0,"", null);
        if (picked.playGame(enemy) == picked) {
            winner = chosen;
            loser = enemy;
        }
        else {
            winner = enemy;
            loser = chosen;
        }
    }

    public double finalBalance() {
        if (currentBalance == 0)
            return 0;

        if (chosen.winnerWas(other) == chosen) {
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
        history.add(finalBalance());
        return history;
    }
}
