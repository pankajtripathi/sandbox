package strings;

public class PalindromePermutation {
    public static void main(String[] args) {
        String str = "carerac";
        System.out.println(new PalindromePermutation().canPermutePalindrome(str));

        str = "code";
        System.out.println(new PalindromePermutation().canPermutePalindrome(str));
    }

    private boolean canPermutePalindrome(String s) {
        int[] chars = new int[128];
        for (int i = 0; i < s.length(); i++)
            chars[s.charAt(i)]++;

        int oddCount = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] % 2 != 0)
                oddCount++;

            if (oddCount > 1)
                return false;
        }

        return true;
    }
}
