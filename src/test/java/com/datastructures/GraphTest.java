package com.datastructures;

import org.junit.Test;

public class GraphTest {
    @Test
    public void should_print_dfs_of_graph() {
        int V = 5;
        final Graph graph = new Graph( V );
        graph.addEdge( 0, 1 );
        graph.addEdge( 0, 2 );
        graph.addEdge( 0, 3 );

        graph.addEdge( 1, 4 );
        graph.addEdge( 1, 2 );
        graph.addEdge( 4, 2 );

        graph.depthFirstSearch();

        System.out.println();

        graph.breadthFirstSearch();
    }
}