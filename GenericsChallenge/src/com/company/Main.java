package com.company;

public class Main {

    public static void main(String[] args) {
        FootballPlayer beckham = new FootballPlayer("Beckham");
        SoccerPlayer pat = new SoccerPlayer("Pat");

        Team<FootballPlayer> ManU = new Team<>("Manchester United");
        Team<SoccerPlayer> Miami = new Team<>("Miami United");

        ManU.addPlayer(beckham);
//        ManU.addPlayer(pat);

        League<Team<FootballPlayer>> footballLeague = new League<>("Premiere league");
    }
}
