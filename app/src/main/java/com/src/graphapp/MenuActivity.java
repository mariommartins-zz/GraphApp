package com.src.graphapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.src.graphapp.structures.Graph;
import com.src.graphapp.texts.TextsEN;

public class MenuActivity extends Activity implements View.OnClickListener {

    ListView lvMenu;
    Button bHelp;
    Graph graph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        lvMenu = (ListView) findViewById(R.id.lvMenu);
        bHelp = (Button)findViewById(R.id.bHelp);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, TextsEN.getMenu());

        lvMenu.setAdapter(adapter);

        lvMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                switch (position){
                    case 0:
                        startActivity(new Intent(getApplicationContext(), VertexActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(getApplicationContext(),EdgeActivity.class));
                        break;
                    case 2:
                        Intent i2 = new Intent(getApplicationContext(), GraphActivity.class);
                        i2.putExtra("title", TextsEN.getMenuByPosition(2));
                        i2.putExtra("description","hide");
                        i2.putExtra("complexity",TextsEN.getComplexityByPosition(0));
                        startActivity(i2);
                        break;
                    case 3:
                        Intent i3 = new Intent(getApplicationContext(), GraphActivity.class);
                        i3.putExtra("title", TextsEN.getMenuByPosition(3));
                        i3.putExtra("description",TextsEN.getDescriptionByPosition(0));
                        i3.putExtra("complexity",TextsEN.getComplexityByPosition(0));
                        startActivity(i3);
                        break;
                    case 4:
                        Intent i4 = new Intent(getApplicationContext(), GraphActivity.class);
                        i4.putExtra("title", TextsEN.getMenuByPosition(4));
                        i4.putExtra("description",TextsEN.getDescriptionByPosition(1));
                        i4.putExtra("complexity", TextsEN.getComplexityByPosition(1));
                        startActivity(i4);
                        break;
                    case 5:
                        Intent i5 = new Intent(getApplicationContext(), GraphActivity.class);
                        i5.putExtra("title", TextsEN.getMenuByPosition(5));
                        i5.putExtra("description",TextsEN.getDescriptionByPosition(2));
                        i5.putExtra("complexity", TextsEN.getComplexityByPosition(2));
                        startActivity(i5);
                        break;
                    case 6:
                        Intent i6 = new Intent(getApplicationContext(), GraphActivity.class);
                        i6.putExtra("title", TextsEN.getMenuByPosition(6));
                        i6.putExtra("description",TextsEN.getDescriptionByPosition(3));
                        i6.putExtra("complexity", TextsEN.getComplexityByPosition(3));
                        startActivity(i6);
                        break;
                    case 7:
                        Intent i7 = new Intent(getApplicationContext(), TopSortActivity.class);
                        i7.putExtra("title", TextsEN.getMenuByPosition(7));
                        i7.putExtra("description",TextsEN.getDescriptionByPosition(4));
                        i7.putExtra("complexity", TextsEN.getComplexityByPosition(4));
                        startActivity(i7);
                        break;
                    case 8:
                        Intent i8 = new Intent(getApplicationContext(), GraphActivity.class);
                        i8.putExtra("title", TextsEN.getMenuByPosition(8));
                        i8.putExtra("description",TextsEN.getDescriptionByPosition(5));
                        i8.putExtra("complexity", TextsEN.getComplexityByPosition(5));
                        startActivity(i8);
                        break;
                    case 9:
                        Intent i9 = new Intent(getApplicationContext(), WarshallActivity.class);
                        i9.putExtra("title", TextsEN.getMenuByPosition(9));
                        i9.putExtra("description",TextsEN.getDescriptionByPosition(6));
                        i9.putExtra("complexity", TextsEN.getComplexityByPosition(6));
                        startActivity(i9);
                        break;
                }

            }
        });

        bHelp.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_menu, menu);
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
                Toast.makeText(MenuActivity.this, TextsEN.getHelpByPosition(1), Toast.LENGTH_LONG).show();
                break;
        }
    }
}
