class Solution {
    public int[] arrayRankTransform(int[] arr) {

        int n = arr.length;
        int[] arr1 = arr.clone();
        Arrays.sort(arr1);
        Map<Integer, Integer> map = new HashMap<>();
        int rank = 1;

        for (int x : arr1) {
            if (!map.containsKey(x)) {
                map.put(x, rank++);
            }
        }
        for (int i = 0; i < n; i++) {
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }
}