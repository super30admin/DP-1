
/**
Leet Code Submitted : YES
Space Complexity : O(1)
Time Complexity : O(N)
The idea is to store decisions of previous max in two variables choose or not choose as at every step we are referring to previous decision values so instead of storing whole array we only need two variables to keep track of these decision 
**/

class Solution {
    public int rob(int[] nums) {
        
        int max = 0;
        int choose;
        int notchoose;
        
        if(nums == null || nums.length < 1)
            return max;
        
        choose = nums[0];
        notchoose = 0;
        
        /*int[][] decision = new int[nums.length][2];
        
        decision[0][0] = nums[0];
        decision[0][1] = 0;
        
        for(int i=1; i<nums.length; i++){
            decision[i][0] = decision[i-1][1] + nums[i]; //Chosen the house
            decision[i][1] = Math.max(decision[i-1][0],decision[i-1][1]);
        }
        //return decision(nums,0,max) ; 
        return Math.max(decision[nums.length -1][0],decision[nums.length-1][1]);*/
        
        for(int i=1; i<nums.length; i++){
            int temp = choose;
            choose    = notchoose + nums[i];
            notchoose = Math.max(temp,notchoose);
            
            //decision[i][0] = decision[i-1][1] + nums[i]; //Chosen the house
            //decision[i][1] = Math.max(decision[i-1][0],decision[i-1][1]);
        }
        
        return(Math.max(choose,notchoose));
    
    }
    
    //For Recursion
    /*int decision(int[] nums,int i,int max){
        if(i >= nums.length)
            return max;
    
        return (Math.max(decision(nums,i+2,max+nums[i]),decision(nums,i+1,max)));
        
    }*/
}
