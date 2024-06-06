package controller;

import domain.AdjacencyMatrixGraph;
import domain.GraphException;
import domain.list.ListException;
import domain.queue.QueueException;
import domain.stack.StackException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.control.DialogPane;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class AdjacencyMatrixGraphController {

    @FXML
    private Button btn_DFS;
    @FXML
    private Button btn_Randomize;
    @FXML
    private Button btn_ContainsVertex;
    @FXML
    private Button btn_BFS;
    @FXML
    private Pane pane_Grafo;
    @FXML
    private Button btn_ToString;
    @FXML
    private Button btn_ContainsEdge;
    @FXML
    private BorderPane bp;

    private AdjacencyMatrixGraph graph;

    @FXML
    public void initialize() {
        graph = new AdjacencyMatrixGraph(10);
    }

    @FXML
    public void RandomizeOnAction(ActionEvent actionEvent) {
        Random rand = new Random();
        Set<Integer> vertices = new HashSet<>();
        while (vertices.size() < 10) {
            vertices.add(rand.nextInt(100));
        }

        try {
            graph.clear();
            for (Integer v : vertices) {
                graph.addVertex(v);
            }

            for (int i = 0; i < 10; i++) {
                for (int j = i + 1; j < 10; j++) {
                    if (rand.nextBoolean()) { // Decide aleatoriamente si se debe agregar una arista
                        graph.addEdge(vertices.toArray()[i], vertices.toArray()[j]);
                    }
                }
            }

            drawGraph();
        } catch (GraphException | ListException e) {
            showAlert(e.getMessage());
        }
    }



    @FXML
    public void ContainsVertexOnAction(ActionEvent actionEvent) {
        try {
            int vertexCount = graph.size();
            String message = "The graph contains " + vertexCount + " vertices.";
            showAlert(message);
        } catch (ListException e) {
            showAlert(e.getMessage());
        }
    }

    @FXML
    public void ContainsEdgeOnAction(ActionEvent actionEvent) {
        try {
            int edgeCount = 0;
            Object[][] adjacencyMatrix = graph.getAdjacencyMatrix();
            for (int i = 0; i < graph.size(); i++) {
                for (int j = i + 1; j < graph.size(); j++) {
                    if (!adjacencyMatrix[i][j].equals(0)) {
                        edgeCount++;
                    }
                }
            }
            String message = "The graph contains " + edgeCount + " edges.";
            showAlert(message);
        } catch (ListException e) {
            showAlert(e.getMessage());
        }
    }


    @FXML
    public void ToStringOnAction(ActionEvent actionEvent) {
        showAlert(graph.toString());
    }

    @FXML
    public void DFSOnAction(ActionEvent actionEvent) {
        try {
            showAlert(graph.dfs());
        } catch (GraphException | StackException | ListException e) {
            showAlert(e.getMessage());
        }
    }

    @FXML
    public void BFSOnAction(ActionEvent actionEvent) {
        try {
            showAlert(graph.bfs());
        } catch (GraphException | QueueException | ListException e) {
            showAlert(e.getMessage());
        }
    }

    private void drawGraph() throws ListException {
        pane_Grafo.getChildren().clear();
        double radius = 200;
        double centerX = pane_Grafo.getWidth() / 2;
        double centerY = pane_Grafo.getHeight() / 2;

        double[] vertexX = new double[graph.size()];
        double[] vertexY = new double[graph.size()];

        for (int i = 0; i < graph.size(); i++) {
            double angle = 2 * Math.PI * i / graph.size();
            vertexX[i] = centerX + radius * Math.cos(angle);
            vertexY[i] = centerY + radius * Math.sin(angle);
        }

        for (int i = 0; i < graph.size(); i++) {
            for (int j = i + 1; j < graph.size(); j++) {
                if (!graph.getAdjacencyMatrix()[i][j].equals(0)) {
                    javafx.scene.shape.Line line = new javafx.scene.shape.Line();
                    line.setStartX(vertexX[i]);
                    line.setStartY(vertexY[i]);
                    line.setEndX(vertexX[j]);
                    line.setEndY(vertexY[j]);
                    pane_Grafo.getChildren().add(line);
                }
            }
        }

        for (int i = 0; i < graph.size(); i++) {
            javafx.scene.shape.Circle circle = new javafx.scene.shape.Circle();
            circle.setCenterX(vertexX[i]);
            circle.setCenterY(vertexY[i]);
            circle.setRadius(15);
            circle.setStyle("-fx-fill: lightblue; -fx-stroke: black;");

            Text text = new Text(String.valueOf(graph.getVertex(i).data));
            text.setX(vertexX[i] - 5);
            text.setY(vertexY[i] + 5);

            pane_Grafo.getChildren().addAll(circle, text);
        }
    }



    private void showAlert(String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);


        DialogPane dialogPane = alert.getDialogPane();

        dialogPane.setPrefWidth(600);
        dialogPane.setPrefHeight(500);
        alert.showAndWait();

    }
}
