//import java.util.Queue;
//import java.util.LinkedList;

class RecentCounter {
    private Queue<Integer> queue;
    
    public RecentCounter() {
        queue = new LinkedList<>();  // LinkedList implements Queue interface
    }
    
    public int ping(int t) {
        // 1. Add current request
        queue.offer(t);  // offer() == add() but doesn't throw exception on failure
        
        // 2. Remove expired requests (older than t - 3000)
        while (queue.peek() < t - 3000) {
            queue.poll();  // poll() == remove() but returns null if empty
        }
        
        // 3. Return count of requests in window
        return queue.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */