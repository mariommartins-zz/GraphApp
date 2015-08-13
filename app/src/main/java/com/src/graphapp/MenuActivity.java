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
import android.widget.TextView;
import android.widget.Toast;

import com.src.graphapp.structures.Graph;

public class MenuActivity extends Activity implements View.OnClickListener {

    ListView lvMenu;
    Button bHelp;

    String help = "Tap the option you would like to use in the list";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        lvMenu = (ListView) findViewById(R.id.lvMenu);
        bHelp = (Button)findViewById(R.id.bHelp);

        String[] menu = {"Insert a Vertex", "Insert an Edge", "Show Graph", "Kruskal's Tree (or Forest)",
                "Dijkstra's path", "Breadth-First Search", "Depth-First Search",
                "Topological Sorting", "Transitive Closure", "Floyd–Warshall Algorithm"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menu);

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
                        startActivity(new Intent(getApplicationContext(),GraphActivity.class));
                        break;
                    case 3:
                        startActivity(new Intent(getApplicationContext(),GraphActivity.class));
                        break;
                    case 4:
                        startActivity(new Intent(getApplicationContext(),GraphActivity.class));
                        break;
                    case 5:
                        startActivity(new Intent(getApplicationContext(),GraphActivity.class));
                        break;
                    case 6:
                        startActivity(new Intent(getApplicationContext(),GraphActivity.class));
                        break;
                    case 7:
                        startActivity(new Intent(getApplicationContext(),TopSortActivity.class));
                        break;
                    case 8:
                        startActivity(new Intent(getApplicationContext(),GraphActivity.class));
                        break;
                    case 9:
                        startActivity(new Intent(getApplicationContext(),WarshallActivity.class));
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
                Toast.makeText(MenuActivity.this, help, Toast.LENGTH_LONG).show();
                break;
        }
    }
}
