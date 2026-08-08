class Solution {
    public int smallestNumber(int n, int t) {

        int tN = n;
        int digitProduct = 1;
        int temp = n;
        while (temp > 0) {
            digitProduct *= temp % 10;
            temp /= 10;
        }
        if (digitProduct % t == 0) {
            return tN;
        }
        for (int i = 1; i < 11; i++) {
            int ans = tN + i;
            int k = ans;
            int dP = 1;
            while (k > 0) {
                dP *= k % 10;
                k /= 10;
            }
            if (dP % t == 0) {
                return ans;
            }
        }
        return 0;
    }
}