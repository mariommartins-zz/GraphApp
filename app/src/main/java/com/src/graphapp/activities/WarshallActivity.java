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

import com.src.graphapp.Controller;
import com.src.graphapp.R;
import com.src.graphapp.structures.Graph;
import com.src.graphapp.structures.Vertex;
import com.src.graphapp.texts.TextsEN;

import java.util.ArrayList;

public class WarshallActivity extends AppCompatActivity implements View.OnClickListener {

    Graph graph = Controller.getGraph();

    TextView[][] tvFW = new TextView[12][10];
    Button bDescription, bHelp;
    String title, description, complexity;

    public void initMatrix(){
        tvFW[10][0] = (TextView)findViewById(R.id.tvVc0);
        tvFW[10][1] = (TextView)findViewById(R.id.tvVc1);
        tvFW[10][2] = (TextView)findViewById(R.id.tvVc2);
        tvFW[10][3] = (TextView)findViewById(R.id.tvVc3);
        tvFW[10][4] = (TextView)findViewById(R.id.tvVc4);
        tvFW[10][5] = (TextView)findViewById(R.id.tvVc5);
        tvFW[10][6] = (TextView)findViewById(R.id.tvVc6);
        tvFW[10][7] = (TextView)findViewById(R.id.tvVc7);
        tvFW[10][8] = (TextView)findViewById(R.id.tvVc8);
        tvFW[10][9] = (TextView)findViewById(R.id.tvVc9);

        tvFW[11][0] = (TextView)findViewById(R.id.tvVl0);
        tvFW[11][1] = (TextView)findViewById(R.id.tvVl1);
        tvFW[11][2] = (TextView)findViewById(R.id.tvVl2);
        tvFW[11][3] = (TextView)findViewById(R.id.tvVl3);
        tvFW[11][4] = (TextView)findViewById(R.id.tvVl4);
        tvFW[11][5] = (TextView)findViewById(R.id.tvVl5);
        tvFW[11][6] = (TextView)findViewById(R.id.tvVl6);
        tvFW[11][7] = (TextView)findViewById(R.id.tvVl7);
        tvFW[11][8] = (TextView)findViewById(R.id.tvVl8);
        tvFW[11][9] = (TextView)findViewById(R.id.tvVl9);

        tvFW[0][0] = (TextView)findViewById(R.id.tv00);
        tvFW[0][1] = (TextView)findViewById(R.id.tv01);
        tvFW[0][2] = (TextView)findViewById(R.id.tv02);
        tvFW[0][3] = (TextView)findViewById(R.id.tv03);
        tvFW[0][4] = (TextView)findViewById(R.id.tv04);
        tvFW[0][5] = (TextView)findViewById(R.id.tv05);
        tvFW[0][6] = (TextView)findViewById(R.id.tv06);
        tvFW[0][7] = (TextView)findViewById(R.id.tv07);
        tvFW[0][8] = (TextView)findViewById(R.id.tv08);
        tvFW[0][9] = (TextView)findViewById(R.id.tv09);

        tvFW[1][0] = (TextView)findViewById(R.id.tv10);
        tvFW[1][1] = (TextView)findViewById(R.id.tv11);
        tvFW[1][2] = (TextView)findViewById(R.id.tv12);
        tvFW[1][3] = (TextView)findViewById(R.id.tv13);
        tvFW[1][4] = (TextView)findViewById(R.id.tv14);
        tvFW[1][5] = (TextView)findViewById(R.id.tv15);
        tvFW[1][6] = (TextView)findViewById(R.id.tv16);
        tvFW[1][7] = (TextView)findViewById(R.id.tv17);
        tvFW[1][8] = (TextView)findViewById(R.id.tv18);
        tvFW[1][9] = (TextView)findViewById(R.id.tv19);

        tvFW[2][0] = (TextView)findViewById(R.id.tv20);
        tvFW[2][1] = (TextView)findViewById(R.id.tv21);
        tvFW[2][2] = (TextView)findViewById(R.id.tv22);
        tvFW[2][3] = (TextView)findViewById(R.id.tv23);
        tvFW[2][4] = (TextView)findViewById(R.id.tv24);
        tvFW[2][5] = (TextView)findViewById(R.id.tv25);
        tvFW[2][6] = (TextView)findViewById(R.id.tv26);
        tvFW[2][7] = (TextView)findViewById(R.id.tv27);
        tvFW[2][8] = (TextView)findViewById(R.id.tv28);
        tvFW[2][9] = (TextView)findViewById(R.id.tv29);

        tvFW[3][0] = (TextView)findViewById(R.id.tv30);
        tvFW[3][1] = (TextView)findViewById(R.id.tv31);
        tvFW[3][2] = (TextView)findViewById(R.id.tv32);
        tvFW[3][3] = (TextView)findViewById(R.id.tv33);
        tvFW[3][4] = (TextView)findViewById(R.id.tv34);
        tvFW[3][5] = (TextView)findViewById(R.id.tv35);
        tvFW[3][6] = (TextView)findViewById(R.id.tv36);
        tvFW[3][7] = (TextView)findViewById(R.id.tv37);
        tvFW[3][8] = (TextView)findViewById(R.id.tv38);
        tvFW[3][9] = (TextView)findViewById(R.id.tv39);

        tvFW[4][0] = (TextView)findViewById(R.id.tv40);
        tvFW[4][1] = (TextView)findViewById(R.id.tv41);
        tvFW[4][2] = (TextView)findViewById(R.id.tv42);
        tvFW[4][3] = (TextView)findViewById(R.id.tv43);
        tvFW[4][4] = (TextView)findViewById(R.id.tv44);
        tvFW[4][5] = (TextView)findViewById(R.id.tv45);
        tvFW[4][6] = (TextView)findViewById(R.id.tv46);
        tvFW[4][7] = (TextView)findViewById(R.id.tv47);
        tvFW[4][8] = (TextView)findViewById(R.id.tv48);
        tvFW[4][9] = (TextView)findViewById(R.id.tv49);

        tvFW[5][0] = (TextView)findViewById(R.id.tv50);
        tvFW[5][1] = (TextView)findViewById(R.id.tv51);
        tvFW[5][2] = (TextView)findViewById(R.id.tv52);
        tvFW[5][3] = (TextView)findViewById(R.id.tv53);
        tvFW[5][4] = (TextView)findViewById(R.id.tv54);
        tvFW[5][5] = (TextView)findViewById(R.id.tv55);
        tvFW[5][6] = (TextView)findViewById(R.id.tv56);
        tvFW[5][7] = (TextView)findViewById(R.id.tv57);
        tvFW[5][8] = (TextView)findViewById(R.id.tv58);
        tvFW[5][9] = (TextView)findViewById(R.id.tv59);

        tvFW[6][0] = (TextView)findViewById(R.id.tv60);
        tvFW[6][1] = (TextView)findViewById(R.id.tv61);
        tvFW[6][2] = (TextView)findViewById(R.id.tv62);
        tvFW[6][3] = (TextView)findViewById(R.id.tv63);
        tvFW[6][4] = (TextView)findViewById(R.id.tv64);
        tvFW[6][5] = (TextView)findViewById(R.id.tv65);
        tvFW[6][6] = (TextView)findViewById(R.id.tv66);
        tvFW[6][7] = (TextView)findViewById(R.id.tv67);
        tvFW[6][8] = (TextView)findViewById(R.id.tv68);
        tvFW[6][9] = (TextView)findViewById(R.id.tv69);

        tvFW[7][0] = (TextView)findViewById(R.id.tv70);
        tvFW[7][1] = (TextView)findViewById(R.id.tv71);
        tvFW[7][2] = (TextView)findViewById(R.id.tv72);
        tvFW[7][3] = (TextView)findViewById(R.id.tv73);
        tvFW[7][4] = (TextView)findViewById(R.id.tv74);
        tvFW[7][5] = (TextView)findViewById(R.id.tv75);
        tvFW[7][6] = (TextView)findViewById(R.id.tv76);
        tvFW[7][7] = (TextView)findViewById(R.id.tv77);
        tvFW[7][8] = (TextView)findViewById(R.id.tv78);
        tvFW[7][9] = (TextView)findViewById(R.id.tv79);

        tvFW[8][0] = (TextView)findViewById(R.id.tv80);
        tvFW[8][1] = (TextView)findViewById(R.id.tv81);
        tvFW[8][2] = (TextView)findViewById(R.id.tv82);
        tvFW[8][3] = (TextView)findViewById(R.id.tv83);
        tvFW[8][4] = (TextView)findViewById(R.id.tv84);
        tvFW[8][5] = (TextView)findViewById(R.id.tv85);
        tvFW[8][6] = (TextView)findViewById(R.id.tv86);
        tvFW[8][7] = (TextView)findViewById(R.id.tv87);
        tvFW[8][8] = (TextView)findViewById(R.id.tv88);
        tvFW[8][9] = (TextView)findViewById(R.id.tv89);

        tvFW[9][0] = (TextView)findViewById(R.id.tv90);
        tvFW[9][1] = (TextView)findViewById(R.id.tv91);
        tvFW[9][2] = (TextView)findViewById(R.id.tv92);
        tvFW[9][3] = (TextView)findViewById(R.id.tv93);
        tvFW[9][4] = (TextView)findViewById(R.id.tv94);
        tvFW[9][5] = (TextView)findViewById(R.id.tv95);
        tvFW[9][6] = (TextView)findViewById(R.id.tv96);
        tvFW[9][7] = (TextView)findViewById(R.id.tv97);
        tvFW[9][8] = (TextView)findViewById(R.id.tv98);
        tvFW[9][9] = (TextView)findViewById(R.id.tv99);
    }

    public void displayFWMatrix(){
        ArrayList<Vertex> vertices = graph.getVertices();
        Integer[][] fwMatrix = graph.floydWarshall();

        int size = vertices.size();

        for(int i=0;i<size;i++){
            tvFW[10][i].setText(vertices.get(i).getName());
            tvFW[11][i].setText(vertices.get(i).getName());
        }
        for(int i=0;i<size;i++)
            for(int j=0;j<size;j++)
                tvFW[i][j].setText(fwMatrix[i][j].toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_warshall);

        initMatrix();
            displayFWMatrix();

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
                i2.putExtra("previous",3);
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
