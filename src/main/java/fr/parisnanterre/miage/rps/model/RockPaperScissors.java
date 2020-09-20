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

}
