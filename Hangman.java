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

    public void run() {
		/* You fill this in */
    	println("Welcome to Hangman!");
    	
    	/* Randomly choose a word from Hangman Lexicon */
    	HangmanLexicon rl = new HangmanLexicon();
    	int no = rgen.nextInt(0, rl.getWordCount()-1);
    	String word = rl.getWord(no);
    	
    	/* Play the game */
    	dash = "";
    	for (int i = 0; i < word.length(); i++) {
    		dash += "-";
    	}
    	while (true) {
    		println("The word now looks like this" + dash);
    		println("You have " + count + " guesses left.");
    		guessChar = readLine("Your guess: ");
    		// If the user guesses something other than a single letter
    		while (isNotChar()) {
    			println("The guess is illegal, try a new guess!");
    			guessChar = readLine("Your guess: ");
    		}
    		// If the letter in the word
    		if(isInWord()) {
    			dash = dashWithLetter(guessChar);
    		} else {
    			count -=1;
    			println("There are no " + guessChar + "'s in the word.");
    		}	
    	}
    	
    	/* If the user guess is a single letter */
    	private boolean isNotChar() {
    		
    	}
    	
	}

    
    /* Instant variables */
    private RandomGenerator rgen = RandomGenerator.getInstance();
    String dash;
    int count = 8;
    String guessChar;
}
