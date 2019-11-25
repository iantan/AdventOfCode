package dk.topdanmark.iwt.aoc;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class InputReader {

    public static List<Integer> getIntegerInput(String inputFilePath) {
        List<Integer> input = new LinkedList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(new File(inputFilePath)))){
            while (reader.ready()) {
                input.add(Integer.parseInt(reader.readLine()));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return input;
    }

    public static List<String> getStringInput(String inputFilePath) {
        List<String> input = new LinkedList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(new File(inputFilePath)))){
            while (reader.ready()) {
                input.add(reader.readLine());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return input;

    }

}
