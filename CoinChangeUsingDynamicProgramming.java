//Time complexity is o(nk) i.e row * column
//Space complexity is O(nk)  i.e row * column
//This code is submitted on leetcode

public class CoinChangeUsingDynamicProgramming {
	public int coinChange(int[] coins, int amount) {
		int[][] matrix = new int[coins.length +1][amount+1];
		int row  = matrix.length;
		int column = matrix[0].length;
		for (int i =0; i< row; i++) {
			matrix[i][0] = 0;
		}
		for (int i = 1; i< column;i++) {
			matrix[0][i] = 999;
		}
		for (int i = 1;i< row; i++) {
			for (int j = 1; j< column;j++) {
				if(j< coins[i-1]) {
					matrix[i][j] = matrix[i-1][j];
				}else {
					matrix[i][j] = Math.min(matrix[i-1][j], matrix[i][j -coins[i-1]]+1);
				}
			}
		}
		int result = matrix[row-1][column-1];
		if (result == 999) return -1;
		else return result;
	}

	public static void main(String[] args) {
		CoinChangeUsingDynamicProgramming coin = new CoinChangeUsingDynamicProgramming();
		int [] coins = {1,2,5};
		int amount = 11;
		coin.coinChange(coins, amount);
	}

}
