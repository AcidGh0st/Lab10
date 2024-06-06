package domain;

import domain.list.ListException;
import domain.queue.QueueException;
import domain.stack.StackException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



public class AdjacencyMatrixGraphTest {

    @Test
    void testMatrix() throws GraphException, ListException, StackException, QueueException {
        // Create the graph with 9 vertices (T, P, D, K, S, M, Q, A, R, B, G, H)
        AdjacencyMatrixGraph graph = new AdjacencyMatrixGraph(12);

        // Add vertices
        graph.addVertex('T');
        graph.addVertex('P');
        graph.addVertex('D');
        graph.addVertex('K');
        graph.addVertex('S');
        graph.addVertex('M');
        graph.addVertex('Q');
        graph.addVertex('A');
        graph.addVertex('R');
        graph.addVertex('B');
        graph.addVertex('G');
        graph.addVertex('H');

        graph.addEdge('T', 'P');
        graph.addEdge('T', 'D');
        graph.addEdge('P', 'K');
        graph.addEdge('K', 'S');
        graph.addEdge('S', 'M');
        graph.addEdge('M', 'Q');  // M -> Q is missing from the image but is added here based on the instructions
        graph.addEdge('S', 'A');
        graph.addEdge('R', 'G');
        graph.addEdge('G', 'H');
        graph.addEdge('B', 'R');


        // Add edges with random weights (color names)
        graph.addWeight('T', 'P', "red");
        graph.addWeight('T', 'D', "green");
        graph.addWeight('P', 'K', "blue");
        graph.addWeight('K', 'S', "orange");
        graph.addWeight('S', 'M', "black");
        graph.addWeight('M', 'Q', "purple");
        graph.addWeight('S', 'A', "yellow");
        graph.addWeight('R', 'G', "violet");
        graph.addWeight('G', 'H', "brown");
        graph.addWeight('B', 'R', "pink");


        System.out.println(graph.toString());


        System.out.println("DFS traversal: " + graph.dfs());


        System.out.println("BFS traversal: " + graph.bfs());


        graph.removeVertex('A');
        graph.removeVertex('E');
        graph.removeVertex('Q');


        System.out.println("\nGraph after removing vertices A, E, and Q:");
        System.out.println(graph.toString());
    }
}

