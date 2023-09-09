class coinChangeRecursiveApproach {
    //Solving recurrsively, this give Time Limit exceed error and won't execute.
    //TC is exponential for this

    public int coinChange(int[] coins, int amount) {

        if(coins==null || coins.length==0){      //base condn to check if coins array is empty.
            return -1;
        }

        return recurse(coins,amount,0,0);       //return the recursive func,initially index and coinsUsed will be 0.

    }

    private int recurse(int[] coins, int amount, int index, int coinsUsed){
        //base cases
        if(index==coins.length || amount<0){    //Condn if reched the end of the array or amount became -ve
            return -1;          //then return -1
        }
        if(amount == 0){        //condn to check amount became 0
            return coinsUsed;   //If yes then return the number of coinsUsed, if amount was 0 intially then it will return 0.
        }

        //logic
        int case1= recurse(coins,amount,index+1,coinsUsed);     //if we choose 0 path i.e do not select

        int case2= recurse(coins,amount-coins[index],index,coinsUsed+1);    //if we choose 1 i.e selected the coin, amount will decrease, index will remain same and coinUSed will increase by 1.

        if(case1 == -1){        //if we encountered -1 in case 1 then retrun case2.
            return case2;
        }
        if(case2== -1){
            return case1;
        }
        return Math.min(case1, case2);      //I fthere are multiple values of coinsUsed, then return the min one.

    }
    public static void main(String[] args){
        int[] coins={1,2,5};
        int amount=11;
        coinChangeRecursiveApproach obj=new coinChangeRecursiveApproach();
        System.out.println(obj.coinChange(coins,amount));
    }
}