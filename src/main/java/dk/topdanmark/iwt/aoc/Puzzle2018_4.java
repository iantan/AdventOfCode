package dk.topdanmark.iwt.aoc;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Puzzle2018_4 {
    private final static String INPUT_FILE_PATH = "D:/ITSkade/AdventOfCode/src/main/resources/input2018_4.txt";
    private static final List<String> RAW_INPUT;

    final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    static {
        RAW_INPUT = InputReader.getStringInput(INPUT_FILE_PATH);
    }

    Puzzle2018_4(){
        parseInput();
    }

    public static final void main(String... args) {
        Puzzle2018_4 sut = new Puzzle2018_4();
        sut.part1();
        sut.part2();
    }

    private Integer part1() {
//        System.out.println("RESULT of 2018 Puzzle 3 (part 1) = " + size);
        return null;
    }

    private String part2() {
        return null;
    }

    private void parseInput(){
        Map<LocalDateTime, String> entries = getOrderedEntries();

    }

    private Map<LocalDateTime, String> getOrderedEntries(){
        Map<LocalDateTime, String> entries = new TreeMap<>();
        for (String input : RAW_INPUT){
            String logEntryDateTime = input.substring(1, 17);
            LocalDateTime dateTime = LocalDateTime.parse(logEntryDateTime, formatter);
            String logText = input.substring(19);
            entries.put(dateTime, logText);
        }
        return entries;
    }

}