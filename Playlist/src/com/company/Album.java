package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        songs = new ArrayList<>();
    }

    public boolean addSong(String title, double duration) {
        if (findSong(title) == null) {
            songs.add(new Song(title, duration));
            return true;
        }
        return false;
    }

    private Song findSong(String title) {
        for (Song song: songs) {
            if (song.getTitle().equals(title)) {
                return song;
            }
        }
        return null;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playlist) {
        Song song = findSong(title);
        if (song != null) {
            playlist.add(song);
            return true;
        }
        System.out.println("There is no song: " + title);
        return false;
    }

    public boolean addToPlayList(int trackNum, LinkedList<Song> playlist) {
        int index = trackNum - 1;
        if (index >= 0 && index < songs.size()) {
            playlist.add(songs.get(index));
            return true;
        }
        System.out.println("There is no track " + trackNum);
        return false;
    }
}
