//Time Complexity: O(n)
//Speace Complexity : O(1)
//LeetCode:Success
/*Details 
Runtime: 0 ms, faster than 100.00% of Java online submissions for House Robber.
Memory Usage: 34.4 MB, less than 99.94% of Java online submissions for House Robber.*/

//Anything where we need to find max and we neeed to search for alternate numbers. Keeping a meory of previous max is useful
//while calculating - to see if wee need to take next number or next to next number . try eg. [2,1,1,2]

class Solution {
   public int rob(int[] num) {
    int prevMax = 0;
    int currMax = 0;
    for (int x : num) {
        int temp = currMax; //0,1
        currMax = Math.max(prevMax + x, currMax); //2
        prevMax = temp; //0
    }
    return currMax;
}
}
