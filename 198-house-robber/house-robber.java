class Solution {
    public int rob(int[] nums) {
        Integer [] dp = new Integer[nums.length];
        //Arrays.fill(dp, -1)
        return rob(0,nums,dp);
    }
    int rob(int i, int[] nums, Integer[] dp){
        if(i>=nums.length) return 0;
        if(dp[i] != null) return dp[i];
        int pick = nums[i] +rob(i+2, nums,dp);
        int notPick = rob(i+1, nums,dp);
        return dp[i] = Math.max(pick, notPick);

    }
}