package org.example.model;

/**
 * Represents a song with an ID, title, artist, and play count.
 */
public class song {
    private int id;
    private String title;
    private String artist;
    private int playCount;

    /**
     * Constructs a new song with the specified ID, title, artist, and play count.
     *
     * @param id the ID of the song
     * @param title the title of the song
     * @param artist the artist of the song
     * @param playCount the number of times the song has been played
     */
    public song(int id, String title, String artist, int playCount) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.playCount = playCount;
    }


    /**
     * Returns the ID of the song.
     *
     * @return the ID of the song
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the title of the song.
     *
     * @return the title of the song
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the artist of the song.
     *
     * @return the artist of the song
     */
    public String getArtist() {
        return artist;
    }

    /**
     * Returns the play count of the song.
     *
     * @return the play count of the song
     */
    public int getPlayCount() {
        return playCount;
    }

    /**
     * Sets the ID of the song.
     *
     * @param id the new ID of the song
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Sets the title of the song.
     *
     * @param title the new title of the song
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Sets the artist of the song.
     *
     * @param artist the new artist of the song
     */
    public void setArtist(String artist) {
        this.artist = artist;
    }

    /**
     * Sets the play count of the song.
     *
     * @param playCount the new play count of the song
     */
    public void setPlayCount(int playCount) {
        this.playCount = playCount;
    }

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
                '}';
    }
}