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

        System.out.println("\nSeason:\n");
        SmartGambler smart_gambler = new SmartGambler();
        DumbGambler dumb_gambler = new DumbGambler();
        AmbitiousGambler ambitious_gambler = new AmbitiousGambler();


        smart_gambler.bet(chelsea, barca);
        dumb_gambler.bet(chelsea, barca);
        ambitious_gambler.bet(chelsea, barca);
        chelsea.playGame(barca);
        System.out.println(chelsea.winnerWas(barca).team_name + " beat " + chelsea.loserWas(barca).team_name);
        smart_gambler.winnerWas(chelsea, barca);
        dumb_gambler.winnerWas(chelsea, barca);
        ambitious_gambler.winnerWas(chelsea, barca);
        System.out.println("Smart: " + smart_gambler.finalBalance());
        System.out.println("Dumb: " + dumb_gambler.finalBalance());
        System.out.println("Ambitious: " + ambitious_gambler.finalBalance());
        System.out.println("Smart History: " + smart_gambler.gamblingHistory());
        System.out.println("Dumb History: " + dumb_gambler.gamblingHistory());
        System.out.println("Ambitious History: " + ambitious_gambler.gamblingHistory());
        System.out.println(chelsea.getTotal());

        smart_gambler.bet(chelsea, liverpool);
        dumb_gambler.bet(chelsea, liverpool);
        ambitious_gambler.bet(chelsea, liverpool);
        chelsea.playGame(liverpool);
        System.out.println(chelsea.winnerWas(liverpool).team_name + " beat " + chelsea.loserWas(liverpool).team_name);
        System.out.println("Smart: " + smart_gambler.finalBalance());
        System.out.println("Dumb: " + dumb_gambler.finalBalance());
        System.out.println("Ambitious: " + ambitious_gambler.finalBalance());
        System.out.println("Smart History: " + smart_gambler.gamblingHistory());
        System.out.println("Dumb History: " + dumb_gambler.gamblingHistory());
        System.out.println("Ambitious History: " + ambitious_gambler.gamblingHistory());
        System.out.println(chelsea.getTotal());


        smart_gambler.bet(chelsea, real_madrid);
        dumb_gambler.bet(chelsea, real_madrid);
        ambitious_gambler.bet(chelsea, real_madrid);
        chelsea.playGame(real_madrid);
        System.out.println(chelsea.winnerWas(real_madrid).team_name + " beat " + chelsea.loserWas(real_madrid).team_name);
        System.out.println("Smart: " + smart_gambler.finalBalance());
        System.out.println("Dumb: " + dumb_gambler.finalBalance());
        System.out.println("Ambitious: " + ambitious_gambler.finalBalance());
        System.out.println("Smart History: " + smart_gambler.gamblingHistory());
        System.out.println("Dumb History: " + dumb_gambler.gamblingHistory());
        System.out.println("Ambitious History: " + ambitious_gambler.gamblingHistory());
        System.out.println(chelsea.getTotal());

        smart_gambler.bet(liverpool, chelsea);
        dumb_gambler.bet(liverpool, chelsea);
        ambitious_gambler.bet(liverpool, chelsea);
        liverpool.playGame(chelsea);
        System.out.println(liverpool.winnerWas(chelsea).team_name + " beat " + liverpool.loserWas(chelsea).team_name);
        System.out.println("Smart: " + smart_gambler.finalBalance());
        System.out.println("Dumb: " + dumb_gambler.finalBalance());
        System.out.println("Ambitious: " + ambitious_gambler.finalBalance());
        System.out.println("Smart History: " + smart_gambler.gamblingHistory());
        System.out.println("Dumb History: " + dumb_gambler.gamblingHistory());
        System.out.println("Ambitious History: " + ambitious_gambler.gamblingHistory());

        smart_gambler.bet(liverpool, real_madrid);
        dumb_gambler.bet(liverpool, real_madrid);
        ambitious_gambler.bet(liverpool, real_madrid);
        liverpool.playGame(real_madrid);
        System.out.println(liverpool.winnerWas(real_madrid).team_name + " beat " + liverpool.loserWas(real_madrid).team_name);
        System.out.println("Smart: " + smart_gambler.finalBalance());
        System.out.println("Dumb: " + dumb_gambler.finalBalance());
        System.out.println("Ambitious: " + ambitious_gambler.finalBalance());
        System.out.println("Smart History: " + smart_gambler.gamblingHistory());
        System.out.println("Dumb History: " + dumb_gambler.gamblingHistory());
        System.out.println("Ambitious History: " + ambitious_gambler.gamblingHistory());

        smart_gambler.bet(liverpool, barca);
        dumb_gambler.bet(liverpool, barca);
        ambitious_gambler.bet(liverpool, barca);
        liverpool.playGame(barca);
        System.out.println(liverpool.winnerWas(barca).team_name + " beat " + liverpool.loserWas(barca).team_name);
        System.out.println("Smart: " + smart_gambler.finalBalance());
        System.out.println("Dumb: " + dumb_gambler.finalBalance());
        System.out.println("Ambitious: " + ambitious_gambler.finalBalance());
        System.out.println("Smart History: " + smart_gambler.gamblingHistory());
        System.out.println("Dumb History: " + dumb_gambler.gamblingHistory());
        System.out.println("Ambitious History: " + ambitious_gambler.gamblingHistory());

        smart_gambler.bet(real_madrid, barca);
        dumb_gambler.bet(real_madrid, barca);
        ambitious_gambler.bet(real_madrid, barca);
        real_madrid.playGame(barca);
        System.out.println(real_madrid.winnerWas(barca).team_name + " beat " + real_madrid.loserWas(barca).team_name);
        System.out.println("Smart: " + smart_gambler.finalBalance());
        System.out.println("Dumb: " + dumb_gambler.finalBalance());
        System.out.println("Ambitious: " + ambitious_gambler.finalBalance());
        System.out.println("Smart History: " + smart_gambler.gamblingHistory());
        System.out.println("Dumb History: " + dumb_gambler.gamblingHistory());
        System.out.println("Ambitious History: " + ambitious_gambler.gamblingHistory());

        smart_gambler.bet(real_madrid, chelsea);
        dumb_gambler.bet(real_madrid, chelsea);
        ambitious_gambler.bet(real_madrid, chelsea);
        real_madrid.playGame(chelsea);
        System.out.println(real_madrid.winnerWas(chelsea).team_name + " beat " + real_madrid.loserWas(chelsea).team_name);
        System.out.println("Smart: " + smart_gambler.finalBalance());
        System.out.println("Dumb: " + dumb_gambler.finalBalance());
        System.out.println("Ambitious: " + ambitious_gambler.finalBalance());
        System.out.println("Smart History: " + smart_gambler.gamblingHistory());
        System.out.println("Dumb History: " + dumb_gambler.gamblingHistory());
        System.out.println("Ambitious History: " + ambitious_gambler.gamblingHistory());

        smart_gambler.bet(real_madrid, liverpool);
        dumb_gambler.bet(real_madrid, liverpool);
        ambitious_gambler.bet(real_madrid, liverpool);
        real_madrid.playGame(liverpool);
        System.out.println(real_madrid.winnerWas(liverpool).team_name + " beat " + real_madrid.loserWas(liverpool).team_name);
        System.out.println("Smart: " + smart_gambler.finalBalance());
        System.out.println("Dumb: " + dumb_gambler.finalBalance());
        System.out.println("Ambitious: " + ambitious_gambler.finalBalance());
        System.out.println("Smart History: " + smart_gambler.gamblingHistory());
        System.out.println("Dumb History: " + dumb_gambler.gamblingHistory());
        System.out.println("Ambitious History: " + ambitious_gambler.gamblingHistory());

        smart_gambler.bet(barca, real_madrid);
        dumb_gambler.bet(barca, real_madrid);
        ambitious_gambler.bet(barca, real_madrid);
        barca.playGame(real_madrid);
        System.out.println(barca.winnerWas(real_madrid).team_name + " beat " + barca.loserWas(real_madrid).team_name);
        System.out.println("Smart: " + smart_gambler.finalBalance());
        System.out.println("Dumb: " + dumb_gambler.finalBalance());
        System.out.println("Ambitious: " + ambitious_gambler.finalBalance());
        System.out.println("Smart History: " + smart_gambler.gamblingHistory());
        System.out.println("Dumb History: " + dumb_gambler.gamblingHistory());
        System.out.println("Ambitious History: " + ambitious_gambler.gamblingHistory());

        smart_gambler.bet(barca, chelsea);
        dumb_gambler.bet(barca, chelsea);
        ambitious_gambler.bet(barca, chelsea);
        barca.playGame(chelsea);
        System.out.println(barca.winnerWas(chelsea).team_name + " beat " + barca.loserWas(chelsea).team_name);
        System.out.println("Smart: " + smart_gambler.finalBalance());
        System.out.println("Dumb: " + dumb_gambler.finalBalance());
        System.out.println("Ambitious: " + ambitious_gambler.finalBalance());
        System.out.println("Smart History: " + smart_gambler.gamblingHistory());
        System.out.println("Dumb History: " + dumb_gambler.gamblingHistory());
        System.out.println("Ambitious History: " + ambitious_gambler.gamblingHistory());

        smart_gambler.bet(barca, liverpool);
        dumb_gambler.bet(barca, liverpool);
        ambitious_gambler.bet(barca, liverpool);
        barca.playGame(liverpool);
        System.out.println(barca.winnerWas(liverpool).team_name + " beat " + barca.loserWas(liverpool).team_name);
        System.out.println("Smart: " + smart_gambler.finalBalance());
        System.out.println("Dumb: " + dumb_gambler.finalBalance());
        System.out.println("Ambitious: " + ambitious_gambler.finalBalance());

        System.out.println("\n");
        System.out.println("Smart History: " + smart_gambler.gamblingHistory());
        System.out.println("Dumb History: " + dumb_gambler.gamblingHistory());
        System.out.println("Ambitious History: " + ambitious_gambler.gamblingHistory());

        System.out.println("\n");
        System.out.println("Chelsea's total is " + chelsea.getTotal());
        System.out.println("Liverpool's total is " + liverpool.getTotal());
        System.out.println("Real Madrid's total is " + real_madrid.getTotal());
        System.out.println("Barcelona's total is " + barca.getTotal());


        if (chelsea.getTotal() > real_madrid.getTotal() && chelsea.getTotal() > liverpool.getTotal() && chelsea.getTotal() > barca.getTotal())
            System.out.println("Chelsea won the league!");
        else if (liverpool.getTotal() > barca.getTotal() && liverpool.getTotal() > real_madrid.getTotal())
            System.out.println("Liverpool won the league!");
        else if (real_madrid.getTotal() > barca.getTotal())
            System.out.println("Real Madrid won the league!");
        else
            System.out.println("Barcelona won the league!");

        // lowest rating before season starts wins in tie.
        // Only home games count in final point tally; away games are meant to stop the home teams from winning the maximum 9 points.
    }
}
