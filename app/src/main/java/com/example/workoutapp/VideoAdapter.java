package com.example.workoutapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Vector;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {

    List<video_webview> youTubeVideosList;
    Context context;
    public VideoAdapter(Vector<video_webview> youTubeVideos){}
    public VideoAdapter(List<video_webview>youTubeVideosList,Context context){
        this.youTubeVideosList=youTubeVideosList;
            this.context=context;
    }

    @NonNull
    @Override
    public VideoAdapter.VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.video_webview,parent,false);
        return new VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final VideoAdapter.VideoViewHolder holder, int position) {
        holder.videoWeb.loadData(youTubeVideosList.get(position).getVideoUrl(), "text/html", "utf-8");

    }



    @Override
    public int getItemCount() {
        return youTubeVideosList.size();}

    public class VideoViewHolder extends RecyclerView.ViewHolder{

        WebView videoWeb;
        private Context context;

        public VideoViewHolder(View itemView) {
            super(itemView);
            videoWeb = itemView.findViewById(R.id.videoWebView);
            videoWeb.getSettings().setJavaScriptEnabled(true);
            videoWeb.setWebChromeClient( new WebChromeClient(){

            });

        }

    }
}
