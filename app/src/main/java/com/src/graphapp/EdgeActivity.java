package com.src.graphapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class EdgeActivity extends AppCompatActivity implements View.OnClickListener {

    Button bHelp, bInsert;

    String help = "Put the Edge's Weight,Start and End in the given spaces and tap Insert to complete the operation. Tap the Android's back button to return to the last view";
    String insertionOK = "Edge insertion Completed! ";
    String insertionERROR = "Maximum number of Vertices reach (10). Edge not inserted! ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edge);

        bHelp = (Button)findViewById(R.id.bHelp);
        bInsert = (Button)findViewById(R.id.bInsert);

        bHelp.setOnClickListener(this);
        bInsert.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edge, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bHelp:
                Toast.makeText(EdgeActivity.this, help, Toast.LENGTH_LONG).show();
                break;
            case R.id.bInsert:
                Toast.makeText(EdgeActivity.this, insertionOK, Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(), MenuActivity.class));
                break;
        }
    }
}
