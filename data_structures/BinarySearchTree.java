/**
 * 
 */
package algos;

import java.util.ArrayList;
import java.util.List;

/**
 * as explained in tutorial by
 * <a href="https://www.youtube.com/channel/UClEEsT7DkdVO_fkrBw0OTrA">
 * mycodeschool</a>
 * 
 * current it supports only integer types but need to convert it to generic
 * @author vishal gaurav
 *
 */
public class BinarySearchTree {

    public static class BstNode {
        private int data;
        private BstNode left;
        private BstNode right;
        private BstNode(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    /**
     * 
     * @param data
     * @return
     */
    public BstNode getNewNode(int data) {
        return new BstNode(data);
    }
    
    /**
     * Not implemented right now will return false
     */
    public boolean isBinarySearchTree(BstNode rootNode) {
        return isBinarySearchTree(rootNode,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    /**
     * helper overload of isBinarySearchTree. which passes minValue and maxValue for start condition
     * @param rootNode
     * @param minValue
     * @param maxValue
     * @return
     */
    private boolean isBinarySearchTree(BstNode rootNode, int minValue, int maxValue){
        boolean result = true;
        if(rootNode!=null){
            return rootNode.data > minValue && rootNode.data < maxValue && isBinarySearchTree(rootNode.left, minValue ,rootNode.data) && isBinarySearchTree(rootNode.right, rootNode.data ,maxValue) ;
        }
        return result;
    }
    /**
     * return In order successor that is the next element to value in sorted order.
     */
    public BstNode getInOrderSucsseor(BstNode rootNode, int value){
        BstNode resultNode = null;
        BstNode currentNode = Find(rootNode, value);
        if(currentNode != null){
            resultNode = (currentNode.right != null ) ? FindMinNode(currentNode.right): getDeepestAncestorForLeft(rootNode,currentNode) ;
        }
        return resultNode;
    }
    
   
    
    private BstNode getDeepestAncestorForLeft(BstNode rootNode, BstNode currentNode) {
        BstNode successor = null;
        BstNode ancestor = rootNode;
        while(ancestor.data != currentNode.data){
            if(currentNode.data < ancestor.data){
                successor = ancestor;
                ancestor = ancestor.left;
            }else{
                ancestor = ancestor.right;
            }
        }
        return successor;
    }

    /**
     * 
     * @param rootNode
     * @return
     */
    public int getMinimum(BstNode rootNode) {
        return (rootNode == null) ? -1 : ((rootNode.left == null) ? rootNode.data : getMinimum(rootNode));
    }
    
    public BstNode FindMinNode(BstNode rootNode){
        BstNode resultNode = rootNode;
        if(resultNode != null && rootNode.left != null){
            resultNode = FindMinNode(rootNode.left);
        }
        return resultNode;
    }
    
    /**
     * 
     * @param rootNode
     * @return
     */
    public int getMaximum(BstNode rootNode) {
        return (rootNode == null) ? -1 : ((rootNode.right == null) ? rootNode.data : getMaximum(rootNode));
    }

    /**
     * Breadth First Search Level order traversal
     *
     */
    public void getLevelOrderTraversal(BstNode rootNode, List<Integer> list) {
        if (rootNode != null && list != null) {
            List<BstNode> queue = new ArrayList<>();
            queue.add(rootNode);
            while (queue.size() > 0) {
                BstNode nextNode = queue.remove(0); // pop from queue
                if (nextNode.left != null) {
                    queue.add(nextNode.left);
                }
                if (nextNode.right != null) {
                    queue.add(nextNode.right);
                }
                list.add(nextNode.data);
            }
        }
    }

    /**
     * Depth First Search pre order traversal DLR
     */
    public void getPreOrderTraversal(BstNode rootNode, List<Integer> list) {
        if (rootNode != null && list != null) {
            list.add(rootNode.data);
            getPreOrderTraversal(rootNode.left, list);
            getPreOrderTraversal(rootNode.right, list);

        }
    }

    /**
     * Depth First Search in order traversal LDR. Please note that get Inorder returns sorted list
     */
    public void getInOrderTraversal(BstNode rootNode, List<Integer> list) {
        if (rootNode != null && list != null) {
            getInOrderTraversal(rootNode.left, list);
            list.add(rootNode.data);
            getInOrderTraversal(rootNode.right, list);
        }
    }

    /**
     * Depth First Search post order traversal LRD
     */
    public void getPostOrderTraversal(BstNode rootNode, List<Integer> list) {
        if (rootNode != null && list != null) {
            getPostOrderTraversal(rootNode.left, list);
            getPostOrderTraversal(rootNode.right, list);
            list.add(rootNode.data);
        }
    }

    public BstNode insert(int data, BstNode rootNode) {
        if (rootNode == null) {
            rootNode = getNewNode(data);
        } else if (data <= rootNode.data) {
            rootNode.left = insert(data, rootNode.left);
        } else {
            rootNode.right = insert(data, rootNode.right);
        }
        return rootNode;
    }

    private BstNode getMinimumNode(BstNode rootNode) {
        BstNode minNode = rootNode;
        while (rootNode != null) {
            if (rootNode.data < minNode.data) {
                minNode = rootNode;
            }
            rootNode = rootNode.right;
        }
        return minNode;
    }

    /**
     * delete the node with value = data and return it see the following link
     * for more details about the logic explanation
     * https://www.youtube.com/watch?v=gcULXE7ViZw <br>
     * This method acts recursively. </br>
     * 
     * @param rootNode
     * @param data
     * @return
     */
    public BstNode delete(BstNode rootNode, int data) {
        if (rootNode != null) {
            if (data > rootNode.data) {
                rootNode.right = delete(rootNode.right, data);
            } else if (data < rootNode.data) {
                rootNode.left = delete(rootNode.left, data);
            } else if (rootNode.left == null && rootNode.right == null) {
                rootNode = null;
            } else if (rootNode.left == null) {
                rootNode = rootNode.right;
            } else if (rootNode.right == null) {
                rootNode = rootNode.left;
            } else {
                BstNode minNode = getMinimumNode(rootNode.right);
                rootNode.data = minNode.data;
                rootNode.right = delete(rootNode.right, minNode.data);
            }
        }
        return rootNode;
    }

    public int getHeight(BstNode rootNode) {
        return (rootNode == null) ? -1 : (max(getHeight(rootNode.left), getHeight(rootNode.right)) + 1);
    }

    private int max(int firstNumber, int secondNumber) {
        return (firstNumber > secondNumber) ? firstNumber : secondNumber;
    }

    /**
     * search the elements in log(n) time. currently requires root element from
     * user.
     */
    public boolean search(BstNode rootNode, int data) {
        boolean result = false;
        if (rootNode == null) {
            result = false;
        } else if (data == rootNode.data) {
            result = true;
        } else if (data < rootNode.data) {
            result = search(rootNode.left, data);
        } else {
            result = search(rootNode.right, data);
        }
        return result;
    }
    
    public BstNode Find(BstNode rootNode, int data){
        BstNode resultNode = rootNode;
        if(rootNode!= null && rootNode.data != data){
            Find((data < rootNode.data ? rootNode.left : rootNode.right ), data);
        }
        return resultNode;
    }
    
    /**
     * main method for general test cases
     * 
     * @param args
     */
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        int numbers[] = { 15, 12, 17, 10, 18 };
        BstNode rootNode = bst.insert(15, null);
        bst.insert(17, rootNode);
        bst.insert(12, rootNode);
        bst.insert(10, rootNode);
        bst.insert(18, rootNode);
        System.out.println(bst.search(rootNode, 15));
        System.out.println(bst.search(rootNode, 12));
        System.out.println(bst.search(rootNode, 17));
        System.out.println(bst.search(rootNode, 16));
        ArrayList<Integer> order = new ArrayList<>();
        bst.getLevelOrderTraversal(rootNode, order);
        System.out.println("level order traversal");
        for (int i = 0; i < order.size(); i++) {
            System.out.print(order.get(i) + " ");
        }
        System.out.println("\n -- ends --  ");
        order.clear();
        bst.getPreOrderTraversal(rootNode, order);
        System.out.println("pre order traversal");
        for (int i = 0; i < order.size(); i++) {
            System.out.print(order.get(i) + " ");
        }
        System.out.println("\n -- ends --  ");
        order.clear();
        bst.getInOrderTraversal(rootNode, order);
        System.out.println("In order traversal");
        for (int i = 0; i < order.size(); i++) {
            System.out.print(order.get(i) + " ");
        }
        System.out.println("\n -- ends --  ");
        order.clear();
        bst.getPostOrderTraversal(rootNode, order);
        System.out.println("Post order traversal");
        for (int i = 0; i < order.size(); i++) {
            System.out.print(order.get(i) + " ");
        }
        System.out.println("\n -- ends --  ");
        System.out.println("\n -- Testing delete --  ");
        for (int i = 0; i < numbers.length && rootNode != null; i++) {
            System.out.println(" deleting -> " + numbers[i]);
            rootNode = bst.delete(rootNode, numbers[i]);
            order.clear();
            bst.getInOrderTraversal(rootNode, order);
            System.out.println("Post order traversal");
            for (int j = 0; j < order.size(); j++) {
                System.out.print(order.get(j) + " ");
            }
        }
    }

}
