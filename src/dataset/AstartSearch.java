package dataset;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AstartSearch {

	public static final int[][] MAZE = {
			{ 0, 0, 0, 1, 0, 0, 0},
			{ 0, 0, 0, 1, 0, 0, 0},
			{ 0, 0, 0, 1, 0, 0, 0},
			{ 0, 0, 0, 1, 0, 0, 0},
			{ 0, 0, 0, 0, 0, 0, 0},
	};
	
	static class Grid {
		public int x;
		public int y;
		public int f;
		public int g;
		public int h;
		public Grid parent;
		
		public Grid(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public void initGrid(Grid parent, Grid end) {
			this.parent = parent;
			if(parent != null) {
				this.g = parent.g + 1;
			}
			else {
				this.g = 1;
			}
			this.h = Math.abs(this.x - end.x) + Math.abs(this.y - end.y);
			this.f = this.g + this.h;
		}
	}
	
	public static Grid aStartSear(Grid start, Grid end) {
		ArrayList<Grid> openList = new ArrayList<Grid>();
		ArrayList<Grid> closeList = new ArrayList<Grid>();
		
		//起点加入 openlist
		openList.add(start);
		//每一轮检查一个结点
		while(openList.size() > 0) {
			//在 openList 查找 F最小的结点
			Grid currentGrid = findMinGrid(openList);
			//将当前结点从 openList 移除，进入closeList
			openList.remove(currentGrid);
			closeList.add(currentGrid);
			
			//找到邻近结点
			List<Grid> neighbors = findNeighbors(currentGrid, openList, closeList);
			for(Grid grid: neighbors) {
				if(!openList.contains(grid)) {
					grid.initGrid(currentGrid, end);
					openList.add(grid);
				}
			}
			for(Grid grid: neighbors) {
				if((grid.x == end.x) && (grid.y == end.y)){
					return grid;
				}
			}
			
		}
		return null;
	}
	
	private static Grid findMinGrid(ArrayList<Grid> openlist) {
		Grid tempGrid = openlist.get(0);
		for(Grid grid : openlist) {
			if(grid.f < tempGrid.f) {
				tempGrid  = grid;
			}
		}
		return tempGrid;
	}
	
	private static ArrayList<Grid> findNeighbors(Grid grid, List<Grid> openList, List<Grid> closeList){
		ArrayList<Grid> gridList = new ArrayList<Grid>();
		if(isValidGrid(grid.x, grid.y - 1, openList, closeList)) {
			gridList.add(new Grid(grid.x, grid.y-1));
		}
		if(isValidGrid(grid.x, grid.y + 1, openList, closeList)) {
			gridList.add(new Grid(grid.x, grid.y+ 1));
		}
		if(isValidGrid(grid.x-1, grid.y, openList, closeList)) {
			gridList.add(new Grid(grid.x-1, grid.y));
		}
		if(isValidGrid(grid.x+1, grid.y, openList, closeList)) {
			gridList.add(new Grid(grid.x+1, grid.y));
		}
		return gridList;
	}
	
	private static boolean isValidGrid(int x, int y, List<Grid> openList, List<Grid>closeList) {
		if(x < 0 || x >= MAZE.length || y < 0 || y > MAZE[0].length) {
			return false;
		}
		
		if(MAZE[x][y] == 1) {
			return false;
		}
		if(containGrid(openList, x, y)) {
			return false;
		}
		if(containGrid(closeList, x, y)) {
			return false;
		}
		return true;
	}
	
	private static boolean containGrid(List<Grid> grids, int x, int y) {
		for(Grid grid : grids) {
			if((grid.x == x) && (grid.y == y)) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Grid start = new Grid(2,1);
		Grid end = new Grid(2,5);
		
		Grid resultGrid = aStartSear(start, end);
		
		ArrayList<Grid> path = new ArrayList<Grid>();
		while(resultGrid != null) {
			path.add(new Grid(resultGrid.x, resultGrid.y));
			resultGrid = resultGrid.parent;
		}
		
		for( int i = 0; i < MAZE.length; i++) {
			for(int j = 0; j < MAZE[0].length; j++) {
				if(containGrid(path, i, j)) {
					System.out.print("*, ");
				}
				else {
					System.out.print(MAZE[i][j] + ", ");
				}
			}
			System.out.println();
		}
	}

}
