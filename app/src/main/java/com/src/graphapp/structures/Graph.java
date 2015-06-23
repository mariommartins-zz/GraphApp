package com.src.graphapp.structures;

import java.util.ArrayList;

/**
 * Created by Guto on 19/06/2015.
 */


public class Graph {
    private ArrayList<Edge> edges = new ArrayList<Edge>();
    private ArrayList<Vertex> vertices = new ArrayList<Vertex>();
    private boolean cycle = false;
    private boolean directed;

    public void clearLists(){
        this.edges.clear();
        this.vertices.clear();
        this.cycle = false;
    }

    public ArrayList<Vertex> getVertices() {
        return this.vertices;
    }

    public void printTree(){
        for (int i=0; i<edges.size();i++)
            System.out.print(this.edges.get(i).getStart().getName() + this.edges.get(i).getEnd().getName() + " - " + this.edges.get(i).getWeight() + " | ");
        System.out.println();
    }

    public void cleanVisitedVertex(){
        for(int i=0; i<this.getVertices().size() ;i++)
            this.getVertices().get(i).setVisited(false);
    }

    public void cleanVisitedEdge(){
        for(int i=0; i<this.getEdges().size() ;i++)
            this.getEdges().get(i).setVisited(false);
    }

    public ArrayList<Edge> getEdges() {
        return this.edges;
    }

    public void addEdge(int weight, String start, String end){
        int i,j,k;

        //add vertices getting its position
        i = this.addVertex(start);
        j = this.addVertex(end);

        //add edge in the list
        Edge a = new Edge(weight,
                this.vertices.get(i),
                this.vertices.get(j));

        hasCycle(a);
        this.edges.add(a);
        k = this.edges.size();

        //add edge in the list of incident edges of each vertex
        this.vertices.get(i).addIncidents(this.edges.get(k-1));
        this.vertices.get(j).addIncidents(this.edges.get(k-1));
    }

    //add a vertex returning its position
    public int addVertex(String nome){
        int i= this.vertexLocation(nome);

        if(i==this.vertices.size()){
            this.vertices.add(new Vertex(nome));
            return (this.vertices.size() - 1);
        }

        return i;
    }

    //returns the location of a vertex in the list
    public int vertexLocation(String nome){
        int i;

        for (i=0; i<this.vertices.size() ; i++)
            if (this.vertices.get(i).getName().equals(nome))
                return i;

        //if it is not found, returns the list's size
        return this.vertices.size();

    }

    //----------------------KRUSKAL--------------------------------------------

    public Graph kruskal(){
        Edge aux;
        Graph result = new Graph();

        for(int i=0;i<this.getEdges().size();i++){
            //look for the unvisited edge with the lower weight
            aux= this.lowerWeight();
            //if the edge do not create a cycle, it is added to the Kruskal's Tree (or forest)
            if(!result.hasCycle(aux)){
                result.addEdge(aux.getWeight(),
                        aux.getStart().getName(),
                        aux.getEnd().getName());
            }
        }

        return result;
    }

    //look for the unvisited edge with the lower weight
    public Edge lowerWeight(){
        int j;

        for(j=0; j<this.getEdges().size() ;j++){
            if((this.getEdges().get(j).isVisited()==false)){
                this.getEdges().get(j).setVisited(true);

                for(int i=(j+1); i<this.getEdges().size() ;i++){

                    if ((this.getEdges().get(i).isVisited()==false) &&
                            (this.getEdges().get(j).getWeight() > this.getEdges().get(i).getWeight())){


                        this.getEdges().get(j).setVisited(false);
                        j = i;
                        this.getEdges().get(j).setVisited(true);
                    }
                }

                break;
            }
        }

        return this.getEdges().get(j);
    }

    //method that returns whether a certain new edge can create a cycle or not in the current graph
    public boolean hasCycle(Edge edge){

        String start = edge.getStart().getName();
        String end = edge.getEnd().getName();

        for(int j=0; j<this.getEdges().size() ;j++){

            for(int i=0; i<this.getEdges().size() ;i++){

                if (edge!=this.getEdges().get(i)){

                    if (end.equals(this.getEdges().get(i).getStart().getName())){

                        if	(start.equals(this.getEdges().get(i).getEnd().getName())){
                            this.cycle = true;
                            return true;
                        }else
                            end = this.getEdges().get(i).getEnd().getName();

                    }else if (end.equals(this.getEdges().get(i).getEnd().getName())){

                        if	(start.equals(this.getEdges().get(i).getStart().getName())){
                            this.cycle = true;
                            return true;
                        }else
                            end = this.getEdges().get(i).getStart().getName();
                    }
                }
            }
        }
        this.cycle = false;
        return false;
    }

    //-------------------------------------------------------------------------
}
