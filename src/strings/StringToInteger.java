package strings;

public class StringToInteger {
    public static void main(String[] args) {
        System.out.println(new StringToInteger().myAtoi("-42"));
    }

    public int myAtoi(String s) {
        if (s.length() == 0 || s.equals(" ")) return 0;

        int index = 0;
        int res = 0;
        int sign = 1;

        // 1. Discard space
        while (s.charAt(index) == ' ') index++;

        // 2. Check sign
        if (s.charAt(index) == '-' || s.charAt(index) == '+') {
            sign = s.charAt(index) == '-' ? -1 : 1;
            index++;
        }

        // 3. Add digits
        while (index < s.length()) {
            int digit = Character.getNumericValue(s.charAt(index));

            // Check if valid digit
            if (digit < 0 || digit > 9) break;

            // Check for overflow errors
            if (res > Integer.MAX_VALUE / 10 || res == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;

            res = res * 10 + digit;
            index++;
        }

        return sign * res;
    }
}
