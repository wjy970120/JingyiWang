/* Maximum Depth of Binary Tree:
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
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
class Problem104 {
	private int height = 0;
	
    public int maxDepth(TreeNode root) {
        traversal(root, 1);
        return height;
    }
    
    public void traversal(TreeNode root, int depth) {
    	if(root == null) return;
    	// The height of the tree is the maximum depth of all nodes.
    	height = Math.max(depth, height);
    	traversal(root.left, depth + 1);
    	traversal(root.right, depth + 1);
    }
}