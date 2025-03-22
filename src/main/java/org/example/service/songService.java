package org.example.service;

import org.example.DataAccessObject.SongDAO;
import org.example.model.song;

import java.util.List;

/**
 * Service class for managing songs.
 */
public class songService {
    private final SongDAO songDAO;

    /**
     * Constructs a new songService with the specified SongDAO.
     *
     * @param songDAO the data access object for songs
     */
    public songService(SongDAO songDAO) {
        this.songDAO = songDAO;
    }

    /**
     * Adds a new song with the specified title, artist, and play count.
     *
     * @param title  the title of the song
     * @param artist the artist of the song
     * @param plays  the number of plays of the song
     */
    public void addSong(String title, String artist, int plays) {
        song newSong = new song(0, title, artist, plays);
        songDAO.addSong(newSong);
    }

    /**
     * Removes the song with the specified ID.
     *
     * @param songId the ID of the song to be removed
     */
    public void removeSong(int songId) {
        songDAO.removeSong(songId);
    }

    /**
     * Retrieves all songs.
     *
     * @return a list of all songs
     */
    public List<song> getAllSongs() {
        return songDAO.getAllSongs();
    }

    /**
     * Retrieves songs with a play count above the specified minimum.
     *
     * @param minPlays the minimum play count
     * @return a list of songs with a play count above the specified minimum
     */
    public List<song> getSongsAbovePlayCount(int minPlays) {
        return songDAO.getSongsAbovePlayCount(minPlays);
    }
}
