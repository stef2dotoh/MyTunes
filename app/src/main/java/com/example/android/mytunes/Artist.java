package com.example.android.mytunes;

/**
 * {@link Artist} represents an artist in the user's music library.
 * It contains the artist name and bio.
 */

public class Artist {

    /** Name of artist */
    private String mArtistName;

    /** Artist biographical details */
    private String mArtistBio;

    /**
     * Constructs a new artist with default values for
     * @param artistName name of artist
     * @param artistBio artist bio
     */
    public Artist(String artistName, String artistBio) {
        mArtistName = artistName;
        mArtistBio = artistBio;
    }

    /**
     * Get artist name
     */
    public String getArtistName() {
        return mArtistName;
    }

    /**
     * Get artist bio
     */
    public String getArtistBio() {
        return mArtistBio;
    }

    /**
     * Override toString method to display bio
     */
    public String toString() {
        return mArtistBio;
    }
}
