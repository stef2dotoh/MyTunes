package com.example.android.mytunes;

import android.app.Activity;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/*
* {@link SongAdapter} is an {@link ArrayAdapter} that can provide the layout for each list
* based on a data source, which is a list of {@link Song} objects.
* */

public class SongAdapter extends ArrayAdapter<Song> {

    public SongAdapter(Activity context, ArrayList<Song> songs) {
        super(context, 0, songs);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.song_list_item, parent, false);
        }

        // Get the {@link Song} object located at this position in the list
        Song currentSong = getItem(position);

        // Find the ImageView in the song_list_item.xml layout with the ID album_art_icon
        ImageView albumArtIcon = listItemView.findViewById(R.id.album_art_icon);
        // Get the album art image from the current Song object and
        // set this image on the album art icon ImageView
        albumArtIcon.setImageResource(currentSong.getImageResourceId());

        // Find the TextView in the song_list_item.xml layout with the ID song_text_view
        TextView songTextView = listItemView.findViewById(R.id.song_title_text_view);
        // Get the song title from the current Song object and
        // set this text on the song title TextView
        songTextView.setText(currentSong.getSongTitle());
        songTextView.setTextSize(16);
        songTextView.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);

        // Find the TextView in the song_list_item.xml layout with the ID artist_text_view
        TextView artistTextView = listItemView.findViewById(R.id.artist_name_text_view);
        // Get the artist name from the current Song object and
        // set this text on the artist name TextView
        artistTextView.setText(currentSong.getArtistName());

        // Return the whole list item layout (containing 2 TextViews and 1 ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
