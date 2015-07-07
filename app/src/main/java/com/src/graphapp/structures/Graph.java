package com.src.graphapp.structures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * Created by Guto on 19/06/2015.
 */

public class Graph {
    private ArrayList<Edge> edges = new ArrayList<Edge>();
    private ArrayList<Vertex> vertices = new ArrayList<Vertex>();
    private boolean cycle = false;
    private boolean directed = false;

    public void clearLists() {
        this.edges.clear();
        this.vertices.clear();
        this.cycle = false;
    }

    public boolean isDirected() {
        return directed;
    }

    public void setDirected(boolean directed) {
        this.directed = directed;
    }

    public ArrayList<Vertex> getVertices() {
        return this.vertices;
    }

    public void printTree() {
        for (Edge edge: this.getEdges())
            System.out.print(edge.getStart().getName()
                    + edge.getEnd().getName() + " - "
                    + edge.getWeight() + " | ");
        System.out.println();
    }

    public void printVertices() {
        for (int i = 0; i < vertices.size(); i++) {
            System.out.print("{" + this.vertices.get(i));
            if (i < vertices.size() - 1)
                System.out.print(" ,");
        }
        System.out.println("}");
    }

    public void cleanVisitedVertex() {
        for (Vertex v: this.getVertices())
            v.setVisited(false);
    }

    public void cleanVisitedEdge() {
        for (Edge e: this.getEdges())
            e.setVisited(false);
    }

    public ArrayList<Edge> getEdges() {
        return this.edges;
    }

    public void addEdge(int weight, String start, String end) {
        int i, j, k;

        // add vertices getting its position
        i = this.addVertex(start);
        j = this.addVertex(end);

        // add edge in the list
        Edge a = new Edge(weight, this.vertices.get(i), this.vertices.get(j));

        if (!cycle)
            hasCycle(a);
        this.edges.add(a);
        k = this.edges.size();

        // add edge in the list of incident edges of each vertex
        this.vertices.get(i).addIncidents(this.edges.get(k - 1));
        this.vertices.get(j).addIncidents(this.edges.get(k - 1));
    }

    // add a vertex returning its position
    public int addVertex(String nome) {
        int i = this.vertexLocation(nome);

        if (i == this.vertices.size()) {
            this.vertices.add(new Vertex(nome));
            return (this.vertices.size() - 1);
        }

        return i;
    }

    // returns the location of a vertex in the list
    public int vertexLocation(String nome) {
        int i;

        for (i = 0; i < this.vertices.size(); i++)
            if (this.vertices.get(i).getName().equals(nome))
                return i;

        // if it is not found, returns the list's size
        return this.vertices.size();

    }

    public Vertex findVertex(String name) {
        return this.vertices.get(this.vertexLocation(name));
    }

    public Edge findEdge(Vertex vet1, Vertex vet2) {
        for (Edge e: this.edges) {
            if (((e.getStart().getName().equals(vet1.getName())) &&
                    (e.getEnd().getName().equals(vet2.getName()))) ||
                    ((e.getStart().getName().equals(vet2.getName())) &&
                            (e.getEnd().getName().equals(vet1.getName())))) {
                return e;
            }
        }
        return null;
    }

    public void cleanPreviousVertex() {
        for (Vertex v: this.getVertices())
            v.setPrevious(null);
    }

    public void cleanDistances() {
        for (Vertex v: this.getVertices())
            v.setDistance(0);
    }

    public boolean rightDirection(Edge edge,Vertex vertex){

        if (this.isDirected())
            if (edge.getStart().getName().equals(vertex.getName()))
                return true;
            else
                return false;

        return true;
    }

    public ArrayList<Edge> edgeListCreator (ArrayList<Vertex> pathVertex){
        ArrayList<Edge> pathEdge = new ArrayList<Edge>();
        Edge edge;

        for (int i = 0; i < pathVertex.size() - 1; i++) {
            edge = this.findEdge(pathVertex.get(i),
                    pathVertex.get(i + 1));
            pathEdge.add(edge);
        }

        return pathEdge;
    }

    public Graph graphCreator (ArrayList<Edge> pathEdge){
        Graph graph = new Graph();

        for (Edge e : pathEdge)
            graph.addEdge(e.getWeight(), e.getStart().getName(), e.getEnd().getName());

        return graph;
    }

