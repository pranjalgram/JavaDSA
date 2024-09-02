package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Consumer;

public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0)
            return -1;

        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;

        // Add all initially rotten oranges to the queue and count fresh oranges
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    queue.add(new int[] { r, c });
                } else if (grid[r][c] == 1) {
                    freshOranges++;
                }
            }
        }

        if (freshOranges == 0)
            return 0; // No fresh oranges, so return 0

        int minutes = 0;
        int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        // BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rottenInThisMinute = false;

            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();
                assert point != null;
                int r = point[0];
                int c = point[1];

                for (int[] dir : directions) {
                    int newRow = r + dir[0];
                    int newCol = c + dir[1];

                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                        queue.add(new int[] { newRow, newCol });
                        freshOranges--;
                        rottenInThisMinute = true;
                    }
                }
            }

            if (rottenInThisMinute)
                minutes++;
        }

        // If there are still fresh oranges, return -1
        return freshOranges == 0 ? minutes : -1;
    }

    public static void main(String[] args) {
        RottingOranges ro = new RottingOranges();
        int[][] grid = {
                { 2, 1, 1 },
                { 1, 1, 0 },
                { 0, 1, 1 }
        };
        System.out.println(ro.orangesRotting(grid)); // Output: 4

        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(5);
        numbers.add(9);
        numbers.add(8);
        numbers.add(1);
        Consumer<Integer> method = (n) -> {
            System.out.println(n);
        };

        numbers.forEach(method);

        numbers.forEach((n) -> {
            System.out.println(n);
        });

        Consumer<Integer> methodNew = System.out::println;

        numbers.forEach(methodNew);

        numbers.forEach(System.out::println);

        Iterator<Integer> it = numbers.iterator();
        while (it.hasNext()) {
            Integer i = it.next();
            if (i < 10) {
                it.remove();
            }
        }
        System.out.println(numbers);

        numbers.removeIf(i -> i < 10);
        System.out.println(numbers);
    }
}
