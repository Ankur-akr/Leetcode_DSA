class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] arr = new int[nums2.length];
        int count=0;
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        for (int i : nums2){
            if(set.contains(i)){
                arr[count] = i;
                count++;
                set.remove(i);
            }
        }
        int[] slice = Arrays.copyOfRange(arr,0,count);
        return slice;
        
    }
}