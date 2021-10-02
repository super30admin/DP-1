//Appraoch using temp variabl in single array

class Solution {
    public int rob(int[] nums) {
        //using single matrix and constant space complexity
        if(nums==null || nums.length==0)
            return 0;
        
        int C=0,DC=0;
        
        for(int x:nums){
            int temp=DC;
            DC=Math.max(C,DC);
            C= x+temp;
        }
        
        return Math.max(C,DC);
    }
}

//time : O(n)
//Space : O(1)
//ran successfully on leetcode
//No difficulties
