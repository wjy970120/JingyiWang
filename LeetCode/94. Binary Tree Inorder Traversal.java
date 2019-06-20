import java.util.List;

/* Binary Tree Inorder Traversal:
 * Given a binary tree, return the inorder traversal of its nodes' values.
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
class Problem94 {
	private List<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        traversal(root);
        return list;
    }
    
    public void traversal(TreeNode root) {
    	if(root == null) return;
        traversal(root.left);
        list.add(root.val);
        traversal(root.right);
    }
}