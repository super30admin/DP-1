// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// create an array to store the each solved ssubsets
// create a recursive function for bottom up approach
// write the exit conditions for the recursion
class Solution {
    int[] memoi;
    int []num;
    public int rob(int[] nums) {
        memoi = new int[100];
        Arrays.fill(memoi, -1);
        num = nums; 
        return robfunc(0);
    }
    public int robfunc(int i){
        if(i >= num.length)
            return 0;
        if(memoi[i] > -1)
            return memoi[i];  
    int res = Math.max((num[i]+robfunc(i+2)),robfunc(i+1));
    memoi[i] = res;
    return res;
    }
}