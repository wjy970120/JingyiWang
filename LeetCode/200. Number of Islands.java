import java.util.Queue;

/* Number of Islands:
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
 * You may assume all four edges of the grid are all surrounded by water.
 */

class Coordinate {
	int x, y;
	Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        
        int n = grid.length;
        int m = grid[0].length;
        int islands = 0;
        
        for(int i = 0; i < n; i++) {
        	for(int j = 0; j < m; j++) {
        		if(grid[i][j] != '0') {
        			judgeIslands(grid, i, j);
        			islands++;
        		}
        	}
        }
        
        return islands;
    }
    
    public void judgeIslands(char[][] grid, int x, int y) {
    	// (1, 0): go right; (0, 1): go down; (0, -1): go up; (-1, 0): go left.
    	int[] directionX = {1, 0, 0, -1};
    	int[] directionY = {0, 1, -1, 0};
    	
    	Queue<Coordinate> queue = new LinkedList<>();
    	queue.offer(new Coordinate(x, y));
    	grid[x][y] = '0';
    	
    	while(!queue.isEmpty()) {
    		Coordinate coor = queue.poll();
    		for(int i = 0; i < 4; i++) {
    			Coordinate adj = new Coordinate(coor.x + directionX[i], coor.y + directionY[i]);
    			if(!inBound(grid, adj)) continue;
    			if(grid[adj.x][adj.y] != '0') {
    				queue.offer(adj);
    				grid[adj.x][adj.y] = '0';
    			}
    		}
    	}
    }
    
    public boolean inBound(char[][] grid, Coordinate coor) {
    	int n = grid.length;
    	int m = grid[0].length;
    	
    	return coor.x >= 0 && coor.x < n && coor.y >= 0 && coor.y < m;
    }
}