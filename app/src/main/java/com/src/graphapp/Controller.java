package com.src.graphapp;

import android.content.Intent;
import android.view.Menu;

import com.src.graphapp.activities.MenuActivity;
import com.src.graphapp.structures.Graph;

/**
 * Created by Guto on 15/08/2015.
 */
public class Controller {

    static Graph graph;

    public static Graph getGraph() {
        return graph;
    }

    public static void destroy (){
        graph = new Graph();
    }

    public static void initiate(Intent i){
        graph = new Graph();
        graph.setDirected(i.getBooleanExtra("directed", false));
        if (i.getBooleanExtra("random", false)) {
            graph.randomGraphCreator();
        } else {
            // TEST

            graph.addEdge(2,"a","b");
            graph.addEdge(5,"b","c");
            graph.addEdge(1,"c","a");
            graph.addEdge(1,"a","c");
            graph.addVertex("d");
            graph.addVertex("e");
            graph.addVertex("f");
            graph.addVertex("g");
            graph.addVertex("h");
            graph.addVertex("i");
            graph.addVertex("j");
            /*
            graph.addEdge(0,"D","C");
            graph.addEdge(0,"D","B");
            graph.addEdge(0,"E","C");
            graph.addEdge(0,"E","F");
            graph.addEdge(0,"B","A");
            graph.addEdge(0,"A","F");
            /*
            graph.addEdge(2,"a","c");
            graph.addEdge(9,"a","e");
            graph.addEdge(4,"b","a");
            graph.addEdge(5,"b","e");
            graph.addEdge(3,"c","f");
            graph.addEdge(6,"d","b");
            graph.addEdge(7,"d","e");
            graph.addEdge(5,"e","c");
            graph.addEdge(2,"e","f");
            graph.addEdge(7,"e","g");
            graph.addEdge(1,"e","h");
            graph.addEdge(7,"e","i");
            graph.addEdge(1,"f","h");
            graph.addEdge(8,"g","d");
            graph.addEdge(1,"g","i");
            graph.addEdge(9,"h","i");
            graph.addEdge(11,"j","l");
            graph.addEdge(12,"m","l");
            graph.printGraph();

            /*
             * A-2--C-3--F    J
             * |\   |   /|    |
             * 4 9  5  2 1    11
             * |  \ | /  |    |
             * |   \|/   |    |
             * B-5--E-1--H    L
             * |   /|\   |    |
             * 6  7 7 7  9    12
             * | /  |  \ |    |
             * |/   |   \|    |
             * D-8--G-1--I    M
            */

            //------
        }
    }

    public static int main(Intent i){
        switch (i.getIntExtra("previous",3)) { // This value shows which is the previous activity, with: 0-MainActivity/1-VertexActivity/2-EdgeActivity/3-Any other
            case 0:
                initiate(i);
                break;
            case 1:
                if(graph.addVertex(i.getStringExtra("vertex"))==-1) {
                    return 1;
                }else {
                    return 2;
                }
            case 2:
                switch (graph.addEdge(i.getIntExtra("weight", -1),i.getStringExtra("start"),i.getStringExtra("end"))){
                    case -1:
                        return 1;
                    case -2:
                        return 3;
                    case -3:
                        return 4;
                    default:
                        return 5;
                }
        }
        return 0;
    }
}
