package org.example.DataAccessObject;

import org.example.model.song;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SongCSVDAO implements SongDAO {

    private static final String CSV_FILE_PATH = "songs.csv";

    // Helper method: read all songs from CSV
    private List<song> readSongsFromCSV() {
        List<song> songs = new ArrayList<>();
        File file = new File(CSV_FILE_PATH);

        // If the file doesn't exist yet, return empty list
        if (!file.exists()) {
            return songs;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            // Skip the header row if it exists
            String header = br.readLine();
            if (header != null && header.startsWith("id,title,artist,plays")) {
                // We assume the first line is the header
            } else {
                // If not a header, let's re-process that line as data
                // Alternatively, you could require a header row.
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

    // Helper method: write all songs to CSV (overwrites the file)
    private void writeSongsToCSV(List<song> songs) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(CSV_FILE_PATH))) {
            // Write a header row (optional but recommended)
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

    // 1) Add a new song
    @Override
    public void addSong(song song) {
        // Read existing songs from CSV
        List<song> songs = readSongsFromCSV();

        // Generate a new ID if needed (e.g., max existing ID + 1)
        int newId = 1;
        for (song s : songs) {
            if (s.getId() >= newId) {
                newId = s.getId() + 1;
            }
        }
        song.setId(newId);

        // Add the new song
        songs.add(song);

        // Write updated list back to CSV
        writeSongsToCSV(songs);
    }

    // 2) Remove a song by ID
    @Override
    public void removeSong(int songId) {
        // Read existing songs
        List<song> songs = readSongsFromCSV();

        // Filter out the song with the given ID
        songs.removeIf(s -> s.getId() == songId);

        // Write the updated list back
        writeSongsToCSV(songs);
    }

    // 3) Retrieve all songs
    @Override
    public List<song> getAllSongs() {
        return readSongsFromCSV();
    }

    // 4) Retrieve songs above a certain play count
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
