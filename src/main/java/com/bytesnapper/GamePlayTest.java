public class GamePlayTest {

    @Test
    public void testPerfectGame() {
        String playerName = "player1";
        GamePlay gamePlay = new GamePlay();
        // When
        gamePlay.throwBall(playerName, 10);
        gamePlay.throwBall(playerName, 10);
        // ... rest of the test
    }

    @Test
    public void testOneStrikeOneOpenFrame() {
        // existing test
    }

    @Test
    public void testTurkey() {
        // existing test
    }

    @Test
    public void testDuckDuckTurkey() {
        // existing test
    }

    @Test
    public void testOneSpareAndOneOpenFrame() {
        // existing test
    }

    @Test
    public void testDoubleStrike() {
        // existing test
    }

    @Test
    public void testDoubleStrikeMultiPlayer() {
        // existing test
    }

    @Test
    public void testTwoOpenFrames() {
        // existing test
    }

    @Test
    public void testSpareFollowedBySpare() {
        String playerName = "player1";
        GamePlay gamePlay = new GamePlay();
        gamePlay.throwBall(playerName, 5);
        gamePlay.throwBall(playerName, 5);
        gamePlay.throwBall(playerName, 5);
        gamePlay.throwBall(playerName, 5);
        gamePlay.throwBall(playerName, 5);
        Game game = gamePlay.getGameByPlayer(playerName);
        Map<Integer, Integer> scorePerFrame = game.getScorePerFrame();
        assertEquals(2, scorePerFrame.size());
        assertEquals(15, (int) scorePerFrame.get(1));
        assertEquals(15, (int) scorePerFrame.get(2));
    }

    @Test
    public void testStrikeFollowedBySpare() {
        String playerName = "player1";
        GamePlay gamePlay = new GamePlay();
        gamePlay.throwBall(playerName, 10);
        gamePlay.throwBall(playerName, 5);
        gamePlay.throwBall(playerName, 5);
        Game game = gamePlay.getGameByPlayer(playerName);
        Map<Integer, Integer> scorePerFrame = game.getScorePerFrame();
        assertEquals(1, scorePerFrame.size());
        assertEquals(20, (int) scorePerFrame.get(1));
    }

    @Test
    public void testOpenFrame() {
        String playerName = "player1";
        GamePlay gamePlay = new GamePlay();
        gamePlay.throwBall(playerName, 3);
        gamePlay.throwBall(playerName, 4);
        Game game = gamePlay.getGameByPlayer(playerName);
        Map<Integer, Integer> scorePerFrame = game.getScorePerFrame();
        assertEquals(1, scorePerFrame.size());
        assertEquals(7, (int) scorePerFrame.get(1));
    }
}
