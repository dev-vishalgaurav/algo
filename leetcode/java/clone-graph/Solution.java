/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 * https://leetcode.com/problems/clone-graph/
 *
 */
public class Solution {

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return node;
        HashMap<Integer,UndirectedGraphNode> map = new HashMap<>();
        return clone(node,map);
    }
    
    private UndirectedGraphNode clone(UndirectedGraphNode node, HashMap<Integer,UndirectedGraphNode> map ){
        if(!map.containsKey(node.label)){
            UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
            map.put(node.label,copy);
            for(UndirectedGraphNode each : node.neighbors )
                copy.neighbors.add(clone(each,map));
        }
        return map.get(node.label);
    }
    
}