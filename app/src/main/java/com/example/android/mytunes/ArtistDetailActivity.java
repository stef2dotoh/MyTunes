package com.example.android.mytunes;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ArtistDetailActivity extends AppCompatActivity implements View.OnClickListener {

    /** Bundle object to hold data passed from NowPlayingActivity */
    public Bundle getBundle = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Set screen orientation to portrait
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist_detail);

        // Create ArrayList of artists with matching bios retrieved from strings.xml
        ArrayList<Artist> artists = new ArrayList<>();

        artists.add(new Artist("Alanis Morissette", this.getString(R.string.alanis_morissette_bio)));
        artists.add(new Artist("Live", this.getString(R.string.live_bio)));
        artists.add(new Artist("Prince", this.getString(R.string.prince_bio)));
        artists.add(new Artist("Sinead O'Connor", this.getString(R.string.sinead_oconnor_bio)));
        artists.add(new Artist("Casting Crowns", this.getString(R.string.casting_crowns_bio)));
        artists.add(new Artist("Nickelback", this.getString(R.string.nickelback_bio)));
        artists.add(new Artist("Sara Bareilles", this.getString(R.string.sara_bareilles_bio)));
        artists.add(new Artist("The Fray", this.getString(R.string.the_fray_bio)));
        artists.add(new Artist("Rascal Flatts", this.getString(R.string.rascal_flatts_bio)));
        artists.add(new Artist("Christina Perri", this.getString(R.string.christina_perri_bio)));
        artists.add(new Artist("Ed Sheeran", this.getString(R.string.ed_sheeran_bio)));
        artists.add(new Artist("Barbra Streisand", this.getString(R.string.barbra_streisand_bio)));
        artists.add(new Artist("Mary J Blige", this.getString(R.string.mary_j_blige_bio)));
        artists.add(new Artist("Aaron Shust", this.getString(R.string.aaron_shust_bio)));
        artists.add(new Artist("Erasure", this.getString(R.string.erasure_bio)));

        // Gets song data passed from NowPlayingActivity
        getBundle = this.getIntent().getExtras();
        final String songTitle = getBundle.getString("songTitle");
        final String albumTitle = getBundle.getString("albumTitle");
        final String artistName = getBundle.getString("artistName");
        final int albumArt = getBundle.getInt("albumArt", 0);

        // Display information for song currently playing
        //Display song title
        TextView songTextView = findViewById(R.id.song_title_text_view);
        songTextView.setText(songTitle);
        songTextView.setTextSize(16);
        songTextView.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);

        // Display artist name
        TextView artistTextView = findViewById(R.id.artist_name_text_view);
        artistTextView.setText(artistName);

        // Update Action Bar with artist name
        getSupportActionBar().setTitle("About " + artistName);

        // Display album title
        TextView albumTextView = findViewById(R.id.album_title_text_view);
        albumTextView.setText(albumTitle);
        albumTextView.setTypeface(Typeface.SANS_SERIF, Typeface.ITALIC);

        // Display album art
        ImageView albumArtImageView = findViewById(R.id.album_art_icon);
        albumArtImageView.setImageResource(albumArt);

        // Get view for artistBioTextView
        TextView artistBioTextView = findViewById(R.id.artist_bio_text_view);

        for (int i = 0; i < artists.size(); i++) {
            // Convert artist ID to string name
            String name = artists.get(i).getArtistName();

            // Get bio matching artist name
            String bio = artists.get(i).getArtistBio();

            // Display artist bio in artistBioTextView
            if (name.equalsIgnoreCase(artistName)) {
                // Display bio
                artistBioTextView.setText(bio);
                break;
            }
        }

        // Create onClickListener for buttons to return user to Now Playing and Library activities
        Button nowPlaying = findViewById(R.id.now_playing_button);
        nowPlaying.setOnClickListener(this);

        Button library = findViewById(R.id.library_button);
        library.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.now_playing_button:
                // Close current activity and return to previous Now Playing activity
                finish();
                break;
            case R.id.library_button:
                Intent libraryIntent = new Intent(ArtistDetailActivity.this, MainActivity.class);
                startActivity(libraryIntent);
                break;
        }

    }
}
