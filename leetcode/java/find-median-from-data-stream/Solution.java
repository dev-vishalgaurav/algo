/**
 * https://leetcode.com/problems/find-median-from-data-stream/
 */
public class MedianFinder {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder()); // left half of the tree
	PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(); // right half of the tree
    
	// Adds a number into the data structure.
    public void addNum(int num) {
		maxHeap.offer(num);
		minHeap.offer(maxHeap.poll());
		if(maxHeap.size() < minHeap.size()){
			maxHeap.offer(minHeap.poll());
		}
    }

    // Returns the median of current data stream
    public double findMedian() {
        if(maxHeap.size() == minHeap.size()) 
			return (maxHeap.peek() + minHeap.peek()) / 2.0;
		else 
			return maxHeap.peek();
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();