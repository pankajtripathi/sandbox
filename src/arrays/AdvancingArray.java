package arrays;

public class AdvancingArray {
    public static void main(String[] args) {
        int[] game1 = {3, 3, 1, 0, 2, 0, 1};
        System.out.println(new AdvancingArray().canBeReached(game1));

        int[] game2 = {3, 2, 0, 0, 2, 0, 1};
        System.out.println(new AdvancingArray().canBeReached(game2));
    }

    private boolean canBeReached(int[] game) {
        int farthestReached = 0;
        int lastIndex = game.length - 1;

        for (int i = 0; i <= farthestReached && farthestReached < lastIndex; i++) {
            // Max index that can be reached from present index. It is current index pos plus moves that can be made
            // from that index.
            farthestReached = Math.max(farthestReached, i + game[i]);
        }

        return farthestReached >= lastIndex;
    }
}
