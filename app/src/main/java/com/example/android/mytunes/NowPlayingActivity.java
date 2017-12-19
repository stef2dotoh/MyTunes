package com.example.android.mytunes;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * This class controls the Now Playing activity which displays the current song information
 */
public class NowPlayingActivity extends AppCompatActivity {

    /** Bundle object to hold data passed from MainActivity */
    public Bundle getBundle = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        // Gets song data passed from MainActivity
        getBundle = this.getIntent().getExtras();
        final String songTitle = getBundle.getString("songTitle");
        final String albumTitle = getBundle.getString("albumTitle");
        final String artistName = getBundle.getString("artistName");
        final int albumArt = getBundle.getInt("albumArt", 0);

        // Display information for song currently playing: album art, song title, artist name
        ImageView albumArtImageView = findViewById(R.id.album_art);
        albumArtImageView.setImageResource(albumArt);

        TextView songTextView = findViewById(R.id.song_title_text_view);
        songTextView.setText(songTitle);
        songTextView.setTextSize(16);
        songTextView.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);

        TextView artistTextView = findViewById(R.id.artist_name_text_view);
        artistTextView.setText(artistName);

        // Get ID for LinearLayout for onClickListener to launch artist detail intent
        LinearLayout nowPlayingLinearLayout = findViewById(R.id.now_playing);

        // Launch artist detail intent
        nowPlayingLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent artistDetailIntent = new Intent(NowPlayingActivity.this,
                        ArtistDetailActivity.class);
                artistDetailIntent.putExtras(getBundle);
                startActivity(artistDetailIntent);
            }
        });

        // Create onClickListener for play/pause button
        final ImageView btnPlayPause = findViewById(R.id.play_pause_button);
        btnPlayPause.setTag(R.drawable.btn_pause);

        btnPlayPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // If music is playing, pause it, display play button, and set tag for ImageView
                // to play button
                if ((int) btnPlayPause.getTag() == R.drawable.btn_pause) {
                    btnPlayPause.setImageResource(R.drawable.btn_play);
                    btnPlayPause.setTag(R.drawable.btn_play);
                } else
                    // If music is paused, play it, display pause button, and set tag for ImageView
                    // to pause button
                    if ((int) btnPlayPause.getTag() == R.drawable.btn_play) {
                        btnPlayPause.setImageResource(R.drawable.btn_pause);
                        btnPlayPause.setTag(R.drawable.btn_pause);
                }
            }
        });

        // Create onClickListener for button to return user to Library
        Button library = findViewById(R.id.library_button);

        library.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent libraryIntent = new Intent(NowPlayingActivity.this, MainActivity.class);
                    startActivity(libraryIntent);
                }
        });
    }
}