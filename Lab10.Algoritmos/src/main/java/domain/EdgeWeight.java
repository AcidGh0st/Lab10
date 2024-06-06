package domain;

public class EdgeWeight {
    private Object edge; //Corresponde a la arista, en este el  nombre del verice con la arista
    private Object weight;//peso
    public EdgeWeight(Object edge, Object weight) {
    this.weight = weight;
    this.edge = edge;
    }

    public Object getEdge() {
        return edge;
    }

    public void setEdge(Object edge) {
        this.edge = edge;
    }

    public Object getWeight() {
        return weight;
    }

    public void setWeight(Object weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        if(weight == null) return "Edge: " + edge;
        return "Edge: " + edge + " Weight: " + weight;
    }
}
