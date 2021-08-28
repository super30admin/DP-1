public class DP {
    // Time Complexity : N^2
// Space Complexity : N^2
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no
  //  Problem1 (https://leetcode.com/problems/coin-change/)
  public static int coinChange(int[] coins, int amount) {
      if(coins==null || coins.length ==0) return -1;
    int[][] dp = new int[coins.length+1][amount+1];
    dp[0][0]=0;
    for(int j=1;j<dp[0].length;j++){
        dp[0][j] = amount+1;
    }    
    for(int i=1;i<dp.length;i++){
        for(int j =1;j<dp[0].length;j++){
            if(j< coins[i-1]){
                dp[i][j]= dp[i-1][j];
            }else{
                dp[i][j]=Math.min(dp[i-1][j],1+dp[i][j-coins[i-1]]);
            }
        }
    }
    int result = dp[dp.length-1][dp[0].length-1];
    if(result >amount){
        return -1;
    }
    return result;
}
//  Problem2 (https://leetcode.com/problems/house-robber/)
   // Time Complexity : N
// Space Complexity : N
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no
public int rob(int[] nums) {
 if(nums== null || nums.length==0) return -1;
 int[] dp = new int[nums.length+2];
 dp[0]=0;
 dp[0]=0;
 for(int i=2;i<dp.length;i++){
    dp[i]= Math.max(dp[i-1],nums[i-2]+dp[i-2]);
 }       
 return dp[dp.length-1];
}


public static void main(String[] args ){
    DP dp = new DP();
    int[] coins ={1,2,3,1};
 //   System.out.println(dp.coinChange(coins, 11));
    System.out.println(dp.rob(coins));
}


  
}
