package com.example.android.musicapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MediaPlayer.OnCompletionListener
{
    MediaPlayer mMediaPlayer;
    int mCurrentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<Song> songs = new ArrayList<>();

        songs.add(new Song(R.drawable.greedy, "Razorblade Suitcase", "Bush", "Greedy", R.string.bush, R.raw.bush_greedy_fly));
        songs.add(new Song(R.drawable.anna, "Films about ghosts", "Counting Crows", "Anna begins", R.string.countingcrows, R.raw.counting_crows_anna_begins));
        songs.add(new Song(R.drawable.deftones, "White Pony", "Deftones", "Change", R.string.deftones, R.raw.deftones_change));
        songs.add(new Song(R.drawable.deftones, "White Pony", "Deftones", "Lhabia", R.string.deftones, R.raw.deftones_lhabia));
        songs.add(new Song(R.drawable.deftones, "White Pony", "Deftones", "The Chauffer", R.string.deftones, R.raw.deftones_the_chauffeur));
        songs.add(new Song(R.drawable.klingande, "Jubel", "Klingande", "Jubel", R.string.klingande, R.raw.klingande_jubel));
        songs.add(new Song(R.drawable.radio, "Pablo Honey", "Radiohead", "Creep", R.string.radioheads, R.raw.radiohead_creep));
        songs.add(new Song(R.drawable.radio, "Pablo Honey", "Radiohead", "High and Dry", R.string.radioheads, R.raw.radiohead_high_and_dry));
        songs.add(new Song(R.drawable.sp1979, "Aero Plane Files", "The Smashing Pumpkins", "1979", R.string.smashing, R.raw.the_smashing_pumpkins_1979));
        songs.add(new Song(R.drawable.line, "Simple Things", "Zero 7", "In the Waiting Line", R.string.zero7, R.raw.zero7_in_the_waiting_line));

        SongAdapter itemsAdapter = new SongAdapter(this, songs);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Song song = songs.get(position);
                Log.v("MainActivity", "posição: " + position);
                if (mMediaPlayer == null)
                {
                    try
                    {
                        mMediaPlayer = MediaPlayer.create(MainActivity.this, song.getAudioResourceId());
                        mMediaPlayer.start();
                        mCurrentPosition = position;
                    } catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                } else if (position != mCurrentPosition)
                {
                    mMediaPlayer.stop();
                    mMediaPlayer.release();
                    mMediaPlayer = MediaPlayer.create(MainActivity.this, song.getAudioResourceId());
                    mMediaPlayer.start();
                    mCurrentPosition = position;

                } else
                {
                    mMediaPlayer.stop();
                    mMediaPlayer.release();
                    mMediaPlayer = null;
                }
            }
        });
    }

    //OnCompletionListener Methods
    @Override
    public void onCompletion(MediaPlayer mp)
    {
        mMediaPlayer.release();
        mMediaPlayer = null;
    }
}