class Solution {
    //Time O(N)
    //Space O(1)
/*
    Intution: Here there is only one constraint chose or not chose so this is the only decision making criteria 
*/
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0)
        {
            return 0;
        }
        int NotChose = 0 , Chose = nums[0];
        for(int i=1 ; i<nums.length ; i++)
        {
            int temp = NotChose;
            NotChose = Math.max(NotChose, Chose);
            Chose = nums[i] + temp;
        }
        return Math.max(Chose , NotChose);
    }

}