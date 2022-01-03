public class coinChange1 {

    public static int coinChange(int[] coins, int amount) {
        //exhaustive approach
        return exhaustiveHelper(coins, 0, amount, 0);
    }

    private static int exhaustiveHelper(int[] coins, int coinIndex, int amount, int coinsUsed){

        //base cases
        if(amount == 0) return coinsUsed;
        //if path leads to no resut or we have decided not to choose all the coinds
        if(amount < 0 || coinIndex ==  coins.length) return -1;

        //logic
        //case1 : choose a coin
        int case1 = exhaustiveHelper(coins, coinIndex, amount-coins[coinIndex], coinsUsed +1);
        //case2 : not choose a coin
        int case2 = exhaustiveHelper(coins, coinIndex + 1, amount, coinsUsed);

        //check if one of the path leads to no result;
        if(case1 == -1) return case2;
        if(case2 == -1) return case1;
        return Math.min(case1, case2);
    }

}
