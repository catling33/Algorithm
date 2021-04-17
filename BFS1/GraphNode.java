package BFS1;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
    int key;
    List<GraphNode> neighbors;

    public GraphNode(int key) {
        this.key = key;
        this.neighbors = new ArrayList<>();
    }
}
