package arrays;

import java.util.ArrayList;
import java.util.List;

public class PlusOne {
    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>();
        A.add(9);
        A.add(9);

        plusOne(A);
    }

    private static void plusOne(List<Integer> A) {
        int n = A.size();
        A.set(n - 1, A.get(n - 1) + 1);

        for (int i=n-1; i > 0 && A.get(i) == 10; i--) {
            A.set(i, 0);
            A.set(i-1, A.get(i-1) + 1);
        }

        if (A.get(0) == 10) {
            A.set(0, 1);
            A.add(0);
        }
        System.out.println(A);
    }
}
