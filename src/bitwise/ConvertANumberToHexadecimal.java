package bitwise;

/*
* Given an integer num, return a string representing its hexadecimal representation.
For negative integers, two’s complement method is used.
All the letters in the answer string should be lowercase characters, and there should not be any leading zeros
in the answer except for the zero itself.

Example 1:
Input: num = 26
Output: "1a"

Example 2:
Input: num = -1
Output: "ffffffff"
* */
public class ConvertANumberToHexadecimal {
    public static void main(String[] args) {
        System.out.println(new ConvertANumberToHexadecimal().toHex(26));
    }

    public String toHex(int num) {
        if (num == 0) return "0";
        char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        StringBuilder res = new StringBuilder();
        while (num != 0) {
            res.append(map[num & 15]);
            num >>>= 4;
        }
        return res.reverse().toString();
    }
}
