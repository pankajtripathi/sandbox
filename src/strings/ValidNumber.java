package strings;

public class ValidNumber {
    public static void main(String[] args) {
        ValidNumber obj = new ValidNumber();
        System.out.println(obj.isNumber("95a54e53"));
        System.out.println(obj.isNumber("e9"));
        System.out.println(obj.isNumber("-123.456e789"));
        System.out.println(obj.isNumber("abc"));
    }

    private boolean isNumber(String s) {
        if (s == null || s.length() == 0) return false;
        s = s.trim();

        boolean decimal = false;
        boolean number = false;
        boolean sign = false;
        boolean exp = false;

        int low = 0;
        int high = s.length() - 1;

        while (low <= high) {
            char ch = s.charAt(low);
            if (ch == '+' || ch == '-') {
                if (sign || number) return false;
                sign = true;
            } else if (ch >= '0' && ch <= '9') {
                number = true;
            } else if (ch == '.') {
                if (decimal || exp) return false;
                decimal = true;
                sign = true;
            } else if (ch == 'e' || ch == 'E') {
                if (exp || !number) return false;
                exp = true;
                sign = false;
                number = false;
            } else {
                return false;
            }
            low++;
        }

        return number;
    }
}
