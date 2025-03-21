package org.example.service;

import org.example.DataAccessObject.SongDAO;
import org.example.model.song;

import java.util.List;

public class songService {
    private final SongDAO songDAO;

    public songService(SongDAO songDAO) {
        this.songDAO = songDAO;
    }

    public void addSong(String title, String artist, int plays) {
        song newSong = new song(0, title, artist, plays);
        songDAO.addSong(newSong);
    }

    public void removeSong(int songId) {
        songDAO.removeSong(songId);
    }

    public List<song> getAllSongs() {
        return songDAO.getAllSongs();
    }

    public List<song> getSongsAbovePlayCount(int minPlays) {
        return songDAO.getSongsAbovePlayCount(minPlays);
    }
}
