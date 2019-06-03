package FantasySports.Gambling;

import FantasySports.Sports.Team;
import java.util.ArrayList;
import java.util.Random;

public class SmartGambler implements Gambler {
    public Team a;
    public Team b;
    public Team other;
    public double currentBalance=1000;
    boolean correct;
    Team betOn;
    Team winner;
    ArrayList<Double> history = new ArrayList<>();

    public Team bet (Team a, Team b) {
        if (currentBalance == 0)
            return null;
        this.a = a;
        this.b = b;

        if (a.getRating() >= b.getRating()) {
            other = this.b;
            betOn = this.a;
            return this.a;
        }
        else {
            other = this.a;
            betOn = this.b;
            return this.b;
        }
    }

    public Team winnerWas (Team a, Team b) {
        winner = a.winnerWas(this.b);
        return winner;
    }

    public double finalBalance() {
        if (betOn == null)
            return 0;
        if (currentBalance == 0)
            return 0;

        if (betOn.equals(winner)) {
            if (betOn.getFinalRating() >= other.getFinalRating())
                currentBalance += 100;
            else
                currentBalance += 200;
        }
        else {
            if (other.getFinalRating() >= betOn.getFinalRating())
                currentBalance -= 100;
            else
                currentBalance -= 200;
        }

        if (currentBalance <= 0)
            currentBalance = 0;

        return currentBalance;
    }

    public ArrayList<Double> gamblingHistory() {
        history.add(currentBalance);
        return history;
    }
}
