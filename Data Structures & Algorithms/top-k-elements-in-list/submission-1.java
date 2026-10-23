class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count the frequency of each number using a HashMap
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create buckets where the index represents the frequency.
        // The maximum possible frequency for any element is nums.length.
        List<Integer>[] freq = new List[nums.length + 1];
        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        // Populate the buckets
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int number = entry.getKey();
            int frequency = entry.getValue();
            freq[frequency].add(number);
        }

        // Step 3: Collect the top k frequent elements starting from the highest frequency bucket
        int[] result = new int[k];
        int index = 0;
        for (int i = freq.length - 1; i >= 0 && index < k; i--) {
            for (int num : freq[i]) {
                result[index++] = num;
                if (index == k) {
                    break;
                }
            }
        }

        return result;
    }
}