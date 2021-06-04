// Time Complexity : 
// Space Complexity :
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :    not sure about complexities
package dp1;

public class CoinChangeRecursive {

    public int coinChange(int[] coins, int amount) {
        //check length
        if (coins.length == 0 || coins == null) {
            return 0;
        }
        //recursive approach solution
        return recursiveApproach(coins, amount, 0, 0);

    }

    public int recursiveApproach(int[] coins, int amount, int index, int count) {
        //if amount becomes zero, valid case 
        if (amount == 0) {
            return count;
        }

        //if we have reached the end but haven't found the answer
        if (index == coins.length || amount < 0) {
            return -1;
        }
        //when we opt for choosing coin, i.e. 1 case 
        int case1 = recursiveApproach(coins, amount - coins[index], index, count + 1);
        //when we don't choose coin, i.e. 0 case
        int case2 = recursiveApproach(coins, amount, index + 1, count);
        if (case1 == -1) {
            return case2;
        }
        if (case2 == -1) {
            return case1;
        }
        return Math.min(case1, case2);
    }
}
