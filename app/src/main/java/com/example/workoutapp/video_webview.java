package com.example.workoutapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Vector;

public class video_webview extends AppCompatActivity {
     private RecyclerView recyclerView;
     View v;
     Vector<video_webview> youTubeVideos=new Vector<>();
     RecyclerView.LayoutManager mLayoutManager;

     public video_webview() {

     }


     @Nullable
     public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
          setContentView(R.layout.video_webview);
          recyclerView=(RecyclerView)v.findViewById(R.id.recyclerview);
          recyclerView.setHasFixedSize(true);
          mLayoutManager = new LinearLayoutManager(video_webview.this);
          recyclerView.setLayoutManager(mLayoutManager);
          VideoAdapter videoAdapter =new VideoAdapter(youTubeVideos);
          youTubeVideos.add(new video_webview("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/9tT8afUt7kM\" frameborder=\"0\" allowfullscreen></iframe"));
          youTubeVideos.add(new video_webview("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/n69-eVLtevc\" frameborder=\"0\" allowfullscreen></iframe"));
          youTubeVideos.add(new video_webview("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/TcSM1_R0v8E\" frameborder=\"0\" allowfullscreen></iframe"));
          youTubeVideos.add(new video_webview("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/IurNji_wHIA\" frameborder=\"0\" allowfullscreen></iframe"));
          youTubeVideos.add(new video_webview("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/RarcD0Q50nU\" frameborder=\"0\" allowfullscreen></iframe"));
          youTubeVideos.add(new video_webview("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/BEj_IB9kreE\" frameborder=\"0\" allowfullscreen></iframe"));
          youTubeVideos.add(new video_webview("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/7HuB5lHlhpA\" frameborder=\"0\" allowfullscreen></iframe"));
          youTubeVideos.add(new video_webview("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/VecbXgWY0DI\" frameborder=\"0\" allowfullscreen></iframe"));
          recyclerView.setAdapter(videoAdapter);
          return v;


     }
     public video_webview(String s){}


     public String getVideoUrl() {
          return null;
     }
}