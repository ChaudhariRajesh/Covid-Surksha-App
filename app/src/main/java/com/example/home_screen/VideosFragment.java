package com.example.home_screen;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.home_screen.R;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.Vector;


public class VideosFragment extends Fragment {

    YouTubePlayerView ytpv1, ytpv2, ytpv3, ytpv4, ytpv5, ytpv6, ytpv7, ytpv8, ytpv9, ytpv10, ytpv11, ytpv12, ytpv13, ytpv14, ytpv15;

    Context ct;

    public VideosFragment(Context c)
    {
        this.ct=c;

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_videos, container, false);

        ytpv1 = v.findViewById(R.id.youtube_player_view1);
        getLifecycle().addObserver(ytpv1);

        ytpv2 = v.findViewById(R.id.youtube_player_view2);
        getLifecycle().addObserver(ytpv2);

        ytpv3 = v.findViewById(R.id.youtube_player_view3);
        getLifecycle().addObserver(ytpv3);

        ytpv4 = v.findViewById(R.id.youtube_player_view4);
        getLifecycle().addObserver(ytpv4);

        ytpv5 = v.findViewById(R.id.youtube_player_view5);
        getLifecycle().addObserver(ytpv5);

        ytpv6 = v.findViewById(R.id.youtube_player_view6);
        getLifecycle().addObserver(ytpv6);

        ytpv7 = v.findViewById(R.id.youtube_player_view7);
        getLifecycle().addObserver(ytpv7);

        ytpv8 = v.findViewById(R.id.youtube_player_view8);
        getLifecycle().addObserver(ytpv8);

        ytpv9 = v.findViewById(R.id.youtube_player_view9);
        getLifecycle().addObserver(ytpv9);

        ytpv10 = v.findViewById(R.id.youtube_player_view10);
        getLifecycle().addObserver(ytpv10);

        ytpv11 = v.findViewById(R.id.youtube_player_view11);
        getLifecycle().addObserver(ytpv11);

        ytpv12 = v.findViewById(R.id.youtube_player_view12);
        getLifecycle().addObserver(ytpv12);

        ytpv13 = v.findViewById(R.id.youtube_player_view13);
        getLifecycle().addObserver(ytpv13);

        ytpv14 = v.findViewById(R.id.youtube_player_view14);
        getLifecycle().addObserver(ytpv14);

        ytpv15 = v.findViewById(R.id.youtube_player_view15);
        getLifecycle().addObserver(ytpv15);



        return v;


    }



}