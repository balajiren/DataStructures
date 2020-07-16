package Graph;

public class QueueNode 
{
    GraphNode graphNode;
    int level;
     
    // this constructor is used while doing breadth first traversal
    public QueueNode(GraphNode node, int level)
    {
        this.graphNode = node;
        this.level = level;
    }
}
