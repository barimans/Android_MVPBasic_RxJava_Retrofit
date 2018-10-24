package com.example.brizz.mvpfilm.ui.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.brizz.mvpfilm.R;
import com.example.brizz.mvpfilm.adapter.MovieAdapter;
import com.example.brizz.mvpfilm.model.MovieResponse;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainViewInterface {

    @BindView(R.id.rv_movies)
    RecyclerView rvMovies;

    private String TAG = "MainActivity";
    MainPresenter mainPresenter;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setupMVP();
        setupViews();
        getMovieList();
    }

    private void setupMVP() {
        mainPresenter = new MainPresenter(this);
    }

    private void setupViews() {
        rvMovies.setLayoutManager(new GridLayoutManager(this,2));
    }

    private void getMovieList() {
        mainPresenter.getMovies();
    }

    @Override
    public void showToast(String s) {
        Toast.makeText(this,s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void displayMovie(MovieResponse movieResponse) {
        if (movieResponse!=null){
            Log.d(TAG,movieResponse.getResults().get(1).getPosterPath());
            adapter = new MovieAdapter(movieResponse.getResults(), MainActivity.this);
            rvMovies.setAdapter(adapter);
        }else {
            Log.d(TAG,"Movie Response Null");
        }
    }

    @Override
    public void displayError(String e) {
        showToast(e);
    }
}
