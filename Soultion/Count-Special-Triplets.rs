1impl Solution {
2    pub fn special_triplets(nums: Vec<i32>) -> i32 {
3        const MOD: i64=1000000007;
4        const M: usize=100001;
5        let n=nums.len();
6        let mut freq: [i32; M]=[0; M];
7        let mut prev: [i32; M]=[0; M];
8        for i in 0..n{ freq[nums[i] as usize]+=1; }
9        let mut cnt=0 as i64;
10        prev[nums[0] as usize]+=1;
11        freq[nums[0] as usize]-=1;
12        for i in 1..(n-1){
13            let x=nums[i] as usize;
14            let x2=x<<1;
15            freq[x]-=1;
16            if x2<M{
17                cnt+=(prev[x2] as i64)*(freq[x2] as i64);
18            }
19            prev[x]+=1;
20        }
21        (cnt%MOD) as i32
22    }
23}