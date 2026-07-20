class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for(int i : nums){
            if(!map.containsKey(i)) map.put(i,1);
            else map.put(i , map.get(i) +1);
        }
        for(int j :map.keySet()){
            if(map.get(j) > nums.length/2){
                res = j;
            }
        }
        return res;
    }
}