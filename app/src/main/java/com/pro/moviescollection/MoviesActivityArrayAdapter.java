package com.pro.moviescollection;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.Nullable;

public class MoviesActivityArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mMovies;
    private String[] mDates;
    private String[] nNames;

    public MoviesActivityArrayAdapter(Context mContext, int resource, String[] mMovies, String[] mDates, String[] nNames) {
        super(mContext, resource);
        this.mContext = mContext;
        this.mMovies = mMovies;
        this.mDates = mDates;
        this.nNames = nNames;
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        String movies = mMovies[position];
        String dates = mDates[position];
        String actors = nNames[position];
        return String.format("%s \n was release on: %s \n by: %s", movies, dates, actors);
    }

    @Override
    public int getCount() {
        return mMovies.length;
    }
}
