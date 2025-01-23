class Solution {
public:
    int countServers(vector<vector<int>>& grid) {
        int n = grid.size(); 
        int m = grid[0].size();
        int cnt = 0;
        vector<int> r(n, 0);
        vector<int> c(m, 0); 

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j]) {
                    r[i]++;
                    c[j]++;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] && (r[i] > 1 || c[j] > 1)) {
                    cnt++;
                }
            }
        }

        return cnt;
    }
};
