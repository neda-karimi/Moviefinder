package com.example.moviefinder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class MainActivity extends AppCompatActivity {
    GridLayoutManager gridLayoutManager;
    private final String Json_url = "https://api.themoviedb.org/3/movie/popular?api_key=8e831e1fadddbac0c856db2f9bd078aa&language=en-US&page=1";
    private ImageView posters;
    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    Context context;
    private static final String msg = "MainACtivity";
    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    String url1 = "https://image.tmdb.org/t/p/W500/";
    ArrayList<MovieClass> movieClasses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestQueue = Volley.newRequestQueue(this);
        gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        posters = findViewById(R.id.film_poster);
        progressBar = findViewById(R.id.progress1);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setHasFixedSize(true);
        getdata();
    }

    private void view() {
        adapter adapter = new adapter(MainActivity.this.movieClasses);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(gridLayoutManager);
    }

    private void getdata() {
//        RequestQueue queue = Volley.newRequestQueue(this);
        movieClasses = new ArrayList<>();
        final String url = "https://api.themoviedb.org/3/movie/popular?api_key=8e831e1fadddbac0c856db2f9bd078aa&language=en-US&page=1";
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                progressBar.setVisibility(View.GONE);
                if (response != null) {
                    Log.e(msg, "responsing:" + response);
                    try {
                        JSONArray jsonArray = response.getJSONArray(Integer.parseInt("results"));
                        for (int i = 0; i < jsonArray.length(); i++) {
                            try {
                                JSONObject infor = jsonArray.getJSONObject(i);
                                movieClasses.add(new MovieClass(url1 + infor.getString("poster_path"),  url1 + infor.getString("overview"),infor.getString("title")));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        view();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressBar.setVisibility(View.GONE);
                Log.e(msg, "onResponse: " + error);

            }
        });

    }
}



