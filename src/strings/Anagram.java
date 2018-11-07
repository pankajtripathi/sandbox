package strings;

import java.util.HashMap;

public class Anagram {
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println(isAnagram(s, t));

        String s1 = "aacc", t1 = "ccac";
        System.out.println(isAnagram(s1, t1));
    }

    private static boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                int count = map.get(c) + 1;
                map.put(c, count);
            } else {
                map.put(c, 1);
            }
        }

        for (char c : t.toCharArray()) {
            if (map.containsKey(c)) {
                int count = map.get(c) - 1;
                map.put(c, count);
            } else {
                return false;
            }
        }

        for (Integer value : map.values()) {
            if (value < 0)
                return false;
        }

        return true;
    }
}
