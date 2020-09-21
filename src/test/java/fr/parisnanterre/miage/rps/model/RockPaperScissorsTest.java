package fr.parisnanterre.miage.rps.model;

import org.testng.annotations.*;

import fr.parisnanterre.miage.rps.model.RPSEnum;

import java.util.LinkedList;

import static org.testng.Assert.*;

public class RockPaperScissorsTest {

    RockPaperScissors rps;

    private Player p1;
    private Player p2;
    private Player p3;
    private Player p4;

    @BeforeMethod
    public void setUp() {

        rps= new RockPaperScissors();

        LinkedList<RPSEnum> m1 = new LinkedList<>();
        m1.add(RPSEnum.ROCK);
        m1.add(RPSEnum.PAPER);

        LinkedList<RPSEnum> m2 = new LinkedList<>();
        m2.add(RPSEnum.SCISSORS);
        m1.add(RPSEnum.ROCK);

        LinkedList<RPSEnum> m3 = new LinkedList<>();
        m3.add(RPSEnum.ROCK);
        m1.add(RPSEnum.PAPER);

        LinkedList<RPSEnum> m4 = new LinkedList<>();
        m4.add(RPSEnum.PAPER);
        m1.add(RPSEnum.SCISSORS);

        p1 = new Player("Joueur 1", m1);
        p2 = new Player("Joueur 2", m2);
        p3 = new Player("Joueur 3", m3);
        p4 = new Player("Joueur 4", m4);

    }

    @AfterMethod
    public void tearDown() {

        rps=null;
        p1=null;
        p2=null;
        p3=null;
        p4=null;
    }

    @Test
    public void testPlayerWin() {
        assertEquals(rps.jeu(p1, p2), Result.WIN);
    }

    @Test
    public void testPlayerLoose() {
        assertEquals(rps.jeu(p1, p4), Result.LOST);
    }

    @Test
    public void testPlayerTie() {
        assertEquals(rps.jeu(p1, p3), Result.TIE);
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