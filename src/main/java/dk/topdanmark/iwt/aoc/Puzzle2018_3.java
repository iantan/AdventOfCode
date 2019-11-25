package dk.topdanmark.iwt.aoc;

import java.util.*;
import java.util.stream.Collectors;

public class Puzzle2018_3 {
    private final static String INPUT_FILE_PATH = "D:/ITSkade/AdventOfCode/src/main/resources/input2018_3.txt";
    private static final List<String> INPUT;
    private final List<Claim> CLAIMS;

    static {
        INPUT = InputReader.getStringInput(INPUT_FILE_PATH);
    }

    Puzzle2018_3() {
        CLAIMS = parseInput();
    }

    public static final void main(String... args) {
        Puzzle2018_3 sut = new Puzzle2018_3();
        sut.part1();
        sut.part2();
    }

    private Integer part1() {
        final int size = getAllCoordinatesUsedMoreThanOnce().size();
        System.out.println("RESULT of 2018 Puzzle 3 (part 1) = " + size);
        return size;
    }

    private String part2() {
        String output = null;
        final Set<Coordinate> allCoordinatesUsedMoreThanOnce = getAllCoordinatesUsedMoreThanOnce();

        for (Claim claim : CLAIMS) {
            int x_coordinate = claim.coordinate.x_coordinate + 1;
            boolean hasOverlap = false;
            aa:
            for (int x = x_coordinate; x < x_coordinate + claim.width; x++) {
                int y_coordinate = claim.coordinate.y_coordinate + 1;
                for (int y = y_coordinate; y < y_coordinate + claim.height; y++) {
                    Coordinate key = new Coordinate(x, y);
                    if (allCoordinatesUsedMoreThanOnce.contains(key)) {
                        hasOverlap = true;
                        break aa;
                    }
                }
            }
            if (!hasOverlap) {
                output = claim.id;
                System.out.println("RESULT of 2018 Puzzle 3 (part 2) = " + output);
                return output;

            }
        }
        return null;
    }

    private Set<Coordinate> getAllCoordinatesUsedMoreThanOnce(){
        Map<Coordinate, Integer> usedCoordinates = new HashMap<>();
        for (Claim claim : CLAIMS) {
            int x_coordinate = claim.coordinate.x_coordinate + 1;
            for (int x = x_coordinate; x < x_coordinate + claim.width; x++) {
                int y_coordinate = claim.coordinate.y_coordinate + 1;
                for (int y = y_coordinate; y < y_coordinate + claim.height; y++) {
                    Coordinate key = new Coordinate(x, y);
                    if (usedCoordinates.containsKey(key)) {
                        Integer count = usedCoordinates.get(key);
                        usedCoordinates.put(key, ++count);
                    } else {
                        usedCoordinates.put(key, 1);
                    }
                }
            }
        }
        return usedCoordinates.entrySet().stream().filter(p -> p.getValue() > 1).map(p -> p.getKey()).collect(Collectors.toSet());
    }

    private List<Claim> parseInput() {
        List<Claim> claims = new LinkedList<>();
        for (String input : INPUT) {
            Claim claim = new Claim();
            final String[] split = input.split(",|:|x|@|#");
            claim.id = split[1].trim();
            claim.coordinate = new Coordinate(Integer.parseInt(split[2].trim()), Integer.parseInt(split[3].trim()));
            claim.width = Integer.parseInt(split[4].trim());
            claim.height = Integer.parseInt(split[5].trim());
            claims.add(claim);
        }
        return claims;
    }

    class Claim {
        String id;
        Coordinate coordinate;
        int height, width;
    }

    class Coordinate {
        Integer x_coordinate, y_coordinate;

        Coordinate(int x, int y) {
            x_coordinate = x;
            y_coordinate = y;
        }

        @Override
        public boolean equals(Object obj){
            if (!(obj instanceof Coordinate)){
                return false;
            }
            Coordinate o = (Coordinate) obj;
            return this.x_coordinate.equals(o.x_coordinate) && this.y_coordinate.equals(o.y_coordinate);
        }

        @Override
        public int hashCode() {
            return Objects.hash(x_coordinate, y_coordinate);
        }
    }
}