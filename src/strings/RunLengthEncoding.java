package strings;

public class RunLengthEncoding {
    public static void main(String[] args) {
        String str = "eeeffffee";

        String encoded = new RunLengthEncoding().encoding(str);
        System.out.println(encoded);

        String decoded = new RunLengthEncoding().decode(encoded);
        System.out.println(decoded);
    }

    private String encoding(String str) {
        StringBuilder res = new StringBuilder();
        int count = 1;
        for (int i = 1; i <= str.length(); i++) {
            if (i == str.length() || str.charAt(i) != str.charAt(i - 1)) {
                res.append(count);
                res.append(str.charAt(i- 1));
                count = 1;
            } else {
                count++;
            }
        }
        return res.toString();
    }

    private String decode(String str) {
        StringBuilder res = new StringBuilder();
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                count = count * 10 + str.charAt(i) - '0';
            } else { // character
                while (count > 0) {
                    res.append(str.charAt(i));
                    count--;
                }
            }
        }

        return res.toString();
    }
}
