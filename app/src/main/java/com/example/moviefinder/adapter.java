package com.example.moviefinder;
import android.content.Context;
import android.view.LayoutInflater;
import  android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import  androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class adapter extends RecyclerView.Adapter<adapter.ViewHolder> {
    private ArrayList<MovieClass> movieClasses;
    private Context context;
    //DataTransferInterface dataTransferInterface;
    public adapter(Context context,ArrayList<MovieClass>movieClasses){
        this.context=context;
        this.movieClasses=movieClasses;
        //this.dataTransferInterface=dataTransfer;
    }


    @NonNull
    @Override
    public adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movies,parent,false);
      return new ViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull adapter.ViewHolder holder, int position) {
        Glide.with(context).load(movieClasses.get(position).getPoster_path()).into(holder.posters);
    }
    @Override
    public int getItemCount() {
        return movieClasses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView posters;
        //TextView tv_title ;
        //TextView tv_overview ;
        //TextView tv_release ;
        //ImageView img_backdrop;
        private LinearLayout viewContainer;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            viewContainer = itemView.findViewById(R.id.items);
            posters=itemView.findViewById(R.id.film_poster);

                ;
        };
    }
}


