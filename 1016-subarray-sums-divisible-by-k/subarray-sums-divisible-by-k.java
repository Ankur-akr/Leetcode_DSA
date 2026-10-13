class Solution {
    public int subarraysDivByK(int[] nums, int k) {

        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0; 
        int count = 0;
        
        for(int it : nums){
            sum += it;
            int r = ((sum % k) + k) % k;
            count += map.getOrDefault(r,0);
            map.put(r,map.getOrDefault(r,0)+1);
        }
        return count; 
    }
}