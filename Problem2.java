//Accepted on LT
// Followed checklist for dp and yeh it turned out to be a dp problem but got stuck on selecting data structure. As explained in the class i knew i had to use a array but got stuck with how to fill array or what acctuly to fill with after spending a day turns out it was easy 
//Time should be O(n)


class Solution {
    public int rob(int[] nums) {
        int[] profit = new int[nums.length];
        int max = Integer.MIN_VALUE;
        
    
        for(int i=0;i<nums.length;i++){
            if(i==0){
                profit[i] = nums[i];
            }
            else if(i==1){
                profit[i] = Math.max(nums[i] ,profit[i-1]);
            }

            else{
                profit[i] = Math.max(nums[i] + profit[i-2],profit[i-1]);


            }



        }
        return profit[nums.length-1];
    }
}