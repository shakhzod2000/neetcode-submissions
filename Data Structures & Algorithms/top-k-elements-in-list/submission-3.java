class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int[] res = new int[k];
        // build maxHeap structure comparing frequencies of a and b
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> freq.get(b) - freq.get(a));

        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        maxHeap.addAll(freq.keySet());

        for (int i=0; i < k; i++) {
            res[i] = maxHeap.poll(); // Sorting happens here
        }

        return res;
    }
}



/*
Time complexity:
- Building the frequency map: O(n), where n is the length of nums.
- Building the max-heap from the unique keys (m unique numbers): O(m) to add each key, but heapify costs are effectively O(m log m) when inserting all elements.
- Extracting k elements: O(k log m) in the worst case since each poll is O(log m).

Overall: O(n + m log m + k log m). Since m ≤ n, this is O(n log m) in the dominant terms, often written as O(n log m).

Space complexity:
- Frequency map stores m entries: O(m).
- Max-heap stores the same m keys: O(m).
- Result array stores k integers: O(k).

Overall: O(m + k) space, which in worst case is O(n).
*/