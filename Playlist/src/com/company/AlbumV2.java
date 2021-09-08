package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

public class AlbumV2 {
    private String name;
    private String artist;
    private SongList songList;

    private class SongList {
        private ArrayList<Song> songs;

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

        public int size() {
            return songs.size();
        }

        public Song get(int trackIndex) {
            return songs.get(trackIndex);
        }
    }

    public AlbumV2(String name, String artist) {
        this.name = name;
        this.artist = artist;
        songList = new SongList();
    }

    public boolean addSong(String title, double duration) {
        return songList.addSong(title, duration);
    }

    private Song findSong(String title) {
        return songList.findSong(title);
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
        if (index >= 0 && index < songList.size()) {
            playlist.add(songList.get(index));
            return true;
        }
        System.out.println("There is no track " + trackNum);
        return false;
    }

}
