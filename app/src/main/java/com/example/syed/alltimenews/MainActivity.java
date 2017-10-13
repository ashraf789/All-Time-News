package com.example.syed.alltimenews;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String[] siteName={
            "http://prothom-alo.com", "http://bd-pratidin.com",
            "http://amardeshonline.com", "http://ukbdnews.com",
            "http://bdnews24.com", "http://kalerkantho.com",
            "http://ukbdnews.com", "http://bbc.co.uk/bengali",
            "http://anandabazar.com", "http://kolkata24x7.com",
            "http://bbc.co.uk", "http://nbcnews.com",
            "http://edition.cnn.com", "http://cbsnews.com",
            "http://nasa.gov", "http://espncricinfo.com",
            "http://dailynayadiganta.com", "http://dainikamadershomoy.com",
            "http://ittefaq.com.bd", "http://bd-pratidin.com",
            "http://bhorerkagoj.net", "http://jugantor.com",
            "http://shokalerkhobor24.com", "http://manobkantha.com"};
    private int[] siteIamge={
            R.drawable.prothomalo,R.drawable.bangladeshprotitdin,
            R.drawable.amardesh,R.drawable.ukbdnews,
            R.drawable.bdnews24,R.drawable.kalerkontho,
            R.drawable.ukbdnews,R.drawable.bbcbangla,
            R.drawable.anandobaj,R.drawable.kokata24,
            R.drawable.bbc,R.drawable.nbc,
            R.drawable.cnn,R.drawable.cbsnews,
            R.drawable.nasa,R.drawable.cricinfo,
            R.drawable.nayadigonto,R.drawable.amadersomoi,
            R.drawable.ittefaq,R.drawable.bangladeshprotitdin,
            R.drawable.vorerkagoj,R.drawable.jugantor,
            R.drawable.sokalerkhobor,R.drawable.manobkantho,};


    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = (GridView) findViewById(R.id.grid_item);

        final CustomAdapter adapter = new CustomAdapter(MainActivity.this,siteIamge,siteName);
        gridView.setAdapter(adapter);
    }

    public void onBackPressed() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                MainActivity.this);

        // set title
        alertDialogBuilder.setTitle("Exit");

        // set dialog message
        alertDialogBuilder
                .setMessage("Do you really want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        // if this button is clicked, close
                        // current activity
                        MainActivity.this.finish();
                    }
                })
                .setNegativeButton("No",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        // if this button is clicked, just close
                        // the dialog box and do nothing
                        dialog.cancel();
                    }
                });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();
    }
}
