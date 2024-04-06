package com.example.nosdeputes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DeputyAdapter extends BaseAdapter {

    private ArrayList<Deputy> deputies;
    private Context context;

    public DeputyAdapter(ArrayList<Deputy> deputies, Context context) {
        this.deputies = deputies;
        this.context = context;
    }

    public void setDeputies(ArrayList<Deputy> deputies) {
        this.deputies = deputies;
    }

    @Override
    public int getCount() {
        return this.deputies.size();
    }

    @Override
    public Object getItem(int i) {
        return this.deputies.get(i);
    }

    @Override
    public long getItemId(int i) {
        return this.deputies.get(i).getId();
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_deputy, parent, false);
        }
        TextView textViewName = convertView.findViewById(R.id.textViewItemDeputyName);
        textViewName.setText(deputies.get(i).getLastname());
        TextView textViewCirco = convertView.findViewById(R.id.textViewItemDeputyCirco);

        textViewCirco.setText(
                deputies.get(i).getDepartment() + ", "
                        + deputies.get(i).getNameCirco() + " "
                        + deputies.get(i).getNumCirco()
                        + (deputies.get(i).getNumCirco() == 1 ? "er" : "eme")
                        + " circonscription");

        ImageView imageView = convertView.findViewById(R.id.imageViewIteDeputy);
        ApiServices.loadDeputyAvatar(context, deputies.get(i).getNameForAvatar(), imageView);

        return convertView;
    }
}
