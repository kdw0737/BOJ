class Solution {
    public long solution(int n) {
        int[] dp = new int[n];
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        dp[0] = 1;
        dp[1] = 2;
        for(int i =2; i<n; i++){
            dp[i] = (dp[i-2]+dp[i-1])%1234567;
        }
        return dp[n-1];
    }
}