public class Solution {
    /**
	 * https://leetcode.com/problems/reconstruct-itinerary/
     * When you run random custom test cases in editor you will get to know that they require a topological sort to be done on the input.
     * For ex feeding [["JFK",NRT],["JFK",KUL]] returns ["JFK","NRT","KUL"] which seems wrong as per the explanation but since input is not a valid itinerary hence the result.
     * This problem needs a topological sort in short. Hence do a topological sort after storing nodes in a sorted order.
     */
    public List<String> findItinerary(String[][] tickets) {
        LinkedList<String> result = new LinkedList<>();
        HashMap<String,PriorityQueue<String>> graph = new HashMap<>();
        for(String[] edge : tickets){
            if(!graph.containsKey(edge[0]))
                graph.put(edge[0],new PriorityQueue<>());
            graph.get(edge[0]).offer(edge[1]);
        }
        DFS("JFK",graph,result); // we need to do DFS/topological sort only from "JFK"
        return result;
    }
    /*DFS doing topological sort*/
    private void DFS(String node,HashMap<String,PriorityQueue<String>> graph,LinkedList<String> result ){
        PriorityQueue<String> nodes = graph.get(node);
        while(nodes!= null && !nodes.isEmpty())
            DFS(nodes.poll(),graph,result);
        result.addFirst(node); // this is the key, instead of reversing add to the head of linkelist.
    }
}