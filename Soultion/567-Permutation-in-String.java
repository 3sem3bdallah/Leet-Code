import java.util.HashMap;

class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        HashMap<Character, Integer> s1Count = new HashMap<>();
        HashMap<Character, Integer> s2Count = new HashMap<>();

        for (char c : s1.toCharArray()) {
            s1Count.put(c, s1Count.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s1.length(); i++) {
            char c = s2.charAt(i);
            s2Count.put(c, s2Count.getOrDefault(c, 0) + 1);
        }

        if (s1Count.equals(s2Count)) {
            return true;
        }

        for (int i = s1.length(); i < s2.length(); i++) {
            char newChar = s2.charAt(i);
            char oldChar = s2.charAt(i - s1.length());

            s2Count.put(newChar, s2Count.getOrDefault(newChar, 0) + 1);

            s2Count.put(oldChar, s2Count.get(oldChar) - 1);
            if (s2Count.get(oldChar) == 0) {
                s2Count.remove(oldChar);
            }

            if (s1Count.equals(s2Count)) {
                return true;
            }
        }

        return false;
    }
}
