package dk.topdanmark.iwt.aoc;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Puzzle2018_1 {

    private final static String INPUT_FILE_PATH = "D:/ITSkade/AdventOfCode/src/main/resources/input2018_1.txt";
    private static final List<Integer> INPUT;

    private Integer runningTotal;
    private List<Integer> totals;

    static{
        INPUT = InputReader.getIntegerInput(INPUT_FILE_PATH);
    }

    private Puzzle2018_1() {
        runningTotal = new Integer(0);
        totals = new LinkedList<>();
    }

    public static final void main(String... args) throws IOException {
        Puzzle2018_1 sut = new Puzzle2018_1();
        sut.part1();
        sut.part2();
    }

    private Integer part1() {
        final Integer result = INPUT.stream().reduce(0, Integer::sum);
        System.out.println("RESULT of 2018 Puzzle 1 (part 1) = " + result);
        return result;
    }

    private Integer part2() {
        Integer result = null;
        while (result == null) {
            result = this.getFirstReoccurrence();
        }
        System.out.println("RESULT of 2018 Puzzle 1 (part 2) = " + result);
        return result;
    }

    private Integer getFirstReoccurrence() {
        Integer output = null;
        for (Integer input : INPUT) {
            runningTotal = runningTotal + input;
            if (totals.contains(runningTotal)) {
                output = runningTotal;
                break;
            } else {
                totals.add(runningTotal);
            }
        }
        return output;
    }

}
