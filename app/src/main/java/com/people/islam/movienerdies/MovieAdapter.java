package com.people.islam.movienerdies;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    public static String KEY_TITLE = "title";
    public static String KEY_POSTERURL = "posterurl";
    public static String KEY_VOTE = "vote";
    public static String KEY_OVERVIEW = "overview";
    public static String KEY_ADULT = "adult";
    public static String KEY_RELEASEDATE = "releasedate";

    private List<MovieModel> movieModelList;
    private Context context;

    public MovieAdapter(List<MovieModel> movieModelList) {
        this.movieModelList = movieModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final MovieModel movieModel = movieModelList.get(position);
        holder.textTitle.setText(movieModel.getTitle());
        Picasso.get()
                .load("https://image.tmdb.org/t/p/w600_and_h900_bestv2"
                        + movieModel.getPosterUrl())
                .into(holder.moviePoster);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MovieModel movies = movieModelList.get(position);
                Intent intent = new Intent(v.getContext(), MovieDetailActivity.class);
                intent.putExtra(KEY_TITLE, movies.getTitle());
                intent.putExtra(KEY_POSTERURL, movies.getPosterUrl());
                intent.putExtra(KEY_VOTE, movies.getVote());
                intent.putExtra(KEY_OVERVIEW, movies.getOverview());
                intent.putExtra(KEY_ADULT, movies.isAdult());
                intent.putExtra(KEY_RELEASEDATE, movies.getReleaseDate());
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return movieModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView moviePoster;
        public TextView textTitle;

        public LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            moviePoster = itemView.findViewById(R.id.movie_image);
            textTitle = itemView.findViewById(R.id.movie_name);
            linearLayout = itemView.findViewById(R.id.linear_layout);
        }
    }
}
