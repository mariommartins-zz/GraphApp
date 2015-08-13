package com.src.graphapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class GraphActivity extends AppCompatActivity implements View.OnClickListener {

    Button bDescription, bHelp;

    String help = "Tap the DESCRIPTION button for details about the algorithm. Tap the Android's back button to return to the last view";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        bDescription = (Button)findViewById(R.id.bDescription);
        bHelp = (Button)findViewById(R.id.bHelp);

        bHelp.setOnClickListener(this);
        bDescription.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_graph, menu);
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
            case R.id.bDescription:
                startActivity (new Intent(this, DescriptionActivity.class));
                break;
            case R.id.bHelp:
                Toast.makeText(GraphActivity.this, help, Toast.LENGTH_LONG).show();
                break;
        }
    }
}
