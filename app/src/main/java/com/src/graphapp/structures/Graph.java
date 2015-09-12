package com.src.graphapp.structures;

import com.src.graphapp.texts.TextsEN;

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
    private boolean connected = false;

    public void clearGraph() {
        edges.clear();
        vertices.clear();
        cycle = false;
        directed = false;
        connected = false;
    }

    public boolean isConnected() {
        return connected;
    }

    public boolean isDirected() {
        return directed;
    }

    public void setDirected(boolean d) {
        directed = d;
    }

    public ArrayList<Vertex> getVertices() {
        return vertices;
    }

    public String printGraph() {
        String stuart = "";

        for (Edge edge: getEdges()){
            stuart = stuart + edge.getStart().getName()
                    + edge.getEnd().getName() + " - "
                    + edge.getWeight() + " | ";
            edge.getStart().setVisited(true);
            edge.getEnd().setVisited(true);
        }
        for (Vertex v: vertices){
            if(!v.isVisited()){
                stuart = stuart + v.getName()+ " | ";
                v.setVisited(true);
            }
        }
        stuart = stuart + "\n";

        if(directed)
            stuart = stuart + TextsEN.getDescriptionByPosition(7) + "\n";
        else
            stuart = stuart + TextsEN.getDescriptionByPosition(8) + "\n";
        if(cycle)
            stuart = stuart + TextsEN.getDescriptionByPosition(9) + "\n";
        else
            stuart = stuart + TextsEN.getDescriptionByPosition(10) + "\n";
        cleanVisitedVertex();

        return stuart;
    }

    public String printVertices() {
        String stuart = "";

        stuart = stuart + "{";
        for (int i = 0; i < vertices.size(); i++) {
            stuart = stuart + vertices.get(i);
            if (i < vertices.size() - 1)
                stuart = stuart + " ,";
        }
        stuart = stuart + "}";

        return stuart;
    }

    public void cleanVisitedVertex() {
        for (Vertex v: getVertices())
            v.setVisited(false);
    }

    public void cleanVisitedEdge() {
        for (Edge e: getEdges())
            e.setVisited(false);
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public int addEdge(int weight, String start, String end) {
        int i, j, k;

        if (start.equals(end))
            return -2;
        if (findEdge(new Vertex(start), new Vertex(end))!=null) //Edge already exists
            return -3;
        if (weight == 0)
            return -4;

        i=vertexLocation(start);
        j=vertexLocation(end);
        k = vertices.size();

        //Checking if the Vertices can be inserted (the maximum number of vertices is 10)
        if(vertices.size()>=9){
            if (i==vertices.size())
                k++;
            if (j==vertices.size())
                k++;
            if (k>10)
                return -1;
        }

        // adding vertices and getting the position of each one
        if (i==k)
            i = addVertex(start);
        if (j==k)
            j = addVertex(end);

        // add edge in the list
        Edge a = new Edge(weight, vertices.get(i), vertices.get(j));

        if (!cycle)
            hasCycle(a);

        edges.add(a);
        k = edges.size();

        // add edge in the list of incident edges of each vertex
        vertices.get(i).addIncidents(edges.get(k - 1));
        vertices.get(j).addIncidents(edges.get(k - 1));

        if (!connected)
            setConnected();

        return (edges.size() -1);
    }

    public boolean setConnected(){
        String start = vertices.get(0).getName();

        ArrayList<Vertex> breadthTree = new ArrayList<Vertex>();

        for (Vertex v : vertices) {
            v.setColor("white");
        }

        Vertex current = findVertex(start);
        current.setColor("grey");

        LinkedList<Vertex> queue = new LinkedList<Vertex>();
        queue.add(current);

        while (queue.size() > 0) {
            current = queue.remove();
            current.setColor("black");

            for (Vertex neighbor : current.getNeighbors()) {
                Edge edge = findEdge(current, neighbor);
                if (neighbor.getColor().equals("white") &&
                        (edge != null) ) {

                    neighbor.setColor("grey");
                    queue.add(neighbor);
                    breadthTree.add(current);
                    breadthTree.add(neighbor);
                }
            }
        }

        if(breadthTree.size()<vertices.size())
            return false;

        connected = true;
        return true;
    }

    // add a vertex returning its position or '-1' if the insertion was not possible
    public int addVertex(String nome) {
        int i = vertexLocation(nome);

        //Checking if the Vertex already exist
        if(i!=vertices.size())
            return -2;
        //Checking if the Vertex can be inserted (the maximum number of vertices is 10)
        if (vertices.size()==10)
            return -1;

        if (i == vertices.size()) {
            vertices.add(new Vertex(nome));
            connected = false;
            return (vertices.size() - 1);
        }

        return i;

    }

    // returns the location of a vertex in the list
    public int vertexLocation(String nome) {
        int i;

        for (i = 0; i < vertices.size(); i++)
            if (vertices.get(i).getName().equals(nome))
                return i;

        // if it is not found, returns the list's size
        return vertices.size();

    }

    public Vertex findVertex(String name) {
        return vertices.get(vertexLocation(name));
    }

    public Edge findEdge(Vertex vet1, Vertex vet2) {
        if (!vet1.equals(vet2)) {
            if (directed) {
                for (Edge e : edges)
                    if (((e.getStart().getName().equals(vet1.getName())) &&
                            (e.getEnd().getName().equals(vet2.getName()))))
                        return e;
            } else {
                for (Edge e : edges)
                    if (((e.getStart().getName().equals(vet1.getName())) &&
                            (e.getEnd().getName().equals(vet2.getName()))) ||
                            ((e.getStart().getName().equals(vet2.getName())) &&
                                    (e.getEnd().getName().equals(vet1.getName()))))
                        return e;
            }
        }
        return null;

    }

    public void cleanPreviousVertex() {
        for (Vertex v: getVertices())
            v.setPrevious(null);
    }

    public void cleanDistances() {
        for (Vertex v: getVertices())
            v.setDistance(0);
    }

    public ArrayList<Edge> edgeListCreator (ArrayList<Vertex> pathVertex){
        ArrayList<Edge> pathEdge = new ArrayList<Edge>();
        Edge edge;

        for (int i = 0; i < pathVertex.size() - 1; i++) {
            edge = findEdge(pathVertex.get(i),
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

        return Character.getNumericValue(a);
    }

    public void randomGraphCreator (){
        //1 - add vertices
        //2 - add edges
        //2.1 - pesos serão num aleatórios
        //2.2 - a existencia de uma edge entre vertices depende da paridade de um num aleatório

        //Adding Vertices
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        int b = randomNumber();

        if (b==0)
            b=10;
        else if((b==1)||(b==2))
            b=3;

        for(int i=0;i<=b; i++){
            addVertex(new StringBuilder().append(alphabet[i]).toString());
        }
        printVertices();
        //Adding Edges

        for(Vertex v1: vertices)
            for(Vertex v2: vertices)
                if (!v1.getName().equals(v2.getName())){
                    Edge edge = findEdge(v1, v2);
                    //if the random value is even and the edge doesn't exist, a edge will be added
                    if ((randomNumber() %2 == 0) && (edge==null)){

                        addEdge(randomNumber(), v1.getName(), v2.getName());
                    }
                }
        printGraph();
    }

    // ----------------------KRUSKAL--------------------------------------------

    public Graph kruskal() {
        Edge edge;
        Graph result = new Graph();
        result.setDirected(directed);
        result.addVertex(this.getVertices().get(0).getName()); //adding the first vertex

        for (int i = 0; i < getEdges().size(); i++) {
            // look for the unvisited edge with the lower weight
            edge = lowerWeight();
            String start = edge.getStart().getName();
            String end = edge.getEnd().getName();
            int size = result.getVertices().size();
            // if the edge do not create a cycle and one of the vertices is not in the result graph, it is added to the Kruskal's graph
            // Tree (or forest)
            if ((!result.hasCycle(edge)) &&
                    ((result.vertexLocation(start)==size)||(result.vertexLocation(end)==size)||(result.isConnected()!=isConnected()))){
                result.addEdge(edge.getWeight(), start, end);
            }
        }

        for (Vertex v: vertices){
            if(result.vertexLocation(v.getName())==result.getVertices().size()||!result.isConnected()){
                result.addVertex(v.getName());
            }
        }

        return result;
    }

    // look for the unvisited edge with the lower weight
    public Edge lowerWeight() {
        int j;

        for (j = 0; j < getEdges().size(); j++) {
            if ((getEdges().get(j).isVisited() == false)) {
                getEdges().get(j).setVisited(true);

                for (int i = (j + 1); i < getEdges().size(); i++) {

                    if ((getEdges().get(i).isVisited() == false)
                            && (getEdges().get(j).getWeight() > getEdges().get(i).getWeight())) {

                        getEdges().get(j).setVisited(false);
                        j = i;
                        getEdges().get(j).setVisited(true);
                    }
                }

                break;
            }
        }

        return getEdges().get(j);
    }

    // method that returns whether a certain new edge can create a cycle or not
    // in the currentVertex graph
    public boolean hasCycle(Edge edge) {

        String start = edge.getStart().getName();
        String end = edge.getEnd().getName();

        for (int i = 0; i < getEdges().size(); i++) {

            if (isDirected()){

                for (Edge edge2: getEdges()) {

                    if (edge != edge2) {

                        if (end.equals(edge2.getStart().getName())) {

                            if (start.equals(edge2.getEnd()
                                    .getName())) {
                                cycle = true;
                                return true;
                            } else
                                end = edge2.getEnd().getName();
                        }
                    }
                }
            }else{

                for (Edge edge2: getEdges()) {

                    if (edge != edge2) {

                        if (end.equals(edge2.getStart().getName())) {

                            if (start.equals(edge2.getEnd()
                                    .getName())) {
                                cycle = true;
                                return true;
                            } else
                                end = edge2.getEnd().getName();

                        } else if (end.equals(edge2.getEnd()
                                .getName())) {

                            if (start.equals(edge2.getStart()
                                    .getName())) {
                                cycle = true;
                                return true;
                            } else
                                end = edge2.getStart().getName();
                        }
                    }
                }
            }

        }
        cycle = false;
        return false;
    }

    // ----------------------DIJKSTRA-------------------------------------------

    public Graph dijkstra(String start, String end) {

        Vertex v1 = findVertex(start);
        Vertex v2 = findVertex(end);

        // List of Vertices of the found path
        ArrayList<Vertex> pathVertex = new ArrayList<Vertex>();

        // Vertex that is being verified in the moment
        Vertex currentVertex;

        // Edge between the Vertices currentVertex and neighbor
        Edge currentEdge;

        // List of the unvisited vertices in the graph
        ArrayList<Vertex> unvisited = new ArrayList<Vertex>();

        // Setting initial distances
        for (Vertex v : getVertices()) {
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

                currentEdge = findEdge(currentVertex, neighbor);

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
        cleanDistances();
        cleanPreviousVertex();

        // Fills the pathEdge list with the existent edges between the vertices
        // of the pathVertex list (which has the lower path)
        // Fills a graph with the edges from the pathEdge list to be returned by
        // the function

        return graphCreator(edgeListCreator(pathVertex));
    }

    // ------------------BREADTH-FIRST-SEARCH---------------------------------------

    public Graph breadthFirstSearch(String start) {

        ArrayList<Edge> breadthTree = new ArrayList<Edge>();

        for (Vertex v : vertices) {
            v.setColor("white");
        }

        Vertex current = findVertex(start);
        current.setColor("grey");

        LinkedList<Vertex> queue = new LinkedList<Vertex>();
        queue.add(current);

        while (queue.size() > 0) {
            current = queue.remove();
            current.setColor("black");

            for (Vertex neighbor : current.getNeighbors()) {
                Edge edge = findEdge(current, neighbor);
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
    public Graph depthFirstSearch(String start){

        ArrayList<Edge> depthTree = new ArrayList<Edge>();

        recursiveSearch(start);

        for (int i=0; i<edges.size(); i++){
            if(edges.get(i).isVisited())
                depthTree.add(edges.get(i));
        }

        return graphCreator(depthTree);
    }

    //Recursive method that return a boolean as response by the search for a vertex and sets as visited all the vertices and edges on the way.
    public void recursiveSearch(String start){

        int startIndex = vertexLocation(start);
        Edge edge;
        Vertex vertex;

        vertices.get(startIndex).setVisited(true);


        for(Vertex v: vertices.get(startIndex).getNeighbors()){

            if (!v.isVisited()){
                //Finds the edge between the vertices start and v.
                vertex = vertices.get(startIndex);
                edge = findEdge(vertex, v);
                //Sets this edge as visited and keep searching recursively considering if the graph is directed
                if (edge != null){
                    edge.setVisited(true);
                    recursiveSearch(v.getName());
                }


            }
        }
    }

    //------------------TOPOLOGICAL-SORTING-----------------------------------

    public void depthFirstTS(Vertex v, ArrayList<Vertex> list) {

        Edge edge;
        v.setVisited(true);

        for (Vertex neighbor: v.getNeighbors()) {
            edge = findEdge(v, neighbor);
            if( !neighbor.isVisited() && (edge != null) )
                depthFirstTS(neighbor, list);
        }

        list.add(v);
    }

    public ArrayList<Vertex> topologicalSort() {
        ArrayList<Vertex> order = new ArrayList<Vertex>();

        if(!directed){
            order.add(new Vertex("Not directed"));
        }else if(cycle){
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
        Graph graph;
        Integer[][] weightsFW = floydWarshall();
        int weight;

        graph = graphCreator(edges);

        for(Vertex v1 : getVertices()){
            recursiveSearch(v1.getName());
            for(Vertex v2 : getVertices()){
                Edge edge = graph.findEdge(v1, v2);
                if (v2.isVisited()
                        && !(v1.getName().equals(v2.getName()))
                        && (edge==null) ){
                    weight = weightsFW[vertexLocation(v1.getName())][vertexLocation(v2.getName())];
                    graph.addEdge(weight, v1.getName(), v2.getName());
                }
            }
            //GUTOSSAURO DELICIA DA JAC

            cleanVisitedVertex();
        }

        for (Vertex v: vertices){
            if(graph.vertexLocation(v.getName())==graph.getVertices().size()){
                graph.addVertex(v.getName());
            }
        }
        return graph;
    }

    //------------------FLOYD-WARSHALL----------------------------------

    public Integer[][] createGraphMatrix(){
        int n = vertices.size();
        Integer[][] matrix = new Integer[n][n];

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

    public Integer[][] floydWarshall(){
        int n = vertices.size();

        Integer[][] dist = createGraphMatrix();
        Integer[][] pred = new Integer[n][n];

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
			System.out.print(getVertices().get(i));
		}
		System.out.println();
		for(int i = 0; i < pred.length; i++){
			System.out.print(getVertices().get(i) + " ");
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