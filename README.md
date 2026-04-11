# Bowling Game

A Java implementation of a ten-pin bowling score calculator with a simple interactive CLI.

## Bowling Scoring Rules

A game of bowling consists of **10 frames**. In each frame, a player gets up to two rolls to knock down 10 pins.

| Result | Description | Scoring |
|--------|-------------|---------|
| **Strike** | All 10 pins knocked down on the 1st ball | 10 + next 2 balls |
| **Spare** | All remaining pins knocked down on the 2nd ball | 10 + next 1 ball |
| **Open Frame** | Pins remain standing after 2 balls | Sum of the 2 balls |

**10th Frame Special Rule:** If a strike or spare is achieved in the 10th frame, bonus balls are awarded (up to 2 for a strike, 1 for a spare) to complete the scoring calculation. The maximum possible score is **300** (a perfect game — 12 consecutive strikes).

## Project Structure

```
src/
├── main/java/com/bytesnapper/
│   ├── Main.java            # CLI entry point — prompts user for input
│   ├── GamePlay.java        # Manages players and their games
│   ├── Game.java            # Holds the ball list and per-frame scores
│   └── ScoreCalculator.java # Stateless scoring logic
└── test/java/com/bytesnapper/
    └── GamePlayTest.java    # JUnit 4 tests covering various game scenarios
```

### Class Responsibilities

- **`Main`** — reads player name and pin counts from stdin in a loop until 10 frames are scored.
- **`GamePlay`** — maintains a `Map<String, Game>` so multiple players can share a single `GamePlay` instance. Delegates ball recording and scoring to `ScoreCalculator`.
- **`Game`** — plain data container: an ordered list of ball values and a frame-number → frame-score map.
- **`ScoreCalculator`** — stateless utility. `addBall()` appends a ball then rewrites `scorePerFrame` by scanning the full ball list from the beginning, applying strike/spare/open-frame rules with look-ahead.

## Requirements

- Java 8+
- Maven 3+

## Build

```bash
mvn compile
```

## Run Tests

```bash
mvn test
```

## Run the Application

```bash
mvn package
java -cp target/com.bytesnapper-bowling-1.0-SNAPSHOT.jar com.bytesnapper.Main
```

The game prompts you for your name, then repeatedly asks for the number of pins knocked down. It prints the running frame scores after each ball and stops when 10 frames are complete.

## Example Session

```
What's your name?
Alice
How many pins did you knock down?
10
Score for player: Alice
Frame #1 score is: |

How many pins did you knock down?
7
...
```

## Scoring Examples

| Scenario | Balls | Score |
|----------|-------|-------|
| Gutter game | 0 × 20 | 0 |
| All open frames | (3,6) × 10 | 90 |
| All spares | (5,5) × 10 + 5 | 150 |
| Perfect game | 10 × 12 | 300 |
