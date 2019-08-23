package com.shera.internexttv.view.live;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

//import com.masterwok.simplevlcplayer.VlcOptionsProvider;
//import com.masterwok.simplevlcplayer.activities.MediaPlayerActivity;
import com.shera.internexttv.R;

public class StreamActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stream);

        String url = "http://server.internext.tv:8080/get.php?username=zeba&password=zeba@2019&type=m3u_plus&output=ts";

//        VlcOptionsProvider
//                .getInstance()
//                .setOptions(
//                        new VlcOptionsProvider.Builder(this)
//                                .withSubtitleBackgroundOpacity(255)
//                                // See R.array.subtitles_encoding_values
//                                .withSubtitleEncoding("KOI8-R")
//                                .setVerbose(true)
//                                .build()
//                );
//
//        Intent intent = new Intent(this, MediaPlayerActivity.class);
//
//        intent.putExtra(MediaPlayerActivity.getMediaUri(), url);
//
//        startActivity(intent);
    }
}
