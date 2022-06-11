package com.mjh316.shortestpathgraph.algorithm;

class Edge implements Comparable<Edge> {
    public String to;
    public int weight;

    public Edge(String to, int weight) {
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }

}