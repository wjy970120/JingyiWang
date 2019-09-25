import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;

import javax.xml.soap.Node;

/* Clone Graph:
 * Given a reference of a node in a connected undirected graph, return a deep copy (clone) of the graph. 
 * Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.
 */

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/

public class Problem133 {
 
 public Node cloneGraph(Node node) {
     if(node == null) return node;
     
     // Use BFS algorithm to traverse the graph and get all nodes.
     ArrayList<Node> nodes = getNodes(node);
     
     // Copy nodes, store the old->new mapping information in a HashMap.
     HashMap<Node, Node> mapping = new HashMap<>();
     for(Node n : nodes) {
     	mapping.put(n, new Node(n.val, new ArrayList<Node>()));
     }
     
     // Copy neighbors
     for(Node n : nodes) {
     	Node newNode = mapping.get(n);
     	for(Node neighbor : n.neighbors) {
     		Node newNeighbor = mapping.get(neighbor);
     		newNode.neighbors.add(newNeighbor);
     	}
     }
     
     return mapping.get(node);
 }
 
 public ArrayList<Node> getNodes(Node node) {
 	Queue<Node> queue =  new LinkedList<>();
 	HashSet<Node> set =  new HashSet<>();
 	
 	queue.offer(node);
 	set.add(node);
 	
 	while(!queue.isEmpty()) {
 		Node head = queue.poll();
 		for(Node neighbor : head.neighbors) {
 			if(!set.contains(neighbor)) {
 				queue.offer(neighbor);
 				set.add(neighbor);
 			}
 		}
 	}
 	
 	return new ArrayList<Node>(set);
 }
}
