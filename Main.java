import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //Get input:
        Scanner scn = new Scanner(System.in);
        System.out.print("CSV filepath: ");
        String filepath = scn.nextLine();

        //Read lines:
        List<String> lines = new ArrayList<>();
        Path path = Paths.get(filepath);
        try {
            lines = Files.readAllLines(path);
        }
        catch (Exception e) {
            System.out.println(e.toString());
            System.exit(0);
        }

        //Store output values in floating value list:
        List<Double> outputVals = new ArrayList<>();
        for (String line : lines) {
            String[] raw = line.split(",");
            String end = raw[raw.length - 1];
            double out = Double.valueOf(end);
            outputVals.add(out);
        }

        //Displays input CSV without output:
        System.out.println("new inputs:");
        for (String line : lines) {
            String[] split = line.split(",");
            String _new = "";
            for (int i = 0; i < split.length - 1; i++) {
                _new = _new + split[i];
                if (i < split.length - 2) {
                    _new = _new + ",";
                }
            }
            System.out.println(_new);
        }

        //Displays outputs alone:
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("new outputs: ");
        for (Double val : outputVals) {
            System.out.println(val);
        }
    }
}
