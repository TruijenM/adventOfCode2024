package advent;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day1 {
    ArrayList<Integer> firstList = new ArrayList<>();
    ArrayList<Integer> secondList = new ArrayList<>();


    public Day1() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("src/advent/locations"));
            String line = reader.readLine();
            while (line != null) {
                String[] parts = line.split(" +");
                firstList.add(Integer.parseInt(parts[0]));
                secondList.add(Integer.parseInt(parts[1]));
                line = reader.readLine();
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
            int numberOfOccurances = (int) secondList
                    .stream()
                    .filter(integer -> integer == firstListInt)
                    .count();
            result += numberOfOccurances * firstListInt;
        }
        return result;
    }

    public static void main(String[] args) {
        Day1 calculator = new Day1();

        System.out.println("Total distance between your lists: " + calculator.calculateDifference());
        System.out.println("Similarity score : " + calculator.calculateSimilarity());
    }

}

