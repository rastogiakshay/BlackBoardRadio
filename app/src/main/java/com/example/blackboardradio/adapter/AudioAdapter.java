package com.example.blackboardradio.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.helper.widget.Layer;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blackboardradio.R;

import java.io.File;

public class AudioAdapter extends RecyclerView.Adapter<AudioAdapter.ViewHolder>{

    private File[] audioFiles;
    private onItemListClick onItemListClick;


    public AudioAdapter(File[] audioFiles, onItemListClick onItemListClick) {
        this.audioFiles = audioFiles;
        this.onItemListClick = onItemListClick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tile_view,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(audioFiles[position].getName());
       // holder.date.setText(audioFiles[position].lastModified() + " ");
    }

    @Override
    public int getItemCount() {
        return audioFiles.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView title;
        private TextView date;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

        title = itemView.findViewById(R.id.tile_title);

        itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            onItemListClick.onClickListener(audioFiles[getAdapterPosition()],getAdapterPosition());
        }
    }

    public interface onItemListClick {
        void onClickListener(File file, int position);
}
}
