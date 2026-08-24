class Solution {
    public boolean checkDivisibility(int n) {
        int temp = n;
        int pro = 1;
        int sum = 0;
        while(temp>0){
            sum += temp%10;
            pro *= temp%10;
            temp = temp/10;
        }
        if(n%(sum+pro) ==0 ) return true;
        return false;
    }
}