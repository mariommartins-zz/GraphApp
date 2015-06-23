package com.src.graphapp.structures;

/**
 * Created by Guto on 19/06/2015.
 */
public class Edge {

    private int weight;
    private Vertex start;
    private Vertex end;
    private boolean visited = false;


    public Edge(int weight, Vertex start, Vertex end) {
        this.setWeight(weight);
        this.setStart(start);
        this.setEnd(end);
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Vertex getStart() {
        return start;
    }

    public void setStart(Vertex start) {

        this.start = start;
    }

    public Vertex getEnd() {
        return end;
    }

    public void setEnd(Vertex end) {

        this.end = end;
    }

    @Override
    public String toString() {
        String s = " ";
        s+= this.getStart().getName() + this.getEnd().getName();
        return s;
    }

}