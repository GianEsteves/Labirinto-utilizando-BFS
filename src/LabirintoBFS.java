import java.util.LinkedList;
import java.util.Queue;

public class LabirintoBFS {

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static boolean isSafe(int[][] labirinto, int row, int col, boolean[][] visited) {
        int rows = labirinto.length;
        int cols = labirinto[0].length;

        return (row >= 0 && row < rows && col >= 0 && col < cols && labirinto[row][col] == 1 && !visited[row][col]);
    }

    public static void printCaminho(int[][] labirinto, int[][] caminho) {
        int rows = labirinto.length;
        int cols = labirinto[0].length;

        System.out.println("Caminho:");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (caminho[i][j] == -1) {
                    System.out.print("S "); // Início
                } else if (caminho[i][j] == Integer.MAX_VALUE) {
                    System.out.print("E "); // Fim
                } else if (labirinto[i][j] == 0) {
                    System.out.print("# "); // Parede
                } else {
                    System.out.print("0 "); // Caminho
                }
            }
            System.out.println();
        }
    }

    public static void BFS(int[][] labirinto, Point inicio, Point fim) {
        int rows = labirinto.length;
        int cols = labirinto[0].length;

        boolean[][] visited = new boolean[rows][cols];
        int[][] caminho = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                visited[i][j] = false;
                caminho[i][j] = -1;
            }
        }

        Queue<Point> queue = new LinkedList<>();
        queue.add(inicio);
        visited[inicio.x][inicio.y] = true;
        caminho[inicio.x][inicio.y] = 0;

        int[] rowMoves = {-1, 0, 1, 0};
        int[] colMoves = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            Point pontoAtual = queue.poll();

            for (int i = 0; i < 4; i++) {
                int newRow = pontoAtual.x + rowMoves[i];
                int newCol = pontoAtual.y + colMoves[i];

                if (isSafe(labirinto, newRow, newCol, visited)) {
                    queue.add(new Point(newRow, newCol));
                    visited[newRow][newCol] = true;
                    caminho[newRow][newCol] = caminho[pontoAtual.x][pontoAtual.y] + 1;

                    if (newRow == fim.x && newCol == fim.y) {
                        printCaminho(labirinto, caminho);
                        return;
                    }
                }
            }
        }

        System.out.println("Não há caminho possível para o destino.");
    }


}
