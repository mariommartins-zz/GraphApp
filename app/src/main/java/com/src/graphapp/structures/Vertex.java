package com.src.graphapp.structures;

/**
 * Created by Guto on 19/06/2015.
 */
import java.util.ArrayList;


public class Vertex implements Comparable<Vertex> {
    private String name;
    private int distance;
    private Vertex previous;
    private ArrayList<Edge> incidentnts = new ArrayList<Edge>();
    private ArrayList<Vertex> neighbors = new ArrayList<Vertex>();
    private boolean visited = false;
    private String color = "white";

    public Vertex(String name){
        this.setName(name);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Vertex getPrevious() {
        return previous;
    }

    public void setPrevious(Vertex previous) {
        this.previous = previous;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public ArrayList<Edge> getIncidents() {
        return incidentnts;
    }

    public void addIncidents(Edge incident) {
        this.incidentnts.add(incident);

        //adicionando neighbors a lista
        if ( (incident.getStart().getName().equals(this.getName())) &&
                (!this.isNeighbor(incident.getEnd())) ){

            this.addNeighbors(incident.getEnd());

        }else if ( (incident.getEnd().getName().equals(this.getName())) &&
                (!this.isNeighbor(incident.getStart())) ){

            this.addNeighbors(incident.getStart());
        }
    }

    public void addNeighbors(Vertex neighbor) {
        this.neighbors.add(neighbor);
    }

    public ArrayList<Vertex> getNeighbors() {
        return neighbors;
    }

    public boolean isNeighbor(Vertex neighbor){
        int i;

        for (i=0; i<this.neighbors.size() ; i++)
            if (this.neighbors.get(i).getName().equals(neighbor.getName()))
                return true;

        return false;
    }

    @Override
    public String toString() {
        String s = " ";
        s+= this.getName();
        return s;
    }

    @Override
    public int compareTo(Vertex vertex) {

        if(this.getDistance() < vertex.getDistance())
            return -1;
        else if(this.getDistance() == vertex.getDistance())
            return 0;

        return 1;
    }
}