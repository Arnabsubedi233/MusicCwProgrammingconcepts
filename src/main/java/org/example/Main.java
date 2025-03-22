package org.example;

import org.example.DataAccessObject.SongDAO;
import org.example.DataAccessObject.SongCSVDAO;
import org.example.model.song;
import org.example.service.songService;
import org.example.DataAccessObject.AvaiableSongsCSVDAO;
import org.example.model.playableSongs;
import org.example.service.PlaySongService;

import java.util.List;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        // Use CSV-based DAO
        SongDAO songDAO = new SongCSVDAO();
        songService songService = new songService(songDAO);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;


        while (running) {
            printMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    // Add a new song
                    System.out.println("Enter song title:");
                    String title = scanner.nextLine();

                    System.out.println("Enter artist name:");
                    String artist = scanner.nextLine();

                    System.out.println("Enter play count (number):");
                    int plays;
                    try {
                        plays = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid integer!");
                        plays = 0;
                    }

                    songService.addSong(title, artist, plays);
                    System.out.println("Song added successfully.\n");
                    break;

                case "2":
                    // Remove a song
                    System.out.println("Enter the ID of the song to remove:");
                    int songId;
                    try {
                        songId = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID. Operation cancelled.\n");
                        break;
                    }

                    songService.removeSong(songId);
                    System.out.println("Song removed (if it existed).\n");
                    break;

                case "3":
                    // Print list of all songs
                    List<song> allSongs = songService.getAllSongs();
                    System.out.println("All Songs:");
                    for (song s : allSongs) {
                        System.out.printf(
                                "| %-3d | %-25s | %-25s | %-10d |%n",
                                s.getId(),
                                s.getTitle(),
                                s.getArtist(),
                                s.getPlayCount()
                        );
                    }
                    System.out.println();
                    break;

                case "4":
                    // Print songs over a certain play count
                    System.out.println("Enter minimum play count:");
                    int minPlays;
                    try {
                        minPlays = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number. Defaulting to 0.\n");
                        minPlays = 0;
                    }

                    List<song> filteredSongs = songService.getSongsAbovePlayCount(minPlays);
                    System.out.println("Songs with play count over " + minPlays + ":");
                    for (song s : filteredSongs) {
                        System.out.printf(
                                "| %-3d | %-25s | %-25s | %-10d |%n",
                                s.getId(),
                                s.getTitle(),
                                s.getArtist(),
                                s.getPlayCount()
                        );
                    }
                    System.out.println();
                    break;

                case "5":
                    AvaiableSongsCSVDAO availableDAO = new AvaiableSongsCSVDAO();
                    List<playableSongs> availableSongs = availableDAO.getAllAvailableSongs();

                    if (availableSongs.isEmpty()) {
                        System.out.println("No available songs to play.");
                        break;
                    }

                    for (playableSongs s : availableSongs) {
                        System.out.printf(
                                "| %-3d | %-25s | %-25s | %-10d |%n",
                                s.getId(),
                                s.getTitle(),
                                s.getArtist(),
                                s.getPlayCount()
                        );
                    }

                    System.out.println("Enter the ID of the song you want to play:");
                    int playId;
                    try {
                        playId = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Returning to main menu...\n");
                        break;
                    }

                    playableSongs chosenSong = null;
                    for (playableSongs s : availableSongs) {
                        if (s.getId() == playId) {
                            chosenSong = s;
                            break;
                        }
                    }

                    if (chosenSong == null) {
                        System.out.println("Song with ID " + playId + " not found.");
                    } else {
                        String audioPath = "src/main/resources/audio/" + chosenSong.getAudioFile();
                        System.out.println("Playing: " + chosenSong.getTitle() + " by " + chosenSong.getArtist()
                                + "\nFile: " + audioPath);

                        PlaySongService.openAudioFile(audioPath);

                        System.out.println("Playback finished.\n");
                    }

                    break;

                case "6":
                    // Exit
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.\n");
                    break;
            }
        }

        System.out.println("Exiting application...");
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("==== Music Streaming CLI ====");
        System.out.println("1. Add a new song");
        System.out.println("2. Remove a song");
        System.out.println("3. Print all songs");
        System.out.println("4. Print songs above a given play count");
        System.out.println("5. Play a song");
        System.out.println("6. Exit");
        System.out.print("Please choose an option: ");
    }
}
