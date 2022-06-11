# shortestpath
[![Maven Package](https://github.com/mjh316/shortestpath/actions/workflows/maven-publish.yml/badge.svg)](https://github.com/mjh316/shortestpath/actions/workflows/maven-publish.yml)

Enter in a network of places and the distances between them, and your home. Without needing to define a direct distance between your home and every place, you can calculate the distance from the connections of the other places!   
Example:  
```
  A  
  A | B | 4   
  B | D | 6  
  A | D | 3  
  B | E | 6  
  C | E | 2  
  A | C | 1  
  
 
  What's the node you want to travel to?
  E
  The shortest path from A to E has a distance of 3
  The path is [A, C, E]
```  

Written with Java and using Maven as a project configuration tool.
