package fr.parisnanterre.miage.rps.model;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;

import fr.parisnanterre.miage.rps.model.RPSEnum;

import static org.testng.Assert.*;

public class RockPaperScissorsTest {

    RockPaperScissors rps;

    @BeforeMethod
    public void setUp() {

        rps= new RockPaperScissors();
    }

    @AfterMethod
    public void tearDown() {

        rps=null;
    }
    @Parameters({"papier", "ciseaux"})
    @Test
    void testLostPlay(String p1, String p2)
    {
        Result res = rps.play(RPSEnum.valueOf(p1), RPSEnum.valueOf(p2));
        assertEquals(res,Result.LOST);
    }

    @Parameters({"papier", "papier"})
    @Test
    void testTiePlay(String p1, String p2)
    {
        Result res = rps.play(RPSEnum.valueOf(p1), RPSEnum.valueOf(p2));
        assertEquals(res,Result.TIE);
    }


    @Parameters({"ciseaux", "papier"})
    @Test
    void testWinPlay(String p1, String p2)
    {
        Result res = rps.play(RPSEnum.valueOf(p1), RPSEnum.valueOf(p2));
        assertEquals(res,Result.WIN);
    }



}