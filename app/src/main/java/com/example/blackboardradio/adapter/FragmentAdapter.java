package com.example.blackboardradio.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.blackboardradio.R;
import com.example.blackboardradio.fragments.RecorderFragment;
import com.example.blackboardradio.fragments.SongListFragment;
import com.example.blackboardradio.utils.Constants;

public class FragmentAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public FragmentAdapter(@NonNull FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case Constants.RECORDER:
                return new RecorderFragment();
            case Constants.SONGLIST:
                 return new SongListFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }


    public CharSequence getTitle(int position){
        int title;
        switch (position){
            case Constants.RECORDER:
                title = R.string.RECORDER;
                break;
            default:
                title = R.string.SONG_LIST;
                break;
        }
        return mContext.getString(title);
    }
}
