import Frontier.Frontier;

import java.util.*;


// Graph class
class Graph {
    // node of adjacency list
    static class Node {
        String label;
        int value;

        public Node(String label, int value) {
            this.label = label;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return value == node.value && Objects.equals(label, node.label);
        }

        @Override
        public int hashCode() {
            return Objects.hash(label, value);
        }
    };

    //class to store edges of the weighted graph
    static class Edge {
        Node src, dest;
        int weight;
        Edge(Node src, Node dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Edge edge = (Edge) o;
            return weight == edge.weight && Objects.equals(src, edge.src) && Objects.equals(dest, edge.dest);
        }

        @Override
        public int hashCode() {
            return Objects.hash(src, dest, weight);
        }
    }

    // define adjacency list
    Map<Node, List<Edge>> adj_list = new HashMap<>();

    //Graph Constructor
    public Graph(List<Node> nodes)
    {
        // adjacency list memory allocation
        for (Node node: nodes) {
            adj_list.put(node, new ArrayList<>());
        }
    }

    public void addEdge(Node src, Node dst, int weight) {
        Edge edge = new Edge(src, dst, weight);
        adj_list.get(src).add(edge);
    }

    // print adjacency list for the graph
    public static void printGraph(Graph graph)  {
        for (Node key: graph.adj_list.keySet()) {
            List<Edge> edgeList = graph.adj_list.get(key);
            for (Edge edge: edgeList) {
                System.out.println(edge.src.label + " is connected to " + edge.dest.label + " with weight " + edge.weight);
            }
        }
    }

    public <F> List<Node> search(Node start, Node goal, Frontier<ArrayList<Node>> frontier) {
        ArrayList<Node> firstPath = new ArrayList<>();
        firstPath.add(start);
        List<Node> expanded = new ArrayList<>();
        frontier.add(firstPath);

        while (!frontier.isEmpty()) {
            ArrayList<Node> selectedPath = frontier.remove();
            Node endNode = selectedPath.get(selectedPath.size()-1);
            expanded.add(endNode);
            if(endNode.equals(goal)) {
                System.out.print("- EXPANDED: ");
                for (Node node: expanded) {
                    System.out.print(node.label+" ");
                }
                System.out.println(" ");

                return selectedPath;
            }

            List<Edge> neighbors = adj_list.get(endNode);

            for (Edge edge: neighbors) {
                ArrayList<Node> newPath = new ArrayList<>(selectedPath);
                newPath.add(edge.dest);
                frontier.add(newPath);
            }
        }

        System.out.print("- EXPANDED: ");
        for (Node node: expanded) {
            System.out.print(node.label+" ");
        }
        System.out.println(" ");

        return new ArrayList<>();
    }
}
