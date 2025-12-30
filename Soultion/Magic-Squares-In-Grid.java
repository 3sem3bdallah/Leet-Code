1class Solution {
2    public boolean isMagicSquare(int[][] grid,int r,int c){
3        int sum = grid[r][c] + grid[r][c+1] + grid[r][c+2];
4        HashSet<Integer> set = new HashSet<>();
5 
6        for(int i=0;i<3;i++){
7            for(int j=0;j<3;j++){
8                int num = grid[r+i][c+j];
9                if(num<1 || num>9 || set.contains(num)) return false;
10                set.add(num);
11            }
12        }
13        
14        for(int i=0;i<3;i++){ 
15            if((grid[r][c+i] + grid[r+1][c+i] + grid[r+2][c+i]) != sum) return false;
16            if(grid[r+i][c] + grid[r+i][c+1] + grid[r+i][c+2] != sum) return false;
17        }
18
19        if((grid[r][c] + grid[r+1][c+1] + grid[r+2][c+2]) != sum) return false;
20        if(grid[r][c+2] + grid[r+1][c+1] + grid[r+2][c] != sum) return false;
21        return true;
22    }
23
24    public int numMagicSquaresInside(int[][] grid) {
25        int m = grid.length,n = grid[0].length;
26        int c = 0;
27        for(int i=0;i<=m-3;i++){
28            for(int j=0;j<=n-3;j++){
29                if(isMagicSquare(grid,i,j)) c++;
30            }
31        }
32        return c;
33    }
34}