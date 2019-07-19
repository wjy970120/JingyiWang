import java.util.List;
import java.util.Queue;

/* Binary Tree Level Order Traversal:
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Method: Firstly, put the start node in queue. 
//         Secondly, while queue is not empty, traverse all nodes in current level order ,find all nodes in next level order and put them in queue.
class Problem102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // Define a return list.
    	List<List<Integer>> res = new ArrayList<>();
    	
    	if(root == null) return res;
    	
    	// Define a queue to store TreeNode.
    	Queue<TreeNode> tmp = new LinkedList<>();
    	tmp.offer(root);
    	
    	
    	while(!tmp.isEmpty()) {
    		// The number of TreeNode in one level.
    		int n = tmp.size();
    		// Define a list to store TreeNode's value in one level.
    		List<Integer> level = new ArrayList<>();
    		for(int i = 0; i < n; i++) {
    			// Get the TreeNode's value in one level.
    			TreeNode cur = tmp.poll();
                level.add(cur.val);
    			
                // Store current TreeNode's left and right node to the queue.
    			if(cur.left != null) tmp.offer(cur.left);
    			if(cur.right != null) tmp.offer(cur.right);
    		}
    		res.add(level);
    	}
    	
    	return res;
    }
}