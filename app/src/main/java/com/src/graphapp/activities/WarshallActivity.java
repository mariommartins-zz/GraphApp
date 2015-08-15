package com.src.graphapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.src.graphapp.R;
import com.src.graphapp.texts.TextsEN;

public class WarshallActivity extends AppCompatActivity implements View.OnClickListener {

    Button bDescription, bHelp;
    String title, description, complexity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warshall);

        Intent i1 = getIntent();
        title = i1.getStringExtra("title");
        description = i1.getStringExtra("description");
        complexity = i1.getStringExtra("complexity");

        bDescription = (Button)findViewById(R.id.bDescription);
        bHelp = (Button) findViewById(R.id.bHelp);

        bHelp.setOnClickListener(this);
        bDescription.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_warshall, menu);
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
                Intent i2 = new Intent(getApplicationContext(), DescriptionActivity.class);
                i2.putExtra("title",title);
                i2.putExtra("description",description);
                i2.putExtra("complexity",complexity);
                startActivity (i2);
                break;
            case R.id.bHelp:
                Toast.makeText(WarshallActivity.this, TextsEN.getHelpByPosition(4), Toast.LENGTH_LONG).show();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
