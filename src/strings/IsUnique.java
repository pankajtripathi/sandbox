package strings;

public class IsUnique {
    public static void main(String[] args) {
        String s1 = "abca";
        System.out.println(isUnique(s1));
    }

    private static boolean isUnique(String str1) {
        boolean[] charSet = new boolean[256];

        for (char c : str1.toCharArray()) {
            if (charSet[c]) return false;
            charSet[c] = true;
        }

        return true;
    }
}
