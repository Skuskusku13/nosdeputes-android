package com.example.nosdeputes;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class ApiServices {

    private static final String URL_API_SEARCH = "https://www.nosdeputes.fr/recherche/";
    private static final String URL_END_FORMATJSON = "?format=json";
    private static final String URL_AVATAR = "https://www.nosdeputes.fr/depute/photo/";


    public static void searchRequest(Context context, String search, SearchObserver listener) {
        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest request = new StringRequest(URL_API_SEARCH + search + URL_END_FORMATJSON,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            JSONArray jsonArray = jsonObject.getJSONArray("results");
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject object = jsonArray.getJSONObject(i);
                                if (object.getString("document_type").equals("Parlementaire")) {
                                    getDeputyInfo(context, object.getString("document_url"), listener);
                                }
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

    public static void getDeputyInfo(Context context, String urlInfoDeputy, SearchObserver listener) {
        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest request = new StringRequest(urlInfoDeputy,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            JSONObject jsonObjectDeputy = jsonObject.getJSONObject("depute");
                            Deputy deputy = new Deputy(jsonObjectDeputy.getInt("id"),
                                    jsonObjectDeputy.getString("prenom"),
                                    jsonObjectDeputy.getString("nom_de_famille"),
                                    jsonObjectDeputy.getString("num_deptmt"),
                                    jsonObjectDeputy.getInt("num_circo"),
                                    jsonObjectDeputy.getString("nom_circo"),
                                    jsonObjectDeputy.getString("sexe")
                            );

                            JSONArray jsonArrayResp = jsonObjectDeputy.getJSONArray("responsabilites");
                            ArrayList<Responsability> responsabilities = new ArrayList<>();

                            for (int i = 0; i < jsonArrayResp.length(); i++) {
                                JSONObject obj = jsonArrayResp.getJSONObject(i);
                                JSONObject jsonObjectResp = obj.getJSONObject("responsabilite");

                                Responsability responsability = new Responsability(
                                        jsonObjectResp.getString("organisme"),
                                        jsonObjectResp.getString("fonction"),
                                        jsonObjectResp.getString("debut_fonction")
                                );

                                responsabilities.add(responsability);
                            }

                            deputy.setResponsabilities(responsabilities);

                            listener.onReceiveDeputyInfo(deputy);
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

    public static void loadDeputyAvatar(Context context, String deputyName, final ImageView imageView) {
        RequestQueue queue = Volley.newRequestQueue(context);
        ImageRequest request = new ImageRequest(URL_AVATAR + deputyName + "/160",
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap bitmap) {
                        imageView.setImageBitmap(bitmap);
                    }
                }, 0, 0, null,
                new Response.ErrorListener() {
                    public void onErrorResponse(VolleyError error) {
                        imageView.setImageResource(android.R.drawable.ic_menu_gallery);
                    }
                });
        queue.add(request);
    }
}
