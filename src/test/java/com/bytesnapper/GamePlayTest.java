package com.bytesnapper;

import org.junit.Assert;
import org.junit.Test;

/**
 * A Test for different bowling gameplays
 *
 * @author Ahmed Soliman
 * @since Nov-2018
 */
public class GamePlayTest {


    @Test
    public void testPerfectGame() {
        String playerName = "player1";
        GamePlay gamePlay = new GamePlay();
        // When
        gamePlay.throwBall(playerName, 10);
        gamePlay.throwBall(playerName, 10);
        gamePlay.throwBall(playerName, 10);
        gamePlay.throwBall(playerName, 10);
        gamePlay.throwBall(playerName, 10);
        gamePlay.throwBall(playerName, 10);
        gamePlay.throwBall(playerName, 10);
        gamePlay.throwBall(playerName, 10);
        gamePlay.throwBall(playerName, 10);
        gamePlay.throwBall(playerName, 10);
        // bonus balls
        gamePlay.throwBall(playerName, 10);
        gamePlay.throwBall(playerName, 10);
        int score = gamePlay.getGameByPlayer(playerName).getTotalScore();
        // Then
        Assert.assertEquals(300, score);
    }


    @Test
    public void testOneStrikeOneOpenFrame() {
        String playerName = "player1";
        GamePlay gamePlay = new GamePlay();
        // When
        gamePlay.throwBall(playerName, 10);
        gamePlay.throwBall(playerName, 3);
        gamePlay.throwBall(playerName, 6);
        int score = gamePlay.getGameByPlayer(playerName).getTotalScore();
        // Then
        Assert.assertEquals(28, score);
    }


    @Test
    public void testTurkey() {
        String playerName = "player1";
        GamePlay gamePlay = new GamePlay();
        // When
        gamePlay.throwBall(playerName, 10);
        gamePlay.throwBall(playerName, 10);
        gamePlay.throwBall(playerName, 10);
        gamePlay.throwBall(playerName, 8);
        gamePlay.throwBall(playerName, 2);
        gamePlay.throwBall(playerName, 8);
        gamePlay.throwBall(playerName, 0);
        int score = gamePlay.getGameByPlayer(playerName).getTotalScore();
        // Then
        Assert.assertEquals(104, score);
    }


    @Test
    public void testDuckDuckTurkey() {
        String playerName = "player1";
        GamePlay gamePlay = new GamePlay();
        // When
        gamePlay.throwBall(playerName, 10);
        gamePlay.throwBall(playerName, 10);
        gamePlay.throwBall(playerName, 10);
        gamePlay.throwBall(playerName, 10);
        gamePlay.throwBall(playerName, 10);
        gamePlay.throwBall(playerName, 7);
        gamePlay.throwBall(playerName, 2);
        int score = gamePlay.getGameByPlayer(playerName).getTotalScore();
        // Then
        Assert.assertEquals(145, score);
    }

    @Test
    public void testOneSpareAndOneOpenFrame() {
        String playerName = "player1";
        GamePlay gamePlay = new GamePlay();
        // When
        gamePlay.throwBall(playerName, 7);
        gamePlay.throwBall(playerName, 3);
        gamePlay.throwBall(playerName, 4);
        gamePlay.throwBall(playerName, 2);
        int score = gamePlay.getGameByPlayer(playerName).getTotalScore();
        // Then
        Assert.assertEquals(20, score);
    }


    @Test
    public void testDoubleStrike() {
        String playerName = "player1";
        GamePlay gamePlay = new GamePlay();
        // When
        gamePlay.throwBall(playerName, 10);
        gamePlay.throwBall(playerName, 10);
        gamePlay.throwBall(playerName, 9);
        gamePlay.throwBall(playerName, 0);
        int score = gamePlay.getGameByPlayer(playerName).getTotalScore();
        // Then
        Assert.assertEquals(57, score);
    }

    @Test
    public void testDoubleStrikeMultiPlayer() {
        String playerName1 = "player1";
        String playerName2 = "player2";
        String playerName3 = "player3";
        GamePlay gamePlay = new GamePlay();
        // When
        gamePlay.throwBall(playerName1, 10);
        gamePlay.throwBall(playerName1, 10);
        gamePlay.throwBall(playerName1, 9);
        gamePlay.throwBall(playerName1, 0);
        int score1 = gamePlay.getGameByPlayer(playerName1).getTotalScore();
        // Then
        Assert.assertEquals(57, score1);
        // When
        gamePlay.throwBall(playerName2, 7);
        gamePlay.throwBall(playerName2, 3);
        gamePlay.throwBall(playerName2, 4);
        gamePlay.throwBall(playerName2, 2);
        int score2 = gamePlay.getGameByPlayer(playerName2).getTotalScore();
        // Then
        Assert.assertEquals(20, score2);
        // When
        gamePlay.throwBall(playerName3, 10);
        gamePlay.throwBall(playerName3, 3);
        gamePlay.throwBall(playerName3, 6);
        int score3 = gamePlay.getGameByPlayer(playerName3).getTotalScore();
        // Then
        Assert.assertEquals(28, score3);
    }


