class Solution {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int ans = -1;
        int maxFreq = 0;

        for (int num : nums) {
            if (num % 2 != 0) continue; 

            int count = freq.getOrDefault(num, 0) + 1;
            freq.put(num, count);

            if (count > maxFreq || (count == maxFreq && num < ans)) {
                maxFreq = count;
                ans = num;
            }
        }
        
        return ans;
    }
}