package com.example.android.mytunes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create ArrayList of songs
        final ArrayList<Song> songs = new ArrayList<>();

        songs.add(new Song("All I Really Want", "Jagged Little Pill",
                "Alanis Morissette", R.drawable.all_i_really_want));
        songs.add(new Song("The Beauty of Gray", "Mental Jewelry",
                "Live", R.drawable.mental_jewelry));
        songs.add(new Song("Controversy", "Controversy",
                "Prince", R.drawable.controversy));
        songs.add(new Song("Drink Before the War", "The Lion and the Cobra",
                "Sinead O'Connor", R.drawable.the_lion_and_the_cobra));
        songs.add(new Song("East to West", "The Altar and the Door",
                "Casting Crowns", R.drawable.the_altar_and_the_door));
        songs.add(new Song("Far Away", "All the Right Reasons",
                "Nickelback", R.drawable.all_the_right_reasons));
        songs.add(new Song("Gravity", "Careful Confessions",
                "Sara Bareilles", R.drawable.careful_confessions));
        songs.add(new Song("How to Save A Life", "How to Save A Life",
                "The Fray", R.drawable.how_to_save_a_life));
        songs.add(new Song("I Melt", "Melt",
                "Rascal Flatts", R.drawable.melt));
        songs.add(new Song("Jar of Hearts", "Lovestrong",
                "Christina Perri", R.drawable.lovestrong));
        songs.add(new Song("Lego House", "+",
                "Ed Sheeran", R.drawable.plus));
        songs.add(new Song("My Heart Belongs to Me", "Streisand Superman",
                "Barbra Streisand", R.drawable.streisand_superman));
        songs.add(new Song("No More Drama", "No More Drama",
                "Mary J Blige", R.drawable.no_more_drama));
        songs.add(new Song("O Come, O Come Emmanuel", "Aaron Shust Christmas",
                "Aaron Shust", R.drawable.aaron_shust_christmas));
        songs.add(new Song("Piano Song", "Wild!",
                "Erasure", R.drawable.wild));

        // Create an {@link ArrayAdapter}, whose data source is a list of Songs. The
        // adapter knows how to create layouts for each item in the list, using the
        // song_list_item.xml layout.
        // This list item layout contains two {@link TextView} and one {@link ImageView},
        // which the adapter will set to display a song.
        SongAdapter adapter = new SongAdapter(this, songs);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // activity_main.xml file.
        ListView listView = findViewById(R.id.song_list);

        // Make the {@link ListView} use the {@link ArrayAdapter} created above, so that the
        // {@link ListView} will display list items for each song in the list of songs.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name adapter.
        listView.setAdapter(adapter);

        // Create a message handling object as an anonymous class.
        // Ref developer.android.com/guide/topics/ui/declaring-layout.html#HandlingUserSelections
        AdapterView.OnItemClickListener mMessageClickedHandler = new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView parent, View v, int position, long id) {

                // Get song info
                String songTitle = songs.get(position).getSongTitle();
                String albumTitle = songs.get(position).getAlbumTitle();
                String artistName = songs.get(position).getArtistName();
                int albumArt = songs.get(position).getImageResourceId();

                // Launch now playing intent
                Bundle nowPlayingBundle = new Bundle();
                nowPlayingBundle.putString("songTitle", songTitle);
                nowPlayingBundle.putString("albumTitle", albumTitle);
                nowPlayingBundle.putString("artistName", artistName);
                nowPlayingBundle.putInt("albumArt", albumArt);

                Intent nowPlayingIntent = new Intent(MainActivity.this, NowPlayingActivity.class);
                nowPlayingIntent.putExtras(nowPlayingBundle);
                startActivity(nowPlayingIntent);
            }
        };

        listView.setOnItemClickListener(mMessageClickedHandler);
    }
}
