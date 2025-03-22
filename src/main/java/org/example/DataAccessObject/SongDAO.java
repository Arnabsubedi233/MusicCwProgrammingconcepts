package org.example.DataAccessObject;

import org.example.model.song;
import java.util.List;

/**
 * Data Access Object (DAO) interface for managing songs.
 */
public interface SongDAO {
    /**
     * Adds a new song to the data store.
     *
     * @param song the song to be added
     */
    void addSong(song song);

    /**
     * Removes a song from the data store by its ID.
     *
     * @param songId the ID of the song to be removed
     */
    void removeSong(int songId);

    /**
     * Retrieves all songs from the data store.
     *
     * @return a list of all songs
     */
    List<song> getAllSongs();

    /**
     * Retrieves songs with a play count above the specified minimum.
     *
     * @param minPlays the minimum play count
     * @return a list of songs with a play count above the specified minimum
     */
    List<song> getSongsAbovePlayCount(int minPlays);
}