class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0;
        int count = 0;
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
            }
            while (count > k) {
                if (nums[l] == 0) {
                    count--;
                }
                l++;
            }
            ans = Math.max(ans, i - l + 1);
        }
        return ans;
    }
}