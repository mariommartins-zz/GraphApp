package com.src.graphapp;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class TopSortActivity extends Activity implements View.OnClickListener {

    ListView lvTopSort;
    Button bDescription, bHelp;

    String help = "Tap the DESCRIPTION button for details about the algorithm. Tap the Android's back button to return to the last view";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_sort);

        lvTopSort = (ListView) findViewById(R.id.lvTopSort);
        bHelp = (Button)findViewById(R.id.bHelp);

        bDescription = (Button)findViewById(R.id.bDescription);

        bDescription.setOnClickListener(this);

        String[] menu = {"1. a", "2. b", "3. c"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menu);
        lvTopSort.setAdapter(adapter);

        bHelp.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_top_sort, menu);
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
                Toast.makeText(TopSortActivity.this, help, Toast.LENGTH_LONG).show();
                break;
        }
    }
}
