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

import com.src.graphapp.Controller;
import com.src.graphapp.R;
import com.src.graphapp.structures.Graph;
import com.src.graphapp.texts.TextsEN;

public class InputActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvTitle, tvEnd;
    EditText etStart, etEnd;
    Button bNext,bHelp;

    Graph graph = Controller.getGraph();
    String title, description, complexity;
    int algorithm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        Intent i1 = getIntent();
        algorithm = i1.getIntExtra("algorithm", -1);
        title = i1.getStringExtra("title");
        description = i1.getStringExtra("description");
        complexity = i1.getStringExtra("complexity");

        tvTitle = (TextView)findViewById(R.id.tvTitle);
        tvEnd = (TextView)findViewById(R.id.tvEnd);
        etStart = (EditText)findViewById(R.id.etStart);
        etEnd = (EditText)findViewById(R.id.etEnd);
        bNext = (Button)findViewById(R.id.bNext);
        bHelp = (Button)findViewById(R.id.bHelp);

        tvTitle.setText(title);
        bNext.setOnClickListener(this);
        bHelp.setOnClickListener(this);

        if(algorithm!=4){ // if the algorithm is Dijkstra, it needs to get a start and a end to the Dijkstra Path
            tvEnd.setVisibility(View.INVISIBLE);
            etEnd.setVisibility(View.INVISIBLE);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_input, menu);
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
        switch (v.getId()) {
            case R.id.bNext:
                String start = etStart.getText().toString();

                if (start.equals("")){ // Checking if the gap 'start' is empty
                    Toast.makeText(this, TextsEN.getHelpByPosition(6), Toast.LENGTH_LONG).show();
                }else if (graph.vertexLocation(start)!=graph.getVertices().size()) { //Checking if the vertex exist
                    if (algorithm == 4) {
                        String end = etEnd.getText().toString();

                        if (end.equals("")){ // Checking if the gap 'end' is empty
                            Toast.makeText(this, TextsEN.getHelpByPosition(6), Toast.LENGTH_LONG).show();
                        }else if(graph.vertexLocation(end)==graph.getVertices().size()){ //Checking if the vertex exist
                            Toast.makeText(this, TextsEN.getErrorByPosition(3), Toast.LENGTH_LONG).show();
                        }else if(start.equals(end)){ //Checking if the start is equal to the end
                            Toast.makeText(this, TextsEN.getErrorByPosition(1), Toast.LENGTH_LONG).show();
                        }else {
                            Intent i2 = new Intent(this, GraphActivity.class);
                            i2.putExtra("title", title);
                            i2.putExtra("algorithm", algorithm);
                            i2.putExtra("start", start);
                            i2.putExtra("end", end);
                            i2.putExtra("description", description);
                            i2.putExtra("complexity", complexity);
                            startActivity(i2);
                            finish();
                        }

                    } else if (algorithm == 5) {
                        Intent i2 = new Intent(this, GraphActivity.class);
                        i2.putExtra("title", title);
                        i2.putExtra("algorithm", algorithm);
                        i2.putExtra("start", start);
                        i2.putExtra("end", "");
                        i2.putExtra("description", description);
                        i2.putExtra("complexity", complexity);
                        startActivity(i2);
                        finish();
                    } else if (algorithm == 6) {
                        Intent i2 = new Intent(this, GraphActivity.class);
                        i2.putExtra("title", title);
                        i2.putExtra("algorithm", algorithm);
                        i2.putExtra("start", start);
                        i2.putExtra("end", "");
                        i2.putExtra("description", description);
                        i2.putExtra("complexity", complexity);
                        startActivity(i2);
                        finish();
                    }
                }else {
                    Toast.makeText(this, TextsEN.getErrorByPosition(3), Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.bHelp:
                Toast.makeText(this, TextsEN.getHelpByPosition(6), Toast.LENGTH_LONG).show();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        finish ();
    }
}
