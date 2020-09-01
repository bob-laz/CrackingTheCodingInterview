package chapter.four;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You are given a list of projects and a list of dependencies (which is a list of pairs of
 * projects, where the second project is dependent on the first project). All of a project's
 * dependencies must be built before the project is. Find a build order that will allow the projects
 * to be built. If there is no valid build order, return an error.
 *
 * This problem is called "topological sort": linearly ordering the vertices in a graph such that
 * for every edge (a, b), a appears before b in the linear order.
 */
public class Problem7 {

  public static List<String> findBuildOrder(String[] projects, String[][] dependencies)
      throws Exception {
    return buildOrder(buildAdjacencyList(projects, dependencies));
  }

  /**
   * Build the adjacency list representing the graph, adding A to the list of project B's
   * dependencies for dependency entry ["A", "B"]. In other words, this indicates that project B
   * depends on project A.
   *
   * Adjacency list will be a hash map of the form { "A": ["B", "C"], "B": ["C"], "C": [] } where
   * the keys A, B and C are the projects and the lists are the dependencies.
   */
  private static Map<String, List<String>> buildAdjacencyList(String[] projects,
      String[][] dependencies) {
    Map<String, List<String>> adjList = new HashMap<>();
    for (String proj : projects) {
      adjList.put(proj, new ArrayList<>());
    }
    for (String[] dependencyPair : dependencies) {
      List<String> node = adjList.get(dependencyPair[1]);
      node.add(dependencyPair[0]);
    }
    return adjList;
  }

  /**
   * Determine the build order by iterating over the nodes in the graph until they have all been
   * processed or a cycle is found. We check each node's dependencies to see if it is in the build
   * order list and, if so, remove it. Then if the dependency list is empty, add this to the build
   * order. If no new nodes are added to the build order on an iteration, either a cycle is found or
   * all nodes have been processed. We set each project's dependency list to null after it has been
   * processed, so checking to see if all are null tells us whether or not a build order was found.
   *
   * Runtime: O(n*e) where n is the number of nodes and e is the number of edges. Not totally sure
   * about this...
   *
   * Space: O(n) where n is the number of nodes in the graph, used to store list of build order
   */
  private static List<String> buildOrder(Map<String, List<String>> adjList) throws Exception {
    List<String> buildOrder = new ArrayList<>();
    int prevSize;
    // iterate until no new projects are added to build order
    do {
      prevSize = buildOrder.size();
      // iterate over nodes in graph
      for (String key : adjList.keySet()) {
        // not null, node hasn't been built yet
        if (adjList.get(key) != null) {
          // if it has dependencies, check each to see if it has been built
          if (adjList.get(key).size() != 0) {
            // remove dependency if it has been built
            adjList.get(key).removeIf(buildOrder::contains);
          }
          // no dependencies, we can build
          if (adjList.get(key).size() == 0) {
            buildOrder.add(key);
            // set node to null after it has been built
            adjList.put(key, null);
          }
        }
      }
    } while (prevSize != buildOrder.size());
    for (List<String> val : adjList.values()) {
      // if not all values in map have been set to null, not all have been built
      if (val != null) {
        throw new Exception("No possible build order");
      }
    }
    return buildOrder;
  }

  /**
   * Solution implementing topological sort.
   *
   * Runtime: O(P + D) where P is the number of projects and D is the number of dependency pairs.
   */
  public static List<String> findBuildOrderTopological(String[] projects, String[][] dependencies)
      throws Exception {
    Graph graph = buildGraph(projects, dependencies);
    return orderProjects(graph.nodes);
  }

  /**
   * Build the graph, adding the edge (a,b) if b is dependent on a. Assumes a pair is listed in
   * "build order". The pair (a,b) in dependencies indicates that b depends on a and a must be built
   * before b.
   */
  private static Graph buildGraph(String[] projects, String[][] dependencies) {
    Graph graph = new Graph();
    for (String project : projects) {
      graph.getOrCreateNode(project);
    }

    for (String[] dependency : dependencies) {
      String first = dependency[0];
      String second = dependency[1];
      graph.addEdge(first, second);
    }

    return graph;
  }

  /**
   * Return a list of the projects in the correct build order.
   */
  private static List<String> orderProjects(ArrayList<Project> projects) throws Exception {
    Project[] order = new Project[projects.size()];

    // add projects with no dependencies
    int endOfList = addNonDependent(order, projects, 0);

    int toBeProcessed = 0;
    while (toBeProcessed < order.length) {
      Project current = order[toBeProcessed];

      // circular dependency
      if (current == null) {
        throw new Exception("No possible build order");
      }

      // remove this project as a dependency
      ArrayList<Project> children = current.children;
      for (Project child : children) {
        child.dependencies--;
      }

      // add children with no dependencies to build order list
      endOfList = addNonDependent(order, children, endOfList);
      toBeProcessed++;
    }

    List<String> orderedList = new ArrayList<>();
    for (Project p : order) {
      orderedList.add(p.name);
    }
    return orderedList;
  }

  /**
   * Helper function to insert projects with no dependencies into the build order, starting at index
   * offset.
   */
  private static int addNonDependent(Project[] order, ArrayList<Project> projects, int offset) {
    for (Project project : projects) {
      if (project.dependencies == 0) {
        order[offset] = project;
        offset++;
      }
    }
    return offset;
  }

  private static class Graph {

    ArrayList<Project> nodes = new ArrayList<>();
    HashMap<String, Project> map = new HashMap<>();

    public Project getOrCreateNode(String name) {
      if (!map.containsKey(name)) {
        Project node = new Project(name);
        nodes.add(node);
        map.put(name, node);
      }

      return map.get(name);
    }

    public void addEdge(String startName, String endName) {
      Project start = getOrCreateNode(startName);
      Project end = getOrCreateNode(endName);
      start.addNeighbor(end);
    }
  }

  public static class Project {

    ArrayList<Project> children = new ArrayList<>();
    HashMap<String, Project> map = new HashMap<>(); // dependency map
    String name;
    int dependencies = 0;

    public Project(String n) {
      name = n;
    }

    public void addNeighbor(Project node) {
      if (!map.containsKey(node.name)) {
        children.add(node);
        map.put(node.name, node);
        node.dependencies++;
      }
    }
  }
}
