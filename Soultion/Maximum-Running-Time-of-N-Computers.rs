1impl Solution {
2    pub fn max_run_time(n: i32, batteries: Vec<i32>) -> i64 {
3        let n = n as i64;
4        let mut lt = 0;
5        let mut rt = batteries.iter().map(|&b| b as i64).sum();
6
7        while lt < rt {
8            let m = (lt + rt + 1) / 2;
9            let t = batteries.iter().map(|&b| (b as i64).min(m)).sum();
10
11            if n * m <= t {
12                lt = m;
13            } else {
14                rt = m - 1;
15            }
16        }
17
18        lt
19    }
20}