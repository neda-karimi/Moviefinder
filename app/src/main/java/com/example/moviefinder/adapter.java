package com.example.moviefinder;
import  android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import  androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
public class adapter extends RecyclerView.Adapter<adapter.VeiwHolder> {
    ArrayList<MovieClass> movieClasses;
    public adapter(ArrayList<MovieClass>movieClasses){
        this.movieClasses=movieClasses;
    }
    @NonNull
    @Override
    public adapter.VeiwHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return null;
    }
    @Override
    public void onBindViewHolder(@NonNull adapter.VeiwHolder holder, int position) {
    }
    @Override
    public int getItemCount() {
        return 0;
    }

    public class VeiwHolder extends RecyclerView.ViewHolder {
        public VeiwHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
