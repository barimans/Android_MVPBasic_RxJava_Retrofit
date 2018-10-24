package com.example.brizz.mvpfilm.ui.main;

import com.example.brizz.mvpfilm.model.MovieResponse;

public interface MainViewInterface {

    void showToast(String s);
    void displayMovie(MovieResponse movieResponse);
    void displayError(String s);
}
