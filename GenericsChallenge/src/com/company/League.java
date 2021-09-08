package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class League<T extends Team> {
    String name;
    ArrayList<T> teams;

    public League(String name) {
        this.name = name;
        teams = new ArrayList<T>();
    }

    public boolean addTeam(T team) {
        if (teams.contains(team)) {
            return false;
        }
        teams.add(team);
        return true;
    }

    public void displayTable() {
        Collections.sort(teams);
        for (int i=0; i<teams.size(); i++) {
            T team = teams.get(i);
            System.out.println((i+1) + ") " + team.getName() + " " + team.rank());
        }
    }
}
