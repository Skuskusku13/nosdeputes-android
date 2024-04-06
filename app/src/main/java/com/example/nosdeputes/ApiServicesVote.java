package com.example.nosdeputes;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;

public class ApiServicesVote {

    private static final String URL_API_SEARCH = "https://2017-2022.nosdeputes.fr/";
    private static final String URL_END_FORMATJSON = "/votes/json";

    public static void searchRequest(Context context, String search, SearchObserverVote listener) {
        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest request = new StringRequest(URL_API_SEARCH + search + URL_END_FORMATJSON,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            JSONArray jsonArray = jsonObject.getJSONArray("votes");
                            ArrayList<Vote> votes = new ArrayList<>();

                            System.out.println(jsonArray);

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject object = jsonArray.getJSONObject(i).getJSONObject("vote");
                                Vote vote = new Vote(
                                        object.getJSONObject("scrutin").getInt("numero"),
                                        object.getJSONObject("scrutin").getString("date"),
                                        object.getJSONObject("scrutin").getString("titre"),
                                        object.getJSONObject("scrutin").getString("type"),
                                        object.getJSONObject("scrutin").getString("sort"),
                                        object.getJSONObject("scrutin").getString("nombre_votants"),
                                        object.getJSONObject("scrutin").getString("nombre_pours"),
                                        object.getJSONObject("scrutin").getString("nombre_contres"),
                                        object.getJSONObject("scrutin").getString("nombre_abstentions"),
                                        object.getString("parlementaire_groupe_acronyme")
                                );
                                votes.add(vote);

                                Collections.reverse(votes);
                                listener.onReceiveVoteInfo(votes);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        queue.add(request);

    }
}
