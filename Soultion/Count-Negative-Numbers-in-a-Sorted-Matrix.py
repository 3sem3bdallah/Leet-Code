1class Solution:
2    def countNegatives(self, grid: List[List[int]]) -> int:
3        rows = len(grid)
4        cols = len(grid[0])
5        r = rows - 1
6        c = 0
7        ans = 0
8        
9        while r >= 0 and c < cols:
10            if grid[r][c] < 0:
11                ans += cols - c
12                r -= 1
13            else:
14                c += 1
15        
16        return ans
17