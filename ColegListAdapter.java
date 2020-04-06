package com.exemple.android.schoolbox;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class ColegListAdapter extends ArrayAdapter<nume_list> {

    private Context mContext;
    int mResource;

    public ColegListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<nume_list> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        String nume = getItem(position).getNume();
        String eticheta = getItem(position).getEticheta();
        String email = getItem(position).getEmail();
        int number = getItem(position).getNumber();

        nume_list coleg = new nume_list(nume,eticheta,email,number);

        LayoutInflater inflanter = LayoutInflater.from(mContext);
        convertView= inflanter.inflate(mResource,parent, false);

        TextView tvNume = convertView.findViewById(R.id.NumeTextView);
        TextView tvEticheta =convertView.findViewById(R.id.EtichetaTextView);

        tvNume.setText(nume);
        tvEticheta.setText(eticheta);

        return  convertView;
    }
}
