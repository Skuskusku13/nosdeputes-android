package com.example.nosdeputes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class VoteAdapter extends BaseAdapter {


    private ArrayList<Vote> votes;
    private Context context;

    public VoteAdapter(ArrayList<Vote> votes, Context context) {
        this.votes = votes;
        this.context = context;
    }

    public void setVotes(ArrayList<Vote> votes) {
        this.votes = votes;
    }

    @Override
    public int getCount() {
        return this.votes.size();
    }

    @Override
    public Object getItem(int i) {
        return this.votes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.vote, parent, false);
        }

        TextView numero = convertView.findViewById(R.id.numero);
        TextView date = convertView.findViewById(R.id.date_vote);
        TextView titre = convertView.findViewById(R.id.titre);
        TextView type = convertView.findViewById(R.id.type);
        TextView sort = convertView.findViewById(R.id.sort);
        TextView nombres_votant = convertView.findViewById(R.id.nombres_votant);
        TextView nombre_pours = convertView.findViewById(R.id.nombres_pours);
        TextView nombre_contres = convertView.findViewById(R.id.nombres_contres);
        TextView nombre_abstentions = convertView.findViewById(R.id.nombres_abstentions);
        TextView parlementaire_groupe_acronyme = convertView.findViewById(R.id.parlementaire_groupe_acronyme);

        numero.setText(String.format("%d", votes.get(position).getNumero()));
        date.setText(votes.get(position).getDate());
        titre.setText(votes.get(position).getTitre());
        type.setText(votes.get(position).getType());
        sort.setText(votes.get(position).getSort());
        nombres_votant.setText(votes.get(position).getNombres_votant());
        nombre_pours.setText(votes.get(position).getNombre_pours());
        nombre_contres.setText(votes.get(position).getNombre_contres());
        nombre_abstentions.setText( votes.get(position).getNombre_abstentions());
        parlementaire_groupe_acronyme.setText(String.format(votes.get(position).getParlementaire_groupe_acronyme()));

        return convertView;
    }
}
