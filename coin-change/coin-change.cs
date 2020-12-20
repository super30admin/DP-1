public class Solution {
    public int CoinChange(int[] coins, int amount) {
        if(amount<1) return 0;
        
        return CoinChange(coins,amount,new int[amount]);
        
    }
    
    public int CoinChange(int[] coins,int rem,int[] count)
    {
        if(rem<0) return -1;
        if(rem==0) return 0;
        
        if(count[rem-1]!=0) return count[rem-1];
        int min = Int32.MaxValue;
        foreach(int coin in coins)
        {
            int res = CoinChange(coins,rem-coin,count);
            if(res>=0 && res < min)
            {
                min = 1+res;
            }
        }
        
        count[rem-1] = (min==Int32.MaxValue) ?-1 :min;
        return count[rem-1];
    }
}
