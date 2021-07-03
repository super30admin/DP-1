package HouseRobber_198;

public class HouseRobber_198 {
	public int rob(int[] nums) {
        if(nums==null || nums.length == 0)
       {
           return 0;
       }
       
       int house_number = nums.length;
       int[][] earning_matrix = new int[house_number][2];
 //Edge Case       
      
       
       earning_matrix[0][0] = 0;
       earning_matrix[0][1] = nums[0];
       
       for(int i=1 ; i<house_number; i++)
       {
           for(int j=0;j<2;j++)
           {
               if (j==0)
               {
                   earning_matrix[i][j] = Math.max(earning_matrix[i-1][0],earning_matrix[i-1][1]);
               }
               
               else
                   earning_matrix[i][j] = earning_matrix[i-1][0]+nums[i];
                   
           }
       }
        return Math.max(earning_matrix[house_number-1][0],earning_matrix[house_number-1][1]);
   }

	public static void main(String[] args) {
		int[] house_values = {2,4,6,8,9};
		HouseRobber_198 obj = new HouseRobber_198();
		int earnings = obj.rob(house_values);
		System.out.println("The maximum earnings possible is : "+earnings);
	}

}
