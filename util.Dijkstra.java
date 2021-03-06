package util;
import java.util.*;

public class Dijkstra{

    // Member variables of the class
    private int distance[];
    private Set<Integer> settld;
    private PriorityQueue<Node> pQue;

    // Total count of the vertices
    private int totalNodes;
    List<List<Node>> adjacent;

    // Constructor of the class
    public Dijkstra(int totalNodes) {
        this.totalNodes = totalNodes;
        distance = new int[totalNodes];
        settld = new HashSet<Integer>();
        pQue = new PriorityQueue<Node>(totalNodes, new Node());
    }

    public void dijkstra(List<List<Node>> adjacent2, int s) {
        this.adjacent = adjacent2;

        for (int j = 0; j < totalNodes; j++) {
            // initializing the distance of every node to infinity (a large number)
            distance[j] = Integer.MAX_VALUE;
        }

        // Adding the source node to pQue
        pQue.add(new Node(s, 0));

        // distance of the source is always zero
        distance[s] = 0;

        while (settld.size() != totalNodes) {

            // Terminating condition check when the priority queue contains zero elements, return
            if (pQue.isEmpty()) return;

            // Deleting the node that has the minimum distance from the priority queue
            int ux = pQue.remove().n;

            // Adding the node whose distance is confirmed
            if (settld.contains(ux)) continue;

            // We don't have to call eNeighbors(ux) if ux is already present in the settled set.
            settld.add(ux);
            eNeighbours(ux);
        }
    }

    private void eNeighbours(int ux) {

        int edgeDist = -1;
        int newDist = -1;

        // All of the neighbors of vx
        for (int j = 0; j < adjacent.get(ux).size(); j++) {
            Node vx = adjacent.get(ux).get(j);

            // If the current node hasn't been already processed
            if (!settld.contains(vx.n)) {
                edgeDist = vx.price;
                newDist = distance[ux] + edgeDist;

                // If the new distance is lesser in the cost
                if (newDist < distance[vx.n]) distance[vx.n] = newDist;

                // Adding the current node to the priority queue pQue
                pQue.add(new Node(vx.n, distance[vx.n]));
            }
        }
    }

    public int get_distance(int vertex){
        return distance[vertex];
    }

    // Main method
    public static void main(String argvs[]) {

        int totalNodes = 9;
        int s = 0;

        // representation of the connected edges using the adjacency list
        // by declaration of the List class object

        // Declaring and object of the type List<Node>
        List<List<Node>> adjacent = new ArrayList<List<Node>>();

        // Initialize list for every node
        for (int i = 0; i < totalNodes; i++) {
            List<Node> itm = new ArrayList<Node>();
            adjacent.add(itm);
        }

        /* adding the edges
         The statement adjacent.get(0).add(new Node(1, 3)); means to travel from node 0 to 1, 
         one has to cover 3 units of distance it does not mean one has to travel from 1 to 0
         To travel from 1 to 0, we have to add the statement adjacent.get(1).add(new Node(0, 3));
         Note that the distance is the same i.e., 3 units in both the cases.
         Similarly, we have added other edges too. 
                     from           to  weight    */
        adjacent.get(0).add(new Node(1, 3));

        // creating an object of the class DijkstraExample1
        Dijkstra obj = new Dijkstra(totalNodes);
        obj.dijkstra(adjacent, s);

        //for (int j = 0; j < obj.distance.length; j++) {
        //    System.out.println(s + " to " + j + " is " + obj.distance[j]);
        //}
    }
}
