package com.example.home_screen;


import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class ContactFragment extends Fragment implements View.OnClickListener {



    CardView cv1, cv2, cv3, cv4, cv5, cv6;
    Context ct;

    public ContactFragment(Context c)
    {
        this.ct=c;
    }




    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_contact, container, false);

        cv1 = (CardView) v.findViewById(R.id.cardView1);
        cv2 = (CardView) v.findViewById(R.id.cardView2);
        cv3 = (CardView) v.findViewById(R.id.cardView3);
        cv4 = (CardView) v.findViewById(R.id.cardView4);
        cv5 = (CardView) v.findViewById(R.id.cardView5);
        cv6 = (CardView) v.findViewById(R.id.cardView6);

        cv1.setOnClickListener(this);
        cv2.setOnClickListener(this);
        cv3.setOnClickListener(this);
        cv4.setOnClickListener(this);
        cv5.setOnClickListener(this);
        cv6.setOnClickListener(this);


        return (v);
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    public void onClick(View v)
    {

        Intent i = new Intent(Intent.ACTION_CALL);

        switch (v.getId()) {
            case R.id.cardView1:
                i.setData(Uri.parse("tel:" + "1123978046"));
                break;

            case R.id.cardView2:
                i.setData(Uri.parse("tel:" + "0111078"));
                break;

            case R.id.cardView3:
                i.setData(Uri.parse("tel:" + "02026127394"));
                break;

            case R.id.cardView4:
                i.setData(Uri.parse("tel:" + "41227912111"));
                break;

            case R.id.cardView5:
                i.setData(Uri.parse("tel:" + "02586220022"));
                break;

            case R.id.cardView6:
                i.setData(Uri.parse("tel:" + "02586220333"));
                break;

        }

        if (i.resolveActivity(ct.getPackageManager()) != null)
        {
            if (ActivityCompat.checkSelfPermission(ct,
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
            {
                return;
            }

            startActivity(i);
        }

    }

}