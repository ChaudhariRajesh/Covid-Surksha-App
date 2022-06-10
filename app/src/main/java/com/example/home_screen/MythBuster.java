package com.example.home_screen;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

public class MythBuster extends AppCompatActivity {

    ListView lv1;

    int[] IMAGES = {R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four, R.drawable.five, R.drawable.six, R.drawable.seven,
            R.drawable.eight, R.drawable.nine, R.drawable.ten, R.drawable.eleven, R.drawable.twelve, R.drawable.thirteen, R.drawable.fourteen};

    String[] NAMES = {"Cold weather and snow CANNOT kill the CoronaVirus.", "The coronavirus CAN be transmitted in areas with hot and humid climates.",
            "The coronavirus CANNOT be transmitted through mosquito bites.", "There is NO evidence that companion animals/pets such as dogs or cats can transmit the coronavirus.",
            "Taking a hot bath DOES NOT prevent the coronavirus.", "Hand dryers are NOT effective in killing the coronavirus.",
            "Ultraviolet light SHOULD NOT be used for sterilization and can cause skin irritation.", "Thermal scanners CAN detect if people have a fever but CANNOT detect whether or not someone has the coronavirus.",
            "Spraying alcohol or chlorine all over your body WILL NOT kill viruses that have already entered your body.",
            "Vaccines against pneumonia, such as pneumococcal vaccine and Haemophilus influenzae type b (Hib) vaccine, DO NOT provide protection against the coronavirus.",
            "There is NO evidence that regularly rinsing the nose with saline has protected people from infection with the coronavirus.",
            "Garlic is healthy but there is NO evidence from the current outbreak that eating garlic has protected people from the coronavirus.",
            "Antibiotics DO NOT work against viruses, antibiotics only work against bacteria.",
            "To date, there is NO specific medicine recommended to prevent or treat the coronavirus."};



    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myth_buster);

        lv1 = findViewById(R.id.listView1);

        MyCustomAdapter customAdapter = new MyCustomAdapter(this,IMAGES,NAMES);

        lv1.setAdapter(customAdapter);




    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        NavUtils.navigateUpFromSameTask(this);
        return super.onOptionsItemSelected(item);

    }


    class MyCustomAdapter extends ArrayAdapter<String>
    {

        Context c;
        String NAMES[];
        int IMAGES[];

        MyCustomAdapter(Context c, int IMAGES[], String NAMES[])
        {
            super(c,R.layout.layout_listview,R.id.mythTextView1,NAMES);
            this.c=c;
            this.NAMES=NAMES;
            this.IMAGES=IMAGES;

        }


        @Override
        public int getCount() {
            return IMAGES.length;
        }



        @Override
        public long getItemId(int position) {
            return 0;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView,@NonNull ViewGroup parent) {

            LayoutInflater inflater=(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row=inflater.inflate(R.layout.layout_listview,parent,false);


            ImageView iv1 = (ImageView) row.findViewById(R.id.mythImageView1);
            TextView tv1 = (TextView) row.findViewById(R.id.mythTextView1);


            iv1.setImageResource(IMAGES[position]);
            tv1.setText(NAMES[position]);


            return (row);


        }

    }

}

