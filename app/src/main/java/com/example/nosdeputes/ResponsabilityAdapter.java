package com.example.nosdeputes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ResponsabilityAdapter extends BaseAdapter {

    private ArrayList<Responsability> responsabilities;

    private Deputy deputy;
    private Context context;

    public ResponsabilityAdapter(ArrayList<Responsability> responsabilities, Context context) {
        this.responsabilities = responsabilities;
        this.context = context;
    }

    public void setResponsabilities(ArrayList<Responsability> responsabilities) {
        this.responsabilities = responsabilities;
    }

    @Override
    public int getCount() {
        return this.responsabilities.size();
    }

    @Override
    public Object getItem(int i) {
        return this.responsabilities.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_resp, parent, false);
        }

        TextView organisme = convertView.findViewById(R.id.organisme);
        organisme.setText(responsabilities.get(position).getOrganisme());

        TextView fonction = convertView.findViewById(R.id.fonction);
        fonction.setText(responsabilities.get(position).getFonction());

        TextView debutFonction = convertView.findViewById(R.id.debut_fonction);
        debutFonction.setText(responsabilities.get(position).getDebut_fonction());

        return convertView;
    }
}
