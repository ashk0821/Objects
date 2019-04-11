package FantasySports.Gambling;

import FantasySports.Sports.Team;

import java.util.ArrayList;

public interface Gambler {
    //public Team chosen;
    //public Team winner;

    public Team bet (Team a, Team b);

    public Team winnerWas (Team a, Team b);

    public double finalBalance();

    public ArrayList<Double> gamblingHistory();
}
