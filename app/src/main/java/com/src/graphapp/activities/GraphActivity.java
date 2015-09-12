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
import com.src.graphapp.structures.Edge;
import com.src.graphapp.structures.Graph;
import com.src.graphapp.structures.Vertex;
import com.src.graphapp.texts.TextsEN;

import java.util.ArrayList;

public class GraphActivity extends AppCompatActivity implements View.OnClickListener {

    Graph graph = Controller.getGraph();
    Button bDescription, bHelp;
    TextView tvTitle, tvGraph;
    TextView tvVertices[] = new TextView[10];
    TextView tvEdges[][] = new TextView[10][10];


    int algorithm;
    String title, start, end, description, complexity;

    public void initDisplay(){

        tvVertices[0] = (TextView)findViewById(R.id.tv0);
        tvVertices[1] = (TextView)findViewById(R.id.tv1);
        tvVertices[2] = (TextView)findViewById(R.id.tv2);
        tvVertices[3] = (TextView)findViewById(R.id.tv3);
        tvVertices[4] = (TextView)findViewById(R.id.tv4);
        tvVertices[5] = (TextView)findViewById(R.id.tv5);
        tvVertices[6] = (TextView)findViewById(R.id.tv6);
        tvVertices[7] = (TextView)findViewById(R.id.tv7);
        tvVertices[8] = (TextView)findViewById(R.id.tv8);
        tvVertices[9] = (TextView)findViewById(R.id.tv9);

        if(graph.isDirected()) {

            //0
            tvEdges[0][1] = (TextView) findViewById(R.id.tvE01);
            tvEdges[0][2] = (TextView) findViewById(R.id.tvE02);
            tvEdges[0][3] = (TextView) findViewById(R.id.tvE03);
            tvEdges[0][4] = (TextView) findViewById(R.id.tvE04);
            tvEdges[0][5] = (TextView) findViewById(R.id.tvE05);
            tvEdges[0][6] = (TextView) findViewById(R.id.tvE06);
            tvEdges[0][7] = (TextView) findViewById(R.id.tvE07);
            tvEdges[0][8] = (TextView) findViewById(R.id.tvE08);
            tvEdges[0][9] = (TextView) findViewById(R.id.tvE09);
            //1
            tvEdges[1][0] = (TextView) findViewById(R.id.tvE10);
            tvEdges[1][2] = (TextView) findViewById(R.id.tvE12);
            tvEdges[1][3] = (TextView) findViewById(R.id.tvE13);
            tvEdges[1][4] = (TextView) findViewById(R.id.tvE14);
            tvEdges[1][5] = (TextView) findViewById(R.id.tvE15);
            tvEdges[1][6] = (TextView) findViewById(R.id.tvE16);
            tvEdges[1][7] = (TextView) findViewById(R.id.tvE17);
            tvEdges[1][8] = (TextView) findViewById(R.id.tvE18);
            tvEdges[1][9] = (TextView) findViewById(R.id.tvE19);
            //2
            tvEdges[2][0] = (TextView) findViewById(R.id.tvE20);
            tvEdges[2][1] = (TextView) findViewById(R.id.tvE21);
            tvEdges[2][3] = (TextView) findViewById(R.id.tvE23);
            tvEdges[2][4] = (TextView) findViewById(R.id.tvE24);
            tvEdges[2][5] = (TextView) findViewById(R.id.tvE25);
            tvEdges[2][6] = (TextView) findViewById(R.id.tvE26);
            tvEdges[2][7] = (TextView) findViewById(R.id.tvE27);
            tvEdges[2][8] = (TextView) findViewById(R.id.tvE28);
            tvEdges[2][9] = (TextView) findViewById(R.id.tvE29);
            //3
            tvEdges[3][0] = (TextView) findViewById(R.id.tvE30);
            tvEdges[3][1] = (TextView) findViewById(R.id.tvE31);
            tvEdges[3][2] = (TextView) findViewById(R.id.tvE32);
            tvEdges[3][4] = (TextView) findViewById(R.id.tvE34);
            tvEdges[3][5] = (TextView) findViewById(R.id.tvE35);
            tvEdges[3][6] = (TextView) findViewById(R.id.tvE36);
            tvEdges[3][7] = (TextView) findViewById(R.id.tvE37);
            tvEdges[3][8] = (TextView) findViewById(R.id.tvE38);
            tvEdges[3][9] = (TextView) findViewById(R.id.tvE39);
            //4
            tvEdges[4][0] = (TextView) findViewById(R.id.tvE40);
            tvEdges[4][1] = (TextView) findViewById(R.id.tvE41);
            tvEdges[4][2] = (TextView) findViewById(R.id.tvE42);
            tvEdges[4][3] = (TextView) findViewById(R.id.tvE43);
            tvEdges[4][5] = (TextView) findViewById(R.id.tvE45);
            tvEdges[4][6] = (TextView) findViewById(R.id.tvE46);
            tvEdges[4][7] = (TextView) findViewById(R.id.tvE47);
            tvEdges[4][8] = (TextView) findViewById(R.id.tvE48);
            tvEdges[4][9] = (TextView) findViewById(R.id.tvE49);
            //5
            tvEdges[5][0] = (TextView) findViewById(R.id.tvE50);
            tvEdges[5][1] = (TextView) findViewById(R.id.tvE51);
            tvEdges[5][2] = (TextView) findViewById(R.id.tvE52);
            tvEdges[5][3] = (TextView) findViewById(R.id.tvE53);
            tvEdges[5][4] = (TextView) findViewById(R.id.tvE54);
            tvEdges[5][6] = (TextView) findViewById(R.id.tvE56);
            tvEdges[5][7] = (TextView) findViewById(R.id.tvE57);
            tvEdges[5][8] = (TextView) findViewById(R.id.tvE58);
            tvEdges[5][9] = (TextView) findViewById(R.id.tvE59);
            //6
            tvEdges[6][0] = (TextView) findViewById(R.id.tvE60);
            tvEdges[6][1] = (TextView) findViewById(R.id.tvE61);
            tvEdges[6][2] = (TextView) findViewById(R.id.tvE62);
            tvEdges[6][3] = (TextView) findViewById(R.id.tvE63);
            tvEdges[6][4] = (TextView) findViewById(R.id.tvE64);
            tvEdges[6][5] = (TextView) findViewById(R.id.tvE65);
            tvEdges[6][7] = (TextView) findViewById(R.id.tvE67);
            tvEdges[6][8] = (TextView) findViewById(R.id.tvE68);
            tvEdges[6][9] = (TextView) findViewById(R.id.tvE69);
            //7
            tvEdges[7][0] = (TextView) findViewById(R.id.tvE70);
            tvEdges[7][1] = (TextView) findViewById(R.id.tvE71);
            tvEdges[7][2] = (TextView) findViewById(R.id.tvE72);
            tvEdges[7][3] = (TextView) findViewById(R.id.tvE73);
            tvEdges[7][4] = (TextView) findViewById(R.id.tvE74);
            tvEdges[7][5] = (TextView) findViewById(R.id.tvE75);
            tvEdges[7][6] = (TextView) findViewById(R.id.tvE76);
            tvEdges[7][8] = (TextView) findViewById(R.id.tvE78);
            tvEdges[7][9] = (TextView) findViewById(R.id.tvE79);
            //8
            tvEdges[8][0] = (TextView) findViewById(R.id.tvE80);
            tvEdges[8][1] = (TextView) findViewById(R.id.tvE81);
            tvEdges[8][2] = (TextView) findViewById(R.id.tvE82);
            tvEdges[8][3] = (TextView) findViewById(R.id.tvE83);
            tvEdges[8][4] = (TextView) findViewById(R.id.tvE84);
            tvEdges[8][5] = (TextView) findViewById(R.id.tvE85);
            tvEdges[8][6] = (TextView) findViewById(R.id.tvE86);
            tvEdges[8][7] = (TextView) findViewById(R.id.tvE87);
            tvEdges[8][9] = (TextView) findViewById(R.id.tvE89);
            //9
            tvEdges[9][0] = (TextView) findViewById(R.id.tvE90);
            tvEdges[9][1] = (TextView) findViewById(R.id.tvE91);
            tvEdges[9][2] = (TextView) findViewById(R.id.tvE92);
            tvEdges[9][3] = (TextView) findViewById(R.id.tvE93);
            tvEdges[9][4] = (TextView) findViewById(R.id.tvE94);
            tvEdges[9][5] = (TextView) findViewById(R.id.tvE95);
            tvEdges[9][6] = (TextView) findViewById(R.id.tvE96);
            tvEdges[9][7] = (TextView) findViewById(R.id.tvE97);
            tvEdges[9][8] = (TextView) findViewById(R.id.tvE98);
        }else{

            //0
            tvEdges[0][1] = (TextView) findViewById(R.id.tvE01);
            tvEdges[0][2] = (TextView) findViewById(R.id.tvE02);
            tvEdges[0][3] = (TextView) findViewById(R.id.tvE03);
            tvEdges[0][4] = (TextView) findViewById(R.id.tvE04);
            tvEdges[0][5] = (TextView) findViewById(R.id.tvE05);
            tvEdges[0][6] = (TextView) findViewById(R.id.tvE06);
            tvEdges[0][7] = (TextView) findViewById(R.id.tvE07);
            tvEdges[0][8] = (TextView) findViewById(R.id.tvE08);
            tvEdges[0][9] = (TextView) findViewById(R.id.tvE09);
            //1
            tvEdges[1][0] = (TextView) findViewById(R.id.tvE01);
            tvEdges[1][2] = (TextView) findViewById(R.id.tvE12);
            tvEdges[1][3] = (TextView) findViewById(R.id.tvE13);
            tvEdges[1][4] = (TextView) findViewById(R.id.tvE14);
            tvEdges[1][5] = (TextView) findViewById(R.id.tvE15);
            tvEdges[1][6] = (TextView) findViewById(R.id.tvE16);
            tvEdges[1][7] = (TextView) findViewById(R.id.tvE17);
            tvEdges[1][8] = (TextView) findViewById(R.id.tvE18);
            tvEdges[1][9] = (TextView) findViewById(R.id.tvE19);
            //2
            tvEdges[2][0] = (TextView) findViewById(R.id.tvE02);
            tvEdges[2][1] = (TextView) findViewById(R.id.tvE12);
            tvEdges[2][3] = (TextView) findViewById(R.id.tvE23);
            tvEdges[2][4] = (TextView) findViewById(R.id.tvE24);
            tvEdges[2][5] = (TextView) findViewById(R.id.tvE25);
            tvEdges[2][6] = (TextView) findViewById(R.id.tvE26);
            tvEdges[2][7] = (TextView) findViewById(R.id.tvE27);
            tvEdges[2][8] = (TextView) findViewById(R.id.tvE28);
            tvEdges[2][9] = (TextView) findViewById(R.id.tvE29);
            //3
            tvEdges[3][0] = (TextView) findViewById(R.id.tvE03);
            tvEdges[3][1] = (TextView) findViewById(R.id.tvE13);
            tvEdges[3][2] = (TextView) findViewById(R.id.tvE23);
            tvEdges[3][4] = (TextView) findViewById(R.id.tvE34);
            tvEdges[3][5] = (TextView) findViewById(R.id.tvE35);
            tvEdges[3][6] = (TextView) findViewById(R.id.tvE36);
            tvEdges[3][7] = (TextView) findViewById(R.id.tvE37);
            tvEdges[3][8] = (TextView) findViewById(R.id.tvE38);
            tvEdges[3][9] = (TextView) findViewById(R.id.tvE39);
            //4
            tvEdges[4][0] = (TextView) findViewById(R.id.tvE04);
            tvEdges[4][1] = (TextView) findViewById(R.id.tvE14);
            tvEdges[4][2] = (TextView) findViewById(R.id.tvE24);
            tvEdges[4][3] = (TextView) findViewById(R.id.tvE34);
            tvEdges[4][5] = (TextView) findViewById(R.id.tvE45);
            tvEdges[4][6] = (TextView) findViewById(R.id.tvE46);
            tvEdges[4][7] = (TextView) findViewById(R.id.tvE47);
            tvEdges[4][8] = (TextView) findViewById(R.id.tvE48);
            tvEdges[4][9] = (TextView) findViewById(R.id.tvE49);
            //5
            tvEdges[5][0] = (TextView) findViewById(R.id.tvE05);
            tvEdges[5][1] = (TextView) findViewById(R.id.tvE15);
            tvEdges[5][2] = (TextView) findViewById(R.id.tvE25);
            tvEdges[5][3] = (TextView) findViewById(R.id.tvE35);
            tvEdges[5][4] = (TextView) findViewById(R.id.tvE45);
            tvEdges[5][6] = (TextView) findViewById(R.id.tvE56);
            tvEdges[5][7] = (TextView) findViewById(R.id.tvE57);
            tvEdges[5][8] = (TextView) findViewById(R.id.tvE58);
            tvEdges[5][9] = (TextView) findViewById(R.id.tvE59);
            //6
            tvEdges[6][0] = (TextView) findViewById(R.id.tvE06);
            tvEdges[6][1] = (TextView) findViewById(R.id.tvE16);
            tvEdges[6][2] = (TextView) findViewById(R.id.tvE26);
            tvEdges[6][3] = (TextView) findViewById(R.id.tvE36);
            tvEdges[6][4] = (TextView) findViewById(R.id.tvE46);
            tvEdges[6][5] = (TextView) findViewById(R.id.tvE56);
            tvEdges[6][7] = (TextView) findViewById(R.id.tvE67);
            tvEdges[6][8] = (TextView) findViewById(R.id.tvE68);
            tvEdges[6][9] = (TextView) findViewById(R.id.tvE69);
            //7
            tvEdges[7][0] = (TextView) findViewById(R.id.tvE07);
            tvEdges[7][1] = (TextView) findViewById(R.id.tvE17);
            tvEdges[7][2] = (TextView) findViewById(R.id.tvE27);
            tvEdges[7][3] = (TextView) findViewById(R.id.tvE37);
            tvEdges[7][4] = (TextView) findViewById(R.id.tvE47);
            tvEdges[7][5] = (TextView) findViewById(R.id.tvE57);
            tvEdges[7][6] = (TextView) findViewById(R.id.tvE67);
            tvEdges[7][8] = (TextView) findViewById(R.id.tvE78);
            tvEdges[7][9] = (TextView) findViewById(R.id.tvE79);
            //8
            tvEdges[8][0] = (TextView) findViewById(R.id.tvE08);
            tvEdges[8][1] = (TextView) findViewById(R.id.tvE18);
            tvEdges[8][2] = (TextView) findViewById(R.id.tvE28);
            tvEdges[8][3] = (TextView) findViewById(R.id.tvE38);
            tvEdges[8][4] = (TextView) findViewById(R.id.tvE48);
            tvEdges[8][5] = (TextView) findViewById(R.id.tvE58);
            tvEdges[8][6] = (TextView) findViewById(R.id.tvE68);
            tvEdges[8][7] = (TextView) findViewById(R.id.tvE78);
            tvEdges[8][9] = (TextView) findViewById(R.id.tvE89);
            //9
            tvEdges[9][0] = (TextView) findViewById(R.id.tvE09);
            tvEdges[9][1] = (TextView) findViewById(R.id.tvE19);
            tvEdges[9][2] = (TextView) findViewById(R.id.tvE29);
            tvEdges[9][3] = (TextView) findViewById(R.id.tvE39);
            tvEdges[9][4] = (TextView) findViewById(R.id.tvE49);
            tvEdges[9][5] = (TextView) findViewById(R.id.tvE59);
            tvEdges[9][6] = (TextView) findViewById(R.id.tvE69);
            tvEdges[9][7] = (TextView) findViewById(R.id.tvE79);
            tvEdges[9][8] = (TextView) findViewById(R.id.tvE89);

            //Setting background image
            //0
            tvEdges[0][1].setBackgroundResource(R.drawable.und01);
            tvEdges[0][2].setBackgroundResource(R.drawable.und02);
            tvEdges[0][3].setBackgroundResource(R.drawable.und03);
            tvEdges[0][4].setBackgroundResource(R.drawable.und04);
            tvEdges[0][5].setBackgroundResource(R.drawable.und05);
            tvEdges[0][6].setBackgroundResource(R.drawable.und06);
            tvEdges[0][7].setBackgroundResource(R.drawable.und07);
            tvEdges[0][8].setBackgroundResource(R.drawable.und08);
            tvEdges[0][9].setBackgroundResource(R.drawable.und09);
            //1
            tvEdges[1][2].setBackgroundResource(R.drawable.und12);
            tvEdges[1][3].setBackgroundResource(R.drawable.und13);
            tvEdges[1][4].setBackgroundResource(R.drawable.und14);
            tvEdges[1][5].setBackgroundResource(R.drawable.und15);
            tvEdges[1][6].setBackgroundResource(R.drawable.und16);
            tvEdges[1][7].setBackgroundResource(R.drawable.und17);
            tvEdges[1][8].setBackgroundResource(R.drawable.und18);
            tvEdges[1][9].setBackgroundResource(R.drawable.und19);
            //2
            tvEdges[2][3].setBackgroundResource(R.drawable.und23);
            tvEdges[2][4].setBackgroundResource(R.drawable.und24);
            tvEdges[2][5].setBackgroundResource(R.drawable.und25);
            tvEdges[2][6].setBackgroundResource(R.drawable.und26);
            tvEdges[2][7].setBackgroundResource(R.drawable.und27);
            tvEdges[2][8].setBackgroundResource(R.drawable.und28);
            tvEdges[2][9].setBackgroundResource(R.drawable.und29);
            //3
            tvEdges[3][4].setBackgroundResource(R.drawable.und34);
            tvEdges[3][5].setBackgroundResource(R.drawable.und35);
            tvEdges[3][6].setBackgroundResource(R.drawable.und36);
            tvEdges[3][7].setBackgroundResource(R.drawable.und37);
            tvEdges[3][8].setBackgroundResource(R.drawable.und38);
            tvEdges[3][9].setBackgroundResource(R.drawable.und39);
            //4
            tvEdges[4][5].setBackgroundResource(R.drawable.und45);
            tvEdges[4][6].setBackgroundResource(R.drawable.und46);
            tvEdges[4][7].setBackgroundResource(R.drawable.und47);
            tvEdges[4][8].setBackgroundResource(R.drawable.und48);
            tvEdges[4][9].setBackgroundResource(R.drawable.und49);
            //5
            tvEdges[5][6].setBackgroundResource(R.drawable.und56);
            tvEdges[5][7].setBackgroundResource(R.drawable.und57);
            tvEdges[5][8].setBackgroundResource(R.drawable.und58);
            tvEdges[5][9].setBackgroundResource(R.drawable.und59);
            //6
            tvEdges[6][7].setBackgroundResource(R.drawable.und67);
            tvEdges[6][8].setBackgroundResource(R.drawable.und68);
            tvEdges[6][9].setBackgroundResource(R.drawable.und69);
            //7
            tvEdges[7][8].setBackgroundResource(R.drawable.und78);
            tvEdges[7][9].setBackgroundResource(R.drawable.und79);
            //8
            tvEdges[8][9].setBackgroundResource(R.drawable.und89);

        }
    }

