package org.example.DataAccessObject;
import org.example.model.playableSongs;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Object (DAO) for managing available songs using a CSV file.
 */
public class AvaiableSongsCSVDAO {
    private static final String CSV_FILE_PATH = "src/main/resources/playableSongs.csv";

    /**
     * Retrieves all available songs from the CSV file.
     *
     * @return a list of all available songs
     */
    public List<playableSongs> getAllAvailableSongs() {
        List<playableSongs> songs = new ArrayList<>();
        File file = new File(CSV_FILE_PATH);

        if (!file.exists()) {
            return songs;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String header = br.readLine();

            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                // We now expect 5 columns
                if (values.length == 5) {
                    int id = Integer.parseInt(values[0]);
                    String title = values[1];
                    String artist = values[2];
                    int plays = Integer.parseInt(values[3]);
                    String audioFile = values[4];

                    songs.add(new playableSongs(id, title, artist, plays, audioFile));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return songs;
    }
}
