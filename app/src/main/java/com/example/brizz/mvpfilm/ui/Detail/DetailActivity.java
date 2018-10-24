package com.example.brizz.mvpfilm.ui.Detail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.brizz.mvpfilm.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {

    @BindView(R.id.iv_poster_detail)
    ImageView ivPosterDetail;
    @BindView(R.id.tv_title_movie_detail)
    TextView tvTitleMovieDetail;
    @BindView(R.id.tv_overview_detail)
    TextView tvOverviewDetail;
    @BindView(R.id.tv_realease_date_detail)
    TextView tvRealeaseDateDetail;

    private String get_title, get_date, get_overview, get_poster;
    private static final String KEY_TITLE = "title";
    private static final String KEY_DATE = "date";
    private static final String KEY_OVERVIEW = "overview";
    private static final String KEY_POSTER = "poster";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        get_title    = getIntent().getStringExtra(KEY_TITLE);
        get_date     = getIntent().getStringExtra(KEY_DATE);
        get_overview = getIntent().getStringExtra(KEY_OVERVIEW);
        get_poster   = getIntent().getStringExtra(KEY_POSTER);

        tvTitleMovieDetail.setText(get_title);
        tvRealeaseDateDetail.setText(get_date);
        tvOverviewDetail.setText(get_overview);

        Picasso.get().load(get_poster).into(ivPosterDetail);
        Log.d("Detail Activity",get_poster);

    }
}
