impl Solution {
    pub fn to_lower_case(s: String) -> String {
        
        let mut res = String::new();

        for ch in s.chars() {

            if ch >= 'A' && ch <= 'Z' {
                let lower = ((ch as u8) +32) as char;
                res.push(lower);
                
            } else {
                res.push(ch);
            }
        }
        res
    }
}