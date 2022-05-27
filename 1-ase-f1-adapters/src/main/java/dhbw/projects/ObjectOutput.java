package dhbw.projects;

import java.util.Collections;
import java.util.Map;

public class ObjectOutput {

    private String output = "";
    private final int width = 123;
    private final String endSeperator = ("\n" + String.join("", Collections.nCopies(width+1, "=")) + "\n");

    public ObjectOutput(Map<String, String> strings, String outputName){
        getHeader(outputName);
        getBody(strings);
        output += endSeperator;
    }

    private void getHeader(String headerTitle){
        StringBuilder header = new StringBuilder(headerTitle);
        while (header.length() < width) {
            header = new StringBuilder("=" + header + "=");
        }
        if (header.length() == width) {
            header.append("=");
        }
        output += header +"\n";
    }

    private void getBody(Map<String, String> strings){
        double value = (strings.size()) / 5.0;
        int maxColumn = (int) Math.floor(value) + 1;
        int endObj = strings.size() % 5;

        for (int i = 0; i < (Math.min(strings.size(), 5)); i++) {
            if (i == endObj) {
                maxColumn--;
            }
            for (int j = 0; j < maxColumn; j++) {
                output += String.format("%5s", "[" + (i + 1 + (5 * j)) + "] ");
                output += String.format("%-21s", strings.get(String.valueOf(i + 1 + (5 * j))));
            }
            if (i < (Math.min(strings.size(), 5) - 1)) {
                output += "\n";
            }
        }
    }

    public String getOutput() {
        return output;
    }
}
