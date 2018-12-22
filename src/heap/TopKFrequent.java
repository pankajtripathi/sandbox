package heap;

import java.util.*;

public class TopKFrequent {
    public static void main(String[] args) {
        int[] nums1 = {1, 1, 1, 2, 2, 3};
        int k1 = 2;
        System.out.println(new TopKFrequent().topKFrequent(nums1, k1));

        int[] nums2 = {5,3,1,1,1,3,73,1};
        int k2 = 2;
        System.out.println(new TopKFrequent().topKFrequent(nums2, k2));
    }

    private List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>((n1, n2) -> Integer.compare(map.get(n1), map.get(n2)));

        for (int num : nums) {
            if (map.containsKey(num)) {
                int count = map.get(num);
                map.put(num, ++count);
            } else {
                map.put(num, 1);
            }
        }

        for (Integer key : map.keySet()) {
            queue.add(key);
            if (queue.size() > k)
                queue.poll();
        }

        while (!queue.isEmpty()) {
            result.add(queue.poll());
        }

        Collections.reverse(result);
        return result;
    }
}
