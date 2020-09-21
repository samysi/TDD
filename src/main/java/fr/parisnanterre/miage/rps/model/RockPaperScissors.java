package fr.parisnanterre.miage.rps.model;

import static fr.parisnanterre.miage.rps.model.Result.LOST;

public class RockPaperScissors {
    public RockPaperScissors(){
    }

    Result play(RPSEnum n1, RPSEnum n2) {

        if ((n1 == RPSEnum.PAPER && n2 == RPSEnum.PAPER) || (n1 == RPSEnum.ROCK && n2 == RPSEnum.ROCK) || (n1 == RPSEnum.SCISSORS && n2 == RPSEnum.SCISSORS)) {
            return Result.TIE;
        } else if ((n1 == RPSEnum.ROCK && n2 == RPSEnum.SCISSORS) || (n1 == RPSEnum.SCISSORS && n2 == RPSEnum.PAPER) || (n1 == RPSEnum.PAPER && n2 == RPSEnum.ROCK)) {
            return Result.WIN;
        } else {
            return LOST;
        }
    }

    Result jeu(Player p1, Player p2) {

        RPSEnum m1 = p1.getNextMove();
        RPSEnum m2 = p2.getNextMove();

        while ((m1 != null) && (m2 != null)) {
            Result res = play(m1, m2);

            if (res == Result.WIN) {
                p1.setScore(p1.getScore() + 1);
            } else if (res == Result.LOST) {
                p2.setScore(p2.getScore() + 1);
            } else {
                p1.setScore(p1.getScore() + 1);
                p2.setScore(p2.getScore() + 1);
            }

            m1 = p1.getNextMove();
            m2 = p2.getNextMove();
        }
        if (p1.getScore() == p2.getScore())
            return Result.TIE;
        if (p1.getScore() < p2.getScore())
            return Result.LOST;
        return Result.WIN;
    }

}
