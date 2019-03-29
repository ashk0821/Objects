package FantasySports.Gambling;

import FantasySports.Sports.Team;

import java.util.ArrayList;

public interface Gambler {
    //public Team chosen;
    //public Team winner;

    public void bet (Team a, Team b);

    public void winnerWas ();

    public double balance();

    public ArrayList<Double> gamblingHistory();
}
