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
        System.out.println(new UniqueBSTs().numTreesDP(3));
    }

    private int numTrees(int n) {
        int C = 1;
        for (int i = 0; i < n; i++) {
            C = C * 2 * (2 * i + 1) / (i + 2);
        }

        return C;
    }

    public int numTreesDP(int n) {
        int [] G = new int[n+1];
        G[0] = G[1] = 1;

        for(int i=2; i<=n; ++i) {
            for(int j=1; j<=i; ++j) {
                G[i] += G[j-1] * G[i-j];
            }
        }

        return G[n];
    }
}
