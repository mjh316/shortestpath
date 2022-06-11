package com.mjh316.shortestpathgraph.algorithm;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Graph extends HashMap<String, List<Edge>> {
    public String source;

    public Graph(String sourceFile) {
        super();
        try {
            var fr = new BufferedReader(new InputStreamReader(new FileInputStream(sourceFile)));
            String line;
            source = fr.readLine().trim();
            if (source == null || source.contains("|")) {
                fr.close();
                throw new InvalidParameterException("Source node invalid (Not found or formatting issue).");
            }
            while ((line = fr.readLine()) != null) {
                var _line = line.split(Pattern.quote("|"));
                for (var e : _line) {
                    System.out.println("e: " + e);
                }
                if (_line[0].equals("") || _line[1].equals("") || _line[2].equals("")) {
                    fr.close();
                    throw new InvalidParameterException("Invalid line for edge: " + line);
                }
                var from = _line[0].trim();
                var to = _line[1].trim();
                var weight = Integer.parseInt(_line[2].trim());
                System.out.printf("from: %s to: %s weight: %d\n", from, to, weight);
                if (!this.containsKey(from)) {
                    this.put(from, new ArrayList<Edge>());
                }
                if (!this.containsKey(to)) {
                    this.put(to, new ArrayList<Edge>());
                }
                this.get(from).add(new Edge(to, weight));
                this.get(to).add(new Edge(from, weight));
            }
            fr.close();
        } catch (Exception e) {
            System.err.println("""
                        File format:
                            begin_city | end_city | weight

                        Example:
                            source
                            A | B | 1
                            A | C | 2
                            B | C | 3
                            B | D | 4
                        Note: all leading and trailing spaces are ignored for each city name
                    """);
            e.printStackTrace();
        }
    }
}
