class MedianFinder {

    // 1. sort in findMedian - NlogN, add - O(1)
    // 2. binary search in addNum (logN) + add to index O(N), findMedian - O(1)
    // 3. two heaps - addNum(logN), findMedian - O(1)
    // max heap contains smallest numbers
    // min heap contains biggest numbers
    // balance their size - how?
    // max heap - 2 1
    // min heap - 3 4 5 6
    // now let's say i insert 5, 5 > 2, insert into min heap
    // now 6
    // when diff is > 1 pop, and push into a smaller size heap

    PriorityQueue<Integer> leftHeap = new PriorityQueue<>(Collections.reverseOrder()); // max heap
    PriorityQueue<Integer> rightHeap = new PriorityQueue<>(); // min heap

    public MedianFinder() {
    }
    
    public void addNum(int num) {
        if (leftHeap.isEmpty() || num > leftHeap.peek()) {
            rightHeap.offer(num);
        } else {
            leftHeap.offer(num);
        }
        // rebalance
        while (leftHeap.size() - rightHeap.size() > 1) {
            rightHeap.offer(leftHeap.poll());
        }
        while (rightHeap.size() - leftHeap.size() > 1) {
            leftHeap.offer(rightHeap.poll());
        }
    }
    
    public double findMedian() {
        if (leftHeap.size() > rightHeap.size()) {
            return leftHeap.peek();
        }
        if (rightHeap.size() > leftHeap.size()) {
            return rightHeap.peek();
        }
        return (rightHeap.peek() + leftHeap.peek())/2.0;
    }
}
