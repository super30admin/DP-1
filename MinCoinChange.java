class MinCoinChange {
    
    public int coinChange(int[] coins, int amount) {
       
        if(amount <= 0)
            return 0;
        
        int result = Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++){
            if(coins[i] <= amount){
                int subResult = coinChange(coins, amount-coins[i]);
                if(subResult != Integer.MAX_VALUE && (subResult+1) < result){
                    result = subResult+1;
                }
            }   
        }
       
        return result == Integer.MAX_VALUE ? 0 : result;
    }
    public static void main(String[] args){
        System.out.println("MinCoinChange");

        int[] coins = {1,5,6,9};
        int amount = 11;

        MinCoinChange obj = new MinCoinChange();
        System.out.println(obj.coinChange(coins, amount));

    }
}