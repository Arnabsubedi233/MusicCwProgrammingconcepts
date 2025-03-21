package org.example.model;

public class song {
    private int id;
    private String title;
    private String artist;
    private int playCount;

    public song(int id, String title, String artist, int playCount) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.playCount = playCount;
    }

    // Getters & Setters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getPlayCount() {
        return playCount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setPlayCount(int playCount) {
        this.playCount = playCount;
    }

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