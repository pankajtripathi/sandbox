package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SampleOfflineData {
    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>();
        A.add(3);
        A.add(7);
        A.add(5);
        A.add(11);

        new SampleOfflineData().randomSampling(3, A);
    }

    private void randomSampling(int k, List<Integer> A) {
        Random random = new Random();
        for (int i = 0; i < k; i++) {
            Collections.swap(A, i, i + random.nextInt(A.size() - i));
        }

        System.out.println(A);
    }
}
