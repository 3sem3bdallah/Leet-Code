1class Solution {
2    public long[] distance(int[] nums) {
3        int n = nums.length;
4        long[] res = new long[n];
5
6        // value -> list of indices
7        Map<Integer, List<Integer>> map = new HashMap<>();
8
9        for (int i = 0; i < n; i++) {
10            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
11        }
12
13        // process each group
14        for (List<Integer> list : map.values()) {
15            int size = list.size();
16
17            // prefix sum array
18            long[] prefix = new long[size + 1];
19            for (int i = 0; i < size; i++) {
20                prefix[i + 1] = prefix[i] + list.get(i);
21            }
22
23            for (int i = 0; i < size; i++) {
24                int idx = list.get(i);
25
26                // left side
27                long left = (long) idx * i - prefix[i];
28
29                // right side
30                long right = (prefix[size] - prefix[i + 1]) - (long) idx * (size - i - 1);
31
32                res[idx] = left + right;
33            }
34        }
35
36        return res;
37    }
38}