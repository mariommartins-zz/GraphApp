package com.src.graphapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.src.graphapp.R;
import com.src.graphapp.texts.TextsEN;

public class DescriptionActivity extends AppCompatActivity implements View.OnClickListener {

    Button bHelp;
    TextView tvTitle, tvDescription, tvComplexity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        Intent i = getIntent();
        bHelp = (Button)findViewById(R.id.bHelp);
        tvTitle = (TextView)findViewById(R.id.tvTitle);
        tvDescription = (TextView)findViewById(R.id.tvDescription);
        tvComplexity = (TextView)findViewById(R.id.tvComplexity);

        tvComplexity.setText(i.getStringExtra("complexity"));
        tvDescription.setText(i.getStringExtra("description"));
        tvTitle.setText(i.getStringExtra("title"));
        bHelp.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_description, menu);
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
                Toast.makeText(DescriptionActivity.this, TextsEN.getHelpByPosition(5), Toast.LENGTH_LONG).show();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