    // ----------------------KRUSKAL--------------------------------------------

    public Graph kruskal() {
        Edge aux;
        Graph result = new Graph();

        for (int i = 0; i < this.getEdges().size(); i++) {
            // look for the unvisited edge with the lower weight
            aux = this.lowerWeight();
            // if the edge do not create a cycle, it is added to the Kruskal's
            // Tree (or forest)
            if (!result.hasCycle(aux)) {
                result.addEdge(aux.getWeight(), aux.getStart().getName(), aux
                        .getEnd().getName());
            }
        }

        return result;
    }

    // look for the unvisited edge with the lower weight
    public Edge lowerWeight() {
        int j;

        for (j = 0; j < this.getEdges().size(); j++) {
            if ((this.getEdges().get(j).isVisited() == false)) {
                this.getEdges().get(j).setVisited(true);

                for (int i = (j + 1); i < this.getEdges().size(); i++) {

                    if ((this.getEdges().get(i).isVisited() == false)
                            && (this.getEdges().get(j).getWeight() > this
                            .getEdges().get(i).getWeight())) {

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

    // method that returns whether a certain new edge can create a cycle or not
    // in the currentVertex graph
    public boolean hasCycle(Edge edge) {

        String start = edge.getStart().getName();
        String end = edge.getEnd().getName();

        for (int i = 0; i < this.getEdges().size(); i++) {

            for (Edge edge2: this.getEdges()) {

                if (edge != edge2) {

                    if (end.equals(edge2.getStart().getName())) {

                        if (start.equals(edge2.getEnd()
                                .getName())) {
                            this.cycle = true;
                            return true;
                        } else
                            end = edge2.getEnd().getName();

                    } else if (end.equals(edge2.getEnd()
                            .getName())) {

                        if (start.equals(edge2.getStart()
                                .getName())) {
                            this.cycle = true;
                            return true;
                        } else
                            end = edge2.getStart().getName();
                    }
                }
            }
        }
        this.cycle = false;
        return false;
    }

    // ----------------------DIJKSTRA-------------------------------------------

    public Graph dijkstra(String start, String end) {

        Vertex v1 = this.findVertex(start);
        Vertex v2 = this.findVertex(end);

        // List of Vertices of the found path
        ArrayList<Vertex> pathVertex = new ArrayList<Vertex>();

        // Vertex that is being verified in the moment
        Vertex currentVertex;

        // Edge between the Vertices currentVertex and neighbor
        Edge currentEdge;

        // List of the unvisited vertices in the graph
        ArrayList<Vertex> unvisited = new ArrayList<Vertex>();

        // Setting initial distances
        for (Vertex v : this.getVertices()) {
            // Set the distance of currentVertex to zero, and all others to
            // 9999(infinite)
            if (v.getName().equals(v1.getName()))
                v.setDistance(0);
            else
                v.setDistance(9999);
            // Insert all vertices in the unvisited list
            unvisited.add(v);
        }
        // Organize the unvisited list by the order of distances (the distance 0
        // will be the first)
        Collections.sort(unvisited);
        // Creating a loop to visit all vertices
        while (!unvisited.isEmpty()) {
            // Get the vertex with the lower distance (always the first of the
            // list unvisited)
            currentVertex = unvisited.get(0);
			/*
			 * For each unvisited neighbor of currentVertex, it is been done a
			 * calculation of its distance from the first vertex on the path.
			 * This calculation is done by the some of all weights of the
			 * visited edges in the way from the first vertex to the current
			 * neighbor If this distance is lower than the distance of its
			 * neighbor, the distance is updated with the lower one.
			 */

            for (Vertex neighbor : currentVertex.getNeighbors()) {

                currentEdge = this.findEdge(currentVertex, neighbor);

                // Case the Graph is directed, it checks if the currentVertex is
                // the Start of the Edge,
                // if it is not, the edge cannot be inserted on the path.

                if ((!neighbor.isVisited()) && rightDirection(currentEdge,currentVertex)) {

                    // Comparing the distance of neighbor with the distance
                    // added in the path till the currentVertex
                    if (neighbor.getDistance() > (currentVertex.getDistance() + currentEdge.getWeight())) {

                        neighbor.setDistance(currentVertex.getDistance()
                                + currentEdge.getWeight());
                        neighbor.setPrevious(currentVertex);

						/*
						 * If neighbor is equal to v2, and there was a change of
						 * distance, the list with the previous lower path is
						 * erased, since it is a path lower than this one, that
						 * is created by the neighbor and its previous vertices
						 * till v1.
						 */
                        if (neighbor == v2) {
                            pathVertex.clear();
                            pathVertex.add(neighbor);
                            while (neighbor.getPrevious() != null) {
                                pathVertex.add(neighbor.getPrevious());
                                neighbor = neighbor.getPrevious();
                            }
                            Collections.sort(pathVertex);
                        }
                    }
                }

            }
            // Sets currentVertex as visited and takes it out of the unvisited
            // list
            currentVertex.setVisited(true);
            unvisited.remove(currentVertex);

            Collections.sort(unvisited);

        }
        // clean the value "Vertex.Distance" and "Vertex.Previous" of each
        // Vertex in the graph.
        this.cleanDistances();
        this.cleanPreviousVertex();

        // Fills the pathEdge list with the existent edges between the vertices
        // of the pathVertex list (which has the lower path)
        // Fills a graph with the edges from the pathEdge list to be returned by
        // the function

        return graphCreator(edgeListCreator(pathVertex));
    }

    // ------------------BREADTH-FIRST-SEARCH---------------------------------------

    public Graph breadthFirstSearch(String start) {

        ArrayList<Edge> breadthTree = new ArrayList<Edge>();
        boolean stop = false;

        for (Vertex v : this.vertices) {
            v.setColor("white");
        }

        Vertex current = this.findVertex(start);
        current.setColor("grey");

        LinkedList<Vertex> queue = new LinkedList<Vertex>();
        queue.add(current);

        while (queue.size() > 0) {
            current = queue.remove();
            current.setColor("black");

            for (Vertex neighbor : current.getNeighbors()) {
                if (neighbor.getColor().equals("white") &&
                        this.rightDirection(this.findEdge(current, neighbor),current) ) {

                    neighbor.setColor("grey");
                    queue.add(neighbor);
                    breadthTree.add(this.findEdge(current, neighbor));
                }
            }
        }

        return graphCreator(breadthTree);
    }

//------------------DEPTH-FIRST-SEARCH----------------------------------

    //Calls the recursive method of Depth-First Search and returns a Graph with the result
    public	Graph depthFirstSearch(String start){

        ArrayList<Edge> depthTree = new ArrayList<Edge>();

        this.recursiveSearch(start);

        for (int i=0; i<this.edges.size(); i++){
            if(this.edges.get(i).isVisited())
                depthTree.add(this.edges.get(i));
        }

        return graphCreator(depthTree);
    }

    //Recursive method that return a boolean as response by the search for a vertex and sets as visited all the vertices and edges on the way.
    public boolean recursiveSearch(String start){

        int startIndex = this.vertexLocation(start);
        Edge edge;
        Vertex vertex;

        this.vertices.get(startIndex).setVisited(true);


        for(Vertex v: this.vertices.get(startIndex).getNeighbors()){

            if (!v.isVisited()){
                //Finds the edge between the vertices start and v.
                vertex = this.vertices.get(startIndex);
                edge = this.findEdge(vertex, v);
                //Sets this edge as visited and keep searching recursively considering if the graph is directed
                if (isDirected() && this.rightDirection(edge, vertex)){
                    edge.setVisited(true);
                    this.recursiveSearch(v.getName());
                }


            }
        }

        return true;
    }

//------------------ORDENACAO-TOPOLOGICA-----------------------------------

    public void DFS(Vertex v, ArrayList<Vertex> list) {
        v.setVisited(true);

        for (Vertex neighbor: v.getNeighbors()) {
            if(!neighbor.isVisited())
                DFS(neighbor, list);
        }

        list.add(v);
    }

    public ArrayList<Vertex> topologicalSort() {
        ArrayList<Vertex> order = new ArrayList<Vertex>();

        if(!this.directed){
            order.add(new Vertex("Not directed"));
        }else if(this.cycle){
            order.add(new Vertex("cycle"));
        }else{
            for(Vertex v:vertices){
                if(!v.isVisited())
                    DFS(v, order);
            }
        }

        Collections.reverse(order);
        return order;
    }

    // -------------------------------------------------------------------------
}