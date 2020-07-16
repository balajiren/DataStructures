package Graph;
import java.util.*;

 class Node<T>
{
    private final T data;
    private final Set<Node> adjacent = new HashSet<Node>();

    public Set<Node> getAdjacent() {
      return adjacent;
    }

    public Node(T data) {
      this.data = data;
    }

    public T getData() {
      return data;
    }

    // returns if the node was added, false if already there
    public boolean addAdjacent(Node node) {
      return adjacent.add(node);
    }

    // returns true if any were added
    public boolean addAdjacents(Set<Node> nodes) {
      return adjacent.addAll(nodes);
    }


public static boolean pathExistsBidirectional(Node a, Node b)
{
    // BFS on both nodes at the same time
	Queue<Node> queueA = new LinkedList<Node>();
    Queue<Node> queueB = new LinkedList<Node>();
    Set<Node> visitedA = new HashSet<Node>();
    Set<Node> visitedB = new HashSet<Node>();

    visitedA.add(a);
    visitedB.add(b);
    queueA.add(a);
    queueB.add(b);

    while (!queueA.isEmpty() && !queueB.isEmpty()) {
      if (pathExistsBidirectionalHelper(queueA, visitedA, visitedB)) {
        return true;
      }
      if (pathExistsBidirectionalHelper(queueB, visitedB, visitedA)) {
        return true;
      }
    }

    return false;
  }

  private static boolean pathExistsBidirectionalHelper(Queue<Node> queue, Set<Node> visitedFromThisSide, Set<Node> visitedFromThatSide) {
    if (!queue.isEmpty()) {
      Node next = queue.remove();
      for (Object objadjacent : next.getAdjacent()) {
    	  Node adjacent = (Node) objadjacent;
        if (visitedFromThatSide.contains(adjacent)) {
          return true;
        } else if (visitedFromThisSide.add(adjacent)) {
          queue.add(adjacent);
        }
      }
    }
    return false;
  }
  }