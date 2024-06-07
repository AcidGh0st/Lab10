package domain;

import domain.list.ListException;
import domain.queue.QueueException;
import domain.stack.StackException;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class AdjacencyListGraphTest {

    @Test
    void test() throws GraphException, ListException, StackException, QueueException {
        AdjacencyListGraph graph = new AdjacencyListGraph(50);

        for(int i = 0; i < 20; i++) {
            //Agrega 20 vertices
            graph.addVertex(util.Utility.getRandom(50));
        }

        //Eliminar duplicados en la representación del grafo
        System.out.println(removeDuplicateVertices(graph.toString()));

        graph.connectEvenOddVertices();

        //5 vértices pares y 5 vértices impares al azar
        connectRandomEvenOddVertices(graph);

        System.out.println("DFS traversal: " + graph.dfs());

        System.out.println("BFS traversal: " + graph.bfs());

        //Suprimir 5 vértices al azar
        for (int i = 0; i < 5; i++) {
            Vertex[] vertices = graph.getVertices();
            Vertex randomVertex = vertices[util.Utility.getRandom(vertices.length)];
            graph.removeVertex(randomVertex.data);
        }

        System.out.println("Graph content after deleting 5 random vertices:");
        System.out.println(removeDuplicateVertices(graph.toString()));
    }

    private static void connectRandomEvenOddVertices(AdjacencyListGraph graph) throws GraphException, ListException {
        Vertex[] evenVertices = graph.getEvenVertices();
        Vertex[] oddVertices = graph.getOddVertices();

        if (evenVertices.length < 5 || oddVertices.length < 5) {
            throw new GraphException("Not enough even or odd vertices to make 5 connections.");
        }

        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            int evenIndex = random.nextInt(evenVertices.length);
            int oddIndex = random.nextInt(oddVertices.length);

            //Obtener los vértices correspondientes a los índices aleatorios
            Object vertexA = evenVertices[evenIndex].data;
            Object vertexB = oddVertices[oddIndex].data;
            int weight = 100 + util.Utility.getRandom(101); //Generar un peso entre 100 y 200
            graph.addEdgeWeight(vertexA, vertexB, weight);
        }
    }

    private static String removeDuplicateVertices(String graphRepresentation) {
        String[] lines = graphRepresentation.split("\n");
        StringBuilder result = new StringBuilder();
        for (String line : lines) {
            result.append(line).append("\n");
        }
        return result.toString();
    }
}
