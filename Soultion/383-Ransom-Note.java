import java.util.HashMap;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> charCount = new HashMap<>();
        
        for (char ch : magazine.toCharArray()) {
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
        }

        for (char ch : ransomNote.toCharArray()) {
            if (charCount.containsKey(ch) && charCount.get(ch) > 0) {
                charCount.put(ch, charCount.get(ch) - 1); 
            } else {
                return false; 
            }
        }
        
        return true;
    }

    // public static void main(String[] args) {
    //     Solution solution = new Solution();
        
    //     System.out.println(solution.canConstruct(\a\, \b\));   
    //     System.out.println(solution.canConstruct(\aa\, \ab\));     
    //     System.out.println(solution.canConstruct(\aa\, \aab\));    
    // }
}
