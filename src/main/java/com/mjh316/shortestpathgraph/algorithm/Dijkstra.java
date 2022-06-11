package com.mjh316.shortestpathgraph.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Dijkstra {
    private PriorityQueue<Edge> pq;
    private HashMap<String, Integer> dist;
    private Graph graph;
    private Map<String, String> prev;
    private final static int SENTINEL = -1;

    public final String source;

    /**
     * Constructor for Dijkstra
     * 
     * @param s The source node
     * @param e The graph
     */
    public Dijkstra(String s, Graph e) {
        this.graph = e;
        this.pq = new PriorityQueue<>();
        this.dist = new HashMap<>();
        this.prev = new HashMap<>();
        this.source = s;
    }

    public boolean existsInGraph(String to) {
        return this.dist.containsKey(to);
    }

    public int distanceTo(String node) {
        return this.dist.getOrDefault(node, SENTINEL);
    }

    public List<String> pathTo(String node) {
        var path = new ArrayList<String>();
        var curr = node;
        while (curr != null) {
            path.add(curr);
            curr = this.prev.get(curr);
        }
        Collections.reverse(path);
        return path;
    }

    public void run() {
        dist.put(source, 0);
        pq.add(new Edge(source, 0));
        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            String u = e.to;
            int weight = e.weight;
            dist.put(u, weight);
            for (Edge v : graph.get(u)) {
                var newWeight = v.weight + weight;
                if (dist.containsKey(v.to) && dist.get(v.to) <= newWeight) {
                    continue;
                }
                prev.put(v.to, u);
                pq.add(new Edge(v.to, newWeight));
            }
        }
    }
}
