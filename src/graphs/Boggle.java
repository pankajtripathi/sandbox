package graphs;

import java.util.HashSet;
import java.util.Set;

public class Boggle {
    Set<String> words = new HashSet<>();
    public static void main(String[] args) {
        Boggle b = new Boggle();

        b.words.add("GEEKS");
        b.words.add("GO");
        b.words.add("QUIZ");

        char graph[][] = {
                {'G','I','Z'},
                {'U','E','K'},
                {'Q','S','E'}

        };
        b.getWords(graph);
    }

    private void getWords(char[][] graph) {
        int M = graph.length;
        int N = graph[0].length;
        boolean[][] visited = new boolean[M][N];

        String result = "";
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                dfs(graph, visited, i, j, result);
            }
        }
    }

    private void dfs(char[][] graph, boolean[][] visited, int i, int j, String result) {
        visited[i][j] = true;
        result += graph[i][j];

        if (words.contains(result)) System.out.println(result);

        for (int row = i - 1; row <= i + 1 && row < graph.length; row++) {
            for (int col = j - 1; col <= j + 1 && col < graph[0].length; col++) {
                if (row >= 0 && col >= 0 && !visited[row][col]) {
                    dfs(graph, visited, row, col, result);
                }
            }
        }

        visited[i][j] = false;
    }
}
