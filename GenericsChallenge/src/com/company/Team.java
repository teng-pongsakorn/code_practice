package com.company;

import java.util.ArrayList;

public class Team<T extends Player> implements Comparable<Team<T>>{
    String name;
    ArrayList<T> players;
    int plays;
    int won;
    int lost;
    int draw;

    public Team(String name) {
        this.name = name;
        this.players = new ArrayList<T>();
        this.plays = 0;
        this.won = 0;
        this.lost = 0;
        this.draw = 0;
    }

    public boolean addPlayer(T player) {
        if (players.contains(player)) {
            System.out.println(player.getName() + " already in team " + this.getName());
            return false;
        }
        players.add(player);
        return true;
    }

    public String getName() {
        return name;
    }

    public void match(Team<T> opponent, int ourScore, int theirScore) {
        String message;
        if (ourScore > theirScore) {
            this.won++;
            message = " beated ";
        } else if (ourScore < theirScore) {
            this.lost++;
            message = " lost to ";
        } else {
            this.draw++;
            message = " drew against ";
        }
        if (opponent != null) {
            opponent.match(null, theirScore, ourScore);
            System.out.println(getName() + message + opponent.getName());
        }
    }

    public int rank() {
        return 2*won + draw;
    }

    @Override
    public int compareTo(Team<T> o) {
        if (this.rank() > o.rank()) {
            return -1;
        } else if (this.rank() < o.rank()) {
            return 1;
        }
        return 0;
    }
}
