class Solution {
    public int rob(int[] arr) {
        if(arr.length==0)return 0;
        int dp[] = new int[arr.length+1];
        dp[0]=0;
        dp[1]=arr[0];
        for(int i=1; i<arr.length; i++){
            dp[i+1]=Math.max(dp[i],dp[i-1]+arr[i]);
        }
        return dp[arr.length];
    }
}