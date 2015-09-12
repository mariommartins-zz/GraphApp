package com.src.graphapp.texts;

/**
 * Created by Guto on 14/08/2015.
 */
public class TextsEN {

    final static String[] menu = {
            "Insert a Vertex",
            "Insert an Edge",
            "Show Graph",
            "Kruskal",
            "Dijkstra",
            "Breadth-First Search",
            "Depth-First Search",
            "Topological Sorting",
            "Transitive Closure",
            "Floyd–Warshall",
            "Reference",
            "RESTART EMULATOR"
    };

    final static String[] insertion = {
            "Vertex insertion Completed!",
            "Edge insertion Completed!",
    };

    final static String[] error = {
            "ERROR" +
                    "\nYou cannot add a new vertex, the maximum number is 10.",
            "ERROR" +
                    "\nIt is not allowed edges from a vertex to itself.",
            "ERROR" +
                    "\nThis Edge already exists.",
            "ERROR" +
                    "\nVertex not found",
            "ERROR" +
                    "\n\"The graph is not directed.\"",
            "ERROR" +
                    "\nThe graph has cycle.",
            "ERROR" +
                    "\nThis Vertex already exist.",
            "ERROR" +
                    "\nThe only path with weight '0' is the path from a vertex to itself." +
                    "\nWhich can't be inserted."
    };

    final static String[] help = {
            "Select if you want to have a directed graph or/and a random graph.\n" +
                    "Tap just the NEXT button for none of these.",
            "Tap the option you would like to use in the list.\n" +
                    "Select the last item to restart the app.\n" +
                    "Tap twice the back button to close the app.",
            "Input the Vertex's Name in the given space and tap Insert to complete the operation.\n" +
                    "Tap the back button to return to the last view",
            "Input the Edge's Weight,Start and End in the given spaces and tap Insert to complete the operation.\n" +
                    "Tap the back button to return to the last view",
            "Tap the DESCRIPTION button for details about the algorithm.\n" +
                    "Tap the back button to return to the last view",
            "Tap the back button to return to the last view",
            "Input the asked vertex(s) in the given space(s) and tap next to see the result.\n" +
                    "Tap the back button to return to the last view",
    };

    final static String[] description = {"The Kruskal's algorithm, which is an example of a greedy algorithm (always conducting to the choice which seems to be the best at the moment), seeks a minimum spanning tree for a connected graph with weights. This means that it is a subset of edges forming a tree that includes all the vertices, wherein the total weight, given by the sum of the weights of the tree edges, is minimized. If the graph is not connected, then it finds a minimum spanning forest (a minimum spanning tree for each connected component of the graph).",
            "The Dijkstra's algorithm is (also of the \"greedy\" kind) solves the problem of the shortest path between two vertices in a graph weighted directed or undirected.",
            "A BFS is a search method that expands and systematically examines all vertices of a graph directed or undirected. The algorithm ensures that no vertex or edge is played more than once. For this, it uses a queue that ensures the analysis order of each vertex. It works as follows: Given a root, it is analyzed and its direct neighbors are queued. After this, we apply the same steps to the next item of the line, repeating the process until the queue is empty. An well known analogy to demonstrate the operation of the algorithm is painting the vertices of white, gray and black. The vertices in white represent the vertices that have not been marked nor queued, the gray color are the vertices that are in the queue structure and the black color are those who have had queued all its neighboring vertices and marked by algorithm.",
            "The DFS algorithm is used to perform a search or a crossing in a tree, tree structure, or graph. Intuitively, the algorithm starts at a root node (as our case is a graph, the node is previously informed by the user) and explores each of its branches as much as possible. When the end of the way is found, it goes back to the previous vertex to assess whether it is possible to continue the search for another of its neighbors. This process is repeated until all vertices be checked.",
            "The Topological Sorting algorithm is responsible for returning a linear order of the vertices such that the criterion of ordination is that any vertex which is son of another vertex should be in a lower order than its vertex \"father\". This makes it possible to see that a graph has more than a topological order, as there are vertices that are not related. A great use for this algorithm is to developing a task scheduler, given that there are some tasks that only can be completed if other tasks are completed. If the graph G(V, E) is undirected or contain at least a cycle, we can not set a topological order.",
            "The Transitive Closure Algorithm applied to a directed graph will return a new graph with all existent edges and some new edges creating ways between every two vertices of the graph that has a connecting path.",
            "The Floyd–Warshall Algorithm is used to calculate the distance of the shortest path between all vertices of a graph, two-for-two. The input of this algorithm is a graph G(V, E) and its output is an matrix | V | x | V | that contains the shortest distance between each vertex. In this case, this matrix has the diagonal zeroed, since the distance from one vertex to itself is zero (unless there is a distance to the own vertex in the input graph G).",
            "Is directed",
            "Is undirected",
            "Has cycle",
            "Has no cycle"
    };

