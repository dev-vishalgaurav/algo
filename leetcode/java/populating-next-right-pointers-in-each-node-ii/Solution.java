/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 */
public class Solution {
	public void connect(TreeLinkNode root) {
		TreeLinkNode dummyHead = new TreeLinkNode(0);
		TreeLinkNode pre = dummyHead;
		while (root != null) {
			if (root.left != null) {
				pre.next = root.left;
				pre = pre.next;
			}
			if (root.right != null) {
				pre.next = root.right;
				pre = pre.next;
			}
			root = root.next;
			if (root == null) {
				pre = dummyHead;
				root = dummyHead.next;
				dummyHead.next = null;
			}
		}
	}
	public void connect(TreeLinkNode root) {
        int level = 1, nextLevel = 0;
        TreeLinkNode levelTail = root, levelHead = root;
        while(levelHead != null){
            root = levelHead;
            levelHead = levelHead.next;
            level--;
            if(root.left != null){
                nextLevel++;
                if(levelHead == null){
                    levelHead = levelTail = root.left;
                }else{
                    levelTail.next = root.left;
                    levelTail = levelTail.next;
                }
                
            }
            if(root.right != null){
                nextLevel++;
                if(levelHead == null){
                    levelHead = levelTail = root.right;
                }else{
                    levelTail.next = root.right;
                    levelTail = levelTail.next;
                }
            }
            if(level == 0){
                level = nextLevel;
                nextLevel = 0;
                root.next = null;
            }
            
        }
        
    }
}