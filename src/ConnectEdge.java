/**
 * Created by ziyaoli on 10/22/18.
 */
import java.util.*;

public class ConnectEdge {
    public static void main(String[] args) {
        int[][] M = new int[][] {{1,0,0,0,0}, {1,1,0,1,0}, {0,0,0,1,0},{1,1,0,1,0},{0,1,0,0,1}};
        //int[][] M = new int[][] {{1,1,1,1,1}, {1,1,1,1,1}, {1,1,0,1,1},{1,1,1,1,1},{1,1,1,1,1}};
        //int[][] M = new int[][] {{0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};
        int[][] res = new ConnectEdge().connect(M);
        for (int[] i : res) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    private int[][] connect(int[][] M) {
        int row = M.length;
        int col = M[0].length;
        boolean[][] visited = new boolean[row][col];
        int[][] result = new int[row][col];
        Deque<Cell> queue = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            queue.offerLast(new Cell(i, 0, M[i][0]));
            queue.offerLast(new Cell(i, col - 1, M[i][col - 1]));
            visited[i][0] = true;
            visited[i][col - 1] = true;
        }

        for (int j = 1; j < col; j++) {
            queue.offerLast(new Cell(0, j, M[0][j]));
            queue.offerLast(new Cell(row - 1, j, M[row - 1][j]));
            visited[0][j] = true;
            visited[row - 1][j] = true;
        }

        while (!queue.isEmpty()) {
            Cell cur = queue.pollFirst();
            int x = cur.x;
            int y = cur.y;
            int v = cur.value;
            visited[x][y] = true;

            if (v == 1) {
                result[x][y] = 1;
                if (x >= 1 && !visited[x - 1][y]) {
                    queue.offer(new Cell(x - 1, y, M[x - 1][y]));
                }
                if (x < row - 1 && !visited[x + 1][y]) {
                    queue.offer(new Cell(x + 1, y, M[x + 1][y]));
                }
                if (y >= 1 && !visited[x][y - 1]) {
                    queue.offer(new Cell(x, y - 1, M[x][y - 1]));
                }
                if (y < col - 1 && !visited[x][y + 1]) {
                    queue.offer(new Cell(x, y + 1, M[x][y + 1]));
                }
            }
        }
        return result;
    }
}

class Cell {
    int x;
    int y;
    int value;

    Cell(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }
}
