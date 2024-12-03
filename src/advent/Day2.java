package advent;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Day2 {
    List<String> file = Files.readAllLines(Paths.get("src/advent/reactorData"));
    boolean isAscending;
    boolean isSafeLine;


    public Day2() throws IOException {
    }

    public boolean isSafe(String line) {
        isSafeLine = true;
        List<String> parts = List.of(line.split(" "));
        List<Integer> numbers = new ArrayList<>();
        for (String part : parts) {
            numbers.add(Integer.parseInt(part));
        }
        isAscending = numbers.get(0) < numbers.get(1);
        for (int i = 1; i < numbers.size(); i++) {
            if (!isSafeLine) return false;
            int num1 = numbers.get(i - 1);
            int num2 = numbers.get(i);
            checkDifference(num1, num2);
            checkAscending(num1, num2);

        }
        return isSafeLine;
    }

    void checkDifference(int num1, int num2) {
        int tempResult = Math.abs(num1 - num2);
        if (!(tempResult > 0 && tempResult < 4)) isSafeLine = false;
    }

    void checkAscending(int num1, int num2) {
        if (num1 == num2) isSafeLine = false;
        if (isAscending && num1 > num2) isSafeLine = false;
        if (!isAscending && num1 < num2) isSafeLine = false;
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
