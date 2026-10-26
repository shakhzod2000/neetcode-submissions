class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int[] res = new int[k];
        // build minHeap structure comparing frequencies of a and b
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> freq.get(a) - freq.get(b));

        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        for (int key : freq.keySet()) {
            minHeap.add(key);
            if (minHeap.size() > k) {
                minHeap.poll(); // remove min value
            }
        }

        for (int i=0; i < k; i++) {
            res[i] = minHeap.poll(); // Sorting happens here
        }

        return res;
    }
}



/*
Time complexity:
- Building the frequency map: O(n), where n is the length of nums.
- Inserting each distinct key into the min-heap with at most k elements: O(m log k), where m is the number of distinct elements (m ≤ n). In the worst case this is O(n log k).
- Extracting k elements from the heap: O(k log k) for polling, but since each poll is O(log k) and there are k polls, this is O(k log k). If k ≤ m, this dominates less than the previous step often.

Overall time is O(n + m log k) in general, which is O(n log k) in the typical worst case where m ~ n.

Space complexity:
- Frequency map stores up to m distinct keys: O(m).
- Min-heap stores up to k elements: O(k).
- Result array stores k elements: O(k).

Total space complexity: O(m + k), which in the worst case is O(n + k).
*/