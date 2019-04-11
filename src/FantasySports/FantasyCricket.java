package FantasySports;

import FantasySports.Gambling.AmbitiousGambler;
import FantasySports.Gambling.DumbGambler;
import FantasySports.Gambling.Gambler;
import FantasySports.Gambling.SmartGambler;
import FantasySports.Sports.Coach;
import FantasySports.Sports.Player;
import FantasySports.Sports.Team;

public class FantasyCricket {
    public static void main(String[] args) {
        Team chelsea = new Team(0, 0, "Chelsea", null);
        Team real_madrid = new Team(0, 0, "Real Madrid", null);
        Team liverpool = new Team(0, 0,  "Liverpool", null);
        Team barca = new Team(0, 0,  "Barcelona", null);

        Player alan = new Player(75, 40, 95, 80, "Alan", chelsea);
        Player eden = new Player(95, 35, 95, 45,  "Eden Hazard", chelsea);
        Player ben = new Player(99, 99, 99, 99, "Mr. Isecke", chelsea);

        Player aashir = new Player(75, 70, 65, 70, "Aashir", liverpool);
        Player mo = new Player (95, 25, 85, 35, "Mohammad Salah", liverpool);
        Player bryan = new Player(99, 99, 99, 99, "Mr. Respass", liverpool);

        Player amani = new Player(95, 30, 75, 10,  "Amani", real_madrid);
        Player ramos = new Player(70, 65, 75, 85, "Sergio Ramos", real_madrid);
        Player matt = new Player(99, 99, 99, 99,  "Mr. Wong", real_madrid);

        Player chris = new Player(55, 85, 35, 80,  "Chris", barca);
        Player leo = new Player(85, 35, 85, 45,  "Lionel Messi", barca);
        Player ansh = new Player(60, 60, 60, 60,  "Ansh", barca);

        Coach sarri = new Coach(75, chelsea, "Mauricio Sarri");
        Coach jurgen = new Coach(85, liverpool, "Jurgen Klopp");
        Coach zidane = new Coach(99,  real_madrid, "Zinedine Zidane");
        Coach ernesto = new Coach(55,  barca, "Ernesto Valverde");

        chelsea.coach = sarri;
        liverpool.coach = jurgen;
        real_madrid.coach = zidane;
        barca.coach = ernesto;

        System.out.println(alan.toString());
        System.out.println(eden.toString());
        System.out.println(ben.toString());
        System.out.println(sarri.toString());

        System.out.println(aashir.toString());
        System.out.println(mo.toString());
        System.out.println(bryan.toString());
        System.out.println(jurgen.toString());

        System.out.println(amani.toString());
        System.out.println(ramos.toString());
        System.out.println(matt.toString());
        System.out.println(zidane.toString());

        System.out.println(chris.toString());
        System.out.println(leo.toString());
        System.out.println(ansh.toString());
        System.out.println(ernesto.toString());

        chelsea.draft(alan);
        chelsea.draft(eden);
        chelsea.draft(ben);

        liverpool.draft(aashir);
        liverpool.draft(mo);
        liverpool.draft(bryan);

        real_madrid.draft(amani);
        real_madrid.draft(ramos);
        real_madrid.draft(matt);

        barca.draft(chris);
        barca.draft(leo);
        barca.draft(ansh);

        System.out.println(chelsea.team_name +  "'s players are: " + chelsea.getPlayers());

        System.out.println(chelsea.team_name + "'s overall rating is " + chelsea.getRating() + ".");

        System.out.println();

        System.out.println(liverpool.team_name +  "'s players are: " + liverpool.getPlayers());

        System.out.println(liverpool.team_name + "'s overall rating is " + liverpool.getRating() + ".");

        System.out.println();


        System.out.println(real_madrid.team_name +  "'s players are: " + real_madrid.getPlayers());

        System.out.println(real_madrid.team_name + "'s overall rating is " + real_madrid.getRating() + ".");

        System.out.println();

        System.out.println(barca.team_name +  "'s players are: " + barca.getPlayers());

        System.out.println(barca.team_name + "'s overall rating is " + barca.getRating() + ".");

        System.out.println();


        System.out.println(eden.toString());
        sarri.Train(eden);
        System.out.println(eden.toString());
        System.out.println();
        System.out.println(matt.toString());
        sarri.Train(matt);
        System.out.println(matt.toString());
        System.out.println();
        System.out.println(ben.toString());
        sarri.Train(ben);
        System.out.println(ben.toString());
        System.out.println();
        System.out.println(amani.toString());
        zidane.Train(amani);
        System.out.println(amani.toString());
        System.out.println();
        System.out.println(ansh.toString());
        ernesto.Train(alan);
        ernesto.Train(ansh);
        System.out.println(ansh.toString());
        System.out.println();
        System.out.println(mo.toString());
        jurgen.Train(mo);
        System.out.println(mo.toString());

        System.out.println("\n");
        System.out.println(chelsea.team_name + "'s overall rating is " + chelsea.getFinalRating() + ".");
        System.out.println(liverpool.team_name + "'s overall rating is " + liverpool.getFinalRating() + ".");
        System.out.println(real_madrid.team_name + "'s overall rating is " + real_madrid.getFinalRating() + ".");
        System.out.println(barca.team_name + "'s overall rating is " + barca.getFinalRating() + ".");

        SmartGambler smart_gambler = new SmartGambler();
        DumbGambler dumb_gambler = new DumbGambler();
        AmbitiousGambler ambitious_gambler = new AmbitiousGambler();

        smart_gambler.bet(chelsea, liverpool);
        dumb_gambler.bet(chelsea, liverpool);
        ambitious_gambler.bet(chelsea, liverpool);

        System.out.println(barca.playGame(chelsea).team_name);
        System.out.println(chelsea.playGame(liverpool).team_name);
        System.out.println(real_madrid.playGame(chelsea).team_name);
        System.out.println(chelsea.getTotal());

        System.out.println(smart_gambler.currentBalance);
    }
}
