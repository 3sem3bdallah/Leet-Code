class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        int k = queries.length;
        int ans[] = new int[k];

        int queries2d[][] = new int[k][2];
        for(int i=0;i<k;i++){
            queries2d[i][0] = queries[i];
            queries2d[i][1] = i;
        }
        Arrays.sort(queries2d,(o1,o2)->o1[0]-o2[0]);

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->o1[2]-o2[2]);
        pq.add(new int[]{0,0,grid[0][0]});

        int n = grid.length, m = grid[0].length;
        boolean vis[][] = new boolean[n][m];
        vis[0][0] = true;

        int dir[][] = {{0,1},{0,-1},{-1,0},{1,0}};

        int cells=0, qi=0;
        while(qi<k && !pq.isEmpty()){
            while(!pq.isEmpty() && pq.peek()[2]<queries2d[qi][0]){
                cells++;

                int pop[] = pq.remove();
                int i = pop[0], j = pop[1];
                for(int d[]:dir){
                    int ni = d[0]+i, nj = d[1]+j;
                    if(ni<0 || nj<0 || ni>=n || nj>=m || vis[ni][nj])   continue;
                    vis[ni][nj] = true;
                    pq.add(new int[]{ni,nj,grid[ni][nj]});
                }
            }

            int pos = queries2d[qi][1];
            ans[pos] = cells;
            qi++;
        }
        
        while(qi<k){
            int pos = queries2d[qi][1];
            ans[pos] = cells;
            qi++;
        }

        return ans;
    }
}