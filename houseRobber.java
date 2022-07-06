//Amazon Interview 
//Time complexity:O(n)
//space Complexity:O(1)
//Greedy approach : first select from given array nums the maximum number and add the alternate houses to it ex:9+2+1=12 but it wont work properly becuase [2,7,9,8,1,1,5] so maxi mum money robber = 16 and not robber = 17 so not works in this case 

//Exhaustive approach: by using recursive the choose not choose method by using 0 and 1 applied to given array until it gives empty end list.By using recursive approach will see any repeated sub problems.It goes till the maximum of the tree taken and stopping condition its end of array length.
class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        int n = nums.length;
        int skip = 0;
        int take = nums[0];
        
        for(int i=1;i<n;i++){
            //not choose to rob house
            int temp = skip;
            skip = Math.max(skip,take);//skip = 0 choose and 1 =take not choose = skip + nums[0]
            //choose to rob the house 
            take = temp+nums[i];
        }
        
        return Math.max(skip,take);
        
    }
}