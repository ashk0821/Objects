package FantasySports.Sports;

public class Coach implements SportsProfessional{
    public int coachRating;
    public int morale;
    public Team team;
    public String name;

    public Coach(int coachRating, Team team, String name) {
        this.coachRating = coachRating;
        this.team = team;
        this.name = name;
    }

    public void Train (Player player) {
        if (player.team == team) {
            if (coachRating <= 65) {
                player.speed++;
                player.catching++;
                player.power++;
                player.stamina++;
            }
            else if (coachRating <= 75) {
                player.speed+=2;
                player.catching+=2;
                player.power+=2;
                player.stamina+=2;
            }
            else if (coachRating <= 85) {
                player.speed+=3;
                player.catching+=3;
                player.power+=3;
                player.stamina+=3;
            }
            else {
                player.speed+=4;
                player.catching+=4;
                player.power+=4;
                player.stamina+=4;
            }
        }
        else {
            System.out.println("The coach and player have to be on the same team!! " + player.name + " is not on " + team.team_name + "!!");
        }

        if (player.speed > 99 || player.catching > 99 || player.power > 99 || player.stamina > 99)
            System.out.println("The player's stats have to have a maximum of 99.");

        if (player.speed > 99)
            player.speed = 99;
        if (player.catching > 99)
            player.catching = 99;
        if (player.power > 99)
            player.catching = 99;
        if (player.stamina > 99)
            player.stamina = 99;
    }


    public int getRating() {
        return coachRating;
    }

    public java.lang.String getName () {
        return name;
    }

    public java.lang.String getTeam () {
        return team.team_name;
    }

    public String toString() {
        return "Hi, my name is " + getName() + " and I coach " + getTeam() + ". My overall rating is " + coachRating + "!";
    }
}
