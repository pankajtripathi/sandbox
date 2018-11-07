package bitwise;

public class PlusWithOperator {
    public static void main(String[] args) {
        System.out.println(addNumber(3, 4));
    }

    private static int addNumber(int x, int y) {
        while (y != 0) {
            int carry = x & y;
            x = x ^ y;
            y = carry << 1;
        }

        return x;
    }
}
