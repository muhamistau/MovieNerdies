package com.people.islam.movienerdies;

import android.content.Context;
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
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final MovieModel movieModel = movieModelList.get(position);
        holder.textTitle.setText(movieModel.getTitle());
        Picasso.get()
                .load("https://image.tmdb.org/t/p/w600_and_h900_bestv2"
                        + movieModel.getPosterUrl())
                .into(holder.moviePoster);
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
