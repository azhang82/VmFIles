// 3959601

// quiz next week!

import java.util.*;

public class Lesson6 {
    public static void main(String[] args) {
        NumberGuessingGame game = new NumberGuessingGame();
        game.play();
    }
    
    static class NumberGuessingGame extends TwoPlayerGame {
        private int mysteryNumber; // 1 to 10
        ArrayList<Integer> pastGuesses;
        Player winner = null;
        
        NumberGuessingGame() {
            super(new HumanPlayer(), new HumanPlayer()); // calls the superclass's constructor
            mysteryNumber = (int)(Math.random() * 10) + 1;
            pastGuesses = new ArrayList<>();
        }
        
        void guess(int guess) {
            if(guess == mysteryNumber) {
                winner = currPlayer;
                System.out.println("You guessed it!");
            }
            else {
                if(pastGuesses.contains(guess)) {
                    System.out.println("You idiot, someone guessed this already");
                }
                pastGuesses.add(guess);
            }
        }
        
        Player getWinner() {
            return winner;
        }
    }
    
    // human player for the number guessing game
    static class HumanPlayer extends Player {
        void move(TwoPlayerGame game) {
            Scanner in = new Scanner(System.in); // not in the quiz
            System.out.println("Please enter your guess: ");
            int guess = in.nextInt();
            ((NumberGuessingGame)game).guess(guess);
            //in.close(); // not in the quiz
        }
    }
    
    static abstract class TwoPlayerGame {
        Player p1, p2;
        Player currPlayer; 
        
        TwoPlayerGame(Player p1, Player p2) {
            this.p1 = p1;
            this.p2 = p2;
            this.currPlayer = p1;
        }
        
        // returns null if no winner yet
        abstract Player getWinner();
        
        void play() {
            while(getWinner() == null) {
                currPlayer.move(this);
                if(currPlayer == p1) {
                    currPlayer = p2;
                }
                else {
                    currPlayer = p1;
                }
            }
        }
    }
    
    static abstract class Player {
        abstract void move(TwoPlayerGame game);
    }
}