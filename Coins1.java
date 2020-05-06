// Time Complexity : O(amount*n) where n is the number of coins in input array
// Space Complexity : O(n) where n is the number of coins in input array
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] arr = new int[amount+1];
        Arrays.fill(arr,amount+1);
        arr[0] = 0;
        for(int i=1;i<=amount;i++){
            for(int coin:coins){
                if(i>=coin){
                    arr[i]=Math.min(arr[i],arr[i-coin]+1);
                }
            }
        }
        
        return arr[amount]==amount+1?-1:arr[amount];
    }
}