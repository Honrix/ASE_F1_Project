package dhbw.projects;

import java.util.Collections;
import java.util.Map;

public class ValuesService {

    public ValuesService(){

    }

    public String sortedOutput(Map<String, String> strings, String outputName) {
        String output = "";

        StringBuilder header = new StringBuilder(outputName);
        while (header.length() < 123) {
            header = new StringBuilder("=" + header + "=");
        }
        if (header.length() == 123) {
            header.append("=");
        }
        output += header +"\n";

        double value = (strings.size()) / 5.0;
        int maxColumn = (int) Math.floor(value) + 1;
        int endObj = strings.size() % 5;

        for (int i = 0; i < (Math.min(strings.size(), 5)); i++) {
            if (i == endObj) {
                maxColumn--;
            }
            for (int j = 0; j < maxColumn; j++) {
                output += String.format("%5s", "[" + (i + 1 + (5 * j)) + "] ");
                output += String.format("%-21s", strings.get(String.valueOf(i + (5 * j))));
            }
            if (i < (Math.min(strings.size(), 5) - 1)) {
                output += "\n";
            }
        }
        output += ("\n" + String.join("", Collections.nCopies(124, "=")) + "\n");

        return output;
    }

}
