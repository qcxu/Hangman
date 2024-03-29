/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.awt.*;

public class Hangman extends ConsoleProgram {

	/* Create SCAFFOLD on Hangman Canvas */
	public void init(){
		canvas = new HangmanCanvas();
		add(canvas);
	}
	
    public void run() {
    	
    	canvas.reset(); // Display scaffold on canvas
    	
		/* You fill this in */
    	println("Welcome to Hangman!");
    	
    	/* Randomly choose a word from Hangman Lexicon */
    	HangmanLexicon rl = new HangmanLexicon();
    	//rgen.setSeed(0);
    	int no = rgen.nextInt(0, rl.getWordCount()-1);
    	word = rl.getWord(no);
    	
    	/* Start to play the game */
    	dash = "";
    	for (int i = 0; i < word.length(); i++) {
    		dash += "-";
    	}
    	
     	canvas.displayWord(dash); // Display all dash
    	
     	while (true) {
    		println("The word now looks like this " + dash);
    		println("You have " + count + " guesses left.");
    		str = readLine("Your guess: ");
    		
    		// Check to see whether the user guesses something other than a single letter
    		while (!isLetter(str)) {
    			println("The guess is illegal, try a new guess!");
    			str = readLine("Your guess: ");
    		}
    		
    		// Check to see whether the letter is in the word, and output the result
    		dash = dashWithLetters(ch, word, dash);
    		 		
    		// Check to see whether win or lose
    		if (guessAllCorrect()) {
    			println("You guessed the word: " + word);
    			println("You win.");
    			break;
    		}
    		if (count == 0) {
    			println("You are completely hung.");
    			println("The word was: " + word);
    			println("You lose.");
    			break;
    		}
    	}
    		
    }
    
    /* Check whether the user guess is a single letter, which means it 
     * meets the following conditions:
     * (1) length is 1;
     * (2) convert it to a char;
     * (3) it is a letter;
     */
	private boolean isLetter(String str) {
		if (str.length() == 1) {
			ch = str.charAt(0);
			if (Character.isLetter(ch)) {
				return true;
			}
		}
		return false;
	}
	
	/* Check whether the guess letter is in the word which means it meets
	 * the following conditions:
	 * (1) convert it to upper case;
	 * (2) if it's in the word, replace that position with the letter;
	 * (3) if it's not in the word, no change.
	 */
	private String dashWithLetters(char ch, String word, String dash) {
		String result = "";
		int flag = 0; // Check whether the letter is in the word
		if (Character.isLowerCase(ch)) {
			ch = Character.toUpperCase(ch);
		}
		for (int i = 0; i < word.length(); i++) {
			if (ch == word.charAt(i)) {
				result += ch;
				flag = 1;
			} else {
				result += dash.charAt(i);
			}
		}
		
		// Display word on canvas
		canvas.displayWord(result);
		
		// Display whether the guess is correct or not
		if (flag == 0) {
			count -=1; // Calculate the incorrect guess
			println("There are no " + ch + "'s in the word.");

			canvas.noteIncorrectGuess(ch); // Update incorrect letters on canvas
		}  else {
			println("That guess is correct.");
		}
		return result;
	}
	
	
	
	/* Check whether all the letters are guessed correctly */
	private boolean guessAllCorrect() {
		for (int i = 0; i < word.length(); i++) {
			char ch = dash.charAt(i);
			if (ch != word.charAt(i)) {
				return false;
			}
		}
		return true;
	}
    
    /* Instant variables */
    private RandomGenerator rgen = RandomGenerator.getInstance();
    String dash;
    String word;
    int count = 8;
    String str;
    char ch;
    private HangmanCanvas canvas;
}
