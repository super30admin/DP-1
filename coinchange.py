class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0){
            return 0;
        }
        int[] res = new int[amount+1];
        for(int i=0;i<amount+1;i++){
            res[i] = amount+1;
        }
        res[0]=0;
        for (int i=1;i<amount+1;i++){
            for(int j=0;j<coins.length;j++){
                if (i >= coins[j]){
                    res[i]=Math.min(res[i],1+res[i-coins[j]]);
                }
            }
        }
        if (res[amount]!=amount+1){
            return res[amount];
        }
        else{
            return -1;
        }
    }
}