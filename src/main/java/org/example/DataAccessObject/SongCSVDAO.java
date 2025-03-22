package org.example.DataAccessObject;

import org.example.model.song;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the SongDAO interface for managing songs using a CSV file.
 */
public class SongCSVDAO implements SongDAO {

    private static final String CSV_FILE_PATH = "src/main/resources/songs.csv";

    /**
     * Reads songs from the CSV file.
     *
     * @return a list of songs read from the CSV file
     */
    private List<song> readSongsFromCSV() {
        List<song> songs = new ArrayList<>();
        File file = new File(CSV_FILE_PATH);

        if (!file.exists()) {
            return songs;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String header = br.readLine();
            if (header != null && header.startsWith("id,title,artist,plays")) {

            } else {
                if (header != null) {
                    String[] values = header.split(",");
                    if (values.length == 4) {
                        int id = Integer.parseInt(values[0]);
                        String title = values[1];
                        String artist = values[2];
                        int plays = Integer.parseInt(values[3]);

                        song song = new song(id, title, artist, plays);
                        songs.add(song);
                    }
                }
            }

            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length == 4) {
                    int id = Integer.parseInt(values[0]);
                    String title = values[1];
                    String artist = values[2];
                    int plays = Integer.parseInt(values[3]);

                    song song = new song(id, title, artist, plays);
                    songs.add(song);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return songs;
    }

    /**
     * Writes songs to the CSV file.
     *
     * @param songs the list of songs to be written to the CSV file
     */
    private void writeSongsToCSV(List<song> songs) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(CSV_FILE_PATH))) {
            bw.write("id,title,artist,plays");
            bw.newLine();

            for (song song : songs) {
                bw.write(song.getId() + "," + song.getTitle() + "," + song.getArtist() + "," + song.getPlayCount());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Adds a new song to the CSV file.
     *
     * @param song the song to be added
     */
    @Override
    public void addSong(song song) {
        List<song> songs = readSongsFromCSV();

        int newId = 1;
        for (song s : songs) {
            if (s.getId() >= newId) {
                newId = s.getId() + 1;
            }
        }
        song.setId(newId);

        songs.add(song);

        writeSongsToCSV(songs);
    }

    /**
     * Removes a song from the CSV file by its ID.
     *
     * @param songId the ID of the song to be removed
     */
    @Override
    public void removeSong(int songId) {
        List<song> songs = readSongsFromCSV();

        songs.removeIf(s -> s.getId() == songId);

        writeSongsToCSV(songs);
    }

    /**
     * Retrieves all songs from the CSV file.
     *
     * @return a list of all songs
     */
    @Override
    public List<song> getAllSongs() {
        return readSongsFromCSV();
    }

    /**
     * Retrieves songs with a play count above the specified minimum from the CSV file.
     *
     * @param minPlays the minimum play count
     * @return a list of songs with a play count above the specified minimum
     */
    @Override
    public List<song> getSongsAbovePlayCount(int minPlays) {
        List<song> allSongs = readSongsFromCSV();
        List<song> filtered = new ArrayList<>();

        for (song song : allSongs) {
            if (song.getPlayCount() > minPlays) {
                filtered.add(song);
            }
        }
        return filtered;
    }
}