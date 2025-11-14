class Solution:
   def rangeAddQueries(self, n: int, queries: List[List[int]]) -> List[List[int]]:
       res = [[0]*n for _ in range(n)]
       for r1,c1,r2,c2 in queries:
           res[r1][c1] += 1
           if c2 + 1 < n: res[r1][c2+1] -= 1
           if r2+1 < n: res[r2+1][c1] -= 1
           if r2+1 < n and c2+1 < n: res[r2+1][c2+1] += 1
       for i in range(n):
           for j in range(1,n):
               res[i][j] += res[i][j-1]
       for j in range(n):
           for i in range(1,n):
               res[i][j] += res[i-1][j]
       return res