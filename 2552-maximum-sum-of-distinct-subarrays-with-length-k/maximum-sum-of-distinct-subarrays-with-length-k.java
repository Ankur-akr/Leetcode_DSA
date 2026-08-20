class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        Set<Integer> elements = new HashSet<>();
        long Sum = 0;
        long maxSum = 0;
        int i = 0;
        
        for (int j = 0; j < n; j++) {
            if (!elements.contains(nums[j])) {
                Sum += nums[j];
                elements.add(nums[j]);
                
                if (j - i + 1 == k) {
                    maxSum = Math.max(maxSum,Sum);
                    Sum -= nums[i];
                    elements.remove(nums[i]);
                    i++;
                }
            } else {
                while (nums[i] != nums[j]) {
                    Sum -= nums[i];
                    elements.remove(nums[i]);
                    i++;
                }
                i++;
            }
        }
        
        return maxSum;
    }
}