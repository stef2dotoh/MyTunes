package com.example.android.mytunes;

/**
 * {@link Song} represents a song in the user's music library.
 * It contains the song title, album title, and artist name.
 */

public class Song {

    /** Title of song */
    private String mSongTitle;

    /** Title of album on which song is found */
    private String mAlbumTitle;

    /** Name of artist who performs song */
    private String mArtistName;

    /** Drawable resource ID */
    private int mImageResourceId;

    /**
     * Constructs a new song with default values for songTitle, albumTitle, artistName,
     * and imageResourceId
     * @param songTitle title of song
     * @param albumTitle title of album
     * @param artistName artist name
     * @param imageResourceId drawable reference ID that corresponds to the album title
     */
    public Song(String songTitle, String albumTitle, String artistName, int imageResourceId) {
        mSongTitle = songTitle;
        mAlbumTitle = albumTitle;
        mArtistName = artistName;
        mImageResourceId = imageResourceId;
    }

    /**
     * Get song title
     */
    public String getSongTitle() {
        return mSongTitle;
    }

    /**
     * Get album title
     */
    public String getAlbumTitle() {
        return mAlbumTitle;
    }

    /**
     * Get artist name
     */
    public String getArtistName() {
        return mArtistName;
    }

    /**
     * Get album image
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }


}
