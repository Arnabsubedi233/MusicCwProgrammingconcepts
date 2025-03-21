package org.example.DataAccessObject;

import org.example.model.song;
import java.util.List;

public interface SongDAO {
    void addSong(song song);
    void removeSong(int songId);
    List<song> getAllSongs();
    List<song> getSongsAbovePlayCount(int minPlays);
}