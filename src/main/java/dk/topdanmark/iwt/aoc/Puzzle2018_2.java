package dk.topdanmark.iwt.aoc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Puzzle2018_2 {
    private final static String INPUT_FILE_PATH = "D:/ITSkade/AdventOfCode/src/main/resources/input2018_2.txt";
    private static final List<String> INPUT;

    static {
        INPUT = InputReader.getStringInput(INPUT_FILE_PATH);
    }

    public static final void main(String... args) {
        Puzzle2018_2 sut = new Puzzle2018_2();
        sut.part1();
        sut.part2();
    }

    private Integer part1() {
        int twice = 0;
        int thrice = 0;

        for (String s : INPUT) {
            final List<Character> chars = s.chars().mapToObj(e -> (char) e).collect(Collectors.toList());
            Map<Character, Integer> charCount = new HashMap<>();
            for (Character c : chars) {
                if (!charCount.containsKey(c)){
                    charCount.put(c, 1);
                }else{
                    final Integer count = charCount.get(c);
                    charCount.put(c, count+1);
                }
            }
            if (charCount.containsValue(2)) twice++;
            if (charCount.containsValue(3)) thrice++;
        }

        System.out.println("RESULT of 2018 Puzzle 2 (part 1) = " + twice*thrice);
        return twice*thrice;
    }

    private String part2() {
        String output = null;

        for (String s : INPUT) {
            String match = findMatch(s);
            if (match == null) continue;
            output = removeDiff(s, match);
        }

        System.out.println("RESULT of 2018 Puzzle 2 (part 2) = " + output);
        return output;
    }

    private String removeDiff(String s, String match) {
        final List<Character> chars1 = s.chars().mapToObj(e -> (char) e).collect(Collectors.toList());
        final List<Character> chars2 = match.chars().mapToObj(e -> (char) e).collect(Collectors.toList());

        int charLength = chars1.size();
        for (int i = 0; i < charLength; i++){
            if (!chars1.get(i).equals(chars2.get(i))){
                return new StringBuilder(s).deleteCharAt(i).toString();
            }
        }
        return null;
    }

    private String findMatch(String s) {
        for (String candidate : INPUT){
            if (candidate.equals(s)) continue;

            final List<Character> chars1 = s.chars().mapToObj(e -> (char) e).collect(Collectors.toList());
            final List<Character> chars2 = candidate.chars().mapToObj(e -> (char) e).collect(Collectors.toList());

            int charLength = chars1.size();
            int numberOfDiff = 0;
            for (int i = 0; i < charLength; i++){
                if (!chars1.get(i).equals(chars2.get(i))){
                    numberOfDiff++;
                }
            }
            if (numberOfDiff <= 1) return candidate;
        }
        return null;
    }
}