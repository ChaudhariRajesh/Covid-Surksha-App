package com.example.home_screen;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import com.github.barteksc.pdfviewer.PDFView;

public class PDFViewer extends AppCompatActivity {

    PDFView v1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_pdf);


        v1=(PDFView)findViewById(R.id.pdfView1);

        v1.fromAsset("coronavirus_info.pdf").load();

    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        NavUtils.navigateUpFromSameTask(this);
        return super.onOptionsItemSelected(item);


    }
}
