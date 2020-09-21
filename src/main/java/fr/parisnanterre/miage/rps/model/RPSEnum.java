package fr.parisnanterre.miage.rps.model;

import java.util.List;
import java.util.Random;

public enum RPSEnum {
    ROCK, PAPER, SCISSORS;
    private static Random RANDOM = new Random();
    private static List<RPSEnum> VALUES = List.of(values());
    private static int SIZE = VALUES.size();


    public static RPSEnum hazard() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
