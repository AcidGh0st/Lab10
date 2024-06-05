package domain;

import org.junit.jupiter.api.Test;

public class AdjacencyListGraphTest {

    @Test
    void test(){
        AdjacencyListGraph graph = new AdjacencyListGraph();

        for(int i = 0; i < 20; i++) {
            //Agregar a la lista
            util.Utility.getRandom(50);
        }
    }


}

