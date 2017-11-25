package com.datastructures;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Graph {
    private final ArrayList<Vertex> vertices;

    public Graph( int V ) {
        vertices = new ArrayList<>( V );
        for ( int i = 0; i < V; i++ ) {
            vertices.add( new Vertex( i ) );
        }
    }

    public void addEdge( int src, int dest ) {
        final Vertex source = vertices.get( src );
        final Vertex destination = vertices.get( dest );
        source.addEdge( new Edge( destination ) );
    }

    public void depthFirstSearch() {
        if ( vertices.isEmpty() ) {
            return;
        }
        Vertex vertex = vertices.get( 0 );
        final HashSet<Integer> visited = new HashSet<>();
        depthFirstSearch( vertex, visited );
    }

    private void depthFirstSearch( Vertex root, Set<Integer> visited ) {
        System.out.println( root );
        visited.add( root.id );
        for ( Edge edge : root.edges ) {
            final Vertex destination = edge.destination;
            if ( !visited.contains( destination.id ) ) {
                depthFirstSearch( destination, visited );
            }
        }
    }

    public void breadthFirstSearch() {
        Set<Integer> visited = new HashSet<>( vertices.size() );
        Queue<Vertex> vertexQueue = new Queue<>();

        final Vertex firstVertex = vertices.get( 0 );
        vertexQueue.add( firstVertex );
        visited.add( firstVertex.id );

        while ( !vertexQueue.isEmpty() ) {
            final Vertex vertex = vertexQueue.remove();
            System.out.println( vertex );

            for ( Edge edge : vertex.edges ) {
                final Vertex destination = edge.destination;
                if ( !visited.contains( destination.id ) ) {
                    vertexQueue.add( destination );
                    visited.add( destination.id );
                }
            }

        }
    }

    private class Vertex {
        private final int id;
        private final List<Edge> edges;

        Vertex( int id ) {
            this.id = id;
            edges = new ArrayList<>();
        }

        void addEdge( Edge edge ) {
            edges.add( edge );
        }

        @Override public String toString() {
            return "Vertex{" +
                    "id=" + id +
                    '}';
        }
    }

    private class Edge {
        private final Vertex destination;

        Edge( Vertex destination ) {
            this.destination = destination;
        }

        @Override public String toString() {
            return "Edge{" +
                    "destination=" + destination +
                    '}';
        }
    }
}
