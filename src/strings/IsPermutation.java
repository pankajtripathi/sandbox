package strings;

public class IsPermutation {
    public static void main(String[] args) {
        String s = "ABC";
        String t = "CAB";

        System.out.println(isPermutation(s, t));
    }

    private static boolean isPermutation(String str1, String str2) {
        if(str1.length() == 0 && str2.length() == 0) return true;
        if(str1.length() == 0 || str2.length() == 0) return false;
        if(str1.length() != str2.length()) return false;

        char[] set = new char[256];

        for (char c : str1.toCharArray()) {
            set[c]++;
        }

        for (char c : str2.toCharArray()) {
            set[c]--;
            if (set[c] < 0) return false;
        }
        return true;
    }
}
