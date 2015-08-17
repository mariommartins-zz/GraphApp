package com.src.graphapp.activities;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.Toast;

import com.src.graphapp.R;
import com.src.graphapp.texts.TextsEN;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    RadioButton rbDirected, rbRandom;
    Button bNext,bHelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bNext = (Button)findViewById(R.id.bNext);
        bHelp = (Button)findViewById(R.id.bHelp);
        rbDirected = (RadioButton)findViewById(R.id.rbDirected);
        rbRandom = (RadioButton)findViewById(R.id.rbRandom);

        bHelp.setOnClickListener(this);
        bNext.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
            case R.id.bNext:
                Intent i = new Intent(getApplicationContext(),MenuActivity.class);
                i.putExtra("previous",0);
                i.putExtra("directed",rbDirected.isChecked());
                i.putExtra("random", rbRandom.isChecked());
                startActivity(i);
                finish();
                break;
            case R.id.bHelp:
                Toast.makeText(MainActivity.this, TextsEN.getHelpByPosition(0), Toast.LENGTH_LONG).show();
                break;
        }
    }
}
