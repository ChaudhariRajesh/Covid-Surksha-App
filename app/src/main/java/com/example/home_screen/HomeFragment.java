package com.example.home_screen;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.home_screen.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class HomeFragment extends Fragment implements View.OnClickListener{

    TextView tv1,tv2,tv3;
    TextView et1,et2,et3;
    ImageButton ib1,ib2,ib3;

    int active2=0;
    int recovered2=0;
    int deaths2=0;

    ExampleLooperThread exampleLooperThread;

    Context ct;

    public HomeFragment(Context c)
    {
        this.ct=c;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_home, container, false);

        tv1=(TextView) v.findViewById(R.id.textView1);
        tv2=(TextView) v.findViewById(R.id.textView2);
        tv3=(TextView) v.findViewById(R.id.textView3);

        et1=(TextView) v.findViewById(R.id.activeTextView1);
        et2=(TextView) v.findViewById(R.id.curedTextView2);
        et3=(TextView) v.findViewById(R.id.deathTextView3);

        ib1=(ImageButton) v.findViewById(R.id.suggestionImageButton);
        ib2=(ImageButton) v.findViewById(R.id.solutionImageButton);
        ib3=(ImageButton) v.findViewById(R.id.donateImageButton);

        getDataFromServer();


        ib1.setOnClickListener(this);
        ib2.setOnClickListener(this);
        ib3.setOnClickListener(this);

        return v;

    }


    @Override
    public void onClick(View v)
    {

        switch (v.getId())
        {
            case R.id.suggestionImageButton:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.mygov.in/group-issue/share-your-ideas-suggestions-help-fight-coronavirus/?utm_source=webcampaign&group_issue&285571")));
                break;

            case R.id.solutionImageButton:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://innovate.mygov.in/covid19/")));
                break;

            case R.id.donateImageButton:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://self4society.mygov.in/")));
                break;

        }


    }

    private void getDataFromServer()
    {

        String url="https://corona.lmao.ninja/v2/countries";


        StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


                int active=0;
                int recovered=0;
                int dt=0;


                if (response != null) {
                    Log.e("Info", "onResponse: " + response);

                    try {

                        String active_cases = "";
                        String discharged = "";
                        String deaths = "";

                        JSONArray jsonArray = new JSONArray(response);

                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject data = jsonArray.getJSONObject(i);

                            if ("India".equals(data.getString("country"))) {
                                active_cases = data.getString("cases");
                                discharged = data.getString("recovered");
                                deaths = data.getString("deaths");

                                //Toast.makeText(ct, active_cases, Toast.LENGTH_SHORT).show();
                                //Toast.makeText(ct, discharged, Toast.LENGTH_SHORT).show();
                                //Toast.makeText(ct, deaths, Toast.LENGTH_SHORT).show();

                            }

                        }

                        //et1.setText(active_cases);
                        //et2.setText(discharged);
                        //et3.setText(deaths);

                        active=Integer.parseInt(active_cases);
                        recovered=Integer.parseInt(discharged);
                        dt=Integer.parseInt(deaths);


                        active2=active;
                        recovered2=recovered;
                        deaths2=dt;

                        exampleLooperThread = new ExampleLooperThread(et1,active,1);
                        exampleLooperThread.start();
                        exampleLooperThread = new ExampleLooperThread(et2,recovered,4);
                        exampleLooperThread.start();
                        exampleLooperThread = new ExampleLooperThread(et3,dt,30);
                        exampleLooperThread.start();


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

            }
        },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Log.e("Info", "onErrorResponse: " + error);

                    }


                });

        Volley.newRequestQueue(ct.getApplicationContext()).add(stringRequest);


    }




}