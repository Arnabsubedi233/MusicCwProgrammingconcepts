package org.example.model;

/**
 * Represents a playable song with an ID, title, artist, play count, and audio file path.
 */
public class playableSongs {
    private int id;
    private String title;
    private String artist;
    private int playCount;
    private String audioFile; // new field for the audio file path/name

    /**
     * Constructs a new playable song with the specified ID, title, artist, play count, and audio file path.
     *
     * @param id the ID of the song
     * @param title the title of the song
     * @param artist the artist of the song
     * @param playCount the number of times the song has been played
     * @param audioFile the path or name of the audio file
     */
    public playableSongs(int id, String title, String artist, int playCount, String audioFile) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.playCount = playCount;
        this.audioFile = audioFile;
    }

    /**
     * Returns the ID of the song.
     *
     * @return the ID of the song
     */
    public int getId() { return id; }

    /**
     * Sets the ID of the song.
     *
     * @param id the new ID of the song
     */
    public void setId(int id) { this.id = id; }

    /**
     * Returns the title of the song.
     *
     * @return the title of the song
     */
    public String getTitle() { return title; }

    /**
     * Sets the title of the song.
     *
     * @param title the new title of the song
     */
    public void setTitle(String title) { this.title = title; }

    /**
     * Returns the artist of the song.
     *
     * @return the artist of the song
     */
    public String getArtist() { return artist; }

    /**
     * Sets the artist of the song.
     *
     * @param artist the new artist of the song
     */
    public void setArtist(String artist) { this.artist = artist; }

    /**
     * Returns the play count of the song.
     *
     * @return the play count of the song
     */
    public int getPlayCount() { return playCount; }

    /**
     * Sets the play count of the song.
     *
     * @param playCount the new play count of the song
     */
    public void setPlayCount(int playCount) { this.playCount = playCount; }

    /**
     * Returns the audio file path or name of the song.
     *
     * @return the audio file path or name of the song
     */
    public String getAudioFile() { return audioFile; }

    /**
     * Sets the audio file path or name of the song.
     *
     * @param audioFile the new audio file path or name of the song
     */
    public void setAudioFile(String audioFile) { this.audioFile = audioFile; }

    /**
     * Returns a string representation of the song.
     *
     * @return a string representation of the song
     */
    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", playCount=" + playCount +
                ", audioFile='" + audioFile + '\'' +
                '}';
    }
}