class Solution {
    public static int[] master;
    public static int[] coins;
    public int coinChange(int[] coinsOg, int amount) {
        coins = coinsOg;
        master = new int[100000];
        for(int i=0;i<100000;i++)
            master[i] = -1;
        master[0]=0;
        int ret =helper(amount);
        return ret==Integer.MAX_VALUE?-1:ret;
    }

    public static int helper(int amount){
        if(master[amount]!=-1)
            return master[amount];
        int min = Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++){
            if(amount>coins[i]){
                int helper = helper(amount-coins[i]);
                if(helper!=-1 && helper!=Integer.MAX_VALUE)
                    min = Math.min(min, 1+helper);
            }
            else if(amount == coins[i]){
                min = 1;
                break;
            }
        }
        master[amount] = min;
        return min;
    }
}