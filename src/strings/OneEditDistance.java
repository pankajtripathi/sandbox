package strings;

public class OneEditDistance {
    public static void main(String[] args) {
        String s = "ab", t = "acb";
        System.out.println(new OneEditDistance().isOneEditDistance(s, t));
    }

    public boolean isOneEditDistance(String s, String t) {
        int minLen = Math.min(s.length(), t.length());

        //iterate through the length of the smaller string
        for (int i = 0; i < minLen; i++) {

            //if the current characters of the two strings are not equal
            if (s.charAt(i) != t.charAt(i)) {

                //return true if the remainder of the two strings are equal, false otherwise
                if (s.length() == t.length()) {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                }
                //return true if the strings would be the same if you deleted a character from string t
                else if (s.length() < t.length()) {
                    return t.substring(i + 1).equals(s.substring(i));
                } else
                    //return true if the strings would be the same if you deleted a character from string s
                    return s.substring(i + 1).equals(t.substring(i));
            }
        }

        //if all characters match for the length of the two strings check if the two strings' lengths do not differ by more than 1
        return Math.abs(s.length() - t.length()) == 1;
    }
}
