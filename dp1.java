//problem1
class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int m=amount;
        int[][] dp=new int[n+1][m+1];
        for(int j=1;j<=m;j++){
            dp[0][j]=amount+1;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(coins[i-1]>j){
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]=Math.min(dp[i-1][j],1+dp[i][j-coins[i-1]]);
                }
            }
        }
        int res=dp[n][m];
        return res==amount+1?-1:res;
    }
}
//problem2
class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int n=nums.length;
        int temp;
        int prev=nums[0];
        int curr=Math.max(nums[0],nums[1]);
        for(int i=2;i<n;i++){
            temp=curr;
            curr=Math.max(curr,nums[i]+prev);
            prev=temp;
        }
        return curr;
    }
}