    @Test
    public void testTwoOpenFrames() {
        String playerName = "player1";
        GamePlay gamePlay = new GamePlay();
        // When
        gamePlay.throwBall(playerName, 7);
        gamePlay.throwBall(playerName, 2);
        gamePlay.throwBall(playerName, 4);
        gamePlay.throwBall(playerName, 2);
        int score = gamePlay.getGameByPlayer(playerName).getTotalScore();
        // Then
        Assert.assertEquals(15, score);
    }

    @Test
    public void testGutterGame() {
        // All 20 balls knock down zero pins → score must be 0
        String playerName = "player1";
        GamePlay gamePlay = new GamePlay();
        for (int i = 0; i < 20; i++) {
            gamePlay.throwBall(playerName, 0);
        }
        int score = gamePlay.getGameByPlayer(playerName).getTotalScore();
        Assert.assertEquals(0, score);
    }

    @Test
    public void testFullTenFrameAllOpen() {
        // 10 frames of (3, 6) → 10 × 9 = 90
        String playerName = "player1";
        GamePlay gamePlay = new GamePlay();
        for (int i = 0; i < 10; i++) {
            gamePlay.throwBall(playerName, 3);
            gamePlay.throwBall(playerName, 6);
        }
        int score = gamePlay.getGameByPlayer(playerName).getTotalScore();
        Assert.assertEquals(90, score);
    }

    @Test
    public void testAllSpares() {
        // 10 frames of (5, 5) plus one bonus ball of 5 → 10 × 15 = 150
        String playerName = "player1";
        GamePlay gamePlay = new GamePlay();
        for (int i = 0; i < 10; i++) {
            gamePlay.throwBall(playerName, 5);
            gamePlay.throwBall(playerName, 5);
        }
        // bonus ball for the 10th-frame spare
        gamePlay.throwBall(playerName, 5);
        int score = gamePlay.getGameByPlayer(playerName).getTotalScore();
        Assert.assertEquals(150, score);
    }

    @Test
    public void testSpareInTenthFrame() {
        // 9 open frames of (3, 6) = 81, then spare (5, 5) + bonus ball 3 = 13 → total 94
        String playerName = "player1";
        GamePlay gamePlay = new GamePlay();
        for (int i = 0; i < 9; i++) {
            gamePlay.throwBall(playerName, 3);
            gamePlay.throwBall(playerName, 6);
        }
        gamePlay.throwBall(playerName, 5);
        gamePlay.throwBall(playerName, 5);
        gamePlay.throwBall(playerName, 3); // bonus ball
        int score = gamePlay.getGameByPlayer(playerName).getTotalScore();
        Assert.assertEquals(94, score);
    }

    @Test
    public void testStrikeInTenthFrame() {
        // 9 open frames of (3, 6) = 81, then strike + bonus balls (10, 6) = 26 → total 107
        String playerName = "player1";
        GamePlay gamePlay = new GamePlay();
        for (int i = 0; i < 9; i++) {
            gamePlay.throwBall(playerName, 3);
            gamePlay.throwBall(playerName, 6);
        }
        gamePlay.throwBall(playerName, 10); // strike in 10th
        gamePlay.throwBall(playerName, 10); // bonus ball 1
        gamePlay.throwBall(playerName, 6);  // bonus ball 2
        int score = gamePlay.getGameByPlayer(playerName).getTotalScore();
        Assert.assertEquals(107, score);
    }

    @Test
    public void testSpareFollowedByStrike() {
        // Frame 1: spare (5,5) + next ball 10 → 20
        // Frame 2: strike (10) + next 2 balls (3,4) → 17
        // Frame 3: open (3,4) → 7
        // Total: 44
        String playerName = "player1";
        GamePlay gamePlay = new GamePlay();
        gamePlay.throwBall(playerName, 5);
        gamePlay.throwBall(playerName, 5);
        gamePlay.throwBall(playerName, 10);
        gamePlay.throwBall(playerName, 3);
        gamePlay.throwBall(playerName, 4);
        int score = gamePlay.getGameByPlayer(playerName).getTotalScore();
        Assert.assertEquals(44, score);
    }

    @Test
    public void testSingleBallGutter() {
        // Only one ball thrown, not enough look-ahead to close a frame → score 0
        String playerName = "player1";
        GamePlay gamePlay = new GamePlay();
        gamePlay.throwBall(playerName, 0);
        int score = gamePlay.getGameByPlayer(playerName).getTotalScore();
        Assert.assertEquals(0, score);
    }

    @Test
    public void testNewPlayerStartsAtZero() {
        // A freshly registered player has no frames and a total score of 0
        GamePlay gamePlay = new GamePlay();
        gamePlay.throwBall("newPlayer", 0);
        Game game = gamePlay.getGameByPlayer("newPlayer");
        Assert.assertNotNull(game);
        Assert.assertEquals(0, game.getTotalScore());
    }

    @Test
    public void testUnknownPlayerReturnsNull() {
        GamePlay gamePlay = new GamePlay();
        Assert.assertNull(gamePlay.getGameByPlayer("ghost"));
    }
}