    public void displayGraph(){
        ArrayList<Vertex> vertices;
        Graph graphAux = new Graph();

        switch (algorithm){
            case 2:
                graphAux = graph;
                bDescription.setEnabled(false);
                break;
            case 3:
                graphAux = graph.kruskal();
                bDescription.setOnClickListener(this);
                break;
            case 4:
                graphAux = graph.dijkstra(start,end);
                bDescription.setOnClickListener(this);
                break;
            case 5:
                graphAux = graph.breadthFirstSearch(start);
                bDescription.setOnClickListener(this);
                break;
            case 6:
                graphAux = graph.depthFirstSearch(start);
                bDescription.setOnClickListener(this);
                break;
            case 8:
                graphAux = graph.transitiveClosure();
                bDescription.setOnClickListener(this);
                break;
        }
        vertices = graphAux.getVertices();

        for(int i=0;i<vertices.size();i++){
            tvVertices[i].setText(vertices.get(i).getName());
            tvVertices[i].setVisibility(View.VISIBLE);
        }

        for(int i=0;i<vertices.size();i++) {
            for (int j = 0; j < vertices.size(); j++) {
                Edge edge = graphAux.findEdge(vertices.get(i), vertices.get(j));
                if (edge != null) {

                    tvEdges[i][j].setText(edge.getWeight() +""); // using ' +"" ' as a easy form of conversion from int to String
                    tvEdges[i][j].setVisibility(View.VISIBLE);
                }
            }
        }

        tvGraph.setText(graphAux.printGraph());

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        Intent i1 = getIntent();
        title = i1.getStringExtra("title");
        algorithm = i1.getIntExtra("algorithm", -1);
        start = i1.getStringExtra("start");
        end = i1.getStringExtra("end");
        description = i1.getStringExtra("description");
        complexity = i1.getStringExtra("complexity");

        initDisplay();

        bHelp = (Button)findViewById(R.id.bHelp);
        tvTitle = (TextView)findViewById(R.id.tvTitle);
        tvGraph = (TextView)findViewById(R.id.tvGraph);
        bDescription = (Button)findViewById(R.id.bDescription);

        tvTitle.setText(title);
        bHelp.setOnClickListener(this);

        displayGraph();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_graph, menu);
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
                Toast.makeText(GraphActivity.this, TextsEN.getHelpByPosition(4), Toast.LENGTH_LONG).show();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
