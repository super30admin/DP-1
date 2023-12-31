public class CoinChange {
//TC 2 pow n
    //SC On

        public int coinChange(int[] coins, int amount) {
            if(coins==null ||coins.length==0){
                return -1;
            }
            int minCoin=helper(coins,amount,0,0);
            if(minCoin==Integer.MAX_VALUE)return -1;
            return minCoin;
        }
        public int helper(int[] coins,int amount,int coinused,int index){
            if(amount<0 || index>=coins.length){
                return Integer.MAX_VALUE;
            }
            if(amount==0)return coinused;
            int case1=helper(coins,amount-coins[index],coinused+1,index);
            int case2=helper(coins,amount,coinused,index+1);

            return Math.min(case1,case2);

    }}
