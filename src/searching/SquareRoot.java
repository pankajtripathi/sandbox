package searching;

public class SquareRoot {
    public static void main(String[] args) {
        System.out.println(new SquareRoot().squareRoot(9));

        System.out.println();
    }

    private int squareRoot(int a) {
        int low = 1;
        int high = a;

        while (low <= high) {
            int mid = (low + high) / 2;
            int current = mid * mid;

            if (a == current) return mid;

            if (current < a) {
                low = mid + 1;
            } else if (current > a) {
                high = mid - 1;
            }
        }

        return high;
    }
}
