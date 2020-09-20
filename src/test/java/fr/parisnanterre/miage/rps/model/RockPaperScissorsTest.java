package fr.parisnanterre.miage.rps.model;

import org.testng.annotations.*;

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

    @DataProvider(name="winData")
    public Object[][] createWinData(){
        return new Object[][]{
                {RPSEnum.PAPER,RPSEnum.ROCK},
                {RPSEnum.ROCK,RPSEnum.SCISSORS},
                {RPSEnum.SCISSORS,RPSEnum.PAPER},

        };

    }
    @DataProvider(name = "tieData")
    public Object[][] createTieData() {
        return new Object[][] {
                {RPSEnum.PAPER, RPSEnum.PAPER },
                {RPSEnum.ROCK, RPSEnum.ROCK},
                {RPSEnum.SCISSORS, RPSEnum.SCISSORS}
        };
    }

    @DataProvider(name = "lostData")
    public Object[][] createLossData() {
        return new Object[][] {
                {RPSEnum.PAPER, RPSEnum.SCISSORS },
                {RPSEnum.ROCK, RPSEnum.PAPER},
                {RPSEnum.SCISSORS, RPSEnum.ROCK}
        };
    }

    @Test(dataProvider = "winData")
    public void testWinPlay(RPSEnum p1, RPSEnum p2) {
        assertEquals(rps.play(p1, p2), Result.WIN);
    }

    @Test(dataProvider = "tieData")
    public void testTiePlay(RPSEnum p1, RPSEnum p2) {
        assertEquals(rps.play(p1, p2), Result.TIE);
    }

    @Test(dataProvider = "lostData")
    public void testLostPlay(RPSEnum p1, RPSEnum p2) {
        assertEquals(rps.play(p1, p2), Result.LOST);
    }


}