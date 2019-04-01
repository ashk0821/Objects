package FantasySports;

import FantasySports.Sports.Player;
import FantasySports.Sports.Team;

public class FantasyCricket {
    public static void main(String[] args) {
        Team chelsea = new Team();
        Team real_madrid = new Team();
        Team liverpool = new Team();
        Team barca = new Team();

        Player alan = new Player();
        chelsea.draft(alan);
        alan.speed = 75;
        alan.stamina = 95;
        alan.catching = 40;
        alan.power = 80;
        alan.name = "Alan";
        alan.team = chelsea;
        System.out.println(chelsea.getPlayers());
        System.out.println(alan.toString());

        chelsea.teamRating
        System.out.println(chelsea.playGame(real_madrid));
    }
}
