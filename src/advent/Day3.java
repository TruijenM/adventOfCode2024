package advent;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3 {
    List<String> exampleLines;
    List<String> inputLines;

    public Day3() throws IOException {
        exampleLines = Files.readAllLines(Paths.get("src/advent/resources/exampleInputDay3"));
        inputLines = Files.readAllLines(Paths.get("src/advent/resources/corruptedComputerInput"));
    }

    int resultFromLine(String line) {
        int result = 0;
        Pattern pattern = Pattern.compile("mul[(]\\d{1,3},\\d{1,3}[)]");
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            String found = matcher.group();
            String clean = found.replace("mul(", "").replace(")", "");
            String[] parts = clean.split(",");
            result += Integer.parseInt(parts[0]) * Integer.parseInt(parts[1]);
        }
        return result;
    }

    int getTotalResult(List<String> lines) {
        int result = 0;
        for (String line : lines) {
            result += resultFromLine(line);
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        var d = new Day3();
        System.out.println(d.getTotalResult(d.inputLines));
    }
}
