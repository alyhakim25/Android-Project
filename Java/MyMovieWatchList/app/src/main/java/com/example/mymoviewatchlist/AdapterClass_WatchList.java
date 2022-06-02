package com.example.mymoviewatchlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterClass_WatchList extends RecyclerView.Adapter<AdapterClass_WatchList.myViewHolder>{
    ArrayList<HelperActivity1> list;
    ArrayList<HelperActivityAdapter> list2;
    public static RecyclerView movieList;
    private Context context;

    String[] movieListOngoing = {
            "Star Wars",
            "Indiana Jones",
            "Naruto",
            "Pirates of Carabian",
            "Dota2 Dragon Blood",
            "Avengers"
    };
    String[] movieListUpcoming = {
            "Pirates of Carabian",
            "Dota2 Dragon Blood",
            "Avengers",
            "Doctor Strange",
            "Black Panther"
    };
    String[] movieListDone = {
            "Doctor Strange",
            "Black Panther",
            "Pirates of Carabian",
            "Dota2 Dragon Blood",
            "Avengers",
    };
    String[] movieAction = {
            "Doctor Strange",
            "Black Panther",
            "Pirates of Carabian",
            "Dota2 Dragon Blood",
            "Avengers",
    };
    String[] movieUSRegion = {
            "Doctor Strange",
            "Black Panther",
            "Pirates of Carabian",
            "Dota2 Dragon Blood",
            "Avengers",
    };
    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_outer_layout, parent, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterClass_WatchList.myViewHolder holder, int position) {
        HelperActivity1 object = list.get(position);
        holder.txtList.setText(object.getList());
        movieList.setLayoutManager(new LinearLayoutManager(movieList.getContext()));
        list2 = new ArrayList<HelperActivityAdapter>();

        if(object.getList() == "On Going")
        {
            for(int i = 0; i < movieListOngoing.length; i++)
            {
                HelperActivityAdapter helperActivityMovieOngoing = new HelperActivityAdapter(movieListOngoing[i]);
                list2.add(helperActivityMovieOngoing);
            }
        }
        else if(object.getList() == "Up Coming")
        {
            for(int i = 0; i < movieListUpcoming.length; i++)
            {
                HelperActivityAdapter helperActivityMovieOngoing = new HelperActivityAdapter(movieListUpcoming[i]);
                list2.add(helperActivityMovieOngoing);
            }
        }
        else if(object.getList() == "Done")
        {
            for(int i = 0; i < movieListDone.length; i++)
            {
                HelperActivityAdapter helperActivityMovieOngoing = new HelperActivityAdapter(movieListDone[i]);
                list2.add(helperActivityMovieOngoing);
            }
        }
        else if(object.getList() == "Action")
        {
            for(int i = 0; i < movieAction.length; i++)
            {
                HelperActivityAdapter helperActivityMovieOngoing = new HelperActivityAdapter(movieAction[i]);
                list2.add(helperActivityMovieOngoing);
            }
        }
        else if(object.getList() == "US Region")
        {
            for(int i = 0; i < movieUSRegion.length; i++)
            {
                HelperActivityAdapter helperActivityMovieOngoing = new HelperActivityAdapter(movieUSRegion[i]);
                list2.add(helperActivityMovieOngoing);
            }
        }
        AdapterClass_Nested_Watchlist adapterClass_nested_watchlist = new AdapterClass_Nested_Watchlist(list2, context);
        movieList.setLayoutManager(new LinearLayoutManager(movieList.getContext(),RecyclerView.HORIZONTAL,false));
        movieList.setAdapter(adapterClass_nested_watchlist);

    }

    public AdapterClass_WatchList(ArrayList<HelperActivity1> list,  Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public class myViewHolder extends RecyclerView.ViewHolder{
        TextView txtList;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            txtList = (TextView) itemView.findViewById(R.id.txtList);
            movieList = (RecyclerView) itemView.findViewById(R.id.movieList);

        }
    }
}
