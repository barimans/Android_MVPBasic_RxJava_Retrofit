package com.example.brizz.mvpfilm.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.brizz.mvpfilm.R;
import com.example.brizz.mvpfilm.model.Results;
import com.example.brizz.mvpfilm.ui.Detail.DetailActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MoviesHolder> {

    private List<Results> resultsList;
    private Context context;
    public static final String IMAGE_URL = "https://image.tmdb.org/t/p/w500";

    public MovieAdapter(List<Results> resultsList, Context context) {
        this.resultsList = resultsList;
        this.context = context;
    }

    @NonNull
    @Override
    public MoviesHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_movie, viewGroup, false);
        context = viewGroup.getContext();
        return new MoviesHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesHolder moviesHolder, int i) {

        final String title_data = resultsList.get(i).getTitle();
        final String date_data = resultsList.get(i).getReleaseDate();
        final String overview_data = resultsList.get(i).getOverview();
        final String poster_data = IMAGE_URL + resultsList.get(i).getPosterPath();
        final String backdrop_poster_data = IMAGE_URL + resultsList.get(i).getBackdropPath();

        moviesHolder.getResultMovies(poster_data, title_data, date_data, overview_data);

        moviesHolder.cvContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendDetail(backdrop_poster_data,title_data,date_data,overview_data);
            }
        });
    }

    @Override
    public int getItemCount() {
        return resultsList.size();
    }

    public class MoviesHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_poster)
        ImageView ivPoster;
        @BindView(R.id.tv_title_movie)
        TextView tvTitleMovie;
        @BindView(R.id.tv_realease_date)
        TextView tvRealeaseDate;
        @BindView(R.id.tv_overview)
        TextView tvOverview;
        @BindView(R.id.cv_container)
        CardView cvContainer;

        public MoviesHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void getResultMovies(String poster, String title, String date, String overview) {
            tvTitleMovie.setText(title);
            tvRealeaseDate.setText(date);
            tvOverview.setText(overview);

            Picasso.get().load(poster).placeholder(R.drawable.mading_image).into(ivPoster);
        }
    }
    public void sendDetail(String poster, String title, String date, String overview){
        Intent send_data = new Intent(context,DetailActivity.class);
        send_data.putExtra("poster", poster);
        send_data.putExtra("title", title);
        send_data.putExtra("date", date);
        send_data.putExtra("overview", overview);
        context.startActivity(send_data);
    }
}
