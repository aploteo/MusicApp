package com.example.android.musicapp;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by luca on 02-03-2018.
 */

public class SongAdapter extends ArrayAdapter<Song>
{
    public SongAdapter(Activity context, ArrayList<Song> songs)
    {
        super(context, 0, songs);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null)
        {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Song currentSong = getItem(position);

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image_view);
        imageView.setImageResource(currentSong.getAlbumImageResourceId());


        TextView songTextView = (TextView) listItemView.findViewById(R.id.song_text_view);
        songTextView.setText(currentSong.getSongName());

        TextView artistTextView = (TextView) listItemView.findViewById(R.id.artist_text_view);
        artistTextView.setText(currentSong.getArtist());

        return listItemView;
        //return super.getView(position, convertView, parent);
    }

}
