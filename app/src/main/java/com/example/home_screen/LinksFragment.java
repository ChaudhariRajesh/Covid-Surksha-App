package com.example.home_screen;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.home_screen.R;


public class LinksFragment extends Fragment {

    ListView lv1;
    int[] IMAGES = {R.drawable.ic_open_in_new_black_24dp, R.drawable.ic_open_in_new_black_24dp, R.drawable.ic_open_in_new_black_24dp,
            R.drawable.ic_open_in_new_black_24dp, R.drawable.ic_open_in_new_black_24dp, R.drawable.ic_open_in_new_black_24dp};

    String[] NAMES = {"Ministry of Health and \nFamily Welfare", "World Health Organization (WHO)", "My Government",
            "Coronavirus Disease (Covid-19)", "Covid-19 Information and Resources", "Centers for Disease Control and Prevention","Coronavirus Research Center","LIVE Science","WANDA","NHS","Covid Visualizer"};

    String[] LINKS = {"https://www.mohfw.gov.in/", "https://www.who.int/emergencies/diseases/novel-coronavirus-201", "https://www.mygov.in/covid-19/",
            "https://www.coronavirus.gov/", "https://www.google.com/covid19/", "https://www.cdc.gov/","https://coronavirus.jhu.edu/","https://www.livescience.com/","https://www.wanda.be/en/a-z-index/coronavirus-2019-ncov/","https://www.nhs.uk/conditions/coronavirus-covid-19/","https://www.covidvisualizer.com/"};

    Context ct;
    public LinksFragment(Context c)
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
        View v= inflater.inflate(R.layout.fragment_links, container, false);

        lv1 = v.findViewById(R.id.listView1);

        MyCustomAdapter customAdapter = new MyCustomAdapter(ct,NAMES,LINKS,IMAGES);

        lv1.setAdapter(customAdapter);

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0)
                {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.mohfw.gov.in/")));
                }
                else if(position==1)
                {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.who.int/emergencies/diseases/novel-coronavirus-201")));
                }
                else if(position==2)
                {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.mygov.in/covid-19/")));
                }
                else if(position==3)
                {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.coronavirus.gov/")));
                }
                else if(position==4)
                {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/covid19/")));
                }
                else if(position==5)
                {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.cdc.gov/")));
                }
                else if(position==6)
                {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://coronavirus.jhu.edu/")));
                }
                else if(position==7)
                {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.livescience.com/")));
                }
                else if(position==8)
                {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.wanda.be/en/a-z-index/coronavirus-2019-ncov/")));
                }
                else if(position==9)
                {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.nhs.uk/conditions/coronavirus-covid-19/")));
                }
                else if(position==10)
                {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.covidvisualizer.com/")));
                }

            }
        });


        return v;
    }


    class MyCustomAdapter extends ArrayAdapter<String> {

        Context c;
        String NAMES[];
        String LINKS[];
        int IMAGES[];

        MyCustomAdapter(Context c,String NAMES[], String LINKS[], int IMAGES[])
        {
            super(c,R.layout.links_listview_layout,R.id.linkTextView1,NAMES);
            this.c=c;
            this.NAMES=NAMES;
            this.LINKS=LINKS;
            this.IMAGES=IMAGES;

        }


        @Override
        public int getCount() {
            return NAMES.length;
        }



        @Override
        public long getItemId(int position) {
            return 0;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            LayoutInflater inflater=(LayoutInflater)ct.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row=inflater.inflate(R.layout.links_listview_layout,parent,false);


            TextView tv1 = (TextView) row.findViewById(R.id.linkTextView1);
            TextView tv2 = (TextView) row.findViewById(R.id.linkTextView2);


            tv1.setText(NAMES[position]);
            tv2.setText(LINKS[position]);

            return (row);


        }

    }




}