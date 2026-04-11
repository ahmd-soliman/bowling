package com.bytesnapper;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The entry point to run the application
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("What's your name? ");
        Scanner scanner = new Scanner(System.in);
        String playerName = scanner.next();
        GamePlay gamePlay = new GamePlay();
        while (true) {
            System.out.println("How many pins did you knock down? ");
            int noOfPins = getNoOfPins(scanner);
            gamePlay.throwBall(playerName, noOfPins);
            Game game = gamePlay.getGameByPlayer(playerName);
            if (game.getScorePerFrame().size() == 10) {
                break;
            }
        }
    }

    /**
     * Gets number of pins as input.
     *
     * @param scanner A scanner to get the input from the user.
     * @return number of pins.
     */
    private static int getNoOfPins(Scanner scanner) {
        int noOfPins = -1;
        try {
            noOfPins = scanner.nextInt();
            if (noOfPins < 0 || noOfPins > 10) {
                throw new InputMismatchException();
            }
        } catch (InputMismatchException e) {
            System.err.println("Wrong number of pins! Please enter number from 0 to 10.");
        }
        return noOfPins;
    }

}
