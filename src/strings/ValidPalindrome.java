package strings;

public class ValidPalindrome {
    public static void main(String[] args) {
        String str1 = "A man, a plan, a canal: Panama";
        String str2 = "race a car";

        System.out.println(new ValidPalindrome().isPalindrome(str1));
        System.out.println(new ValidPalindrome().isPalindrome(str2));
    }

    private boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            while (!Character.isLetterOrDigit(s.charAt(start)) && start < end)
                start++;

            while (!Character.isLetterOrDigit(s.charAt(end)) && end > start)
                end--;

            if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end)))
                return false;

            start++;
            end--;
        }

        return true;
    }
}
