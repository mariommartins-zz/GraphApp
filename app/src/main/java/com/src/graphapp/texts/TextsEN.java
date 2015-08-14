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
            "Floyd–Warshall"
    };

    final static String[] insertion = {
            "Vertex insertion Completed!",
            "Maximum number of Vertices reach (10). Vertex not inserted!",
            "Edge insertion Completed!",
            "Maximum number of Vertices reach (10). Edge not inserted!"
    };

    final static String[] help = {
            "Select if you want to have a directed graph or/and a random graph. Tap just the NEXT button for none of these.",
            "Tap the option you would like to use in the list",
            "Put the Vertex's Name in the given space and tap Insert to complete the operation. Tap the Android's back button to return to the last view",
            "Put the Edge's Weight,Start and End in the given spaces and tap Insert to complete the operation. Tap the Android's back button to return to the last view",
            "Tap the DESCRIPTION button for details about the algorithm. Tap the Android's back button to return to the last view",
            "Tap the Android's back button to return to the last view"
    };

    final static String[] description = {"The Kruskal's algorithm, which is an example of a greedy algorithm (always conducting to the choice which seems to be the best at the moment), seeks a minimum spanning tree for a connected graph with weights. This means that it is a subset of edges forming a tree that includes all the vertices, wherein the total weight, given by the sum of the weights of the tree edges, is minimized. If the graph is not connected, then it finds a minimum spanning forest (a minimum spanning tree for each connected component of the graph).",
            "The Dijkstra's algorithm is (also of the \"greedy\" kind) solves the problem of the shortest path between two vertices in a graph weighted directed or undirected.",
            "A BFS is a search method that expands and systematically examines all vertices of a graph directed or undirected. The algorithm ensures that no vertex or edge is played more than once. For this, it uses a queue that ensures the analysis order of each vertex. It works as follows: Given a root, it is analyzed and its direct neighbors are queued. After this, we apply the same steps to the next item of the line, repeating the process until the queue is empty. An well known analogy to demonstrate the operation of the algorithm is painting the vertices of white, gray and black. The vertices in white represent the vertices that have not been marked nor queued, the gray color are the vertices that are in the queue structure and the black color are those who have had queued all its neighboring vertices and marked by algorithm.",
            "The DFS algorithm is used to perform a search or a crossing in a tree, tree structure, or graph. Intuitively, the algorithm starts at a root node (as our case is a graph, the node is previously informed by the user) and explores each of its branches as much as possible. When the end of the way is found, it goes back to the previous vertex to assess whether it is possible to continue the search for another of its neighbors. This process is repeated until all vertices be checked.",
            "The Topological Sorting algorithm is responsible for returning a linear order of the vertices such that the criterion of ordination is that any vertex which is son of another vertex should be in a lower order than its vertex \"father\". This makes it possible to see that a graph has more than a topological order, as there are vertices that are not related. A great use of this algorithm is to developing a task scheduler, given that there are some tasks that only can be completed if other tasks are completed. If the graph G(V, E) contains cycles, we can not set a topological order.",
            "The Transitive Closure Algorithm applied to a directed graph will return a new graph with all existent edges and some new edges creating ways between every two vertices of the graph that has a connecting path.",
            "The Floyd–Warshall Algorithm is used to calculate the distance of the shortest path between all vertices of a graph, two-for-two. The input of this algorithm is a graph G(V, E) and its output is an matrix | V | x | V | that contains the shortest distance between each vertex. In this case, this matrix has the diagonal zeroed, since the distance from one vertex to itself is zero (unless there is a distance to the own vertex in the input graph G)."
    };

    final static String[] complexity = {
            "The complexity of the Kruskal algorithm is given as follows:\n" +
                    "In a graph with 'n' nodes and 'a' edges, the number of operations is:\n" +
                    "(i) O(log a) to order the edges, which is equivalent to O(log n);\n" +
                    "(ii) O(n) to initialize the different sets of each connected component;\n" +
                    "(iii) In the worst case, O((2a+n-1)*lg n) to determine and mix related components;\n" +
                    "(iv) The (a) for the remaining operations.\n" +
                    "It follows that the total time for the Kruskal algorithm is O(log n)\n",
            "If | V | is the number of vertices and |E| the number of edges, so:\n" +
                    "(i) Initialization: T (V);\n" +
                    "(ii) Cycle \"while\" runs |V| times;\n" +
                    "(ii.1) All graph arcs are visited, vertices and edges;\n" +
                    "Total = O (V lg V + E lg V) = O ((V+E)lg V).",
            "Given a graph G (V,E) where V is the set of vertices and E the set of edges of the graph, in the worst case the algorithm represents a cost of O(|V|+|E|), where |E| means the total of all edges, and |V| means the number of vertices. The characteristic worst case occurs when the algorithm goes through all the vertices and all edges of the graph. One must realize that |V| represents the operations performed on the vertices, which is always constant (usually an operation that checks whether it is the sought vertex, mark as visited and dequeue) for each vertex, and |E| represents the operations carried out in each edge (usually the operation of picking up the neighbor's edge \"a\" of the graph).",
            "The space complexity of the search algorithm is much smaller in DFS than that in BFS. The temporal complexity is unique since it is proportional to the number of vertices plus the number of edges of the graph they traverse. However, when there are searches in very large graphs, the DFS can not finish because the operation of remember what were visited not work for lack of memory space. Analyzing this complexity, it is possible to see that the total cost of this algorithm is O(V+E), where V is the number of vertices and E the number of edges, that is, the same complexity of BFS.",
            "The complexity of the topological sort algorithm is given by the complexity of the DFS which is O(|V|+|E|) as explained above. In the case of our implementation, we have O(|V|+|E|) to the DFS method and O(|V|) to the operation of reversing the order of the list. with this the complexity is O(|V|+|E|) + O(|V|).",
            "The complexity is O(n³) because there is three repetition structure involved in the algorithm for interacting with the vertices that have paths with each other.",
            "The time complexity of the Warshall algorithm is defined by the 3 loops that pass through all the vertices. In this case, the complexity of this algorithm is O(n³). The algorithm is simple but practical in some mid-size entries."
    };


    public static String[] getMenu() {
        return menu;
    }

    public static String getMenuByPosition(int i) {
        return menu[i];
    }

    public static String getInsertionByPosition(int i) {
        return insertion[i];
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
}
