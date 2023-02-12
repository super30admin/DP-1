//Time complexity : O(m*n)
//Space : O(m*n)
//Did it run on leet code : Yes
//Did I face any problems : No
// Code is below
class Solution {
    public int coinChange(int[] coins, int amount) {

   //null
    if(coins.length ==0||coins ==null){
        return 0;
    }
    int m = coins.length;
    int n = amount;

    int[][] dp = new int[m+1][n+1];
    dp[0][0] = 0;

    //top row fill
    for(int j=1; j<dp[0].length; j++){
        dp[0][j] = amount+1;
    }

    for(int i =1; i<dp.length;i++){
        for(int j = 1 ; j< dp[0].length; j++){
            //till amount is less than the denomination of coinChange
            if(j<coins[i-1]){
                dp[i][j] = dp[i-1][j];
            }else{
                //both 1 & 0 case
                dp[i][j] = Math.min(dp[i-1][j],1+dp[i][j-coins[i-1]]);
            }   
        }
    }
    int result = dp[m][n];
    if(result>amount) return -1;
    else return result;
}

}
//House robber
//Time complexity : O(n)
//Space : O(n)
//Did it run on leet code : Yes
//Did I face any problems : No
// Code is below
class Solution {
    public int rob(int[] nums) {

        if(nums.length==0|| nums == null) return 0;

        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        if(n==1) return dp[0];
        dp[1] = Math.max(nums[0],nums[1]);

        for(int i =2; i<n;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
      return dp[n-1];
    }
}





