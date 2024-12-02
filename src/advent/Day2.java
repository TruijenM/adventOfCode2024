package advent;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Day2 {
    List<String> file = Files.readAllLines(Paths.get("src/advent/reactorData"));

    public Day2() throws IOException {
    }

    public boolean isSafe(String line) {
        String[] parts = line.split(" ");
        int[] numbers = Arrays.stream(parts).mapToInt(Integer::parseInt).toArray();
        return isValid(numbers) && getDifference(numbers);
    }

    boolean getDifference(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            int tempResult = Math.abs(numbers[i] - numbers[i + 1]);
            if (!(tempResult > 0 && tempResult < 4)) return false;
        }
        return true;
    }

    boolean isValid(int[] numbers) {
        if (numbers[0] == numbers[1]) return false;
        boolean ascending = (numbers[0] < numbers[1]);
        if (ascending) {
            for (int i = 0; i < numbers.length - 1; i++) {
                if (!(numbers[i] < numbers[i + 1])) return false;
            }
        }
        if (!ascending) {
            for (int i = 0; i < numbers.length - 1; i++) {
                if (!(numbers[i] > numbers[i + 1])) return false;
            }
        }
        return true;
    }

    public int numberOfSafe() {
        int count = 0;
        for (String line : file) {
            if (isSafe(line)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        var day2 = new Day2();
        System.out.println(day2.numberOfSafe());
    }

}
