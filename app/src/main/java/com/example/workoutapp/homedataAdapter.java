package com.example.workoutapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class homedataAdapter extends RecyclerView.Adapter<homedataAdapter.ViewHolder> {

    homedata[] homedata1;
    Context context;

    public homedataAdapter(homedata[] homedata1, Main2Activity activity) {
        this.homedata1 = homedata1;
        this.context = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.homeactivity,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,final int position) {
        final homedata myexcerciseDataList = homedata1[position];
        holder.textViewName.setText(myexcerciseDataList.getexcerciseName());
        holder.excerciseImage.setImageResource(myexcerciseDataList.getexcerciseImage());

        holder.cardview.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent;
                switch (position) {
                    case 0:
                        intent = new Intent(context.getApplicationContext(), excersisefrag.class);
                        context.startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(context.getApplicationContext(), dietplanmainactivity.class);
                        context.startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(context.getApplicationContext(), video_webview.class);
                        context.startActivity(intent);
                        break;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return homedata1.length;
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView excerciseImage;
        TextView textViewName;
        CardView cardview;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            excerciseImage = itemView.findViewById(R.id.imageview);
            textViewName = itemView.findViewById(R.id.textName);
            cardview = itemView.findViewById(R.id.cardview);


        }
    }
    public int getItemViewType(int position) {
        // Just as an example, return 0 or 2 depending on position
        // Note that unlike in ListView adapters, types don't have to be contiguous
        return position % 2 * 2;
    }


}
