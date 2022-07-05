class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int[] combination = new int[amount +1];
        Arrays.fill(combination, amount + 1);
        combination[0]=0;

        for(int i=1;i<amount+1;i++){

            for(int coin : coins){

                if(coin<=i){
                    combination[i] = Math.min(combination[i],combination[i-coin]+1); 
                }
            }
        }
        return combination[amount]>amount?-1:combination[amount];
    }
}