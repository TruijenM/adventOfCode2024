package advent;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Day1 {
    ArrayList<Integer> firstList = new ArrayList<>();
    ArrayList<Integer> secondList = new ArrayList<>();


    public Day1() {
        try {
            List<String> file = Files.readAllLines(Paths.get("src/advent/resources/locations"));
            for (String s : file) {
                String [] parts=s.split(" +");
                firstList.add(Integer.parseInt(parts[0]));
                secondList.add(Integer.parseInt(parts[1]));
            }
            firstList.sort(Integer::compareTo);
            secondList.sort(Integer::compareTo);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Integer calculateDifference() {
        int result = 0;
        for (int i = 0; i < firstList.size(); i++) {
            result += Math.abs(firstList.get(i) - secondList.get(i));
        }
        return result;
    }

    public Integer calculateSimilarity() {
        int result = 0;
        for (int firstListInt : firstList) {
            int numberOfOccurrences = (int) secondList
                    .stream()
                    .filter(integer -> integer == firstListInt)
                    .count();
            result += numberOfOccurrences * firstListInt;
        }
        return result;
    }

    public static void main(String[] args) {
        Day1 calculator = new Day1();

        System.out.println("Total distance between your lists: " + calculator.calculateDifference());
        System.out.println("Similarity score : " + calculator.calculateSimilarity());
    }

}

