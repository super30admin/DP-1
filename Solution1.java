public class Solution1{
  public int coins(int target, int []coins){
    
    if(coins.length ==0)
      return -1;
    
    int []dp = new int[target+1];
    Arrays.fill(dp, target+1);
    for(int i=0; i< dp.length; i++)
    {
      for( int coinValue: coins){
        if(i >= coinValue)
        {
          dp[i] = Math.min(dp[i], dp[i-coinValue]+1);
        }
      }
    }
    return dp[dp.length-1];
  }
}
