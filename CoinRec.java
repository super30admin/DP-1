package Day8;
//3 coins to make up 11 - 5 + 5 +1
//Time Complexity: O(2^n) Exponential complexity
//Space Complexity: O()
//Because of recursion you will end going "Time Limit Exceeded" though not for this case
public class CoinRec {
    public int coinChange(int[] coins, int amount) {
        return coinChangeRec(coins, amount, 0, 0);

    }

    public static int coinChangeRec(int [] coins, int remainingAmount, int coinIndex, int noOfCurrentCoins){

        //extreme case
        if(remainingAmount < 0 || coinIndex > coins.length-1) return -1;

        //end case
        if(remainingAmount == 0) return noOfCurrentCoins;

        //Case1: When the coin is not chosen
        //array is same; amount remains to be same; index will be for the next element; noOfCurrentCoins will
        //remain to be same
        int noOfCoinsCase1 = coinChangeRec(coins, remainingAmount, coinIndex+1, noOfCurrentCoins);

        //Case 2: When the coin is chosen
        //coins array will be same; remainingAmount will the remainingAmount - the element chosen; coinIndex can be chosen to be the same;
        // noOfCurrentCoins will be +1 as there is an addition to it because of the chosen coin
        int noOfCoinsCase2 = coinChangeRec(coins, remainingAmount - coins[coinIndex], coinIndex, noOfCurrentCoins+1);


        if(noOfCoinsCase1 == -1) return noOfCoinsCase2;
        if(noOfCoinsCase2 == -1) return noOfCoinsCase1;
        else return Math.min(noOfCoinsCase1, noOfCoinsCase2);

    }

    public static void main(String args[]){
        CoinRec ob = new CoinRec();

        int[] nums = new int[]{1,2,5};

        System.out.println("The min number of required to sum up given target with given denominations: "+ ob.coinChange(nums, 11));
    }

}