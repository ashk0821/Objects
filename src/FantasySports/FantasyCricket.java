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
        Team chelsea = new Team();
        chelsea.team_name = "Chelsea";
        Team real_madrid = new Team();
        real_madrid.team_name = "Real Madrid";
        Team liverpool = new Team();
        liverpool.team_name = "Liverpool";
        Team barca = new Team();
        barca.team_name = "Barcelona";

        Player alan = new Player();
        alan.speed = 75;
        alan.stamina = 95;
        alan.catching = 40;
        alan.power = 80;
        alan.name = "Alan";
        chelsea.draft(alan);
        alan.team = chelsea;

        Player eden = new Player();
        eden.speed = 95;
        eden.stamina = 95;
        eden.catching = 35;
        eden.power = 45;
        eden.name = "Eden Hazard";
        chelsea.draft(eden);
        eden.team = chelsea;

        Player ben = new Player();
        ben.speed = 99;
        ben.stamina = 99;
        ben.catching = 99;
        ben.power = 99;
        ben.name = "Mr. Isecke";
        chelsea.draft(ben);
        ben.team = chelsea;

        Coach sarri = new Coach();
        sarri.coachRating = 75;
        sarri.team = chelsea;
        sarri.name = "Mauricio Sarri";

        System.out.println(alan.toString());
        System.out.println(eden.toString());
        System.out.println(ben.toString());
        System.out.println(sarri.toString());

        System.out.println(chelsea.team_name +  "'s players are: " + chelsea.getPlayers());

        System.out.println(chelsea.team_name + "'s overall rating is " + chelsea.getRating() + ".");

        System.out.println("\n");

        Player aashir = new Player();
        aashir.speed = 75;
        aashir.stamina = 65;
        aashir.catching = 70;
        aashir.power = 70;
        aashir.name = "Aashir";
        liverpool.draft(aashir);
        aashir.team = liverpool;

        Player mo = new Player();
        mo.speed = 95;
        mo.stamina = 85;
        mo.catching = 25;
        mo.power = 35;
        mo.name = "Mohammad Salah";
        liverpool.draft(mo);
        mo.team = liverpool;

        Player bryan = new Player();
        bryan.speed = 99;
        bryan.stamina = 99;
        bryan.catching = 99;
        bryan.power = 99;
        bryan.name = "Mr. Respass";
        liverpool.draft(bryan);
        bryan.team = liverpool;

        Coach jurgen = new Coach();
        jurgen.coachRating = 85;
        jurgen.team = liverpool;
        jurgen.name = "Jurgen Klopp";

        System.out.println(aashir.toString());
        System.out.println(mo.toString());
        System.out.println(bryan.toString());
        System.out.println(jurgen.toString());

        System.out.println(liverpool.team_name +  "'s players are: " + liverpool.getPlayers());

        System.out.println(liverpool.team_name + "'s overall rating is " + liverpool.getRating() + ".");

        System.out.println("\n");

        Player amani = new Player();
        amani.speed = 95;
        amani.stamina = 75;
        amani.catching = 30;
        amani.power = 10;
        amani.name = "Amani";
        real_madrid.draft(amani);
        amani.team = real_madrid;

        Player ramos = new Player();
        ramos.speed = 70;
        ramos.stamina = 75;
        ramos.catching = 65;
        ramos.power = 85;
        ramos.name = "Sergio Ramos";
        real_madrid.draft(ramos);
        ramos.team = real_madrid;

        Player matt = new Player();
        matt.speed = 99;
        matt.stamina = 99;
        matt.catching = 99;
        matt.power = 99;
        matt.name = "Mr. Wong";
        real_madrid.draft(matt);
        matt.team = real_madrid;

        Coach zidane = new Coach();
        zidane.coachRating = 99;
        zidane.team = real_madrid;
        zidane.name = "Zinedine Zidane";

        System.out.println(amani.toString());
        System.out.println(ramos.toString());
        System.out.println(matt.toString());
        System.out.println(zidane.toString());

        System.out.println(real_madrid.team_name +  "'s players are: " + real_madrid.getPlayers());

        System.out.println(real_madrid.team_name + "'s overall rating is " + real_madrid.getRating() + ".");

        System.out.println("\n");

        Player chris = new Player();
        chris.speed = 55;
        chris.stamina = 35;
        chris.catching = 85;
        chris.power = 80;
        chris.name = "Chris";
        barca.draft(chris);
        chris.team = barca;

        Player leo = new Player();
        leo.speed = 85;
        leo.stamina = 85;
        leo.catching = 35;
        leo.power = 45;
        leo.name = "Lionel Messi";
        barca.draft(leo);
        leo.team = barca;

        Player ansh = new Player();
        ansh.speed = 60;
        ansh.stamina = 60;
        ansh.catching = 60;
        ansh.power = 60;
        ansh.name = "Ansh";
        barca.draft(ansh);
        ansh.team = barca;

        Coach ernesto = new Coach();
        ernesto.coachRating = 55;
        ernesto.team = barca;
        ernesto.name = "Ernesto Valverde";

        System.out.println(chris.toString());
        System.out.println(leo.toString());
        System.out.println(ansh.toString());
        System.out.println(ernesto.toString());

        System.out.println(barca.team_name +  "'s players are: " + barca.getPlayers());

        System.out.println(barca.team_name + "'s overall rating is " + barca.getRating() + ".");

        System.out.println("\n");



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

    }
}
