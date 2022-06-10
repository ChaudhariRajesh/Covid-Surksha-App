package com.example.home_screen;

import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ExampleLooperThread extends Thread
{

    Handler handler=new Handler();

    int count=0;
    TextView et;
    int delay=0;

    int count10;



    ExampleLooperThread(TextView et, int c,int delay)
    {
        this.et=et;
        this.count=c;
        this.delay=delay;

        count10=count/25;

    }


    public void run()
    {
        for(int i=0;i<=count10;i++)
        {

            final int finalI = i;
            handler.post(new Runnable() {
                @Override
                public void run() {

                    et.setText(String.valueOf(finalI));
                }


            });

            SystemClock.sleep(delay);

        }

        handler.post(new Runnable() {
            @Override
            public void run() {

                et.setText(String.valueOf(count));
            }


        });

    }


}
