package com.src.graphapp.structures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

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

    public void setCycle(boolean cycle) {
        this.cycle = cycle;
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

        if(directed)
            System.out.println("directed");
        else
            System.out.println("undirected");
        if(cycle)
            System.out.println("cycle");
    }

    public void printVertices() {
        System.out.print("{");
        for (int i = 0; i < vertices.size(); i++) {
            System.out.print(this.vertices.get(i));
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

    public boolean addEdge(int weight, String start, String end) {
        int i, j, k;

        i=this.vertexLocation(start);
        j=this.vertexLocation(end);

        //Checking if the Vertices can be inserted (the maximum number of vertices is 10)
        if(vertices.size()>=9){
            k=vertices.size();
            if (i==vertices.size())
                k++;
            if (j==vertices.size())
                k++;
            if (k>vertices.size())
                return false;
        }


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

        return true;
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
        if (directed){
            for (Edge e: this.edges)
                if (((e.getStart().getName().equals(vet1.getName())) &&
                        (e.getEnd().getName().equals(vet2.getName()))))
                    return e;
        }else{
            for (Edge e: this.edges)
                if (((e.getStart().getName().equals(vet1.getName())) &&
                        (e.getEnd().getName().equals(vet2.getName()))) ||
                        ((e.getStart().getName().equals(vet2.getName())) &&
                                (e.getEnd().getName().equals(vet1.getName()))))
                    return e;
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
        graph.setDirected(directed);

        for (Edge e : pathEdge)
            graph.addEdge(e.getWeight(), e.getStart().getName(), e.getEnd().getName());


        return graph;
    }

    public int randomNumber (){

        // getting a Random number by the random function
        Random rn = new Random();
        int i = rn.nextInt() + 1;

        // always returning a random int between 3 and 10
        String o = Long.toString(System.currentTimeMillis() / i);
        o =  new StringBuilder(o).reverse().toString();
        char a = (char)o.charAt(0);
        int b = Character.getNumericValue(a);

        return b;
    }

    public void randomGraphCreator (){
        //1 - add vertices
        //2 - add edges
        //2.1 - pesos serão num aleatórios
        //2.2 - a existencia de uma edge entre vertices depende da paridade de um num aleatório

        //Adding Vertices
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        int b = this.randomNumber();

        if (b==0)
            b=10;
        else if((b==1)||(b==2))
            b=3;

        for(int i=0;i<=b; i++){
            this.addVertex(new StringBuilder().append(alphabet[i]).toString());
        }
        this.printVertices();
        //Adding Edges

        for(Vertex v1: vertices)
            for(Vertex v2: vertices)
                if (!v1.getName().equals(v2.getName())){
                    Edge edge = this.findEdge(v1, v2);
                    //if the random value is even and the edge doesn't exist, a edge will be added
                    if ((this.randomNumber() %2 == 0) && (edge==null)){

                        this.addEdge(this.randomNumber(), v1.getName(), v2.getName());
                    }
                }
        this.printTree();
    }

    // ----------------------KRUSKAL--------------------------------------------

    public Graph kruskal() {
        Edge aux;
        Graph result = new Graph();
        result.setDirected(directed);

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

            if (this.isDirected()){

                for (Edge edge2: this.getEdges()) {

                    if (edge != edge2) {

                        if (end.equals(edge2.getStart().getName())) {

                            if (start.equals(edge2.getEnd()
                                    .getName())) {
                                this.cycle = true;
                                return true;
                            } else
                                end = edge2.getEnd().getName();
                        }
                    }
                }
            }else{

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

                if ((!neighbor.isVisited()) && (currentEdge != null)) {

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
                Edge edge = this.findEdge(current, neighbor);
                if (neighbor.getColor().equals("white") &&
                        (edge != null) ) {

                    neighbor.setColor("grey");
                    queue.add(neighbor);
                    breadthTree.add(edge);
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
    public void recursiveSearch(String start){

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
                if (edge != null){
                    edge.setVisited(true);
                    this.recursiveSearch(v.getName());
                }


            }
        }
    }

    //------------------TOPOLOGICAL-SORTING-----------------------------------

    public void depthFirstTS(Vertex v, ArrayList<Vertex> list) {

        Edge edge;
        v.setVisited(true);

        for (Vertex neighbor: v.getNeighbors()) {
            edge = this.findEdge(v, neighbor);
            if( !neighbor.isVisited() && (edge != null) )
                depthFirstTS(neighbor, list);
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
                    depthFirstTS(v, order);
            }
        }

        Collections.reverse(order);
        return order;
    }

    //------------------TRANSITIVE-CLOSURE---------------------------------------

    public Graph transitiveClosure (){
        Graph graph = new Graph();
        int[][] weightsFW = this.floydWarshall();
        int weight;

        graph = this.graphCreator(this.edges);

        for(Vertex v1 : this.getVertices()){
            this.recursiveSearch(v1.getName());
            for(Vertex v2 : this.getVertices()){
                Edge edge = graph.findEdge(v1, v2);
                if (v2.isVisited()
                        && !(v1.getName().equals(v2.getName()))
                        && (edge==null) ){
                    weight = weightsFW[vertexLocation(v1.getName())][vertexLocation(v2.getName())];
                    graph.addEdge(weight, v1.getName(), v2.getName());
                }
            }
            //GUTOSSAURO DELICIA DA JAC

            this.cleanVisitedVertex();
        }

        return graph;
    }

    //------------------FLOYD-WARSHALL----------------------------------

    public int[][] createGraphMatrix(){
        int[][] matrix = new int[vertices.size()][vertices.size()];

        for(int i = 0; i < vertices.size(); i++){
            for(int j = 0; j < vertices.size(); j++){
                if(i==j){
                    matrix[i][j] = 0;
                } else {
                    Vertex v = vertices.get(i);
                    Edge e = findEdge(v , vertices.get(j));

                    if(e != null){
                        matrix[i][j] = e.getWeight();
                    } else {
                        matrix[i][j] = 999;//infinity
                    }
                }
            }
        }

        return matrix;
    }

    public int[][] floydWarshall(){
        int n = this.vertices.size();

        int[][] dist = createGraphMatrix();
        int[][] pred = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                pred[i][j] = 9;

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        pred[i][j] = k;
                    }
                }
            }
        }

    	/*System.out.print("  ");
		for(int i = 0; i < pred.length; i++){
			System.out.print(this.getVertices().get(i));
		}
		System.out.println();
		for(int i = 0; i < pred.length; i++){
			System.out.print(this.getVertices().get(i) + " ");
			for(int j = 0; j < pred.length; j++){
				System.out.print(pred[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();*/

        return dist;
    }

    // -------------------------------------------------------------------------
}