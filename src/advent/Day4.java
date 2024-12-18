package advent;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Day4 {
    List<String> file;
    List<char[]> arrayOfChars;


    public Day4() throws IOException {
        file = Files.readAllLines(Paths.get("src/advent/resources/wordSearchInput"));
        arrayOfChars = new ArrayList<>();
        for (String s : file) {
            arrayOfChars.add(s.toCharArray());
        }
    }

    void countForXmas() {

        int counter = 0;
        for (int i = 0; i < arrayOfChars.size(); i++) {
            for (int j = 0; j < arrayOfChars.get(i).length; j++) {
                if (arrayOfChars.get(i)[j] == 'X') {
                    if (j >= 3 && arrayOfChars.get(i)[j - 1] == 'M' && arrayOfChars.get(i)[j - 2] == 'A' && arrayOfChars.get(i)[j - 3] == 'S') {
                        counter++; //right
                    }
                    if (j + 3 < arrayOfChars.get(i).length && arrayOfChars.get(i)[j + 1] == 'M' && arrayOfChars.get(i)[j + 2] == 'A' && arrayOfChars.get(i)[j + 3] == 'S') {
                        counter++; //left
                    }
                    if (i >= 3 && arrayOfChars.get(i - 1)[j] == 'M' && arrayOfChars.get(i - 2)[j] == 'A' && arrayOfChars.get(i - 3)[j] == 'S') {
                        counter++; //up
                    }
                    if (i + 3 <= arrayOfChars.size() && arrayOfChars.get(i + 1)[j] == 'M' && arrayOfChars.get(i + 2)[j] == 'A' && arrayOfChars.get(i + 3)[j] == 'S') {
                        counter++; //down
                    }
                    if (j >= 3 && i >= 3 && arrayOfChars.get(i - 1)[j - 1] == 'M' && arrayOfChars.get(i - 2)[j - 2] == 'A' && arrayOfChars.get(i - 3)[j - 3] == 'S') {
                        counter++; //diag up-left
                    }
                    if (j + 3 < arrayOfChars.get(i).length && i + 3 < arrayOfChars.size() && arrayOfChars.get(i + 1)[j + 1] == 'M' && arrayOfChars.get(i + 2)[j + 2] == 'A' && arrayOfChars.get(i + 3)[j + 3] == 'S') {
                        counter++; //diag down-right
                    }
                    if (j >= 3 && i + 3 < arrayOfChars.size() && arrayOfChars.get(i + 1)[j - 1] == 'M' && arrayOfChars.get(i + 2)[j - 2] == 'A' && arrayOfChars.get(i + 3)[j - 3] == 'S') {
                        counter++; //diag up-right
                    }
                    if (i >= 3 && j + 3 < arrayOfChars.get(i).length && arrayOfChars.get(i - 1)[j + 1] == 'M' && arrayOfChars.get(i - 2)[j + 2] == 'A' && arrayOfChars.get(i - 3)[j + 3] == 'S') {
                        counter++; //diag down-left
                    }
                }
            }

        }
        System.out.println(counter);
    }

    void xShapedMasCounter() {
        int counter = 0;
        for (int i = 0; i < arrayOfChars.size(); i++) {
            for (int j = 0; j < arrayOfChars.get(i).length; j++) {
                if (arrayOfChars.get(i)[j] == 'A' && j > 0 && i > 0 && i + 1 < arrayOfChars.size() && j + 1 < arrayOfChars.get(i).length) {
                    if ((arrayOfChars.get(i + 1)[j + 1] == 'M' && arrayOfChars.get(i - 1)[j - 1] == 'S') || (arrayOfChars.get(i + 1)[j + 1] == 'S' && arrayOfChars.get(i - 1)[j - 1] == 'M'))
                        if ((arrayOfChars.get(i - 1)[j + 1] == 'M' && arrayOfChars.get(i + 1)[j - 1] == 'S') || (arrayOfChars.get(i - 1)[j + 1] == 'S' && arrayOfChars.get(i + 1)[j - 1] == 'M')) {
                            counter++;
                        }
                }
            }
        }
        System.out.println(counter);
    }


    public static void main(String[] args) throws IOException {
        var d = new Day4();
        d.countForXmas();
        d.xShapedMasCounter();
    }

}
