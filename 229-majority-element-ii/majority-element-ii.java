class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        HashMap<Integer , Integer> map = new HashMap<>();
        ArrayList<Integer> al = new ArrayList<>();
        for (int j : nums) {
            if (!map.containsKey(j)) map.put(j, 1);
            else map.put(j, map.get(j) + 1);
        }
        for (int i : map.keySet()){
            if (map.get(i) > n/3) {
                al.add(i);
            }
        }
        return al;
    }
}