package com.example.nosdeputes;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class DeputyActivity extends AppCompatActivity implements SearchObserverVote {

    private ResponsabilityAdapter responsabilityAdapter;
    private VoteAdapter voteAdapter;
    private ArrayList<Responsability> responsabilities;
    private ArrayList<Vote> votes;
    private ListView listView;
    private ListView listViewVote;

    private TextView textViewName;
    private TextView sexe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deputy_activity);

        listView = findViewById(R.id.listViewDeputy);
        listViewVote = findViewById(R.id.listViewVote);

        responsabilities = new ArrayList<>();
        responsabilityAdapter = new ResponsabilityAdapter(responsabilities, this);

        textViewName = findViewById(R.id.textViewItemDeputyName);
        sexe = findViewById(R.id.sexe);

        votes = new ArrayList<>();
        voteAdapter = new VoteAdapter(votes,this);

        listView.setAdapter(responsabilityAdapter);
        listViewVote.setAdapter(voteAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Deputy deputy = (Deputy) getIntent().getSerializableExtra("deputy");

        ApiServicesVote.searchRequest(this, deputy.getFirstname() + "-" + deputy.getLastname(), this);


        ImageView imageView = findViewById(R.id.imageViewIteDeputy);
        ApiServices.loadDeputyAvatar(this, deputy.getNameForAvatar(), imageView);
        textViewName.setText(String.format("%s %s", deputy.getFirstname(), deputy.getLastname()));
        sexe.setText(String.format("%s", deputy.getSexe().equals("F") ? "Femme" : "Homme"));
        responsabilities.addAll(deputy.getResponsabilities());
        responsabilityAdapter.notifyDataSetChanged();


    }

    @Override
    public void onReceiveVoteInfo(ArrayList<Vote> vote) {
            voteAdapter.setVotes(vote);
            voteAdapter.notifyDataSetChanged();
    }
}
