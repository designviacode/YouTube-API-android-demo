package com.manpreetgulati.youtubedemo.youtubedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;

public class MainActivity extends AppCompatActivity {
    // Youtube Event-Listener
    private YouTubePlayer.OnInitializedListener mOnInitializedListener;
    // declare the view
    private YouTubePlayerSupportFragment fragment;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment = (YouTubePlayerSupportFragment) getSupportFragmentManager()
                .findFragmentById(R.id.youtube_player);
        button = findViewById(R.id.button_play);


        initPlayer();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment.initialize(BuildConfig.YOUTUBEDEMO_API_KEY, mOnInitializedListener);
            }
        });

        fragment.initialize(BuildConfig.YOUTUBEDEMO_API_KEY, mOnInitializedListener);
    }

    private void initPlayer() {
        mOnInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("DNp1ullIXP4");

                Toast.makeText(MainActivity.this, "Silicon Valley Theme song - rocks!!!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        };
    }

}
