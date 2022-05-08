// Time Complexity : O(M*N)
// Space Complexity : O(M*N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes

class Solution {
    public int coinChange(int[] coins, int amount) {
        int length1 = coins.length;
        int length2 = amount;
        // repesenting tree of all possible combinations of given denominations
        // for each penny in the given amount calculation
        int[][] mapping = new int[length1+1][amount+1];
        // filling the first row with 0 and max number,
        // to handle the case of when certain amount can not be summed amongst given denomination
        // for instance, denomination [2,5] amount = 11
        // parent node, [2,5] - left child [2] with remaing amount 11, right child [2,5] with remaining amount 9
        // left child [2] with remaining 11, 11 -> 9 -> 7 -> 5 -> 4 -> 3 -> 1 -> -1
        // right [2,5] with remainig, same as above sub array, until [2,5]^-4
        // there's no place where we could find sum of denominations equal to given amount
        for(int i=1;i<=amount;i++) {
            mapping[0][i] = 999999;
        }
        for(int i=1;i<=length1;i++) {
            for(int j=0;j<=amount;j++){
                if(j < coins[i-1])
                    // if the current amount j is not equivalent to the current denomination
                    // take the value from above
                    mapping[i][j] = mapping[i-1][j];
                else
                    // else, cacluate the min of the value from above, and previously occured substree on the same denomination
                    mapping[i][j] = Math.min(mapping[i-1][j],mapping[i][j-coins[i-1]]+1);

            }
        }
        return mapping[length1][amount] == 999999 ? -1 : mapping[length1][amount];
    }
}