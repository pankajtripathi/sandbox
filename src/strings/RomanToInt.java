package strings;

import java.util.HashMap;

public class RomanToInt {
    public static void main(String[] args) {
        String str = "III";
        System.out.println(new RomanToInt().romanToInt(str));
    }

    private int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if ((map.get(s.charAt(i)) < map.get(s.charAt(i + 1)))) {
                result -= map.get(s.charAt(i));
            } else {
                result += map.get(s.charAt(i));
            }
        }

        result += map.get(s.charAt(s.length() - 1));
        return result;
    }
}
