//package controller;
//
//import domain.AdjacencyListGraph;
//import domain.GraphException;
//import domain.list.ListException;
//import domain.queue.QueueException;
//import domain.stack.StackException;
//import javafx.event.ActionEvent;
//import javafx.scene.control.TextArea;
//import javafx.scene.layout.Pane;
//import domain.AdjacencyListGraph;
//import domain.EdgeWeight;
//import domain.Vertex;
//import domain.list.ListException;
//import javafx.fxml.FXML;
//import javafx.scene.layout.Pane;
//import javafx.scene.shape.Circle;
//import javafx.scene.shape.Line;
//import javafx.scene.text.Text;
//
//public class AdjacencyListGraphController
//{
//    @javafx.fxml.FXML
//    private Pane paneGraph;
//    @javafx.fxml.FXML
//    private TextArea txtArea;
//    AdjacencyListGraph graph;
//
//    @javafx.fxml.FXML
//    public void initialize() {
//        graph = new AdjacencyListGraph(10);
//    }
//
//    @javafx.fxml.FXML
//    public void toStringOnAction(ActionEvent actionEvent) {
//        txtArea.setText(graph.toString());
//    }
//
//    @javafx.fxml.FXML
//    public void dfsOnAction(ActionEvent actionEvent) {
//        try {
//            graph.dfs();
//        } catch (GraphException |StackException |ListException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @javafx.fxml.FXML
//    public void randomizeOnAction(ActionEvent actionEvent) {
//
//    }
//
//    @javafx.fxml.FXML
//    public void bfsOnAction(ActionEvent actionEvent) {
//        try {
//            graph.bfs();
//        } catch (GraphException |QueueException |ListException e) {
//            throw new RuntimeException(e);
//    }
//    }
//
//    @javafx.fxml.FXML
//    public void containsVertexOnAction(ActionEvent actionEvent) {
//    }
//
//    @javafx.fxml.FXML
//    public void containsEdgeOnAction(ActionEvent actionEvent) {
//    }
//
//    private void drawGraph() throws ListException {
//        paneGraph.getChildren().clear();
//
//        double centerX = paneGraph.getWidth() / 2;
//        double centerY = paneGraph.getHeight() / 2;
//        double radius = 150;
//        double angleIncrement = 2 * Math.PI / graph.size();
//
//        // Dibujar nodos
//        for (int i = 0; i < graph.size(); i++) {
//            double angle = i * angleIncrement;
//            double x = centerX + radius * Math.cos(angle);
//            double y = centerY + radius * Math.sin(angle);
//
//            Circle circle = new Circle(x, y, 15);
//            circle.setStyle("-fx-fill: lightblue; -fx-stroke: black;");
//
//            Text text = new Text(String.valueOf(graph.getVertex(i).data));
//            text.setX(x - 5);
//            text.setY(y + 5);
//
//            paneGraph.getChildren().addAll(circle, text);
//        }
//
//        // Dibujar aristas
//        for (int i = 0; i < graph.size(); i++) {
//            Vertex vertex = graph.getVertex(i);
//            for (int j = 0; j < vertex.edgesList.size(); j++) {
//                EdgeWeight edge = (EdgeWeight) vertex.edgesList.getNode(j).data;
//                int destinationIndex = graph.indexOf(edge.getVertex());
//
//                double startX = centerX + radius * Math.cos(i * angleIncrement);
//                double startY = centerY + radius * Math.sin(i * angleIncrement);
//                double endX = centerX + radius * Math.cos(destinationIndex * angleIncrement);
//                double endY = centerY + radius * Math.sin(destinationIndex * angleIncrement);
//
//                Line line = new Line(startX, startY, endX, endY);
//                paneGraph.getChildren().add(line);
//            }
//        }
//    }
//
//}