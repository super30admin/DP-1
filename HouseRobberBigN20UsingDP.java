//Time complexity is o(n) i.e row * column but column here is constant so only n i.e O(n)
//Space complexity is O(n) i.e row * column but column here is constant so only n i.e O(n)
//This code is submitted on leetcode

public class HouseRobberBigN20UsingDP {

	public int rob(int[] nums) {
        if (nums.length ==0 ||nums == null) return 0;

		int[][] matrix = new int[nums.length][2];
		int row = matrix.length;
		int column = matrix[0].length;
		matrix[0][0] = 0;
		matrix[0][1] = nums[0];
		for (int i = 1; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (j == 0) {
					matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i - 1][j + 1]);
				} else {
					matrix[i][j] = matrix[i - 1][0] + nums[i];
				}
			}
		}
		return Math.max(matrix[row - 1][0], matrix[row - 1][1]);
	}

	public static void main(String[] args) {
		HouseRobberBigN20UsingDP house = new HouseRobberBigN20UsingDP();
		int [] nums = {1,3,2,1};
		house.rob(nums);
	}

}
