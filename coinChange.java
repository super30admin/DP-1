class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int count = 0;
        int num = coins.length - 1;
        Arrays.sort(coins);
        
        int temp = 0;
        while(amount > 0){
            temp = amount/coins[num];
            if( temp > 0 ){
                count += temp;
                amount = amount%coins[num];
            }
            if(num == 0 && amount != 0)
                return -1;
            num--;
        }
        return count;
    }
}
