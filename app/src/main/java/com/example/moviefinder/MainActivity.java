package com.example.moviefinder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
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
    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    private List<MovieClass> lstmovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lstmovie = new ArrayList<>();
        posters = findViewById(R.id.film_poster);
        progressBar = findViewById(R.id.progress1);
        recyclerView = findViewById(R.id.recyclerview);
        getdata();
    }

    private void getdata() {
        RequestQueue queue = Volley.newRequestQueue(this);
       String url = "https://api.themoviedb.org/3/movie/popular?api_key=8e831e1fadddbac0c856db2f9bd078aa&language=en-US&page=1";
        StringRequest stringRequest= new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressBar.setVisibility(View.GONE);

                try {

                    JSONObject jsonObject = new JSONObject(response);
                    //posters.setImageBitmap(jsonObject.getJSONArray("example"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressBar.setVisibility(View.GONE);
                Log.d("Error Response", error.toString());
//            }
//        }
//        );
//        queue.add(stringRequest);
            }
        });
    }
}



