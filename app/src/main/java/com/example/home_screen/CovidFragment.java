package com.example.home_screen;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.home_screen.R;

import static android.content.Intent.getIntent;


public class CovidFragment extends Fragment implements View.OnClickListener {

    ImageView iv1;
    LinearLayout ll1,ll2,ll3,ll4,ll5;

    Context ct;

    public CovidFragment(Context c)
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
        View v=inflater.inflate(R.layout.fragment_covid, container, false);

        iv1=(ImageView)v.findViewById(R.id.pdfImageView1);

        ll1=(LinearLayout)v.findViewById(R.id.linearLayout1);
        ll2=(LinearLayout)v.findViewById(R.id.linearLayout2);
        ll3=(LinearLayout)v.findViewById(R.id.linearLayout3);
        ll4=(LinearLayout)v.findViewById(R.id.linearLayout4);
        ll5=(LinearLayout)v.findViewById(R.id.linearLayout5);

        iv1.setOnClickListener(this);

        ll1.setOnClickListener(this);
        ll2.setOnClickListener(this);
        ll3.setOnClickListener(this);
        ll4.setOnClickListener(this);
        ll5.setOnClickListener(this);

        return v;

    }


    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.pdfImageView1:
                Intent i = new Intent(ct, PDFViewer.class);
                startActivity(i);
                break;

            case R.id.linearLayout2:
                startActivity(new Intent(ct.getApplicationContext(), Prevention.class));
                break;

            case R.id.linearLayout3:
                startActivity(new Intent(ct.getApplicationContext(), Symptoms.class));
                break;

            case R.id.linearLayout4:
                startActivity(new Intent(ct.getApplicationContext(), MythBuster.class));
                break;

            case R.id.linearLayout5:
                startActivity(new Intent(ct.getApplicationContext(), OurHeroes.class));
                break;

        }


    }

}