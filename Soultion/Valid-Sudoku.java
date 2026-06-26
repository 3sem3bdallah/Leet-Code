1import java.util.*;
2
3class Solution {
4    public boolean isValidSudoku(char[][] board) {
5        Set<String> seen = new HashSet<>();
6
7        for (int i = 0; i < 9; i++) {
8            for (int j = 0; j < 9; j++) {
9                char number = board[i][j];
10
11                if (number != '.') {
12                    if (!seen.add(number + " in row " + i) ||
13                            !seen.add(number + " in column " + j) ||
14                            !seen.add(number + " in block " + i / 3 + "-" + j / 3))
15                        return false;
16                }
17            }
18        }
19        return true;
20    }
21}