class Solution {
  int minTimeToReach(List<List<int>> moveTime) {
    int n = moveTime.length;
    int m = moveTime[0].length;
    List<List<bool>> visited = List.generate(n, (_) => List.filled(m, false));
    
    List<List<int>> bestTime = List.generate(n, (_) => List.filled(m, 1 << 30));
    List<List<int>> dir = [
      [-1, 0],
      [0, 1],
      [1, 0],
      [0, -1]
    ];
    
    int ans = 1 << 30;

    void _helper(int i, int j, int time) {
      // Prune worse paths
      if (time >= bestTime[i][j]) return;
      bestTime[i][j] = time;

      if (i == n - 1 && j == m - 1) {
        ans = min(ans, time);
        return;
      }

      for (List<int> d in dir) {
        int x = i + d[0];
        int y = j + d[1];
        if (x >= 0 && x < n && y >= 0 && y < m && !visited[x][y]) {
          visited[x][y] = true;
          int wait = moveTime[x][y];
          int nextTime = wait > time ? wait + 1 : time + 1;
          if (i == 0 && j == 0 && wait <= time) {
            nextTime = 1 + wait;
          }
          _helper(x, y, nextTime);
          visited[x][y] = false;
        }
      }
    }

    visited[0][0] = true;
    _helper(0, 0, 0);
    return ans;
  }
}