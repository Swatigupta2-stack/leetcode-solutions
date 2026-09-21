class Solution {
    public int findKthLargest(int[] nums, int k) {
      PriorityQueue<Integer> minHeap = new PriorityQueue<>();
      for(int x : nums){
        minHeap.add(x);
        if(minHeap.size() > k)
        minHeap.poll();

      } 
      return minHeap.peek(); 
    }
}
/*
a min-heap by default.

That means:

The smallest element always stays at the top.

Example:

PriorityQueue<Integer> pq = new PriorityQueue<>();

pq.add(50);
pq.add(10);
pq.add(30);
pq.add(20);

Internally, you don't need to think of it as fully sorted.

But:

pq.peek()

will always give:

10

because 10 is the smallest.

And:

pq.poll()

will remove and return the smallest element:

poll() → 10

Now the smallest remaining element becomes the top.
*/