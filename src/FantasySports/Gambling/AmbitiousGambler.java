package FantasySports.Gambling;

import FantasySports.Sports.Team;

import java.util.ArrayList;
import java.util.Random;

public class AmbitiousGambler implements Gambler {
    public Team a;
    public Team b;
    public Team other;
    public double currentBalance=1000;
    ArrayList<Double> history = new ArrayList<>();


    public Team bet (Team a, Team b) {
        if (currentBalance == 0)
            return null;
        this.a = a;
        this.b = b;
        if (a.getRating() + 5 >= b.getRating() && a.getRating() < b.getRating()) {
            other = this.b;
            return this.a;
        }
        else if (b.getRating() + 5 >= a.getRating() && b.getRating() < a.getRating()) {
            other = this.a;
            return this.b;
        }

        else {
            if (a.getRating() > b.getRating()) {
                other = this.b;
                return this.a;
            }
            else {
                other = this.a;
                return this.b;
            }
        }
    }

    public Team winnerWas (Team a, Team b) {
        return a.winnerWas(b);
    }

    public double finalBalance() {
        if (bet(a, b) == null)
            return 0;
        if (currentBalance == 0)
            return 0;

        if (bet(a, b).equals(winnerWas(a, b))) {
            if (bet(a, b).getFinalRating() >= b.getFinalRating())
                currentBalance += 100;
            else
                currentBalance += 200;
        }
        else {
            if (other.getFinalRating() >= bet(a, b).getFinalRating())
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
