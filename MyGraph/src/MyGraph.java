import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class MyGraph {
    private int numVertices;
    private int numEdges;
    private HashMap<Vertex, ArrayList<GraphPairing>> graph;

    public MyGraph() {
        numEdges = 0;
        numVertices = 0;
        graph = new HashMap<>(); //don't know order, vertex, graphing pair
    }

    public int NumVertices() {
        return numVertices;
    }

    public int numEdges() {
        return numEdges;
    }

    public void insertVertex(String name) {
        Vertex temp = new Vertex(name);
        //assume for now, the given name does not exist in map
        graph.put(temp, null); //assume new vertex with no edges
        numVertices++;
    }

    public void print() {
        Set<Vertex> vertexArrayList = graph.keySet();

        for (Vertex v: vertexArrayList) {
            System.out.print(v + ": ");
            System.out.println(graph.get(v));
        }
    }

    //THis is O(2n) can we make this 0 (1n)
    //assumes v1 and v2 exist
    public void insertEdge(String v1, String v2, String edgeName) {
        Set<Vertex> vertices = graph.keySet();
        Vertex vertex1 = null;
        Vertex vertex2 = null;
        Edge edge = new Edge(edgeName);

        //add in // v != null && // to each if to prevent null pointer exception
        for (Vertex v: vertices) {
            if (v.compareTo(new Vertex(v1)) == 0)
                vertex1 = v;
            if (v.compareTo(new Vertex(v2)) == 0)
                vertex2 = v;
        }

        //System.out.println("Contains v1: " + graph.containsKey(vertex1));
        //System.out.println("Contains v2: " + graph.containsKey(vertex1));
        ArrayList<GraphPairing> v1EdgeList = graph.get(vertex1);
        if (v1EdgeList == null)
            graph.put(vertex1, new ArrayList<>());
        graph.get(vertex1).add(new GraphPairing(vertex2, edge));

        ArrayList<GraphPairing> v2EdgeList = graph.get(vertex2);
        if (v2EdgeList == null)
            graph.put(vertex2, new ArrayList<>());
        graph.get(vertex2).add(new GraphPairing(vertex1, edge));

        numEdges++;
    }

    public Set<Vertex> vertices() {
        return graph.keySet();
    }

    //add in // v != null && // to each if to prevent null pointer exception
    public Edge getEdge(Vertex u, Vertex v) {
        //graph.get(u);
        return null;
    }

    //we need to ochagne Vertex v1, v2 to STring v1, v2
    //get all the keys, loop and find the correct key w those names
    /*
    public void insertEdge(String v1, String v2, String edgeName) {
        //make vertices
        ArrayList<GraphPairing> gp1 = graph.get(v1);
        if (gp1 == null)
            gp1 = new ArrayList<>();
        gp1.add(new GraphPairing(v2, new Edge(edgeName)));

        ArrayList<GraphPairing> gp2 = graph.get(v2);
        if (gp2 == null)
            gp2 = new ArrayList<>();
        gp2.add(new GraphPairing(v1, new Edge(edgeName)));
    }

     */


}
