package com.example.mymoviewatchlist;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterClass_Nested_Watchlist extends RecyclerView.Adapter<AdapterClass_Nested_Watchlist.myViewHolder>{
    ArrayList<HelperActivityAdapter> list1;

    private Context context;
    int[] pictMovie = {R.drawable.avenger, //1
            R.drawable.blackpanther,        //2
            R.drawable.doctorstrange,       //3
            R.drawable.dota2,               //4
            R.drawable.indianajones,        //5
            R.drawable.naruto,              //6
            R.drawable.piratesofcarabean,   //7
            R.drawable.starwars             //8
    };
    @NonNull
    @Override
    public AdapterClass_Nested_Watchlist.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_inner_layout, parent, false);

        return new AdapterClass_Nested_Watchlist.myViewHolder(view);
    }

    public Dialog onCreateDialog(String message) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // START THE GAME!
                    }
                })
                .setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }
    @Override
    public void onBindViewHolder(@NonNull AdapterClass_Nested_Watchlist.myViewHolder holder, int position) {
        HelperActivityAdapter object = list1.get(position);

        holder.txtTitle.setText(object.getMovie());
        if(object.getMovie() == "Star Wars") holder.imgMovie.setImageResource(pictMovie[7]);
        else if(object.getMovie() == "Indiana Jones") holder.imgMovie.setImageResource(pictMovie[4]);
        else if(object.getMovie() == "Naruto") holder.imgMovie.setImageResource(pictMovie[5]);
        else if(object.getMovie() == "Pirates of Carabian") holder.imgMovie.setImageResource(pictMovie[6]);
        else if(object.getMovie() == "Dota2 Dragon Blood") holder.imgMovie.setImageResource(pictMovie[3]);
        else if(object.getMovie() == "Avengers") holder.imgMovie.setImageResource(pictMovie[0]);
        else if(object.getMovie() == "Doctor Strange") holder.imgMovie.setImageResource(pictMovie[2]);
        else if(object.getMovie() == "Black Panther") holder.imgMovie.setImageResource(pictMovie[1]);

        holder.cardMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Movie Name");
                builder.setMessage(object.getMovie())
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // START THE GAME!
                            }
                        })
                        .setNegativeButton("Close", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User cancelled the dialog
                            }
                        });
                // membuat alert dialog dari builder
                AlertDialog alertDialog = builder.create();

                // menampilkan alert dialog
                alertDialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list1.size();
    }

    public AdapterClass_Nested_Watchlist(ArrayList<HelperActivityAdapter> list1, Context context) {
        this.list1 = list1;
        this.context = context;
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitle;
        ImageView imgMovie;
        LinearLayout cardMovie;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.titleMovie);
            imgMovie = itemView.findViewById(R.id.imgMovie);
            cardMovie = itemView.findViewById(R.id.cardMovie);
        }
    }
}
