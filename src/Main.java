import Frontier.QueueBasedFrontier;
import Frontier.StackBasedFrontier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main (String[] args) {
        // define edges of the graph
        Graph.Node nodeS = new Graph.Node("S", 24);
        Graph.Node nodeA = new Graph.Node("A", 21);
        Graph.Node nodeB = new Graph.Node("B", 19);
        Graph.Node nodeC = new Graph.Node("C", 19);
        Graph.Node nodeD = new Graph.Node("D", 9);
        Graph.Node nodeE = new Graph.Node("E", 11);
        Graph.Node nodeF = new Graph.Node("F", 12);
        Graph.Node nodeG = new Graph.Node("G", 4);
        Graph.Node nodeH = new Graph.Node("H", 6);
        Graph.Node nodeZ = new Graph.Node("Z", 0);

        List<Graph.Node> nodes = Arrays.asList(nodeS, nodeA, nodeB, nodeC, nodeD, nodeE, nodeF, nodeG, nodeH, nodeZ);

        // call graph class Constructor to construct a graph
        Graph graph = new Graph(nodes);

        graph.addEdge(nodeS, nodeA, 3);
        graph.addEdge(nodeS, nodeB, 9);
        graph.addEdge(nodeS, nodeC, 4);
        graph.addEdge(nodeA, nodeC, 2);
        graph.addEdge(nodeB, nodeC, 13);

        graph.addEdge(nodeC, nodeD, 5);
        graph.addEdge(nodeC, nodeE, 8);
        graph.addEdge(nodeC, nodeF, 4);
        graph.addEdge(nodeD, nodeF, 5);
        graph.addEdge(nodeE, nodeF, 7);

        graph.addEdge(nodeF, nodeG, 8);
        graph.addEdge(nodeF, nodeH, 7);
        graph.addEdge(nodeF, nodeZ, 18);
        graph.addEdge(nodeG, nodeZ, 9);
        graph.addEdge(nodeH, nodeZ, 6);



        DFS(nodeS, nodeZ, graph);
        BFS(nodeS, nodeZ, graph);
    }

    private static void DFS(Graph.Node start, Graph.Node goal, Graph graph) {
        System.out.println("DFS: ");
        List<Graph.Node> dfsPath = graph.search(start, goal, new StackBasedFrontier<ArrayList<Graph.Node>>());
        System.out.print("- PATH: ");
        for (Graph.Node node: dfsPath) {
            System.out.print(node.label+ " ");
        }
        System.out.println("");
    }

    private static void BFS(Graph.Node start, Graph.Node goal, Graph graph) {
        System.out.println("BFS: ");
        List<Graph.Node> dfsPath = graph.search(start, goal, new QueueBasedFrontier<ArrayList<Graph.Node>>());
        System.out.print("- PATH: ");
        for (Graph.Node node: dfsPath) {
            System.out.print(node.label+ " ");
        }
        System.out.println("");
    }
}
