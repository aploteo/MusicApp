/**
 * Created by luca on 02-03-2018.
 */

package com.example.android.musicapp;

public class Song
{
    private int mAlbumImageResourceId;
    private String mAlbumName;
    private String mArtist;
    private String mSongName;
    private int mDetails;
    private int mAudioResourceId;

    public Song(int albumImageResourceId, String albumName, String artist, String songName, int details, int audioResourceId)
    {
        this.mAlbumImageResourceId = albumImageResourceId;
        this.mAlbumName = albumName;
        this.mArtist = artist;
        this.mSongName = songName;
        this.mDetails = details;
        this.mAudioResourceId = audioResourceId;
    }

    public int getAlbumImageResourceId()
    {
        return mAlbumImageResourceId;
    }

    public String getAlbumName()
    {
        return mAlbumName;
    }

    public String getArtist()
    {
        return mArtist;
    }

    public String getSongName()
    {
        return mSongName;
    }

    public int getDetails()
    {
        return mDetails;
    }

    public int getAudioResourceId()
    {
        return mAudioResourceId;
    }
}