    final static String[] complexity = {
            "The complexity of the Kruskal's algorithm for a graph G(V,E) in this case is:\n" +
                    "O(E lgV).\n\n" +
                    "p.s.: It's good to keep in mind that the running time of an algorithm depends of its implementation, for more information check the given reference in the Menu page",
            "The complexity of the Dijkstra's algorithm for a graph G(V,E) in this case is:\n" +
                    "O(V²).\n\n" +
                    "p.s.: It's good to keep in mind that the running time of an algorithm depends of its implementation, for more information check the given reference in the Menu page",
            "The complexity of the Breadth-First Search algorithm for a graph G(V,E) in this case is:\n" +
                    "O(V + E).\n\n" +
                    "p.s.: It's good to keep in mind that the running time of an algorithm depends of its implementation, for more information check the given reference in the Menu page",
            "The complexity of the Depth-First Search algorithm for a graph G(V,E) in this case is:\n" +
                    "O(V + E).\n\n" +
                    "p.s.: It's good to keep in mind that the running time of an algorithm depends of its implementation, for more information check the given reference in the Menu page",
            "The complexity of the Topological Sort algorithm for a graph G(V,E) in this case is:\n" +
                    "O(V + E).\n\n" +
                    "p.s.: It's good to keep in mind that the running time of an algorithm depends of its implementation, for more information check the given reference in the Menu page",
            "The complexity of the Transitive Closure algorithm for a graph G(V,E) in this case is:\n" +
                    "O(V³).\n\n" +
                    "p.s.: It's good to keep in mind that the running time of an algorithm depends of its implementation, for more information check the given reference in the Menu page",
            "The complexity of the Floyd-Warshall algorithm for a graph G(V,E) in this case is:\n" +
                    "O(V³).\n\n" +
                    "p.s.: It's good to keep in mind that the running time of an algorithm depends of its implementation, for more information check the given reference in the Menu page",
    };

    final static String reference =
            "Complexity:\n" +
            "Kruskal                (pg.633)\n" +
            "Dijkstra               (pg.662)\n" +
            "BFS                    (pg.597)\n" +
            "DFS                    (pg.606)\n" +
            "Topological Sort       (pg.613)\n" +
            "Transitive Closure     (pg.697)\n" +
            "Floyd Warshall         (pg.695)";


    public static String[] getMenu() {
        return menu;
    }

    public static String getMenuByPosition(int i) {
        return menu[i];
    }

    public static String getInsertionByPosition(int i) {
        return insertion[i];
    }

    public static String getErrorByPosition(int i) {
        return error[i];
    }

    public static String[] getHelp() {
        return help;
    }

    public static String getHelpByPosition(int i) {
        return help[i];
    }

    public static String getDescriptionByPosition(int i) {
        return description[i];
    }

    public static String getComplexityByPosition(int i) {
        return complexity[i];
    }

    public static String getReference(){
        return reference;
    }
}
