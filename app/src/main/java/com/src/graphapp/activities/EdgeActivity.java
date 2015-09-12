package com.src.graphapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.src.graphapp.R;
import com.src.graphapp.texts.TextsEN;

public class EdgeActivity extends AppCompatActivity implements View.OnClickListener {

    Button bHelp, bInsert;
    EditText etWeight, etStart, etEnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edge);

        bHelp = (Button)findViewById(R.id.bHelp);
        bInsert = (Button)findViewById(R.id.bInsert);
        etWeight = (EditText)findViewById(R.id.etWeight);
        etStart = (EditText)findViewById(R.id.etStart);
        etEnd = (EditText)findViewById(R.id.etEnd);

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
        int weight;

        String start = etStart.getText().toString();
        String end = etEnd.getText().toString();

        switch (v.getId()){
            case R.id.bHelp:
                Toast.makeText(EdgeActivity.this, TextsEN.getHelpByPosition(3), Toast.LENGTH_LONG).show();
                break;
            case R.id.bInsert:
                if ((etWeight.getText().toString().equals(""))||(start.equals(""))||(end.equals(""))){
                    Toast.makeText(EdgeActivity.this, TextsEN.getHelpByPosition(3), Toast.LENGTH_LONG).show();
                }else if(etWeight.getText().toString().equals("0")) {
                    Toast.makeText(EdgeActivity.this, TextsEN.getErrorByPosition(7), Toast.LENGTH_LONG).show();
                }else {
                    weight = Integer.parseInt(etWeight.getText().toString());

                    Intent i = new Intent(getApplicationContext(), MenuActivity.class);
                    i.putExtra("previous", 2);
                    i.putExtra("weight", weight);
                    i.putExtra("start", start);
                    i.putExtra("end", end);
                    startActivity(i);
                    finish();
                }
                break;
        }
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, MenuActivity.class));
        finish();
    }
}
