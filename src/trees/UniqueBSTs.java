package trees;

/*
* Actually, as it turns out, the sequence of G(n)G(n) function results is known as Catalan number Cn
* and one of the more convenient forms for calculation is defined as follows:
* Cn+1 = Cn * 2 (2n + 1) / n + 2;

We skip the proof here, which one can find following the above reference.
* */
public class UniqueBSTs {
    public static void main(String[] args) {
        System.out.println(new UniqueBSTs().numTrees(3));
    }

    private int numTrees(int n) {
        int C = 1;
        for (int i = 0; i < n; i++) {
            C = C * 2 * (2 * i + 1) / (i + 2);
        }

        return C;
    }
}
