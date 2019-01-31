package com.people.islam.movienerdies;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MovieDetailActivity extends AppCompatActivity {

    CollapsingToolbarLayout collapsingToolbarLayout;
    Toolbar toolbar;
    ImageView moviePoster;
    FloatingActionButton fab;
    TextView textOverview;
    TextView textVote;
    String movieCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        collapsingToolbarLayout = findViewById(R.id.toolbar_layout);
        moviePoster = findViewById(R.id.movie_poster);
        fab = findViewById(R.id.fab);
        textOverview = findViewById(R.id.text_overview);
        textVote = findViewById(R.id.text_vote);

        Intent intent = getIntent();

        final String movieTitle = intent.getStringExtra(MovieAdapter.KEY_TITLE);
        final String moviePosterUrl = intent.getStringExtra(MovieAdapter.KEY_POSTERURL);
        final double movieVote = intent.getDoubleExtra(MovieAdapter.KEY_VOTE, 0.0);
        final String movieOverview = intent.getStringExtra(MovieAdapter.KEY_OVERVIEW);
        final boolean movieAdult = intent.getBooleanExtra(MovieAdapter.KEY_ADULT, false);
        final String movieReleaseDate = intent.getStringExtra(MovieAdapter.KEY_RELEASEDATE);

        if (movieAdult) {
            movieCategory = "Adult";
        } else {
            movieCategory = "All Ages";
        }

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(movieTitle);

        Picasso.get()
                .load("https://image.tmdb.org/t/p/w600_and_h900_bestv2"
                        + moviePosterUrl)
                .into(moviePoster);
        textOverview.setText("Category: " + movieCategory + "\n\n" + movieOverview + "\n\n"
                + "Release Date: " + movieReleaseDate);
        textVote.setText(Double.toString(movieVote));

        AppBarLayout appBarLayout = findViewById(R.id.app_bar);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (verticalOffset == 0) {
                    collapsingToolbarLayout.setCollapsedTitleTextColor(getResources().
                            getColor(R.color.white));
                    toolbar.getNavigationIcon().setColorFilter(getResources()
                            .getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
                    fab.setVisibility(View.VISIBLE);
                    textVote.setVisibility(View.VISIBLE);
                } else {
//                    toolbar.setBackgroundColor(getResources().getColor(R.color.white));
                    collapsingToolbarLayout.setCollapsedTitleTextColor(getResources().
                            getColor(R.color.colorPrimary));
                    toolbar.getNavigationIcon().setColorFilter(getResources()
                            .getColor(R.color.colorPrimary), PorterDuff.Mode.SRC_ATOP);
                    fab.setVisibility(View.GONE);
                    textVote.setVisibility(View.GONE);
                }
            }
        });


        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
