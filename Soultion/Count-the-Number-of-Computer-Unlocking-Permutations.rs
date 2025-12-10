1impl Solution {
2    pub fn count_permutations(complexity: Vec<i32>) -> i32 {
3        const MOD: i64 = 1_000_000_007;
4        let n = complexity.len();
5        let first = complexity[0];
6
7        for &x in &complexity[1..] {
8            if x <= first {
9                return 0;
10            }
11        }
12
13        let mut fact: i64 = 1;
14        for i in 2..n as i64 {
15            fact = (fact * i) % MOD;
16        }
17
18        fact as i32
19    }
20}