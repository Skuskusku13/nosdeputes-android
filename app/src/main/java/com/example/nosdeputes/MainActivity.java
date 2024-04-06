package com.example.nosdeputes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener, SearchObserver, View.OnClickListener, AdapterView.OnItemClickListener {


    private SearchView searchView;
    private ArrayList<Deputy> deputies;
    private ArrayList<Vote> votes;
    private ListView listView;
    private DeputyAdapter deputyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.searchView = findViewById(R.id.searchViewItem);
        this.searchView.setOnQueryTextListener(this);

        listView = findViewById(R.id.listViewMain);
        deputies = new ArrayList<Deputy>();
        votes = new ArrayList<Vote>();
        deputyAdapter = new DeputyAdapter(deputies, this);
        listView.setAdapter(deputyAdapter);
        listView.setOnItemClickListener(this);

    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        this.deputies = new ArrayList<>();ApiServices.searchRequest(this, query, this);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        return false;
    }

    @Override
    public void onReceiveDeputyInfo(Deputy deputy) {
        if(!deputies.contains(deputy)) {
            deputies.add(deputy);
            deputyAdapter.setDeputies(deputies);
            deputyAdapter.notifyDataSetChanged();
        }
    }


    @Override
    public void onClick(View view) {

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(MainActivity.this, DeputyActivity.class);
        intent.putExtra("deputy", deputies.get(i));
        startActivity(intent);
    }
}