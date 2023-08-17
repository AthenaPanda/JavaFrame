package dataset;

public class GoldGreat {

	/**
	 * 获得金矿最佳收益
	 * @param w 工人数量
	 * @param p 金矿所需工人数量
	 * @param g 金矿储量
	 * @param n 金矿数量
	 * 递归法
	 */
	public static int getBestGoldMining_V1(int w, int n, int[] p, int[] g){
		if(w == 0 || n == 0) {
			return 0;
		}
		
		if( w < p[n-1]) {
			return getBestGoldMining_V1(w, n -1, p, g);
		}
		
		return Math.max(getBestGoldMining_V1(w,  n-1, p, g), getBestGoldMining_V1(w-p[n-1], n-1, p, g) + g[n-1]);
	}
	/**
	 * 获得金矿最佳收益
	 * @param w 工人数量
	 * @param p 金矿所需工人数量
	 * @param g 金矿储量
	 */
	public static int getBestGoldMining_V2(int w, int[] p, int[] g) {
		int[][] resultTable = new int[g.length + 1][w+1];
		
		for(int i = 1; i <= g.length; i++) {
			for(int j = 1; j <= w; j++) {
				if(j < p[i-1]) {
					resultTable[i][j] = resultTable[i -1][j];
				}
				else {
					resultTable[i][j] = Math.max(resultTable[i-1][j], resultTable[i-1][j-p[i-1]] +g[i-1]);
				}
			}
		}
		return resultTable[g.length][w];
	}
	
	/**
	 * 获得金矿最佳收益
	 * @param w 工人数量
	 * @param p 金矿所需工人数量
	 * @param g 金矿储量
	 * 
	 * 对 v2 进行优化 只保留所求一行结果值
	 */
	public static int getBestGoldMining_V3(int w, int[] p, int[] g) {
		int[] results = new int[w+1];
		
		for(int i = 1; i <= g.length; i++) {
			for(int j = w; j>= 1; j--) {
				if( j >= p[i-1]) {
					results[j] = Math.max(results[j], results[j-p[i-1]] +g[i-1]);
				}
			}
		}
		return results[w];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int w =10;
		int[] p = {5, 5, 3, 4, 3};
		int[] g = {400, 500, 200, 300,350};
		System.out.println(getBestGoldMining_V3(w, p, g));
	}

}
