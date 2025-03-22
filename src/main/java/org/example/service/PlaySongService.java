package org.example.service;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

/**
 * Opens an audio file using the default media player on the system.
 *
 * @parameters filepath the path to the audio file to be opened
 */
public class PlaySongService {
    public static void openAudioFile(String filePath) {
        if (!Desktop.isDesktopSupported()) {
            System.out.println("Desktop is not supported on this environment.");
            return;
        }

        Desktop desktop = Desktop.getDesktop();
        if (!desktop.isSupported(Desktop.Action.OPEN)) {
            System.out.println("OPEN action is not supported on this environment.");
            return;
        }

        File audioFile = new File(filePath);
        if (!audioFile.exists()) {
            System.out.println("File does not exist: " + audioFile.getAbsolutePath());
            return;
        }

        try {
            desktop.open(audioFile);
            System.out.println("Opening file in the default media player: " + audioFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
