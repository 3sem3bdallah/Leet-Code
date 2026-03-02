1class Solution {
2    public int minSwaps(int[][] grid) {
3        int n = grid.length;
4        int[] trailingZeros = new int[n];
5        
6        for (int i = 0; i < n; i++) {
7            int count = 0;
8            for (int j = n - 1; j >= 0; j--) {
9                if (grid[i][j] == 0) count++;
10                else break;
11            }
12            trailingZeros[i] = count;
13        }
14        
15        int swaps = 0;
16        
17        for (int i = 0; i < n; i++) {
18            int needed = n - i - 1;
19            int j = i;
20            
21            while (j < n && trailingZeros[j] < needed) {
22                j++;
23            }
24            
25            if (j == n) return -1;
26            
27            while (j > i) {
28                int temp = trailingZeros[j];
29                trailingZeros[j] = trailingZeros[j - 1];
30                trailingZeros[j - 1] = temp;
31                j--;
32                swaps++;
33            }
34        }
35        
36        return swaps;
37    }
38}