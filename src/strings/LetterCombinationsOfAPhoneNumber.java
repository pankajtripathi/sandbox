package strings;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        String str = "23";
        System.out.println(new LetterCombinationsOfAPhoneNumber().letterCombinations(str));
    }

    private List<String> letterCombinations(String digits) {
        String[] map = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) return result;
        result.add("");

        for (int i = 0; i < digits.length(); i++) {
            List<String> temp = new ArrayList<>();
            int digit = digits.charAt(i) - '0';
            String characters = map[digit];

            for (int c = 0; c < characters.length(); c++) {
                for (int r = 0; r < result.size(); r++) {
                    temp.add(result.get(r) + characters.charAt(c));
                }
            }
            result = temp;
        }
        return result;
    }
}
