package com.urbanms.woteatv1;

import android.content.Context;
import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.location.places.PlaceBuffer;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<String> rNames = new ArrayList<>();
    private ArrayList<String> rImageUrls = new ArrayList<>();
    private ArrayList<Double> rRatings = new ArrayList<>();
    private ArrayList<Integer> rPriceLevel = new ArrayList<>();

    private Context mContext;

    public RecyclerViewAdapter(ArrayList<String> image, ArrayList<String> name, ArrayList<Integer> priceLevel, Context context) {//, ArrayList<Double> rating
        this.rImageUrls = image;
        this.rNames = name;
        //this.rRatings = rating;
        this.rPriceLevel = priceLevel;
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
        //return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Glide.with(mContext).asBitmap().load(rImageUrls.get(position)).into(holder.image);
        holder.name.setText(rNames.get(position));
        //holder.rating.setText(rRatings.get(position));
        holder.priceLevel.setText(String.valueOf(rPriceLevel.get(position)));

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on an image: " + rNames.get(position));
                Toast.makeText(mContext, rNames.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return rNames.size(); //we can use rImageUrls/rRatings as well because they are all the same size
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView name;
        TextView rating;
        TextView priceLevel;
        TextView address;
        RelativeLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image);
            name = (TextView) itemView.findViewById(R.id.title);
            //rating = itemView.findViewById(R.id.rating);
            priceLevel = (TextView) itemView.findViewById(R.id.priceLevel);

            parentLayout = itemView.findViewById(R.id.parentLayout);
        }
    }
}
