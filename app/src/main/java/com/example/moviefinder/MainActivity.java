package com.example.moviefinder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.lang.ref.ReferenceQueue;

public class MainActivity extends AppCompatActivity {
     private ImageView posters;
     private ProgressBar progressBar;
     private RecyclerView recyclerView;
     Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        posters = findViewById(R.id.film_poster);
        progressBar= findViewById(R.id.progress1);
        recyclerView= findViewById(R.id.recyclerview);
        getdata();
    }
    private void getdata(){
        RequestQueue queue= Volley.newRequestQueue(this);
        String url="https://api.themoviedb.org/3/movie/popular?api_key=8e831e1fadddbac0c856db2f9bd078aa&language=en-US&page=1";
        StringRequest stringRequest= new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressBar.setVisibility(View.GONE);
                try {
                    JSONObject jsonObject=new JSONObject(response.toString(""));
                }
            }
        })
    }
}
