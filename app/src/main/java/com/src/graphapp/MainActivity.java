package com.src.graphapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.view.MenuItem;
import android.widget.Toast;

import com.src.graphapp.texts.TextsEN;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    Button bNext,bHelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bNext = (Button)findViewById(R.id.bNext);
        bHelp = (Button)findViewById(R.id.bHelp);

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
                startActivity (new Intent(this, MenuActivity.class));
                break;
            case R.id.bHelp:
                Toast.makeText(MainActivity.this, TextsEN.getHelpByPosition(0), Toast.LENGTH_LONG).show();
                break;
        }
    }
}
