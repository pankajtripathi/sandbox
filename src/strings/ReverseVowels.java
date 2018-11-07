package strings;

public class ReverseVowels {
    public static void main(String[] args) {
        String str = "hello";
        System.out.println(new ReverseVowels().reverse(str));
    }

    private String reverse(String str) {
        if (str == null || str.length() == 0) return str;

        String vowels = "aeiouAEIOU";
        char[] chars = str.toCharArray();

        int start = 0;
        int end = str.length() - 1;

        while (start < end) {
            while (start < end && !vowels.contains(chars[start] + ""))
                start++;

            while (start < end && !vowels.contains(chars[end] + ""))
                end--;

            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;

            start++;
            end--;
        }

        return new String(chars);
    }
}
