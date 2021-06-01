class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        rows, cols = len(grid), len(grid[0])
        dir = [1,0,0,1,-1,0,0,-1]
        res = 0
        for i in range(rows):
            for j in range(cols):
                if grid[i][j] == 1:
                    #bfs
                    size = 0
                    q = []
                    q.append( (i,j) )
                    while q:
                        x,y = q.pop(0)
                        grid[x][y] = 2
                        size += 1
                        for d in range(0,8,2):
                            newX, newY = x + dir[d], y + dir[d+1]
                            if 0 <= newX < rows and 0 <= newY < cols and grid[newX][newY] == 1:
                                q.append( (newX,newY) )
                                grid[newX][newY] = 2
                    res = max(size, res)
        return res
                    
