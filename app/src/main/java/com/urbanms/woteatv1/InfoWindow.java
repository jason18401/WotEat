package com.urbanms.woteatv1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

public class InfoWindow implements GoogleMap.InfoWindowAdapter{

    private final View mView;
    private Context mContext;

    public InfoWindow(Context context) {
        mContext = context;
        mView = LayoutInflater.from(context).inflate(R.layout.info_window, null);
    }

    //setting text to the view
    private void windowText(Marker marker, View view){

        String title = marker.getTitle();
        TextView tvTitle = (TextView) view.findViewById(R.id.title);

        if(!title.equals("")){
            tvTitle.setText(title);
        }

        String snippet = marker.getSnippet();
        TextView textSnip = (TextView) view.findViewById(R.id.detail);

        if(!snippet.equals("")){    //if title is not null
            textSnip.setText(snippet);
        }
    }

    @Override
    public View getInfoWindow(Marker marker) {
        windowText(marker, mView);
        return mView;
    }

    @Override
    public View getInfoContents(Marker marker) {
        windowText(marker, mView);
        return mView;
    }
}
