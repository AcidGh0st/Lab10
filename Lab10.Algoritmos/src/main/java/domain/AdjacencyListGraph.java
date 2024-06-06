package domain;

import domain.list.ListException;
import domain.queue.QueueException;
import domain.stack.StackException;

public class AdjacencyListGraph implements Graph {

    //Hay que arreglar toda la clase respecto a la lista
    //Lo unico que hice fue traer los metodos de graph

    @Override
    public int size() throws ListException {
        return 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsVertex(Object element) throws GraphException, ListException {
        return false;
    }

    @Override
    public boolean containsEdge(Object a, Object b) throws GraphException, ListException {
        return false;
    }

    @Override
    public void addVertex(Object element) throws GraphException, ListException {

    }

    @Override
    public void addEdge(Object a, Object b) throws GraphException, ListException {

    }

    @Override
    public void addWeight(Object a, Object b, Object weight) throws GraphException, ListException {

    }

    @Override
    public void addEdgeWeight(Object a, Object b, Object weight) throws GraphException, ListException {

    }

    @Override
    public void removeVertex(Object element) throws GraphException, ListException {

    }

    @Override
    public void removeEdge(Object a, Object b) throws GraphException, ListException {

    }

    @Override
    public String dfs() throws GraphException, StackException, ListException {
        return "";
    }

    @Override
    public String bfs() throws GraphException, QueueException, ListException {
        return "";
    }

}
