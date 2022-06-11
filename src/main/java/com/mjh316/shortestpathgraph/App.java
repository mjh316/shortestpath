package com.mjh316.shortestpathgraph;

import com.mjh316.shortestpathgraph.algorithm.Dijkstra;
import com.mjh316.shortestpathgraph.algorithm.Graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Hello world!
 */
public final class App {
    /**
     * Says hello to the world.
     * 
     * @param args The arguments of the program.
     */
    public static void main(String[] args) throws IOException {
        Dijkstra dijkstra;
        switch (args.length) {
            case 0: {
                System.err.println("Usage: java -jar shortestpath.jar graphFile");
                return;
            }
            case 1: {
                String graphFile = args[0];
                var graph = new Graph(graphFile);
                dijkstra = new Dijkstra(graph.source, graph);
                dijkstra.run();
                break;
            }
            default: {
                System.err.println("Too mant arguments passed to shortestpath.jar");
                System.err.println("Usage: java -jar shortestpath.jar graphFile");
                return;
            }
        }

        while (true) {
            System.out.println("Enter a node to find the shortest path to (or nothing to exit): ");
            var reader = new BufferedReader(new InputStreamReader(System.in));
            var node = reader.readLine().trim();
            if (node.equals("")) {
                break;
            }
            if (!dijkstra.existsInGraph(node)) {
                System.out.println("Node not found in graph");
                continue;
            } else {
                System.out.println(
                        "The distance from " + dijkstra.source + " to " + node + " is " + dijkstra.distanceTo(node));
                System.out.println("The path from " + dijkstra.source + " to " + node + " is " + dijkstra.pathTo(node));
            }
        }
    }
}
